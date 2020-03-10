package cn.ustb.test;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.ustb.pojo.News;
import cn.ustb.service.INewsService;
import junit.framework.TestCase;

public class INewsServiceTest {
	
	public static ApplicationContext ctx;
	static {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testInsert() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		News vo = new News();
		vo.setTitle("SSH项目整合新增测试");
		vo.setPubdate(new Date());
		vo.setContent("测试通过");
		try {
			TestCase.assertTrue(service.insert(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testUpdate() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		News vo = new News();
		vo.setNid(22);
		vo.setTitle("SSH项目整合修改测试");
		vo.setPubdate(new Date());
		vo.setContent("测试通过");
		try {
			TestCase.assertTrue(service.update(vo));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testDelete() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		Set<Integer> set = new HashSet<Integer>();
		set.add(9);
		set.add(10);
		set.add(11);
		try {
			TestCase.assertTrue(service.delete(set));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGet() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		try {
			News vo = service.get(22);
			System.out.println(vo);
			TestCase.assertNotNull(vo);;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testList() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		try {
			List<News> all = service.list();
			System.out.println(all);
			TestCase.assertTrue(all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testListStringStringIntInt() {
		INewsService service = ctx.getBean("newsServiceImpl", INewsService.class);
		try {
			Map<String, Object> all = service.list("title", "", 4, 5);
			System.out.println(all);
			TestCase.assertTrue(all.size() > 0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
