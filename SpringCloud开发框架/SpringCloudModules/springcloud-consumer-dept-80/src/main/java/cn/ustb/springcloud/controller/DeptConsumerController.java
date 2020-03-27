package cn.ustb.springcloud.controller;

import cn.ustb.springcloud.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {
    /*
        1、消费者不应该有Service层，而是通过URL请求
        2、使用RestTemplate，进行远程通信，但是要先注册到Spring中
        3、通过Restful方式去请求(String url,
                Class<T> responseType,
                实体：Map)
     */

    @Autowired
    private RestTemplate restTemplate; // 用来提供多种便捷访问远程HTTP服务的方法，简单的Restful服务模版

    private static final String REST_URL_PREFIX = "http://localhost:8001";

    @RequestMapping("/consumer/dept/insert")
    public boolean insert(Dept dept) {
        return restTemplate.postForObject(REST_URL_PREFIX + "/dept/insert", dept, Boolean.class);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/get/" + id, Dept.class);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "/dept/list", List.class);
    }

}
