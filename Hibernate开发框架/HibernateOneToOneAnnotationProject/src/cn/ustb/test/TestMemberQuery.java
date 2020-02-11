package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

public class TestMemberQuery {
	public static void main(String[] args) {
		Query query = HibernateSessionFactory.getSession().createQuery("FROM MemberLogin AS m WHERE m.mid=?");
		query.setParameter(0, "ustb-simple");
		System.out.println(query.uniqueResult());
		HibernateSessionFactory.closeSession();
	}
}
