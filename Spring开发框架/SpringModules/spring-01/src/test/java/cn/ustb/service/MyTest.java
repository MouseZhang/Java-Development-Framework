package cn.ustb.service;

import cn.ustb.dao.UserDaoMySQLImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        // 方式一：
        // 用户实际调用的是业务层
        // UserService userService = new UserServiceImpl();
        // ((UserServiceImpl)userService).setUserDao(new UserDaoMySQLImpl());
        // userService.getUser();

        // 方式二：
        // 获取ApplicationContext，拿到Spring的容器
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("userServiceImpl");
        userServiceImpl.getUser();
    }
}
