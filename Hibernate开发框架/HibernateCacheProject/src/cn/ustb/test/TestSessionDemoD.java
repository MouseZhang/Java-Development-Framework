package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoD {
	public static void main(String[] args) {
		// 在保存完成之后，并且没有关闭Session的前提下发出了一个查询操作
		Member vo = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb5");
		// 将之前查询出来的对象(保存在缓存中的)进行缓存的清除
		HibernateSessionFactory.getSession().evict(vo);
		// 此时没有关闭Session，再一次发出同样的查询操作，此时缓存中没有此对象
		Member temp = (Member) HibernateSessionFactory.getSession().get(Member.class, "ustb5");
		
	}
}
