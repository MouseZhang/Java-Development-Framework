package cn.ustb.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "worker", catalog = "hdb")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Worker extends Member implements java.io.Serializable {

	private String company;
	private Double salary;

	@Column(name = "company", length = 50)
	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	@Column(name = "salary", precision = 22, scale = 0)
	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + "Worker [company=" + company + ", salary=" + salary + "]";
	}

}