package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryDemoG {
	public static void main(String[] args) {
		// 统计数据个数
		String column = "title";
		String keyWord = "";
		String hql = "SELECT COUNT(*) FROM News AS n WHERE n." + column + " LIKE ?";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		// Hibernate返回数据个数的统计结果类型为java.lang.Long，如果需要int需要转型
		Long num = (Long) query.uniqueResult();
		int count = num.intValue(); // 数据转型
		System.out.println(count);
		HibernateSessionFactory.closeSession();
	}
}
