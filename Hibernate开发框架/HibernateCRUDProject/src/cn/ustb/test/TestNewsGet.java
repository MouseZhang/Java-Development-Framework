package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsGet {
	public static void main(String[] args) {
		// 如果没有值，返回null
		News vo = (News) HibernateSessionFactory.getSession().get(News.class, 1);
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}