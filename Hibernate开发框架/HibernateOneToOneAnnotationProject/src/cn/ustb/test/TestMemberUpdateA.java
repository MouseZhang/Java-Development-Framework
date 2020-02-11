package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.MemberDetails;
import cn.ustb.pojo.MemberLogin;

public class TestMemberUpdateA {
	public static void main(String[] args) {
		MemberLogin login = new MemberLogin();
		login.setMid("ustb-simple");
		login.setPassword("www.ustb.cn");
		MemberDetails details = new MemberDetails();
		details.setMid("ustb-simple");
		details.setName("JONE");
		details.setEmail("a@aa.com");
		details.setPhone("120");
		login.setMemberDetails(details);
		HibernateSessionFactory.getSession().update(login);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
