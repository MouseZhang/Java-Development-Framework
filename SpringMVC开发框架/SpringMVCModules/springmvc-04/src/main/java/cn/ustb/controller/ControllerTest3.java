package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/c3")
public class ControllerTest3 {

    @RequestMapping("/t1")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest3");
        return "admin/admintest";
    }
}
