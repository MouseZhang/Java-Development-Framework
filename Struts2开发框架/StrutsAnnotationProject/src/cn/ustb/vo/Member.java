package cn.ustb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private Integer mid;
	private String name;
	private String email;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", email=" + email + "]";
	}
	
}
