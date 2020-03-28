package cn.ustb.springcloud;

import cn.ustb.lbrule.MyLBRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/*
    Ribbon与Eureka整合以后，客户端可以直接调用，不用关心IP地址和端口号
 */
@EnableEurekaClient
@RibbonClient(name = "SPRINGCLOUD-PROVIDER-DEPT",configuration = MyLBRule.class) // 在微服务启动的时候，就能加载自定义的Ribbon类
@SpringBootApplication
public class DeptConsumer_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_80.class, args);
    }
}
