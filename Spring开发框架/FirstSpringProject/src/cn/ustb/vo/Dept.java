package cn.ustb.vo;

import java.util.List;

public class Dept {
	
	private Integer deptno;
	private String dname;
	private boolean close;
	private List<Emp> emps;
	
	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}
	

	public List<Emp> getEmps() {
		return emps;
	}

	public void setEmps(List<Emp> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "部门编号：" + this.deptno + "，部门名称：" + this.dname + "，关闭标记：" + this.close + "，雇员：" + this.emps;
	}
}
