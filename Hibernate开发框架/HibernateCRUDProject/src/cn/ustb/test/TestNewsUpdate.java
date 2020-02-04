package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsUpdate {
	public static void main(String[] args) {
		News vo = new News();
		vo.setNid(2);
		vo.setTitle("吃口热腾腾的米饭！");
		vo.setItem("大众生活");
		vo.setVisits(30);
		HibernateSessionFactory.getSession().update(vo);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
