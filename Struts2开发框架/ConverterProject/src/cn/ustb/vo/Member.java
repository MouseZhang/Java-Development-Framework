package cn.ustb.vo;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Member implements Serializable {
	private Integer mid;
	private String name;
	private Double score;
	private Date birthday;
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
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", score=" + score + ", birthday=" + birthday + "]";
	}
	
}
