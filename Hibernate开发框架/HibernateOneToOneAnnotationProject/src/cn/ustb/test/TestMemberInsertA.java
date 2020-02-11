package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.MemberLogin;

public class TestMemberInsertA {
	public static void main(String[] args) {
		MemberLogin login = new MemberLogin();
		login.setMid("ustb-simple");
		login.setPassword("www.ustb.cn");
		HibernateSessionFactory.getSession().save(login);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
