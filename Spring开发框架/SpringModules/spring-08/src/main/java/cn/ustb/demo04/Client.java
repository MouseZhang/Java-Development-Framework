package cn.ustb.demo04;

import cn.ustb.demo02.UserService;
import cn.ustb.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        // 1、真实角色
        UserService userService = new UserServiceImpl();
        // 2、代理角色，使用代理处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        pih.setTarget(userService); // 3、设置要代理的对象
        // 4、动态生成代理类
        UserService proxy = (UserService) pih.getProxy();
        proxy.insert();
        proxy.delete();
    }
}
