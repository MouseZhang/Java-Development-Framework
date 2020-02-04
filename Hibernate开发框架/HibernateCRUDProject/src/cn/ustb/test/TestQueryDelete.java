package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestQueryDelete {
	public static void main(String[] args) {
		// 使用Query接口删除数据，日后开发中的更新、删除操作使用Query接口来完成
		String hql = "DELETE FROM News WHERE nid=?";
		Query query = HibernateSessionFactory.getSession().createQuery(hql);
		query.setParameter(0, 3);
		int len = query.executeUpdate();
		HibernateSessionFactory.getSession().beginTransaction().commit();
		System.out.println("【删除行数】：" + len);
		HibernateSessionFactory.closeSession();
	}
}
