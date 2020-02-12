package cn.ustb.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "groups", catalog = "hdb")
public class Groups implements java.io.Serializable {

	private Integer gid;
	private String title;
	private String note;
	private Set<Role> roles = new HashSet<Role>(0);

	@Id
	@GeneratedValue
	@Column(name = "gid", unique = true, nullable = false)
	public Integer getGid() {
		return this.gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	@Column(name = "title", length = 50)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "note", length = 65535)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@ManyToMany( // 表示多对多的操作关系
			cascade = CascadeType.ALL,  // 描述数据的级联操作
			fetch = FetchType.LAZY,  // 表示数据的延迟加载
			mappedBy = "groupses") // 对应Role中的集合名称
	public Set<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

}