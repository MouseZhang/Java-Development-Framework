package cn.ustb.controller;

import cn.ustb.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    // http://localhost:8080/user/t1?name=smith
    @GetMapping("/t1")
    public String test1(String name, Model model) {
        // 1、接收前端参数
        System.out.println("接收到的前端参数为：" + name);
        // 2、将返回的结果传给前端
        model.addAttribute("msg", name);
        // 3、视图跳转
        return "test";
    }

    // http://localhost:8080/user/t2?username=smith
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model) {
        // 1、接收前端参数
        System.out.println("接收到的前端参数为：" + name);
        // 2、将返回的结果传给前端
        model.addAttribute("msg", name);
        // 3、视图跳转
        return "test";
    }

    /*
        分析：
        1、接收前端用户传递的参数，判断参数的名称，如果和方法的参数名称一致，可以直接使用
        2、假设接收的是一个对象，匹配对象中各个字段，如果名称一致则成功匹配，否则匹配不到
        前端接收的是一个User对象：id、name、age
     */
    // http://localhost:8080/user/t3?id=1&name=smith&age=10
    @GetMapping("/t3")
    public String test3(User user) {
        // 1、接收前端参数
        System.out.println("接收到的前端对象为：" + user);
        // 2、视图跳转
        return "test";
    }

}
