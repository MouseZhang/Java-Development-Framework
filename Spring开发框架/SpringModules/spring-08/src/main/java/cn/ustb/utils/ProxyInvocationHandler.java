package cn.ustb.utils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 工具类
// 会用这个类自动生成代理类
public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理的接口
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 生成得到代理类
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(), // 类加载器
                target.getClass().getInterfaces(), // 代理类的接口
                this);
    }

    // 处理代理实例，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 动态代理的本质，就是反射机制
        Object result = method.invoke(target, args);
        return result;
    }

}
