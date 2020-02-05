package cn.ustb.pojo;

@SuppressWarnings("serial")
public class MemberId implements java.io.Serializable {

	private String mid;
	private String name;

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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MemberId))
			return false;
		MemberId castOther = (MemberId) other;

		return ((this.getMid() == castOther.getMid())
				|| (this.getMid() != null && castOther.getMid() != null && this.getMid().equals(castOther.getMid())))
				&& ((this.getName() == castOther.getName()) || (this.getName() != null && castOther.getName() != null
						&& this.getName().equals(castOther.getName())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getMid() == null ? 0 : this.getMid().hashCode());
		result = 37 * result + (getName() == null ? 0 : this.getName().hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "MemberId [mid=" + mid + ", name=" + name + "]";
	}

}