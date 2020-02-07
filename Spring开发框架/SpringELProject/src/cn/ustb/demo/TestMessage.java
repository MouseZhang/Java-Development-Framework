package cn.ustb.demo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.vo.Message;


public class TestMessage {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Message msg = ctx.getBean("msg", Message.class);
		System.out.println(msg.getInfo());
	}
}
