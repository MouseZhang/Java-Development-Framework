package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsFindById {
	public static void main(String[] args) {
		// 查询操作Session只提供了根据ID查询的支持
		News vo = (News) HibernateSessionFactory.getSession().load(News.class, 1);
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
