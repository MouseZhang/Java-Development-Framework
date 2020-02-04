package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestCriteriaDemoB {
	public static void main(String[] args) {
		// 根据ID查询
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(News.class);
		criteria.add(Restrictions.eq("nid", 1));
		List<News> all = criteria.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			News vo = iter.next();
			System.out.println(vo);
		}
		HibernateSessionFactory.closeSession();
	}
}
