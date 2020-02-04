package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoF {
	public static void main(String[] args) {
		// 分页显示
		int currentPage = 1;
		int lineSize = 2;
		String column = "title";
		String keyWord = "";
		String hql = "FROM News AS n WHERE n." + column + " LIKE ?";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		// 不管是什么数据库，只要是设置了分页，就可以由Hibernate自己完成分页显示
		query.setFirstResult((currentPage - 1) * lineSize); // 开始
		query.setMaxResults(lineSize);
		List<News> all = query.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		HibernateSessionFactory.closeSession();
	}
}
