package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestNewsInsertB {
	public static void main(String[] args) {
		News vo = new News();
		// saveOrUpdate()方法，若设置了主键内容则认为是更新操作，
		// 否则认为是增加操作
		vo.setNid(3);
		vo.setTitle("冬天容易犯困！");
		vo.setItem("天气预报");
		vo.setVisits(100);
		HibernateSessionFactory.getSession().saveOrUpdate(vo);
		System.out.println("vo类中的ID属性：" + vo.getNid());
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
