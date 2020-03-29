package cn.ustb.springcloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@EnableCircuitBreaker // 开启对熔断的支持
@EnableDiscoveryClient // 配置服务发现
@EnableEurekaClient // 在服务启动后，自动注册到Eureka
@SpringBootApplication
public class DeptProvider_8001 { // 设置主启动类
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider_8001.class, args);
    }

    // 添加一个Servlet，配合dashboard监控使用
    @Bean
    public ServletRegistrationBean hystrixMetricsStreamServlet() {
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
        registrationBean.addUrlMappings("/actuator/hystrix.stream");
        return registrationBean;
    }

}