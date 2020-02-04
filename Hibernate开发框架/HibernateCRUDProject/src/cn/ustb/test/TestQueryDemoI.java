package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToBeanResultTransformer;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoI {
	public static void main(String[] args) {
		// 使用标准SQL查询，开发中不建议使用
		String hql = "SELECT n.title AS title,n.item AS item FROM news AS n";
		Query query = HibernateSessionFactory.getSession().createSQLQuery(hql);
		query.setResultTransformer(new AliasToBeanResultTransformer(News.class));
		List<News> all = query.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		HibernateSessionFactory.closeSession();
	}
}
