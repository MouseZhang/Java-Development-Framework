package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Role;

public class TestGroupsGet {
	public static void main(String[] args) {
		Role role = (Role) HibernateSessionFactory.getSession().get(Role.class, 1);
//		HibernateSessionFactory.closeSession();
		System.out.println(role.getTitle());
		// 在多对多的关系中，延迟加载依然是默认打开的状态
		System.out.println(role.getGroupses());
		// 在多对多的关系中，查询角色对应的权限信息的时候只有“join”一种操作
		HibernateSessionFactory.closeSession();
	}
}
