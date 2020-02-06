package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Student;

public class TestStudentInsert {
	public static void main(String[] args) {
		Student stu = new Student();
		stu.setMid("ustb - stu");
		stu.setName("学生");
		stu.setAge(16);
		stu.setSchool("清华大学");
		stu.setScore(130.0);
		System.out.println(HibernateSessionFactory.getSession().save(stu));
		HibernateSessionFactory.getSession().beginTransaction().commit();
		HibernateSessionFactory.closeSession();
	}
}
