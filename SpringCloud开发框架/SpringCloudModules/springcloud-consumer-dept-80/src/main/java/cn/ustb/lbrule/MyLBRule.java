package cn.ustb.lbrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyLBRule { // 自定义组件
    @Bean
    public IRule myRule() {
        // return new MyRandomRule(); //默认是轮寻，现在自定义MyRandomRule
        return new RandomRule();
    }

}
