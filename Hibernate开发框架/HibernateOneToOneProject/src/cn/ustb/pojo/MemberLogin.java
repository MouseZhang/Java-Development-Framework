package cn.ustb.pojo;


@SuppressWarnings("serial")
public class MemberLogin implements java.io.Serializable {

	private String mid;
	private String password;
	private MemberDetails memberDetails;

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public MemberDetails getMemberDetails() {
		return this.memberDetails;
	}

	public void setMemberDetails(MemberDetails memberDetails) {
		this.memberDetails = memberDetails;
	}

	@Override
	public String toString() {
		return "MemberLogin [mid=" + mid + ", password=" + password + ", memberDetails=" + memberDetails + "]";
	}
	
}