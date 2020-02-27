package cn.ustb.controller;

import cn.ustb.pojo.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!!!";
    }

    // 只要接口中返回值存在有实体类，就会被自动扫描到Swagger中
    @PostMapping("/user")
    public User getUser() {
        return new User();
    }

    @ApiOperation("helloparam接口") // ApiOperation用于给接口加注释，不是放在类上
    @GetMapping("/helloparam")
    public String helloParam(@ApiParam("参数用户名") String username) {
        return "Hello " + username;
    }

    @ApiOperation("POST方法测试接口")
    @PostMapping("/hellopost")
    public User helloPost(@ApiParam("用户信息") User user) {
        return user;
    }
}
