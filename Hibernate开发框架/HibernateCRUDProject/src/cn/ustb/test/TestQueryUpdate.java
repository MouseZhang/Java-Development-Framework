package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryUpdate {
	public static void main(String[] args) {
		// 使用Query接口更新数据，日后开发中的更新、删除操作使用Query接口来完成
		String hql = "UPDATE News SET title=?,visits=? WHERE nid=?";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, "下课去打篮球");
		query.setParameter(1, 50);
		query.setParameter(2, 3);
		int len = query.executeUpdate();
		HibernateSessionFactory.getSession().beginTransaction().commit();
		System.out.println("【更新行数】：" + len);
		HibernateSessionFactory.closeSession();
	}
}
