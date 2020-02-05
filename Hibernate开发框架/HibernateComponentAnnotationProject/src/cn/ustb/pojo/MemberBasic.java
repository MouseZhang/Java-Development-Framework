package cn.ustb.pojo;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Embeddable    // 声明为一个组件
@AttributeOverrides({
	@AttributeOverride(name="name",column=@Column(name="name")),
	@AttributeOverride(name="age",column=@Column(name="age")),
	@AttributeOverride(name="birthday",column=@Column(name="birthday"))
})
public class MemberBasic implements java.io.Serializable {

	private String name;
	private Integer age;
	private Date birthday;

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)
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