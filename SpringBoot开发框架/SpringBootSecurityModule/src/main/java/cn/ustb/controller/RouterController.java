package cn.ustb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin() {
        return "views/login";
    }

    @RequestMapping({"/level1/{pn}"})
    public String toLevel1(@PathVariable("pn") int pn) {
        return "views/level1/" + pn;
    }

    @RequestMapping({"/level2/{pn}"})
    public String toLevel2(@PathVariable("pn") int pn) {
        return "views/level2/" + pn;
    }

    @RequestMapping({"/level3/{pn}"})
    public String toLevel3(@PathVariable("pn") int pn) {
        return "views/level3/" + pn;
    }

}
