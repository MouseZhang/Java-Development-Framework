package cn.ustb.springcloud.controller;

import cn.ustb.springcloud.pojo.Dept;
import cn.ustb.springcloud.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/dept/get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGet")
    public Dept get(@PathVariable("id") long id) {
        Dept dept = deptService.getDeptById(id);
        if (dept == null) {
            throw new RuntimeException("查找的ID：" + id + "不存在，无法取得用户信息！");
        }
        return dept;
    }

    // 熔断时的备选执行方法
    public Dept hystrixGet(@PathVariable("id") long id) {
        return new Dept().setDeptno(id)
                         .setDname("查找的ID：" + id + "不存在，启动Hystrix熔断机制！")
                         .setDbSource("指定空的数据库！");
    }

}
