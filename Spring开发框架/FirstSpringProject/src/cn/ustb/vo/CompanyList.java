package cn.ustb.vo;

import java.util.List;

public class CompanyList {
	private List<String> msg;

	public List<String> getMsg() {
		return msg;
	}

	public void setMsg(List<String> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CompanyList [msg=" + msg + "]";
	}
	
}
