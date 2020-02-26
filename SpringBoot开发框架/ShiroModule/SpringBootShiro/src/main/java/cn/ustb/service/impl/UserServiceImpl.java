package cn.ustb.service.impl;

import cn.ustb.mapper.UserMapper;
import cn.ustb.pojo.User;
import cn.ustb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

}
