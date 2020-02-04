package cn.ustb.test;

import org.hibernate.Query;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.News;

public class TestQueryDemoL {
	public static void main(String[] args) {
		// 读取hbm.xml配置文件中的findById配置元素内容（在根节点下写），不推荐使用
		Query query = HibernateSessionFactory.getSession().getNamedQuery("findById");
		query.setParameter(0, 3);
		News vo = (News) query.uniqueResult(); // 只返回一个数据的情况
		System.out.println(vo);
		HibernateSessionFactory.closeSession();
	}
}
