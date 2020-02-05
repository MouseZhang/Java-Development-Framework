package cn.ustb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "student", catalog = "hdb")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Student extends Member implements java.io.Serializable {

	private String school;
	private Double score;

	@Column(name = "school", length = 50)
	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	@Column(name = "score", precision = 22, scale = 0)
	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return super.toString() + "Student [school=" + school + ", score=" + score + "]";
	}

}