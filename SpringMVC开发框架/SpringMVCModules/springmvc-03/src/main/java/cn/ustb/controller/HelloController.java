package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/HelloController")
public class HelloController {

    // 真实访问地址：项目名/HelloController/hello
    @RequestMapping("/hello") // 处理/HelloController/hello请求
    public String hello(Model model) {
        model.addAttribute("msg", "Hello SpringMVC!"); // 使用Model封装数据
        return "hello"; // 会被视图解析器处理，找到/WEB-INF/jsp/hello.jsp
    }

}
