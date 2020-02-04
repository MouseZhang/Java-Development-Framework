package cn.ustb.pojo;

/**
 * News entity. @author MyEclipse Persistence Tools
 */

public class News implements java.io.Serializable {

	// Fields

	private Integer nid;
	private String title;
	private Integer visits;
	private String item;

	// Constructors

	/** default constructor */
	public News() {
	}

	/** minimal constructor */
	public News(String title) {
		this.title = title;
	}

	/** full constructor */
	public News(String title, Integer visits, String item) {
		this.title = title;
		this.visits = visits;
		this.item = item;
	}

	// Property accessors

	public Integer getNid() {
		return this.nid;
	}

	public void setNid(Integer nid) {
		this.nid = nid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getVisits() {
		return this.visits;
	}

	public void setVisits(Integer visits) {
		this.visits = visits;
	}

	public String getItem() {
		return this.item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", visits=" + visits + ", item=" + item + "]";
	}

}