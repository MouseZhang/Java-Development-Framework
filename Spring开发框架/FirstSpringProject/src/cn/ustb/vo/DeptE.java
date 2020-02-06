package cn.ustb.vo;

import java.beans.ConstructorProperties;

public class DeptE {
	
	private Integer deptno;
	private String dname;
	
	@ConstructorProperties(value={"paramDeptno","paramDname"})
	public DeptE(Integer deptno, String dname) {
		this.deptno = deptno;
		this.dname = dname;
	}
	
	@Override
	public String toString() {
		return "雇员编号：" + this.deptno + "，雇员姓名：" + this.dname;
	}
}
