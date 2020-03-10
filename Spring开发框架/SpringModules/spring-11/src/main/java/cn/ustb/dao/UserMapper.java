package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    public List<User> getUsers();

    public boolean addUser(User user);

    public boolean deleteUser(@Param("id") Integer id);
}
