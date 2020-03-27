package cn.ustb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

// 启动后，访问http://localhost:7001/
@EnableEurekaServer // Eureka服务端的启动类，用于接收客户端的注册
@SpringBootApplication
public class EurekaServer_7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer_7001.class, args);
    }
}
