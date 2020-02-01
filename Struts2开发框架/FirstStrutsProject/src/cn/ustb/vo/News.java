package cn.ustb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class News implements Serializable {
	private Integer nid;
	private String title;
	private String content;
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", content=" + content + "]";
	}
	
}
