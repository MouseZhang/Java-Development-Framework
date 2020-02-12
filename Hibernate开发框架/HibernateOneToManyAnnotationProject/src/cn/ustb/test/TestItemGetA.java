package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;

public class TestItemGetA {
	public static void main(String[] args) {
		Item item = (Item) HibernateSessionFactory.getSession().get(Item.class, 7);
		System.out.println("一级栏目标题：" + item.getTitle());
		System.out.println("二级栏目标题：" + item.getSubitems());
		// 正确的做法
		HibernateSessionFactory.closeSession();
	}
}
