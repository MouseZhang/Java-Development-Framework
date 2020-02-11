package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.MemberDetails;
import cn.ustb.pojo.MemberLogin;

public class TestMemberInsertB {
	public static void main(String[] args) {
		MemberLogin login = new MemberLogin();
		login.setMid("ustb-complete");
		login.setPassword("www.ustb.cn");
		MemberDetails details = new MemberDetails();
		details.setMid("ustb-complete");
		details.setName("SMITH");
		details.setEmail("a@aa.com");
		details.setPhone("110");
		// 设置一对一关系，虽然是一对一，一定是有主控方在里面，所以login做主控方，主控方添加即可
		login.setMemberDetails(details);
		HibernateSessionFactory.getSession().save(login);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
