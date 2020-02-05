package cn.ustb.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "member", catalog = "hdb")
public class Member implements java.io.Serializable {

	private MemberId id;
	private Integer age;

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "mid", column = @Column(name = "mid", nullable = false, length = 50)),
			@AttributeOverride(name = "name", column = @Column(name = "name", nullable = false, length = 50)) })
	public MemberId getId() {
		return this.id;
	}

	public void setId(MemberId id) {
		this.id = id;
	}

	@Column(name = "age")
	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", age=" + age + "]";
	}

}