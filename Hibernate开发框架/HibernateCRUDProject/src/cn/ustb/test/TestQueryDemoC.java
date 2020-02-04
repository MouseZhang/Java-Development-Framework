package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;
import org.hibernate.transform.AliasToBeanResultTransformer;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoC {
	public static void main(String[] args) {
		// 使用标准sql时不再以POJO类的形式返回，而是以对象数组的形式返回
		String hql = "SELECT n.title AS title,n.item AS item FROM News AS n"; // hql查询全部
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setResultTransformer(new AliasToBeanResultTransformer(News.class));
		List<News> all = query.list();
		Iterator<News> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		HibernateSessionFactory.closeSession();
	}
}
