package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    public List<User> getUsers();

    public User getUserById(@Param("id") Integer id);

    public List<User> getUsersSplit(@Param("map") Map<String, Integer> map);

    // 开发中不推荐使用
    public List<User> getUsersRowBounds();
}
