package cn.ustb.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import cn.ustb.pojo.Member;
import cn.ustb.util.MySession;

public class TestMySessionDemo {
	public static void main(String[] args) {
		Member vo = new Member();
		vo.setMid("ustb2");
		vo.setName("JONE");
		vo.setAge(18);
		vo.setSalary(8800.0);
		vo.setBirthday(new Date());
		vo.setNote("www.ustb.cn");
		MySession ms = new MySession();
		ms.save(vo);
	}
}
