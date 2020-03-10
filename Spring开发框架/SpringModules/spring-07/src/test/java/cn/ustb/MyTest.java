package cn.ustb;

import cn.ustb.config.AppConfig;
import cn.ustb.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {

    @Test
    public void test() {
        /*
            如果完全使用配置类的方式，就只能通过AnnotationConfigApplicationContext上下文来获取
            容器，通过配置类的class(AppConfig.class)来获取加载
         */
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        User user = context.getBean("user", User.class);
        System.out.println(user);
    }

}
