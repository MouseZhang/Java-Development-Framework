package cn.ustb.vo;

import java.util.Set;

public class CompanySet {
	private Set<String> msg;

	public Set<String> getMsg() {
		return msg;
	}

	public void setMsg(Set<String> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CompanyList [msg=" + msg + "]";
	}
	
}
