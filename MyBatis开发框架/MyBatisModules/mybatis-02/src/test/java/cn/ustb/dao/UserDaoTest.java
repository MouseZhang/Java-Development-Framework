package cn.ustb.dao;

import cn.ustb.pojo.User;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {

    @Test
    public void testGetUsers() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<User> users = userMapper.getUsers();
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
