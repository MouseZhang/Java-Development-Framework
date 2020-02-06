package cn.ustb.pojo;

@SuppressWarnings("serial")
public abstract class Member implements java.io.Serializable {

	private String mid;
	private String name;
	private Integer age;

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

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", age=" + age + "]";
	}

}