package cn.ustb.demo03;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 会用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }

    // 生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(), // 类加载器
                rent.getClass().getInterfaces(), // 代理类的接口
                this);
    }

    // 处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        // 动态代理的本质，就是反射机制
        Object result = method.invoke(rent, args);
        contract();
        fare();
        return result;
    }

    // 看房
    public void seeHouse() {
        System.out.println("***** 中介带着看房子！");
    }

    // 签租赁合同
    public void contract() {
        System.out.println("***** 签租赁合同！");
    }

    // 收中介费
    public void fare() {
        System.out.println("***** 收取中介费！");
    }

}
