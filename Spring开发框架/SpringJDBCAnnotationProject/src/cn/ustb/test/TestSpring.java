package cn.ustb.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.dao.INewsDAO;
import cn.ustb.vo.News;

public class TestSpring {
	public static void main(String[] args) throws Exception {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 为了简化测试此时使用dao层（代替service层）
		INewsDAO dao = ctx.getBean("newsDAOImpl", INewsDAO.class);
		News vo = new News();
		vo.setTitle("天气寒冷");
		vo.setPubdate(new java.util.Date());
		vo.setContent("多喝热水");
		System.out.println(dao.doCreate(vo));
	}
}
