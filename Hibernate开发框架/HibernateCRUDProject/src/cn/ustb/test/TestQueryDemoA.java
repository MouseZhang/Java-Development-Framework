package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoA {
	public static void main(String[] args) {
		// hql中FROM子句后跟的是POJO类的名字，必须注意大小写!
		String hql = "FROM News AS n"; // hql查询全部
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		List<News> all = query.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		HibernateSessionFactory.closeSession();
	}
}
