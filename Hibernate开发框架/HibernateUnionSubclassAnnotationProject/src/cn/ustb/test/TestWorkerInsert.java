package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Worker;

public class TestWorkerInsert {
	public static void main(String[] args) {
		Worker wk = new Worker();
		wk.setMid("ustb - wk");
		wk.setName("工人");
		wk.setAge(36);
		wk.setCompany("苹果公司");
		wk.setSalary(10000.0);
		System.out.println(HibernateSessionFactory.getSession().save(wk));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
