package cn.ustb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableDiscoveryClient // 配置服务发现
@EnableEurekaClient // 在服务启动后，自动注册到Eureka
@SpringBootApplication
public class DeptProvider_8001 { // 设置主启动类
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class, args);
    }
}
