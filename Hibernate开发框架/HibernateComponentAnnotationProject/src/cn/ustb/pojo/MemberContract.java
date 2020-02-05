package cn.ustb.pojo;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable    // 声明为一个组件
@AttributeOverrides({
	@AttributeOverride(name="address",column=@Column(name="address")),
	@AttributeOverride(name="zipcode",column=@Column(name="zipcode")),
	@AttributeOverride(name="phone",column=@Column(name="phone"))
})
public class MemberContract implements java.io.Serializable {

	private String address;
	private String zipcode;
	private String phone;

	@Column(name = "address", length = 100)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "zipcode", length = 8)
	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "MemberContract [address=" + address + ", zipcode=" + zipcode + ", phone=" + phone + "]";
	}

}