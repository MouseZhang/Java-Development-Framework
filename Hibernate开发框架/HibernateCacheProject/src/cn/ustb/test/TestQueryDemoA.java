package cn.ustb.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryDemoA {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSession().getSessionFactory();
		Session sessionA = factory.openSession();
		// 如果使用Query查询，那么所配置的二级缓存无效，因为Query接口默认情况下没有启动缓存的支持
		Query queryA = sessionA.createQuery("FROM Member AS m WHERE m.mid=?");
		queryA.setParameter(0, "ustb");
		System.out.println(queryA.uniqueResult());
		System.out.println("*********************************");
		Session sessionB = factory.openSession();
		Query queryB = sessionB.createQuery("FROM Member AS m WHERE m.mid=?");
		queryB.setParameter(0, "ustb");
		System.out.println(queryB.uniqueResult());
	}
}
