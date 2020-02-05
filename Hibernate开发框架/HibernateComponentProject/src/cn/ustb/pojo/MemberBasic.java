package cn.ustb.pojo;

import java.util.Date;

@SuppressWarnings("serial")
public class MemberBasic implements java.io.Serializable {

	private String name;
	private Integer age;
	private Date birthday;

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

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "MemberBasic [name=" + name + ", age=" + age + ", birthday=" + birthday + "]";
	}

}