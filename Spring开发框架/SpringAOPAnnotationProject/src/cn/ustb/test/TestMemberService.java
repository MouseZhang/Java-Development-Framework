package cn.ustb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.service.IMemberService;
import cn.ustb.vo.Member;

public class TestMemberService {
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		IMemberService ser = ctx.getBean("memberServiceImpl", IMemberService.class);
		Member vo = new Member();
		vo.setMid(110);
		vo.setName("ustb");
		System.out.println(ser.insert(vo));
	}
}
