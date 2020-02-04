package cn.ustb.test;

import cn.ustb.dbc.HibernateSessionFactory;
import cn.ustb.pojo.Member;

/**
 * <li>瞬时态与游离态无法更新数据</li>
 * <li>持久态可以更新，但是必须在Session关闭之前完成更新</li>
 * 切换方法：
 * <li>瞬时态-->持久态：save()方法、update()方法</li>
 * <li>持久态-->游离态：关闭Session</li>
 * <li>游离态-->瞬时态：delete()方法</li>
 * @author MouseZhang
 *
 */

public class TestMemberDetached {
	public static void main(String[] args) {
		Member vo = HibernateSessionFactory.getSession().get(Member.class, "ustb");
		// 此时session关闭了，变为游离态，所有数据的修改不会影响到实体数据
		HibernateSessionFactory.closeSession();
		vo.setSalary(8888.0);
		HibernateSessionFactory.getSession().beginTransaction().commit();
		// 关闭session后，变为游离态
		HibernateSessionFactory.closeSession();
	}
}
