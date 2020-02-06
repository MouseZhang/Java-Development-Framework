package cn.ustb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.vo.CompanyList;


/**
 * 所有的工厂都由Spring帮助用户自动处理，而且在applicationContext.xml文件配置信息内容，
 * 都会在Spring容器启动的时候默认实例化好了所有的对象，使用的时候根据id名称取出即可
 * Spring两大核心技术：
 * <li>Ioc&DI(控制反转&依赖注入)</li>
 * <li>AOP(面向切面编程)</li>
 * @author MouseZhang
 *
 */

public class TestCompanyList {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		CompanyList vo = ctx.getBean("companylist", CompanyList.class);
		System.out.println(vo);
	}
}
