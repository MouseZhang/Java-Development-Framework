package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberGet {
	public static void main(String[] args) {
		// 在Annocation配置中，member可以正常的查询了
		Member mem = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb - stu");
		System.out.println(mem);
		HibernateSessionFactory.closeSession();
	}
}
