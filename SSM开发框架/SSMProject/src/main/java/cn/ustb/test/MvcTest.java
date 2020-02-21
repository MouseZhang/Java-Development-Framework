package cn.ustb.test;

import java.util.List;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;

import cn.ustb.vo.Emp;

/**
 * 使用Spring测试模块提供的测试请求功能
 * @author MouseZhang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations={"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/dispatcherServlet-servlet.xml"})
public class MvcTest {
	
	@Autowired
	WebApplicationContext context; // 传入Spring MVC的IOC
	
	MockMvc mockMvc; // 虚拟MVC请求，获取处理结果
	
	@Before
	public void initMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	
	@Test
	public void testGetEmps() throws Exception {
		
		// 模拟请求，获得返回值
		MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/emps").param("pn", "5")).andReturn();
		// 请求成功后，请求域中会有pageInfo
		MockHttpServletRequest request = result.getRequest(); // 获得请求对象
		PageInfo pi = (PageInfo) request.getAttribute("pageInfo");
		System.out.println("当前页码：" + pi.getPageNum());
		System.out.println("总页数：" + pi.getPages());
		System.out.println("总记录数：" + pi.getTotal());
		System.out.println("连续显示的页数：");
		int[] nums = pi.getNavigatepageNums();
		for (int i: nums) {
			System.out.print(" " + i);
		}
		System.out.println();
		// 获取雇员数据
		List<Emp> emps = pi.getList();
		for (Emp emp: emps) {
			System.out.println("雇员ID：" + emp.getEmpno() + "，雇员姓名：" + emp.getEname());
		}
	}
	
}
