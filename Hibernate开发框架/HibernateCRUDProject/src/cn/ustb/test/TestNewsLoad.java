package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsLoad {
	public static void main(String[] args) {
		// 如果没有值，会出现ObjectNotFoundException异常
		News vo = (News) HibernateSessionFactory.getSession().load(News.class, 1);
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}