package cn.ustb;

import cn.ustb.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // 动态代理的是接口，所以返回值接收使用UserService
        UserService userService = context.getBean("userService", UserService.class);
        userService.insert();
        userService.delete();
    }
}
