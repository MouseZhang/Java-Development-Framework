package cn.ustb.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryDemoH {
	public static void main(String[] args) {
		// 分组统计查询
		String column = "title";
		String keyWord = "";
		String hql = "SELECT n.item,COUNT(*) AS mcount,SUM(n.visits) AS msum "
				+ "FROM News AS n WHERE n." + column + " LIKE ? GROUP BY n.item HAVING SUM(n.visits)>10";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "%" + keyWord + "%");
		List<Object[]> all = query.list();
		Iterator<Object[]> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(Arrays.toString(iter.next()));
		}
		HibernateSessionFactory.closeSession();
	}
}
