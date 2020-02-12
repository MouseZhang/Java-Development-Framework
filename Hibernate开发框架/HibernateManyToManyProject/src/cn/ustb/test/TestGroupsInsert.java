package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;

public class TestGroupsInsert {
	public static void main(String[] args) {
		Groups gup = new Groups();
		gup.setTitle("自定义权限组");
		gup.setNote("www.ustb.cn");
		System.out.println(HibernateSessionFactory.getSession().save(gup));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
