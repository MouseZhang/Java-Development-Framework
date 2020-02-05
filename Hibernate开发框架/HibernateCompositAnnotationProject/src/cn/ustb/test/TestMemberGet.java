package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;
import cn.ustb.pojo.MemberId;

public class TestMemberGet {
	public static void main(String[] args) {
		MemberId id = new MemberId();
		id.setMid("ustb");
		id.setName("您好");
		Member vo = (Member) HibernateSessionFactory.getSession().get(Member.class, id);
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
