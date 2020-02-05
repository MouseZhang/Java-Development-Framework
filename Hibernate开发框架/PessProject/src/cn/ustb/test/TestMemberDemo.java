package cn.ustb.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberDemo {
	public static void main(String[] args) {
		// 乐观锁
		SessionFactory factory = HibernateSessionFactory.getSessionFactory();
		Session sessionA = factory.openSession();
		Session sessionB = factory.openSession();
		Member memberA = (Member) sessionA.get(Member.class, "ustb");
		Member memberB = (Member) sessionB.get(Member.class, "ustb");
		// 下面两个Session读取出来的数据一起更新
		memberA.setAge(20);
		sessionA.beginTransaction().commit();
		
		memberB.setAge(30);
		sessionB.beginTransaction().commit();
	}
}
