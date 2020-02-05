package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberGet {
	public static void main(String[] args) {
		// 在进行UNION-SUBCLASS的映射过程中，member的查询无法使用
		Member mem = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb - stu");
		System.out.println(mem);
		HibernateSessionFactory.closeSession();
	}
}
