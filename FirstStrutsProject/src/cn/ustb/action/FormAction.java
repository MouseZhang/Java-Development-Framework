package cn.ustb.action;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.Dept;


@SuppressWarnings("serial")
public class FormAction extends ActionSupport {
	private Integer[] dno; // 与复选框组件的参数名称相同
	
	public void setDno(Integer[] dno) {
		this.dno = dno;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("************ " + Arrays.toString(this.dno));
		List<Dept> allDepts = new ArrayList<Dept>();
		for (int i = 0; i < 10; i++) {
			Dept dept = new Dept();
			dept.setDeptno(i);
			dept.setDname("开发部 - " + i);
			allDepts.add(dept);
		}
		ServletActionContext.getRequest().setAttribute("allDepts", allDepts);
		return "form.show";
	}
}
