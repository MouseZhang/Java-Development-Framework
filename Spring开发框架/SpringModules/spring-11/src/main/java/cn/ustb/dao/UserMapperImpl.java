package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl extends SqlSessionDaoSupport implements UserMapper {

    public List<User> getUsers() {
        SqlSession sqlSession = getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User(11, "TOM", "88888");
        mapper.addUser(user);
        mapper.deleteUser(10);
        return mapper.getUsers();
    }

    public boolean addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    public boolean deleteUser(Integer id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUser(id);
    }
}
