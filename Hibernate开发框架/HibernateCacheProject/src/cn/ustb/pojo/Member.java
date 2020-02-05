package cn.ustb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "hdb")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY) // 方式二：配置二级缓存
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
	@Id

	@Column(name = "mid", unique = true, nullable = false, length = 50)

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

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

	@Column(name = "salary", precision = 22, scale = 0)

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 10)

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "note", length = 65535)

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", age=" + age + ", salary=" + salary + ", birthday="
				+ birthday + ", note=" + note + "]";
	}

}