package cn.ustb.pojo;

import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
public class Role implements java.io.Serializable {

	private Integer rid;
	private String title;
	private String note;
	private Set<Groups> groupses = new HashSet<Groups>(0);

	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
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

	public Set<Groups> getGroupses() {
		return groupses;
	}
	
	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

	@Override
	public String toString() {
		return "Role [rid=" + rid + ", title=" + title + ", note=" + note + ", groupses=" + groupses + "]";
	}
	
}