package cn.ustb;

import cn.ustb.mapper.UserMapper;
import cn.ustb.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testWrapper1() {
        // 查询name不为空、邮箱不为空、年龄大于等于20的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNotNull("name")
                    .isNotNull("email")
                    .ge("age", 20);
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testWrapper2() {
        // 查询name为Billie的用户
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "Billie");
        // 查询一个数据，查询多个使用List或Map
        User user = userMapper.selectOne(queryWrapper);
        System.out.println(user);
    }

    @Test
    public void testWrapper3() {
        // 查询年龄在20至30岁之间的用户数
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.between("age", 20, 30);
        Integer count = userMapper.selectCount(queryWrapper);
        System.out.println("查询到的用户数为：" + count);
    }

    // 模糊查询
    @Test
    public void testWrapper4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.notLike("name", "e")
                    .likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    // 模糊查询
    @Test
    public void testWrapper5() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 嵌套子查询
        queryWrapper.inSql("id", "SELECT id FROM user WHERE id < 3");
        List<Object> objects = userMapper.selectObjs(queryWrapper);
        objects.forEach(System.out::println);
    }

    // 排序
    @Test
    public void testWrapper6() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        // 按照id降序排序
        queryWrapper.orderByDesc("id");
        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

}
