package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoJ {
	public static void main(String[] args) {
		// 另一种占位符
		String hql = "FROM News AS n WHERE n.nid=:pnid";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter("pnid", 3); 
		News vo = (News) query.uniqueResult(); // 只返回一个数据的情况
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
