package cn.ustb.vo;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Message implements Serializable {
	private Integer mid;
	private String title;
	private String content;
	public Integer getMid() {
		return mid;
	}
	public void setMid(Integer mid) {
		this.mid = mid;
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
		return "Message [mid=" + mid + ", title=" + title + ", content=" + content + "]";
	}
	
}
