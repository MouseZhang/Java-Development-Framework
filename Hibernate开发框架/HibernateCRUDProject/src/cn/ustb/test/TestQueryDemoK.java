package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoK {
	public static void main(String[] args) {
		// 占位符如果混合使用，请将?写在:前面
		String hql = "FROM News AS n WHERE n.item=? AND n.nid=:pnid";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "天气预报");
		query.setParameter("pnid", 3);
		News vo = (News) query.uniqueResult(); // 只返回一个数据的情况
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
