package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;

public class TestItemInsertA {
	public static void main(String[] args) {
		Item item = new Item();
		item.setTitle("电脑办公");
		System.out.println(HibernateSessionFactory.getSession().save(item));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
