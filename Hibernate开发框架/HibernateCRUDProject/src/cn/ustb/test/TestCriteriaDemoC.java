package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestCriteriaDemoC {
	public static void main(String[] args) {
		// 查询大于的数据
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(News.class);
		criteria.add(Restrictions.gt("visits", 100));
		List<News> all = criteria.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			News vo = iter.next();
			System.out.println(vo);
		}
		HibernateSessionFactory.closeSession();
	}
}
