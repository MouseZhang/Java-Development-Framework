package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestCriteriaDemoA {
	public static void main(String[] args) {
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(News.class);
		List<News> all = criteria.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			News vo = iter.next();
			System.out.println(vo);
		}
		HibernateSessionFactory.closeSession();
	}
}
