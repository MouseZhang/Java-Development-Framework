package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoA {
	public static void main(String[] args) {
		// 瞬时态
		Member vo = new Member();
		vo.setMid("ustb7");
		vo.setName("您好！");
		vo.setAge(20);
		vo.setSalary(8888.0);
		vo.setBirthday(new Date());
		HibernateSessionFactory.getSession().save(vo); // 由瞬时态变为持久态
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// 在保存完成之后，并且没有关闭Session的前提下发出了一个查询操作
		Member temp = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb7");
		System.out.println(temp);
	}
}
