package cn.ustb;

import cn.ustb.mapper.UserMapper;
import cn.ustb.pojo.User;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MybatisPlusApplicationTests {

    // 继承了BaseMapper，也可以编写扩展方法
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testGetUsers() {
        // 查询全部用户
        // Wrapper是一个条件构造器
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setName("SMITH");
        user.setAge(19);
        user.setEmail("test6@smith.com");
        int result = userMapper.insert(user); // 会自动生成ID
        System.out.println(result); // 受影响的行数
        System.out.println(user);
    }

    @Test
    public void testUpdateUser() {
        User user = new User();
        user.setId(1241181123416076294L);
        user.setAge(23);
        // 注意：updateById的参数是一个对象
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    // 测试乐观锁成功
    @Test
    public void testVersionSuccess() {
        // 1、查询用户信息
        User user = userMapper.selectById(1L);
        // 2、修改用户信息
        user.setEmail("test1@jone.com");
        // 3、执行更新操作
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    // 测试乐观锁失败
    @Test
    public void testVersionFail() {
        // 线程1
        User user1 = userMapper.selectById(1241181123416076294L);
        user1.setEmail("test6@smith1.com");
        // 线程2，插队更新
        User user2 = userMapper.selectById(1241181123416076294L);
        user2.setEmail("test6@smith2.com");
        int result2 = userMapper.updateById(user2);
        System.out.println("result2: " + result2);

        // 可以使用自旋锁来尝试多次提交
        int result1 = userMapper.updateById(user1);// 如果没有乐观锁就会覆盖插队线程的值
        System.out.println("result1: " + result1);
    }

    // 测试单个查询
    @Test
    public void testGetUserById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    // 测试批量查询
    @Test
    public void testGetUserByBatchID() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 测试条件查询，方法一：使用Map
    @Test
    public void testGetUsersMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "SMITH");
        map.put("age", 19);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页查询
    @Test
    public void testPage() {
        // 参数一：当前页
        // 参数二：页面大小
        Page<User> page = new Page<>(2, 5);
        IPage<User> users = userMapper.selectPage(page, null);
        users.getRecords().forEach(System.out::println);
        System.out.println("总记录数：" + users.getTotal());
    }

    @Test
    public void testDeleteById() {
        int result = userMapper.deleteById(1241181123416076294L);
        System.out.println(result);
    }

    @Test void testDeleteBatchById() {
        int result = userMapper.deleteBatchIds(Arrays.asList(1241181123416076292L, 1241181123416076293L));
        System.out.println(result);
    }

    @Test void testDeleteMap() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "SMITH");
        int result = userMapper.deleteByMap(map);
        System.out.println(result);
    }

    @Test void testDeleteLogic() {
        int result = userMapper.deleteById(1L);
        System.out.println(result);
    }

}
