package cn.ustb.vo;

public class Dept {
    private Integer deptno;

    private String dname;

    public Dept() {
		super();
	}

	public Dept(Integer deptno, String dname) {
		super();
		this.deptno = deptno;
		this.dname = dname;
	}

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
        this.dname = dname == null ? null : dname.trim();
    }

	@Override
	public String toString() {
		return "Dept [deptno=" + deptno + ", dname=" + dname + "]";
	}
    
}