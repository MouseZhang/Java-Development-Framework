package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoD {
	public static void main(String[] args) {
		// hql中FROM子句后跟的是POJO类的名字，必须注意大小写!
		String hql = "FROM News AS n WHERE n.nid=?"; // hql查询全部
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
//		query.setInteger(0, 3);
		query.setParameter(0, 3); // 所有的类型由Hibernate自己处理
//		List<News> all = query.list();
//		System.out.println(all.get(0));
		News vo = (News) query.uniqueResult(); // 只返回一个数据的情况
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
