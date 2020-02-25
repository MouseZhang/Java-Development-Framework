package cn.ustb.controller;

import cn.ustb.mapper.UserMapper;
import cn.ustb.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getUsers")
    public List<User> getUsers() {
        List<User> users = userMapper.getUsers();
        for (User user: users) {
            System.out.println(user);
        }
        return users;
    }

    @GetMapping("/insertUser")
    public String insertUser() {
        userMapper.insertUser(new User(null, "COOPER", "123321"));
        return "Insert OK";
    }

    @GetMapping("/updateUser")
    public String updateUser() {
        userMapper.updateUser(new User(7, "COOPER", "111111"));
        return "Update OK";
    }

    @GetMapping("/deleteUser")
    public String deleteUser() {
        userMapper.deleteUser(7);
        return "Delete OK";
    }

}
