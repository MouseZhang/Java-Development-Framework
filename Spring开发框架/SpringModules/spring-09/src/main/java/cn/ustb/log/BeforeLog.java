package cn.ustb.log;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {
    /**
     *
     * @param method 要执行目标对象的方法
     * @param args 参数
     * @param target 目标对象
     * @throws Throwable
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("【Before】" + target.getClass().getName() + "的" + method.getName() + "被执行了");
    }
}
