package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsDelete {
	public static void main(String[] args) {
		// 删除的时候设置的是一个对象
		News vo = new News();
		vo.setNid(2);
		HibernateSessionFactory.getSession().delete(vo);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
