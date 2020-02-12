package cn.ustb.test;

import javax.persistence.CascadeType;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

public class TestRoleInsert {
	public static void main(String[] args) {
		int[] gids = new int[] {1, 3};
		Role role = new Role();
		role.setTitle("新增角色Role");
		role.setNote("ustb");
		for (int i = 0; i < gids.length; i++) { // 处理权限组
			Groups g = new Groups();
			g.setGid(gids[i]);
			role.getGroupses().add(g); // 配置角色与权限的关系
		}
		// 此时使用Annotation配置时，在进行角色数据增加的时候，会更新groups数据表，但是本质上并不需要
		// 更新，所以此时修改Role类的cascade = CascadeType.MERGE,让其在更新的时候才出现级联，其它时候
		// 不出现级联
		System.out.println(HibernateSessionFactory.getSession().save(role));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
