package cn.ustb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionFactoryCacheDemoB {
	public static void main(String[] args) {
		// 取得的是SessionFactory类对象
		SessionFactory factory = HibernateSessionFactory.getSession().getSessionFactory();
		Session sessionA = factory.openSession();
		Member mea = (Member) sessionA.get(Member.class, "ustb");
		System.out.println("*********************************");
		Session sessionB = factory.openSession();
		Member meb = (Member) sessionB.get(Member.class, "ustb");
	}
}
