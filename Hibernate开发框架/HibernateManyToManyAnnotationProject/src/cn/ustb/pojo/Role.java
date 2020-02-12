package cn.ustb.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "role", catalog = "hdb")
public class Role implements java.io.Serializable {

	private Integer rid;
	private String title;
	private String note;
	private Set<Groups> groupses = new HashSet<Groups>(0);

	@Id
	@GeneratedValue // 表示主键为自动增长列
	@Column(name = "rid", unique = true, nullable = false)
	public Integer getRid() {
		return this.rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	@Column(name = "title", nullable = false, length = 50)
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

	@ManyToMany( // 定义多对多的操作关系
			cascade = CascadeType.MERGE, // 表示数据的级联（改为MERGE在数据合并的时候级联）
			fetch = FetchType.LAZY)  // 表示延迟加载
	@JoinTable( // 维护中间关系表数据
			name = "role_groups",  // 表名称
			catalog = "hdb",  // 数据库模式名称
			joinColumns = { // 关联的数据列维护
			@JoinColumn( // Role类维护role_groups表中的rid列的信息
					name = "rid", 
					updatable = false) }, 
			inverseJoinColumns = { // 表示role_groups表中的gid由Role负责维护
					@JoinColumn(name = "gid", updatable = false) })
	public Set<Groups> getGroupses() {
		return this.groupses;
	}

	public void setGroupses(Set<Groups> groupses) {
		this.groupses = groupses;
	}

}