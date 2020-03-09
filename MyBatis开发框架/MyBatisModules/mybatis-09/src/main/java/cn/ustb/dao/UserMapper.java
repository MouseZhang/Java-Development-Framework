package cn.ustb.dao;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    public User getUserById(@Param("id") Integer id);

    public boolean updateUser(User user);

}
