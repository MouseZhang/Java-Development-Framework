package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberDemo {
	public static void main(String[] args) {
		// 瞬时态
		Member vo = new Member();
		vo.setMid("world");
		vo.setName("世界");
		vo.setAge(10);
		vo.setBirthday(new Date());
		vo.setNote("www.ustb.cn");
		// 进行数据库的保存，由瞬时态变为持久态
		System.out.println(HibernateSessionFactory.getSession().save(vo));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// session不关闭时，只需要调用setter()方法就可以更新了
		vo.setSalary(1000.0);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// 关闭session后，变为游离态
		HibernateSessionFactory.closeSession();
	}
}
