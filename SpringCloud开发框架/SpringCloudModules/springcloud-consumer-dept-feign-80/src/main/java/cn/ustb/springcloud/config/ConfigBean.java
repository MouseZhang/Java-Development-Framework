package cn.ustb.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    //
    /*
        配置负载均衡实现RestTemplate
        负载均衡的算法：IRule接口
        1、AvailabilityFilteringRule：会先过滤掉跳闸的服务，对剩下的进行轮寻
        2、RoundRobinRule：轮寻算法（默认使用）
        3、RandomRule：随机算法
        4、RetryRule：会先按照轮寻获取服务，如果服务获取失败，则会在指定的时间内进行重试
     */
    @LoadBalanced // Ribbon
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
