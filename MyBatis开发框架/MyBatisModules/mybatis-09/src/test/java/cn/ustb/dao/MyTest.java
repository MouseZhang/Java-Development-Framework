package cn.ustb.dao;

import cn.ustb.pojo.User;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {

    // 测试在一次SqlSession中查询两次相同的记录
    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.getUserById(1);
        System.out.println(user1);
        System.out.println("==================");
        User user2 = userMapper.getUserById(1);
        System.out.println(user2);
        System.out.println("user1 == user2 ? " + (user1 == user2));
        sqlSession.close();
    }

    // MyBatis默认开启一级缓存（SqlSession级的）
    // 只在一次SqlSession中有效，也就是拿到连接到关闭连接之间这个阶段
    // 一级缓存相当于一个Map
    @Test
    public void testGetUserByIdUpdate() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.getUserById(1);
        System.out.println(user1);
        // 1、查询不同的记录，不存在缓存
        // 2、增删改操作，可能会改变原来的数据，所以必定会刷新缓存
        // 3、查询不同的Mapper，不存在缓存
        // 4、手动清理缓存
        userMapper.updateUser(new User(6, "LEE", "11111"));
        System.out.println("==================");
        User user2 = userMapper.getUserById(1);
        System.out.println(user2);
        System.out.println("user1 == user2 ? " + (user1 == user2));
        sqlSession.close();
    }

    // MyBatis默认开启一级缓存（SqlSession级的）
    // 只在一次SqlSession中有效，也就是拿到连接到关闭连接之间这个阶段
    // 一级缓存相当于一个Map
    @Test
    public void testGetUserByIdClear() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user1 = userMapper.getUserById(1);
        System.out.println(user1);
        // 1、查询不同的记录，不存在缓存
        // 2、增删改操作，可能会改变原来的数据，所以必定会刷新缓存
        // 3、查询不同的Mapper，不存在缓存
        // 4、手动清理缓存
        sqlSession.clearCache(); // 手动清理缓存
        System.out.println("==================");
        User user2 = userMapper.getUserById(1);
        System.out.println(user2);
        System.out.println("user1 == user2 ? " + (user1 == user2));
        sqlSession.close();
    }

    // 只要开启了二级缓存，在同一个Mapper下就有效
    // 所有的数据都会先放在一级缓存中，只有当会话提交、或关闭会话的时候，才会提交到二级缓存中
    // 缓存顺序：
    // 1、先看二级缓存中有没有数据
    // 2、再看一级缓存中有没有数据
    // 3、查询数据库
    @Test
    public void testGetUserByIdCache() {
        SqlSession sqlSession1 = MyBatisUtils.getSqlSession();
        UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = userMapper1.getUserById(1);
        System.out.println(user1);
        sqlSession1.close();
        System.out.println("==================");
        SqlSession sqlSession2 = MyBatisUtils.getSqlSession();
        UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
        User user2 = userMapper2.getUserById(1);
        System.out.println(user2);
        System.out.println("user1 == user2 ? " + (user1 == user2));
        User user3 = userMapper2.getUserById(2);
        System.out.println(user3);
        User user4 = userMapper2.getUserById(2);
        System.out.println(user4);
        sqlSession2.close();
    }

}