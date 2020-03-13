package cn.ustb.controller;

import cn.ustb.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @GetMapping("/ajax")
    public String ajax() {
        return "Ajax";
    }

    @RequestMapping("/ajaxResp")
    public void ajaxResp(String name, HttpServletResponse response) throws IOException {
        System.out.println("ajaxResp name: " + name);
        if ("admin".equals(name)) {
            response.getWriter().print("true");
        } else {
            response.getWriter().print("false");
        }
    }

    @RequestMapping("/ajaxUser")
    public List<User> ajaxUser() {
        List<User> users = new ArrayList<User>();
        // 添加数据
        users.add(new User("SMITH", 20, "男"));
        users.add(new User("ALLEN", 18, "女"));
        users.add(new User("LEE", 22, "男"));
        return users;
    }

    @RequestMapping("/login")
    public String login(String name, String password) {
        String msg = "";
        if (!StringUtils.isEmpty(name)) {
            if ("admin".equals(name)) {
                msg = "OK";
            } else {
                msg = "用户名有误！";
            }
        }
        if (!StringUtils.isEmpty(password)) {
            if ("hello".equals(password)) {
                msg = "OK";
            } else {
                msg = "密码不正确！";
            }
        }
        return msg;
    }

}
