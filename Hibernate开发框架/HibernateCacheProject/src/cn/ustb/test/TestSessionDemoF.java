package cn.ustb.test;

import java.util.Date;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

public class TestSessionDemoF {
	public static void main(String[] args) {
		// 批量数据增加的开发（使用Hibernate进行数据批处理）
		for (int i = 100; i < 1000; i++) {
			Member vo = new Member();
			vo.setMid("ibeike" + i);
			vo.setName("您好");
			vo.setAge(20 + i);
			vo.setSalary(8888.0 + i);
			vo.setBirthday(new Date());
			HibernateSessionFactory.getSession().save(vo);
			if (i % 10 == 0) { // 每10条记录进行一次缓冲区的刷新
				HibernateSessionFactory.getSession().flush(); // 强制刷新缓冲区操作
				HibernateSessionFactory.getSession().clear(); // 清空所有缓存数据
				HibernateSessionFactory.getSession().beginTransaction().commit();
			}
		}
		// 由于save()方法保存对象之后，对象会保存在缓存之中，所以此时不会发出ibeike0、ibeike1的两条查询指令
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
