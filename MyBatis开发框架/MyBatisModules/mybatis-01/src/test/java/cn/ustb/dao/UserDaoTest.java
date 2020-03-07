package cn.ustb.dao;

import cn.ustb.pojo.User;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void testGetUsers() {
        // 1、获取SqlSession对象
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            // 2、方式一：getMapper（推荐使用）
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // 2、方式二：
            // List<User> users = sqlSession.selectList("cn.ustb.dao.UserMapper.getUsers");

            List<User> users = userMapper.getUsers();
            for (User user: users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 3、关闭SqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.getUserById(1);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAddUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(null, "SMITH", "111111");
            System.out.println(userMapper.addUser(user));
            // 增删改需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testUpdateUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = new User(5, "ALLEN", "123123");
            System.out.println(userMapper.updateUser(user));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testDeleteUser() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            System.out.println(userMapper.deleteUser(5));
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAddUserMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userName", "LEE");
            map.put("password", "22222");
            System.out.println(userMapper.addUserMap(map));
            // 增删改需要提交事务
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUserByIdMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("userId", 1);
            User user = userMapper.getUserByIdMap(map);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testGetUsersLike() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.getUsersLike("u");
            for (User user: users) {
                System.out.println(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
