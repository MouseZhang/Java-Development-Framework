package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Student;

public class TestStudentGet {
	public static void main(String[] args) {
		Student stu = (Student) HibernateSessionFactory.getSession().get(Student.class, "ustb - stu");
		System.out.println(stu);
		HibernateSessionFactory.closeSession();
	}
}
