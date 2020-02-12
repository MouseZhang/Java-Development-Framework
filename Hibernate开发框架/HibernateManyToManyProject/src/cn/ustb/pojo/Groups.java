package cn.ustb.pojo;

import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
public class Groups implements java.io.Serializable {

	private Integer gid;
	private String title;
	private String note;
	private Set<Role> roles = new HashSet<Role>(0);

	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set<Role> getRoles() {
		return roles;
	}
	
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}