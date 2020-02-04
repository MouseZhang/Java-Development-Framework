package cn.ustb.pojo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 整个JPA的标准就是直接在简单Java类上明确的表示出每一个getter()方法对应的数据列
 * @author MouseZhang
 *
 */

@SuppressWarnings("serial")
@Entity // 表示这是一个数据实体的类型（JPA标准定义好的注解）
@Table(name = "member", catalog = "hdb") // 映射的数据表名称
public class Member implements java.io.Serializable {

	private String mid;
	private String name;
	private Integer age;
	private Double salary;
	private Date birthday;
	private String note;

	@Id // 设置主键属性
	@Column( // 定义
			name = "mid",  // 主键列的名称
			unique = true,  // 是否为唯一
			nullable = false,  // 是否允许为空
			length = 50) // 字段长度，可不写
	public String getMid() { // 此方法返回的内容为主键列
		return this.mid;
	}

	public void setMid(String mid) { // setter没有变化，所有JPA的操作标准都是在getter上定义的
		this.mid = mid;
	}

	@Column(name = "name", length = 50) // 定义name列的映射
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

	@Temporal(TemporalType.DATE) // 定义的是一个日期类型的字段
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

}