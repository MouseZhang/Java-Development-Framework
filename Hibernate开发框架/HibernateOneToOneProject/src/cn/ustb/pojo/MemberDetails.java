package cn.ustb.pojo;


@SuppressWarnings("serial")
public class MemberDetails implements java.io.Serializable {

	private String mid;
	private MemberLogin memberLogin;
	private String name;
	private String email;
	private String phone;

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public MemberLogin getMemberLogin() {
		return this.memberLogin;
	}

	public void setMemberLogin(MemberLogin memberLogin) {
		this.memberLogin = memberLogin;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberDetails [mid=" + mid + ", name=" + name + ", email=" + email + ", phone=" + phone + "]";
	}
	
}