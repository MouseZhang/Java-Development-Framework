package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsert {
	public static void main(String[] args) {
		Member vo = new Member();
		vo.setMid("hello");
		vo.setName("您好");
		vo.setAge(10);
		vo.setBirthday(new Date());
		vo.setNote("www.ustb.cn");
		System.out.println(HibernateSessionFactory.getSession().save(vo));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
