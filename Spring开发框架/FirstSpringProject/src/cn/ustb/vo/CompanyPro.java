package cn.ustb.vo;

import java.util.Properties;

public class CompanyPro {
	private Properties msg;

	public Properties getMsg() {
		return msg;
	}

	public void setMsg(Properties msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "CompanyPro [msg=" + msg + "]";
	}

}
