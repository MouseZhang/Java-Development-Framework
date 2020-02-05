package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoB {
	public static void main(String[] args) {
		// 在保存完成之后，并且没有关闭Session的前提下发出了一个查询操作
		Member vo = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb5");
		// 此时没有关闭Session，再一次发出同样的查询操作
		Member temp = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb5");
	}
}
