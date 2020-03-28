package cn.ustb.springcloud.controller;

import cn.ustb.springcloud.pojo.Dept;
import cn.ustb.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Autowired
    private DiscoveryClient discoveryClient; // 用于获取一些微服务配置信息

    @PostMapping("/dept/insert")
    public boolean insert(Dept dept) {
        return deptService.insertDept(dept);
    }

    @GetMapping("/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return deptService.getDeptById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> list() {
        return deptService.listDepts();
    }

    // 注册进来的微服务，用于获取消息信息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        // 获取微服务列表的清单
        List<String> services = discoveryClient.getServices();
        services.forEach(System.out::println);
        // 得到具体的微服务信息，通过微服务ID（applicationName）获取
        List<ServiceInstance> instances = discoveryClient.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println("Host: " + instance.getHost() + "，Port: " + instance.getPort() + "，Uri: " + instance.getUri() + "，ServiceId: " + instance.getServiceId());
        }
        return this.discoveryClient;
    }
}
