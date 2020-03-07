package cn.ustb.dao;

import cn.ustb.pojo.User;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class UserMapperTest {

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

}
