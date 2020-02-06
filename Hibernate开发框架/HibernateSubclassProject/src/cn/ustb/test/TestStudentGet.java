package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Student;

/**
 * 数据库的连接方式：内连接和外连接
 * 都会产生笛卡尔积，这时候数据库的性能不好
 * @author MouseZhang
 *
 */

public class TestStudentGet {
	public static void main(String[] args) {
		// 此时进行查询的时候使用了一个INNER JOIN
		Student stu = (Student) HibernateSessionFactory.getSession().get(Student.class, "ustb - stu");
		System.out.println(stu);
		HibernateSessionFactory.closeSession();
	}
}
