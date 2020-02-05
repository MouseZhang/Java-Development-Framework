package cn.ustb.test;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryLock {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSession().getSessionFactory();
		Session sessionA = factory.openSession();
		Query queryA = sessionA.createQuery("FROM Member AS m WHERE m.mid=?");
		// 悲观锁：此时数据将采用锁定的模式，其它的Session将无法进行直接更新，也不会进行等待（悲观锁好用）
		queryA.setLockMode("m", LockMode.UPGRADE_NOWAIT);
		queryA.setParameter(0, "ustb");
		queryA.setCacheable(true);
		System.out.println(queryA.uniqueResult());
	}
}
