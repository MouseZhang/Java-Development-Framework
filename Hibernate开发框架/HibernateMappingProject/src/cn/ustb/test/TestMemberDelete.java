package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberDelete {
	public static void main(String[] args) {
		Member member = new Member();
		member.setMid("ustb");
		HibernateSessionFactory.getSession().delete(member);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
