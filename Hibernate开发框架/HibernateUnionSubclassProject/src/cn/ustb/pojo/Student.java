package cn.ustb.pojo;

@SuppressWarnings("serial")
public class Student extends Member implements java.io.Serializable {

	private String school;
	private Double score;

	public String getSchool() {
		return this.school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public Double getScore() {
		return this.score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "Student [school=" + school + ", score=" + score + "]";
	}

}