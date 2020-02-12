package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;
import cn.ustb.pojo.Subitem;

public class TestItemInsertB {
	public static void main(String[] args) {
		Item item = new Item();
		item.setTitle("娱乐游戏");
		for (int i = 0; i < 5; i++) {
			Subitem sub = new Subitem();
			sub.setTitle("游戏 - " + i);
			sub.setItem(item); // 设置关系
			item.getSubitems().add(sub); // 主表保存数据
		}
		System.out.println(HibernateSessionFactory.getSession().save(item));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
