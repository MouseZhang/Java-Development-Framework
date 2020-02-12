package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Item;

public class TestItemGetB {
	public static void main(String[] args) {
		Item item = (Item) HibernateSessionFactory.getSession().get(Item.class, 11);
		System.out.println("一级栏目标题：" + item.getTitle());
		HibernateSessionFactory.closeSession(); // 不建议的做法
		// 出现：org.hibernate.LazyInitializationException，因为在调用多方数据前已经关闭了Session，
		// 所以没有Session供接下来使用，那么自然就无法进行数据的读取了，此时可以将Item中的延迟加载关闭
		// 修改为：<set name="subitems" cascade="all" inverse="true" lazy="false">(开发中应该设为lazy="true")
		// 如果延迟加载取消了，那么在查询一方数据的时候，多方数据也会被加载进来，会出现“1+N”此查询情况
		System.out.println("二级栏目标题：" + item.getSubitems());
	}
}
