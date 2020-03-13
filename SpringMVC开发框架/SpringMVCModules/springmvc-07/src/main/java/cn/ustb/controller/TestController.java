package cn.ustb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/test")
    public String test() {
        System.out.println("TestController ==> 执行了 test()");
        return "hello";
    }
}
