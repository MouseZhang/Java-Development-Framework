package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    public List<User> getUsers();

    public User getUserById(@Param("id") Integer id);

}
