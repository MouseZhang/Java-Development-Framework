package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ModelTest {

    @RequestMapping("/m1/t1")
    public String test1(Model model) {
        // 此种方式需要注掉springmvc-servlet.xml中的视图解析器
        // 转发的方式一：
        model.addAttribute("msg", "ModelTest");
        return "/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t2")
    public String test2(Model model) {
        // 此种方式需要注掉springmvc-servlet.xml中的视图解析器
        // 转发的方式二：
        model.addAttribute("msg", "ModelTest");
        return "forward:/WEB-INF/jsp/test.jsp";
    }

    @RequestMapping("/m1/t3")
    public String test3(Model model) {
        // 有没有视图解析器都可以使用此种方式进行重定向
        // 重定向：
        model.addAttribute("msg", "ModelTest");
        return "redirect:/index.jsp";
    }

}
