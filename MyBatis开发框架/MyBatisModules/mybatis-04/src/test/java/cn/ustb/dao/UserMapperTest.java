package cn.ustb.dao;

import cn.ustb.pojo.User;
import cn.ustb.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class UserMapperTest {

    private static Logger logger = Logger.getLogger(UserMapperTest.class);

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
    public void testLog4j() {
        logger.info("info：进入了testLog4j");
        logger.debug("debug：进入了testLog4j");
        logger.error("error：进入了testLog4j");
    }

}
