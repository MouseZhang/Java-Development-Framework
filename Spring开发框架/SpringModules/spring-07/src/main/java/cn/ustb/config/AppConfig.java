package cn.ustb.config;

import cn.ustb.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/*
    1、也会被Spring容器托管，注册到容器中，本质也是一个@Component
    2、@Configuration代表这是一个配置类，等价与之前配置的applicationContext.xml
 */
@Configuration
@ComponentScan("cn.ustb")
@Import(UstbConfig.class) // 类似引入其它的beans.xml
public class AppConfig {

    // 注册一个bean，相当于applicationContext.xml内的一个bean标签
    // 这个方法的名字就相当于bean id，方法的返回值就相当于bean class
    @Bean
    public User user() {
        return new User(); // 返回要注入到bean的对象
    }
}
