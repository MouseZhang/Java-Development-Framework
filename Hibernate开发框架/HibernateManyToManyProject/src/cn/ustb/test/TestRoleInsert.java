package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

public class TestRoleInsert {
	public static void main(String[] args) {
		int[] gids = new int[] {1, 3, 5};
		Role role = new Role();
		role.setTitle("新增角色Role");
		role.setNote("ustb");
		for (int i = 0; i < gids.length; i++) { // 处理权限组
			Groups g = new Groups();
			g.setGid(gids[i]);
			role.getGroupses().add(g); // 配置角色与权限的关系
		}
		System.out.println(HibernateSessionFactory.getSession().save(role));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
