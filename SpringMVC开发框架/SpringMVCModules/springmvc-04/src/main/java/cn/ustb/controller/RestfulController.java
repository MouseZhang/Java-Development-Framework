package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestfulController {

    /*
        原来的方式：http://localhost:8080/add?a=1&b=2
        Restful：http://localhost:8080/add/1/2
     */

//    @RequestMapping(value="/add/{a}/{b}", method= RequestMethod.GET)
    @GetMapping("/add/{a}/{b}")
    public String testGet(@PathVariable int a, @PathVariable String b, Model model) {
        String res = a + b;
        model.addAttribute("msg", "结果1为：" + res);
        return "test";
    }

    @PostMapping("/add/{a}/{b}")
    public String testPost(@PathVariable int a, @PathVariable String b, Model model) {
        String res = a + b;
        model.addAttribute("msg", "结果2为：" + res);
        return "test";
    }

}
