package cn.ustb.action;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import cn.ustb.vo.Emp;

@SuppressWarnings("serial")
public class EmpAction extends ActionSupport {
	private Emp emp = new Emp();
	
	public Emp getEmp() {
		return emp;
	}

	@Override
	public String execute() throws Exception { //执行操作
		ServletActionContext.getRequest().setAttribute("birthday", new java.util.Date());
		System.out.println(this.emp);
		return "emp.insert";
	}
}
