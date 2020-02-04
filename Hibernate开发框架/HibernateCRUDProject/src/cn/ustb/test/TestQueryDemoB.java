package cn.ustb.test;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanConstructorResultTransformer;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoB {
	public static void main(String[] args) {
		// 使用标准sql时不再以POJO类的形式返回，而是以对象数组的形式返回
		String hql = "SELECT n.title,n.item FROM News AS n"; // hql查询全部
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		List<Object[]> all = query.list();
		Iterator<Object[]> iter = all.iterator();
		while (iter.hasNext()) {
			Object[] obj = iter.next();
			System.out.println(obj[0] + "，" + obj[1]);
		}
		HibernateSessionFactory.closeSession();
	}
}
