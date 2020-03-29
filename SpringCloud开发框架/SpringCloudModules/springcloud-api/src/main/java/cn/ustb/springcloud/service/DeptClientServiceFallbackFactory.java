package cn.ustb.springcloud.service;

import cn.ustb.springcloud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory { // 实现服务熔断降级

    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean insertDept(Dept dept) {
                return false;
            }

            @Override
            public Dept getDeptById(Long id) {
                return new Dept().setDeptno(id)
                                 .setDname("ID：" + id + "，无对应信息，由于客户端提供降级机制，该服务已经关闭！")
                                 .setDbSource("无数据！");
            }

            @Override
            public List<Dept> listDepts() {
                return null;
            }
        };
    }

}
