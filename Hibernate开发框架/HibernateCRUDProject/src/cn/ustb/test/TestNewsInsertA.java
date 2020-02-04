package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsInsertA {
	public static void main(String[] args) {
		News vo = new News();
		vo.setTitle("今天放假了！");
		vo.setItem("热点新闻");
		vo.setVisits(20);
		Integer nid = (Integer) HibernateSessionFactory.getSession().save(vo);
		System.out.println("【当前数据ID】：" + nid);
		System.out.println("vo类中的ID属性：" + vo.getNid());
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
