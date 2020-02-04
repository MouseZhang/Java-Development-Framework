package cn.ustb.test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestCriteriaDemoD {
	public static void main(String[] args) {
		// IN()操作查询的数据，最好用的操作
		Set<Integer> ids = new HashSet<Integer>();
		ids.add(1);
		ids.add(4);
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(News.class);
		criteria.add(Restrictions.in("nid", ids)); // 可以接收Collection集合
		List<News> all = criteria.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			News vo = iter.next();
			System.out.println(vo);
		}
		HibernateSessionFactory.closeSession();
	}
}
