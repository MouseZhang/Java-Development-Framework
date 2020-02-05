package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsert {
	public static void main(String[] args) {
		Member vo = new Member();
		vo.setMid("ustb");
		vo.getBasic().setName("您好");
		vo.getBasic().setAge(20);
		vo.getBasic().setBirthday(new Date());
		vo.getContract().setAddress("天安门");
		vo.getContract().setZipcode("110");
		vo.getContract().setPhone("120");
		HibernateSessionFactory.getSession().save(vo);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
