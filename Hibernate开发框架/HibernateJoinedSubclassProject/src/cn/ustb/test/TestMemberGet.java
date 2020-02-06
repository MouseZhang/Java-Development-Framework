package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberGet {
	public static void main(String[] args) {
		// 此时进行查询的时候使用了OUTER JOIN
		Member mem = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb - stu");
		System.out.println(mem);
		HibernateSessionFactory.closeSession();
	}
}
