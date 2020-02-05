package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;

/**
 * delete()与Query删除的区别：(开发中尽可能使用Query接口删除)
 * delete()删除的时候会考虑到数据关系的维护，会首先发出查询，而后删除子表再删除父表，这样比较麻烦
 * Query删除只是删除一张表数据，不关心数据关联的维护
 * @author MouseZhang
 *
 */
public class TestMemberDeleteQuery {
	public static void main(String[] args) {
		Query query = HibernateSessionFactory.getSession().createQuery("DELETE FROM Member AS m WHERE m.mid=?"); 
		query.setParameter(0, "ustb");
		System.out.println(query.executeUpdate());
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
