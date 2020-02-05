package cn.ustb.pojo;

@SuppressWarnings("serial")
public class MemberContract implements java.io.Serializable {

	private String address;
	private String zipcode;
	private String phone;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

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