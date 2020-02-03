package cn.ustb.pojo;

import java.util.Date;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */

public class Member implements java.io.Serializable {

	// Fields

	private String mid;
	private String name;
	private Integer age;
	private Double salary;
	private Date birthday;
	private String note;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Member(String mid, String name, Integer age, Double salary, Date birthday, String note) {
		this.mid = mid;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
		this.note = note;
	}

	// Property accessors

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}