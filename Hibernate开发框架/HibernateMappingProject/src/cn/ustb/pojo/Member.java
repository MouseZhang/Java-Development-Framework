package cn.ustb.pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("serial")
public class Member implements java.io.Serializable {


	private String mid;
	private String name;
//	private Set<String> emails = new HashSet<String>();
//	private List<String> emails = new ArrayList<String>();
	private Map<String, String> emails = new HashMap<String, String>();

	public String getMid() {
		return this.mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public Set<String> getEmails() {
//		return this.emails;
//	}
//
//	public void setEmails(Set<String> emails) {
//		this.emails = emails;
//	}
	
//	public List<String> getEmails() {
//		return this.emails;
//	}
//
//	public void setEmails(List<String> emails) {
//		this.emails = emails;
//	}
	
	public Map<String, String> getEmails() {
		return this.emails;
	}

	public void setEmails(Map<String, String> emails) {
		this.emails = emails;
	}

	@Override
	public String toString() {
		return "Member [mid=" + mid + ", name=" + name + ", emails=" + emails + "]";
	}
	
}