package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberUpdate {
	public static void main(String[] args) {
		Member member = new Member();
		member.setMid("ustb");
		member.setName("雪人");
//		member.getEmails().add("a@aa.com");
//		member.getEmails().add("a@aa.com");
//		member.getEmails().add("b@aa.com");
//		member.getEmails().add("c@aa.com");
//		member.getEmails().add("d@aa.com");
		HibernateSessionFactory.getSession().update(member);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
