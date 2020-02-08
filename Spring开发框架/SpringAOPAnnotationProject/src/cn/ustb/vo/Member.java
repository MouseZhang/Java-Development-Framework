package cn.ustb.vo;

public class Member {
	private Integer mid;
	private String name;
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
	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + "]";
	}
	
}
