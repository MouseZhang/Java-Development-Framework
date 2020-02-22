package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

// 在templates目录下的所有页面，只能通过controller跳转！（WEB-INF）
// 需要模版引擎的支持（Thymeleaf）
@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        model.addAttribute("msg", "<h1>Hello SpringBoot</h1>");
        model.addAttribute("users", Arrays.asList("SMITH", "JONE"));
        return "index";
    }

}
