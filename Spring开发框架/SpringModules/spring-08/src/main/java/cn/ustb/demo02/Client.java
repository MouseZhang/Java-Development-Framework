package cn.ustb.demo02;

public class Client {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        // 使用代理
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.insert();
        proxy.delete();
    }
}
