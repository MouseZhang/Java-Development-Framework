package cn.ustb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "subitem", catalog = "hdb")
public class Subitem implements java.io.Serializable {

	private Integer sid;
	private Item item;
	private String title;

	@Id
	@GeneratedValue
	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	// 配置多对一的关系，同时设置关联的数据列（控制反转在JPA中是默认支持的，不需要像在HBM配置文件中添加属性那样专门设置）
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "iid")
	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Column(name = "title", length = 50)
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