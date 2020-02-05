package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;
import cn.ustb.pojo.MemberId;

public class TestMemberInsert {
	public static void main(String[] args) {
		MemberId id = new MemberId();
		id.setMid("ustb");
		id.setName("周末愉快");
		Member vo = new Member();
		vo.setId(id);
		vo.setAge(20);
		System.out.println(HibernateSessionFactory.getSession().save(vo));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
