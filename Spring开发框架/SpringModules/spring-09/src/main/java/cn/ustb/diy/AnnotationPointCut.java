package cn.ustb.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

// 方式三：使用注解方式实现AOP
@Aspect // 标志为一个切面（类）
public class AnnotationPointCut {
    @Before("execution(* cn.ustb.service.UserServiceImpl.*(..))") // 通知（方法）
    public void before() {
        System.out.println("======== 方法执行前 ========");
    }
    @After("execution(* cn.ustb.service.UserServiceImpl.*(..))") // 通知（方法）
    public void after() {
        System.out.println("======== 方法执行后 ========");
    }
    // 环绕增强中，可以给定一个参数，代表要获取处理切入的点
    @Around("execution(* cn.ustb.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("======== 环绕执行前 ========");
        // 执行方法
        Object proceed = jp.proceed();
        System.out.println("======== 环绕执行后 ========");

        // Signature signature = jp.getSignature();// 获得签名
        // System.out.println("【Signature】：" + signature);
        // System.out.println(proceed);
    }
}
