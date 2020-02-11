package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.MemberDetails;
import cn.ustb.pojo.MemberLogin;

public class TestMemberUpdateB {
	public static void main(String[] args) {
		MemberLogin login = new MemberLogin();
		login.setMid("ustb-complete");
		login.setPassword("www.ustb.cn");
		MemberDetails details = new MemberDetails();
		details.setMid("ustb-complete");
		details.setName("JONE");
		details.setEmail("a@aa.com");
		details.setPhone("999");
		login.setMemberDetails(details);
		HibernateSessionFactory.getSession().update(login);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
