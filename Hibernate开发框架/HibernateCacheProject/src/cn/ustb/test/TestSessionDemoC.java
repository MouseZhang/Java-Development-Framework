package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoC {
	public static void main(String[] args) {
		System.out.println(HibernateSessionFactory.getSession().get(Member.class, "ustb5"));
		// 此时没有关闭Session，再一次发出同样的查询操作
		Member temp = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb5");
	}
}
