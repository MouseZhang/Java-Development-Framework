package cn.ustb.controller;

import cn.ustb.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    @GetMapping("/hello")
    public String hello() {
        asyncService.hello(); // 停止3秒，网站会在转圈圈
        return "Hello执行完毕！";
    }
}
