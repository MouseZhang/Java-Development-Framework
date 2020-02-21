package cn.ustb.vo;

import javax.validation.constraints.Pattern;

public class Emp {
    private Integer empno;

    @Pattern(regexp="(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",message="用户名必须是2-5位中文或者6-16位英文和数字的组合！")
    private String ename;

    private String sex;

    @Pattern(regexp="^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",message="邮箱地址格式有误！")
    private String email;

    private Integer dno;

    private Dept dept;
    
    
    public Emp() {
		super();
	}

	public Emp(Integer empno, String ename, String sex, String email, Integer dno) {
		super();
		this.empno = empno;
		this.ename = ename;
		this.sex = sex;
		this.email = email;
		this.dno = dno;
	}

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
        this.ename = ename == null ? null : ename.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getDno() {
        return dno;
    }

    public void setDno(Integer dno) {
        this.dno = dno;
    }
    
    public Dept getDept() {
		return dept;
	}
    
    public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Emp [empno=" + empno + ", ename=" + ename + ", sex=" + sex + ", email=" + email + ", dno=" + dno
				+ ", dept=" + dept + "]";
	}
    
}