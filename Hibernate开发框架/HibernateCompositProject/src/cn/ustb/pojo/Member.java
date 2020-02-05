package cn.ustb.pojo;

@SuppressWarnings("serial")
public class Member implements java.io.Serializable {

	private MemberId id;
	private Integer age;

	public MemberId getId() {
		return this.id;
	}

	public void setId(MemberId id) {
		this.id = id;
	}

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