package cn.ustb.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@EnableHystrixDashboard // 开启监控页面
@SpringBootApplication
public class DeptConsumer_Dashboard_9001 {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_Dashboard_9001.class, args);
    }
}
