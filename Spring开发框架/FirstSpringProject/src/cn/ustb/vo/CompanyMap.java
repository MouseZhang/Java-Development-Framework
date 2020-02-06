package cn.ustb.vo;

import java.util.Map;

public class CompanyMap {
	private Map<Integer, String> msg;

	public Map<Integer, String> getMsg() {
		return msg;
	}

	public void setMsg(Map<Integer, String> msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CompanyMap [msg=" + msg + "]";
	}

}
