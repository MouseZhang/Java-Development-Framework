package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberUpdateMap {
	public static void main(String[] args) {
		Member member = new Member();
		member.setMid("ustb");
		member.setName("雪人");
		member.getEmails().put("a@aa.com", "工作邮箱");
		member.getEmails().put("a@aa.com", "家庭邮箱");
		member.getEmails().put("b@aa.com", "学习邮箱");
		member.getEmails().put("c@aa.com", "个人邮箱");
		HibernateSessionFactory.getSession().update(member);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
