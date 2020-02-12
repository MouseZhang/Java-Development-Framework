package cn.ustb.test;


import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

// 正常开发的参考
public class TestRoleUpdate {
	public static void main(String[] args) {
		// 以下的数据设置部分应该在控制器中处理
		int[] gids = new int[] {1, 2, 4};
		Role role = new Role();
		role.setRid(3);
		role.setTitle("修改角色Role New");
		role.setNote("ustb");
		for (int i = 0; i < gids.length; i++) { // 处理权限组
			Groups g = new Groups();
			g.setGid(gids[i]);
			role.getGroupses().add(g); // 配置角色与权限的关系
		}
		// 以下是由数据层控制
		// 可以发现，在多对多关系更新的过程中，如果使用update()的操作方法，那么所有的级联关系自动维护
		HibernateSessionFactory.getSession().update(role);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
