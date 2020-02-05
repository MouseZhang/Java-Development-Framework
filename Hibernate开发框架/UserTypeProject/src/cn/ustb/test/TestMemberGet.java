package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberGet {
	public static void main(String[] args) {
		// 读操作
		Member vo = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb");
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
