package cn.ustb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.demo.Apple;
import cn.ustb.demo.IFruit;

/**
 * 所有的工厂都由Spring帮助用户自动处理，而且在applicationContext.xml文件配置信息内容，
 * 都会在Spring容器启动的时候默认实例化好了所有的对象，使用的时候根据id名称取出即可
 * Spring两大核心技术：
 * <li>Ioc&DI(控制反转&依赖注入)</li>
 * <li>AOP(面向切面编程)</li>
 * @author MouseZhang
 *
 */

public class TestFruit {
	public static void main(String[] args) {
		// ApplicationContext类：所有在applicationContext.xml中配置的信息都需要此类读取才可以
		// ClassPathXmlApplicationContext类：表示在Classpath路径中读取资源文件
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("###################");
		// getBean()方法：取得指定名称的Bean对象，并且设置泛型为指定操作的Bean类型，避免向下转型
		IFruit fruit = ctx.getBean("apple", Apple.class);
		fruit.eat(); // 核心业务操作
	}
}
