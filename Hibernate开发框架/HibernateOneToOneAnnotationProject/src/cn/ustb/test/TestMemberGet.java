package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.MemberLogin;

public class TestMemberGet {
	public static void main(String[] args) {
		MemberLogin login = (MemberLogin) HibernateSessionFactory.getSession().get(MemberLogin.class, "ustb-simple");
		System.out.println(login);
		HibernateSessionFactory.closeSession();
	}
}
