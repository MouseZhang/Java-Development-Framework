package cn.ustb.test;

import java.util.Iterator;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

// 以下代码不作为正常开发的参考
public class TestRoleQueryupdate {
	public static void main(String[] args) {
		// 以下的数据设置部分应该在控制器中处理
		int[] gids = new int[] {2, 4};
		Role role = new Role();
		role.setRid(3);
		role.setTitle("修改角色Role");
		role.setNote("ustb");
		for (int i = 0; i < gids.length; i++) { // 处理权限组
			Groups g = new Groups();
			g.setGid(gids[i]);
			role.getGroupses().add(g); // 配置角色与权限的关系
		}
		// 以下的数据操作部分应该由数据层操作处理
		Query query = HibernateSessionFactory.getSession().createQuery("UPDATE Role AS r SET r.title=?,r.note=? WHERE r.rid=?");
		query.setParameter(0, role.getTitle());
		query.setParameter(1, role.getNote());
		query.setParameter(2, role.getRid());
		if (query.executeUpdate() > 0) {
			// 更新角色与权限的关系
			query =  HibernateSessionFactory.getSession().createSQLQuery("DELETE FROM role_groups WHERE rid=?");
			query.setParameter(0, role.getRid()); // 此时createSQLQuery按照普通SQL执行
			if (query.executeUpdate() >= 0) {
				query = HibernateSessionFactory.getSession().createSQLQuery("INSERT INTO role_groups(rid,gid) VALUES(?,?)");
				Iterator<Groups> iter = role.getGroupses().iterator();
				while (iter.hasNext()) {
					Groups g = new Groups();
					query.setParameter(0, role.getRid());
					query.setParameter(1, g.getGid());
					query.executeUpdate();
				}
			}
		}
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
