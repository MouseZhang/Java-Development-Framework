package cn.ustb.vo;

public class News {
	private Integer nid;
	private String title;
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
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + "]";
	}
}
