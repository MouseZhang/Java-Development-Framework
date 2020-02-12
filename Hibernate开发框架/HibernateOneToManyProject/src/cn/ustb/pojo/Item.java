package cn.ustb.pojo;

import java.util.HashSet;
import java.util.Set;


@SuppressWarnings("serial")
public class Item implements java.io.Serializable {


	private Integer iid;
	private String title;
	private Set<Subitem> subitems = new HashSet<Subitem>();

	public Integer getIid() {
		return iid;
	}
	
	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Subitem> getSubitems() {
		return this.subitems;
	}

	public void setSubitems(Set<Subitem> subitems) {
		this.subitems = subitems;
	}

	@Override
	public String toString() {
		return "Item [iid=" + iid + ", title=" + title + ", subitems=" + subitems + "]";
	}

}