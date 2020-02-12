package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;
import cn.ustb.pojo.Subitem;

public class TestSubitemInsert {
	public static void main(String[] args) {
		Item item = new Item();
		item.setIid(2); // 设置好Item的编号
		item.setTitle("反着测试 - Item"); // 在进行子表数据增加的时候这行语句就没有用处了，此时只考虑子表的数据
		Subitem sub = new Subitem();
		sub.setTitle("反着测试 - Subitem");
		sub.setItem(item);
		item.getSubitems().add(sub);
		// 现在直接保存子表的数据（不建议操作）
		System.out.println(HibernateSessionFactory.getSession().save(sub));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
