package cn.ustb.pojo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "member_login", catalog = "hdb")
public class MemberLogin implements java.io.Serializable {

	private String mid;
	private String password;
	private MemberDetails memberDetails;
	
	@Id
	@Column(name = "mid", unique = true, nullable = false, length = 50)
	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Column(name = "password", length = 32)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "memberLogin",cascade=CascadeType.ALL)
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