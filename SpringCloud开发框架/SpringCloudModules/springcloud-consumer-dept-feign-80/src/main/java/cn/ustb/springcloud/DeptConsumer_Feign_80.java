package cn.ustb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;


@EnableEurekaClient
@EnableFeignClients(basePackages = {"cn.ustb.springcloud"})
//@ComponentScan("cn.ustb.springcloud")
@SpringBootApplication
public class DeptConsumer_Feign_80 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Feign_80.class, args);
    }
}
