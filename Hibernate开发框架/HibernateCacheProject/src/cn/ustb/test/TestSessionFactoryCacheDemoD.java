package cn.ustb.test;

import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionFactoryCacheDemoD {
	public static void main(String[] args) {
		SessionFactory factory = HibernateSessionFactory.getSession().getSessionFactory();
		// 由于二级缓存的存在，所以此时查询的结果会自动写入到缓存之中
		Session sessionA = factory.openSession();
		Member mea = (Member) sessionA.get(Member.class, "ustb");
		System.out.println("*********************************");
		// 此时这个查询会默认去寻找二级缓存中的数据是否存在，如果存在则直接读取
		Session sessionB = factory.openSession();
		sessionB.setCacheMode(CacheMode.PUT); // 不读取二级缓存，只是向里面写
		Member meb = (Member) sessionB.get(Member.class, "ustb");
	}
}
