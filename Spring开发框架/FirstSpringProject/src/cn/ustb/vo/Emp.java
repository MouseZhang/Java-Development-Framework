package cn.ustb.vo;

public class Emp {
	private Integer empno;
	private String ename;
	private Dept dept;
	public Integer getEmpno() {
		return empno;
	}
	public void setEmpno(Integer empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public Dept getDept() {
		return dept;
	}
	public void setDept(Dept dept) {
		this.dept = dept;
	}
//	@Override
//	public String toString() {
//		return "雇员编号：" + empno + "，雇员姓名：" + ename + "，部门：" + dept;
//	}
	
	@Override
	public String toString() {
		return "雇员编号：" + empno + "，雇员姓名：" + ename;
	}
	
}
