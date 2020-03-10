package cn.ustb.demo03;

public class Client {
    public static void main(String[] args) {
        // 真实角色
        Host host = new Host();
        // 代理角色（使用代理处理程序，生成代理类)
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        // 通过调用程序处理角色，来处理我们要调用的接口对象
        // 调用真实程序
        pih.setRent(host);
        // 创建代理类
        Rent proxy = (Rent) pih.getProxy(); // 这里的proxy就是动态生成的代理
        proxy.rent();
    }
}
