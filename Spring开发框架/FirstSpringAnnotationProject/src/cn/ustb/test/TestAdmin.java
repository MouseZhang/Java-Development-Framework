package cn.ustb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.service.IAdminService;

/**
 * 
 * @author MouseZhang
 *
 */

public class TestAdmin {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IAdminService vo = ctx.getBean("adminServiceImpl", IAdminService.class);
		vo.login();
	}
}
