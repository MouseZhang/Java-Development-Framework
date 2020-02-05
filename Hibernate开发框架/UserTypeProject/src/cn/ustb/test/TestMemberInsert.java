package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsert {
	public static void main(String[] args) {
		// 写操作
		Member vo = new Member();
		vo.setMid("ustb");
		vo.setName("您好！");
		vo.getEmails().add("a@aa.com");
		vo.getEmails().add("b@aa.com");
		vo.getEmails().add("c@aa.com");
		vo.getEmails().add("d@aa.com");
		vo.getEmails().add("e@aa.com");
		// 转换器会帮助自动拼接，将List集合变为指定的String
		HibernateSessionFactory.getSession().save(vo);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
