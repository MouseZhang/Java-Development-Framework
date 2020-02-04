package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoE {
	public static void main(String[] args) {
		// 模糊查询
		String column = "title";
		String keyWord = "今天";
		String hql = "FROM News AS n WHERE n." + column + " LIKE ?"; 
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		List<News> all = query.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		HibernateSessionFactory.closeSession();
	}
}
