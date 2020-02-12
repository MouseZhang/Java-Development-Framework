package cn.ustb.test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.transform.AliasToBeanResultTransformer;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Groups;
import cn.ustb.pojo.Role;

// 多对多关系使用子查询（开发中使用）
public class TestGroupsGetSub {
	public static void main(String[] args) {
		// 1、首先查询出角色的完整信息，此时延迟加载一定是打开的
		Role role = (Role) HibernateSessionFactory.getSession().get(Role.class, 1);
		System.out.println(role.getTitle());
		// 2、利用子查询通过关系表查找到所有对应的权限组
		// 利用子查询解决多表查询问题
		String sql = "SELECT gid,title,note FROM groups WHERE gid IN(" + 
				"SELECT gid FROM role_groups WHERE rid=?)";
		Query query = HibernateSessionFactory.getSession().createSQLQuery(sql);
		query.setParameter(0, role.getRid());
		// 需要将查询结果变为POJO类的形式返回
		query.setResultTransformer(new AliasToBeanResultTransformer(Groups.class));
		List<Groups> all = query.list();
		HibernateSessionFactory.closeSession();
		System.out.println(all);
		// 3、可以将List集合变为Set集合
		Set<Groups> set = new HashSet<Groups>();
		set.addAll(all);
		role.setGroupses(set);
		System.out.println(role);
	}
}
