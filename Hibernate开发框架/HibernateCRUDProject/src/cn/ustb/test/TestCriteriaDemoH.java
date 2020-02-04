package cn.ustb.test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestCriteriaDemoH {
	public static void main(String[] args) {
		// 进行分组统计
		Criteria criteria = HibernateSessionFactory.getSession().createCriteria(News.class);
		criteria.addOrder(Order.desc("nid")); // 按主键降序排列
		ProjectionList list = Projections.projectionList(); // 可以增加一系列的分组操作
		list.add(Projections.rowCount()); // 统计行数
		list.add(Projections.sum("visits"));
		list.add(Projections.groupProperty("item")); // 进行分组
		criteria.setProjection(list);
		List<Object[]> all = criteria.list();
		Iterator<Object[]> iter = all.iterator();
		while (iter.hasNext()) {
			System.out.println(Arrays.toString(iter.next()));
		}
		HibernateSessionFactory.closeSession();
	}
}
