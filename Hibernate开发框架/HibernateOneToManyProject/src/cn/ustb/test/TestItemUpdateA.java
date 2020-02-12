package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;
import cn.ustb.pojo.Subitem;

public class TestItemUpdateA {
	public static void main(String[] args) {
		Item item = new Item();
		item.setIid(1); 
		item.setTitle("反着测试 - Item");
		Subitem sub = new Subitem();
		sub.setTitle("更新测试");
		sub.setItem(item);
		item.getSubitems().add(sub);
		// 用update()测试是为了观察出数据的级联操作，开发中一般使用Query()更新
		HibernateSessionFactory.getSession().update(item);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
