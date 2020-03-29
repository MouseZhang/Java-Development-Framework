package cn.ustb.springcloud.service;

import cn.ustb.springcloud.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @PostMapping("/dept/insert")
    public boolean insertDept(Dept dept);

    @GetMapping("/dept/get/{id}")
    public Dept getDeptById(@PathVariable("id") Long id);

    @GetMapping("/dept/list")
    public List<Dept> listDepts();
}
