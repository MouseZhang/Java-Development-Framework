package cn.ustb.pojo;

@SuppressWarnings("serial")
public class Worker extends Member implements java.io.Serializable {

	private String company;
	private Double salary;

	public String getCompany() {
		return this.company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public Double getSalary() {
		return this.salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Worker [company=" + company + ", salary=" + salary + "]";
	}
	
}