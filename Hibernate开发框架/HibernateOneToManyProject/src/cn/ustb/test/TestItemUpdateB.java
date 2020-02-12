package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;
import cn.ustb.pojo.Subitem;

public class TestItemUpdateB {
	public static void main(String[] args) {
		Item item = new Item();
		item.setIid(1); 
		item.setTitle("反着测试 - Item");
		Subitem sub = new Subitem();
		sub.setSid(16); // 此时由于sid的存在，不会在subitem中出现增加操作了
		sub.setTitle("更新测试");
		sub.setItem(item);
		item.getSubitems().add(sub);
		// 用update()测试是为了观察出数据的级联操作，开发中一般使用Query()更新
		HibernateSessionFactory.getSession().update(item);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
