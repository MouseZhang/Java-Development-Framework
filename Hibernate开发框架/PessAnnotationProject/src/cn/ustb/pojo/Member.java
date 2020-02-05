package cn.ustb.pojo;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Member entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member", catalog = "hdb")

public class Member implements java.io.Serializable {

	// Fields

	private String mid;
	private String name;
	private Integer age;
	private Timestamp ver;

	// Constructors

	/** default constructor */
	public Member() {
	}

	/** minimal constructor */
	public Member(String mid) {
		this.mid = mid;
	}

	/** full constructor */
	public Member(String mid, String name, Integer age, Timestamp ver) {
		this.mid = mid;
		this.name = name;
		this.age = age;
		this.ver = ver;
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

	@Version
	@Column(name = "ver", length = 19)
	public Timestamp getVer() {
		return this.ver;
	}

	public void setVer(Timestamp ver) {
		this.ver = ver;
	}

}