package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    @Select("SELECT id,name,pwd AS password FROM user")
    public List<User> getUsers();

    @Select("SELECT id,name,pwd AS password FROM user WHERE id=#{id}")
    public User getUserById(@Param("id") Integer id);

    @Insert("INSERT INTO user (name,pwd) VALUES (#{name},#{password})")
    public boolean addUser(User user);

    @Update("UPDATE user SET name=#{name},pwd=#{password} WHERE id=#{id}")
    public boolean updateUser(User user);

    @Delete("DELETE FROM user WHERE id=#{id}")
    public boolean deleteUser(@Param("id") Integer id);

}
