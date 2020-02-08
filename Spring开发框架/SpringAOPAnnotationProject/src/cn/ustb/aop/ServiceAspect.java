package cn.ustb.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import cn.ustb.vo.Member;

@Component
@Aspect
public class ServiceAspect {
	@Before(value="execution(* cn.ustb..*.*(..))")
	public void serviceBefore() {
		System.out.println("【AOP切面】执行日志记录操作");
	}
	
	@Before(value="execution(* cn.ustb..*.*(..)) and args(param)",argNames="param")
	public void serviceMethod(Object arg) {
		System.out.println("【AOP切面】执行增加前的操作，参数 = " + arg);
	}
	
	@After(value="execution(* cn.ustb..*.*(..))")
	public void serviceAfter() {
		System.out.println("【AOP切面】执行事务处理操作");
	}
	
	@AfterReturning(value="execution(* cn.ustb..*.*(..))",argNames="ret",returning="ret")
	public void serviceAfterReturning(Object val) { // 表示操作结果
		System.out.println("【AOP切面】操作完成，返回结果：" + val);
	}
	
	@AfterThrowing(value="execution(* cn.ustb..*.*(..))",argNames="e",throwing="e")
	public void serviceAfterThrowing(Exception exp) {
		System.out.println("【AOP切面】操作出现异常：" + exp);
	}
	
	@Around(value="execution(* cn.ustb..*.*(..))")
	public Object serviceAround(ProceedingJoinPoint point) throws Throwable {
		System.out.println("【AOP切面】数据层方法调用之前，参数：" + Arrays.toString(point.getArgs()));
		Member vo = new Member();
		vo.setMid(20);
		vo.setName("哈哈");
		Object retVal = point.proceed(new Object[] {vo}); // 调用具体的真实操作
		System.out.println("【AOP切面】数据层方法调用之后，返回值：" + retVal);
		return true; // 可以自己修改返回值
	}
	
}
