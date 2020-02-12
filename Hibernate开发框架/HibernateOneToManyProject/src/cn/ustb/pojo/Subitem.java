package cn.ustb.pojo;


@SuppressWarnings("serial")
public class Subitem implements java.io.Serializable {

	private Integer sid;
	private Item item;
	private String title;

	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Subitem [sid=" + sid + ", title=" + title + "]";
	}

}