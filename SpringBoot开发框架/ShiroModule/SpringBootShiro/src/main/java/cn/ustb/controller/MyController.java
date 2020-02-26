package cn.ustb.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping({"/","/index"})
    public String toIndex(Model model) {
        model.addAttribute("msg", "Hello Shiro!!!");
        return "index";
    }

    @RequestMapping("/user/insert")
    public String insertUser() {
        return "user/insert_user";
    }

    @RequestMapping("/user/update")
    public String updateUser() {
        return "user/update_user";
    }

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        // 获取当前用户
        Subject subject = SecurityUtils.getSubject();
        // 封装用户登录数据（放入令牌加密）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行登录方法，无异常表示登录成功
        try {
            subject.login(token);
            return "index";
        } catch (UnknownAccountException e) { // 用户名不存在
            model.addAttribute("msg", "用户名不存在，请重新登录！");
            return "login";
        } catch (IncorrectCredentialsException e) { // 密码不正确
            model.addAttribute("msg", "密码错误，请重新登录！");
            return "login";
        }
    }

    @RequestMapping("/noauth")
    @ResponseBody
    public String unauthorized() {
        return "未经授权，无法访问此页面！";
    }

    @RequestMapping("/logout")
    public String toLogout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        System.out.println("********** 您已成功登出 **********");
        return "login";
    }

}
