package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoE {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			Member vo = new Member();
			vo.setMid("ibeike" + i);
			vo.setName("您好");
			vo.setAge(20 + i);
			vo.setSalary(8888.0 + i);
			vo.setBirthday(new Date());
			HibernateSessionFactory.getSession().save(vo);
		}
		// 由于save()方法保存对象之后，对象会保存在缓存之中，所以此时不会发出ibeike0、ibeike1的两条查询指令
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// 在保存完成之后，并且没有关闭Session的前提下发出了一个查询操作
		Member vo = (Member) HibernateSessionFactory.getSession().get(Member.class, "ibeike0");
		// 此时没有关闭Session，再一次发出同样的查询操作，此时缓存中没有此对象
		Member temp = (Member) HibernateSessionFactory.getSession().get(Member.class, "ibeike1");
	}
}
