package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

public class TestGroupsInsert {
	public static void main(String[] args) {
		Groups gup = new Groups();
		Role roleA = new Role();
		Role roleB = new Role();
		roleA.setRid(1);
		roleB.setRid(2);
		gup.setTitle("自定义权限组");
		gup.setNote("www.ustb.cn");
		gup.getRoles().add(roleA);
		gup.getRoles().add(roleB);
		System.out.println(HibernateSessionFactory.getSession().save(gup));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
