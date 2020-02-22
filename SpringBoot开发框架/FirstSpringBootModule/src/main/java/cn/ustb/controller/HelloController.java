package cn.ustb.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        // 调用业务，接收前端参数
        return "Hello World!!!";
    }

}
