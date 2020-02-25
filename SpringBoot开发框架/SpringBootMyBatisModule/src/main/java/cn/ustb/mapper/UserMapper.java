package cn.ustb.mapper;

import cn.ustb.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper // 表示这是一个Mybatis的Mapper类
@Repository // 表示这是一个dao层
public interface UserMapper {
    public List<User> getUsers();

    public User getUserById(Integer id);

    public Integer insertUser(User user);

    public Integer updateUser(User user);

    public Integer deleteUser(Integer id);

}
