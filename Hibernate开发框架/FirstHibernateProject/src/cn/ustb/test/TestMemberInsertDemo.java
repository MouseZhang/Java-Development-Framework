package cn.ustb.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cn.ustb.pojo.Member;

public class TestMemberInsertDemo {
	public static void main(String[] args) {
		Member vo = new Member();
		vo.setMid("ustb1");
		vo.setName("ALLEN");
		vo.setAge(16);
		vo.setSalary(8000.0);
		vo.setBirthday(new Date());
		vo.setNote("www.ustb.cn");
		Configuration configuration = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		Session session = sessionFactory.openSession();
		session.save(vo);
		session.beginTransaction().commit(); // 事务提交
		System.out.println("数据保存成功！");
		session.close();
	}
}
