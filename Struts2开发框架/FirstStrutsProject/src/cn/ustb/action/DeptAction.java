package cn.ustb.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.Dept;

@SuppressWarnings("serial")
public class DeptAction extends ActionSupport {
	private Dept mydept = new Dept();
//	private List<Dept> allDepts = new ArrayList<Dept>();
	public Dept getMydept() {
		return mydept;
	}
//	public List<Dept> getAllDepts() {
//		return allDepts;
//	}
	@Override
	public String execute() throws Exception {
//		this.mydept.setDeptno(10);
//		this.mydept.setDname("财务部");
//		return "dept.show";
		Dept dept = new Dept();
		dept.setDeptno(10);
		dept.setDname("财务部");
		ServletActionContext.getRequest().setAttribute("dept", dept);
		List<Dept> allDepts = new ArrayList<Dept>();
		for (int i = 0; i < 10; i++) {
			Dept d = new Dept();
			d.setDeptno(i);
			d.setDname("部门名称 - " + i);
//			this.allDepts.add(d);
			allDepts.add(d);
		}
		
		// 此时通过属性范围内的形式传递
		ServletActionContext.getRequest().setAttribute("allDepts", allDepts);
		return "dept.show";
	}
}