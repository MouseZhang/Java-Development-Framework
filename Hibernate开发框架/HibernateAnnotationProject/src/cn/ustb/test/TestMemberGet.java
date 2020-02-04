package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberGet {
	public static void main(String[] args) {
		// 在session没有关闭之前处于持久态
		Member vo = HibernateSessionFactory.getSession().get(Member.class, "ustb");
		// session不关闭时，只需要调用setter()方法就可以更新了
		vo.setSalary(9000.0);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// 关闭session后，变为游离态
		HibernateSessionFactory.closeSession();
	}
}
