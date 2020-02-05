package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsert {
	public static void main(String[] args) {
		Member member = new Member();
		member.setMid("ustb");
		member.setName("您好");
//		member.getEmails().add("a@aa.com");
//		member.getEmails().add("a@aa.com");
//		member.getEmails().add("b@aa.com");
//		member.getEmails().add("c@aa.com");
		System.out.println(HibernateSessionFactory.getSession().save(member));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
