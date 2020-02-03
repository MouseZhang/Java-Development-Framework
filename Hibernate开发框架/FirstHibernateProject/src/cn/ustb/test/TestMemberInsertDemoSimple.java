package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestMemberInsertDemoSimple {
	public static void main(String[] args) {
		// 1、设置vo的属性内容应该由控制层完成
		Member vo = new Member();
		vo.setMid("ustb3");
		vo.setName("LEE");
		vo.setAge(19);
		vo.setSalary(9800.0);
		vo.setBirthday(new Date());
		vo.setNote("www.ustb.cn");
		// 2、数据的保存操作应该由数据层完成
		HibernateSessionFactory.getSession().save(vo);
		// 3、事务以及Session的关闭应该由业务层完成
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
