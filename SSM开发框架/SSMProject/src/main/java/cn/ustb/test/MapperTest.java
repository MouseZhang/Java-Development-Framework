package cn.ustb.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.ustb.dao.DeptMapper;
import cn.ustb.dao.EmpMapper;
import cn.ustb.vo.Dept;
import cn.ustb.vo.Emp;

/**
 * 
 * 测试Dao层，推荐使用Spring的单元测试方式，可以自动注入组要的组件，操作步骤如下：
 * 1、在pom文件中导入Spring-test
 * 2、@ContextConfiguration配置指定的文件
 * 3、使用Autowired要使用的组件即可
 * @author MouseZhang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class) // 使用Spring的Junit
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	
	@Autowired
	EmpMapper empMapper;
	
	@Autowired
	DeptMapper deptMapper;
	
	@Autowired
	SqlSession sqlSession;
	
	/**
	 * 原生的方式
	 * 1、创建Spring IOC容器
	 * ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
	 * 2、从容器中获取Mapper
	 * Dept dept = ctx.getBean(Dept.class);
	 */
	
	@Test
	public void testInsertDept() {
		deptMapper.insertSelective(new Dept(null, "开发部"));
		deptMapper.insertSelective(new Dept(null, "测试部"));
	}
	
	@Test
	public void testInsertEmp() {
		empMapper.insertSelective(new Emp(null, "SMITH", "M", "ustb@beijing.com", 1));
		empMapper.insertSelective(new Emp(null, "ALLEN", "F", "ustb@beijing.cn", 2));
	}
	
	@Test
	public void testInsertEmpBatch() {
		EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
		for (int i = 0; i < 1000; i++) {
			String uid = UUID.randomUUID().toString().substring(0, 5) + i;
			empMapper.insertSelective(new Emp(null, uid, "M", uid + "@ustb.cn", 1));
		}
		System.out.println("批量插入成功！");
	}
	
}
