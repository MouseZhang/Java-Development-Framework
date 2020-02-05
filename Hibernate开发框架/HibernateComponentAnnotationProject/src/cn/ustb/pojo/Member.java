package cn.ustb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "member", catalog = "hdb")
public class Member implements java.io.Serializable {

	private String mid;
	private MemberBasic basic = new MemberBasic();
	private MemberContract contract = new MemberContract();

	@Id
	@Column(name = "mid", unique = true, nullable = false, length = 50)
	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public MemberBasic getBasic() {
		return basic;
	}

	public void setBasic(MemberBasic basic) {
		this.basic = basic;
	}

	public MemberContract getContract() {
		return contract;
	}

	public void setContract(MemberContract contract) {
		this.contract = contract;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", basic=" + basic + ", contract=" + contract + "]";
	}
	
}