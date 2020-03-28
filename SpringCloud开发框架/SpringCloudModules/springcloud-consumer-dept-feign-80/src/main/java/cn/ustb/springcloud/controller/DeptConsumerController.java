package cn.ustb.springcloud.controller;

import cn.ustb.springcloud.pojo.Dept;
import cn.ustb.springcloud.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService = null;

    @RequestMapping("/consumer/dept/insert")
    public boolean insert(Dept dept) {
        return this.deptClientService.insertDept(dept);
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept get(@PathVariable("id") long id) {
        return this.deptClientService.getDeptById(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> list() {
        return this.deptClientService.listDepts();
    }

}
