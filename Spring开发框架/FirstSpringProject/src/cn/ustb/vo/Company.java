package cn.ustb.vo;

import java.util.Arrays;

public class Company {
	private String[] msg;
	private Integer[] data;

	public String[] getMsg() {
		return msg;
	}

	public void setMsg(String[] msg) {
		this.msg = msg;
	}

	public Integer[] getData() {
		return data;
	}

	public void setData(Integer[] data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Company [msg=" + Arrays.toString(msg) + ", data=" + Arrays.toString(data) + "]";
	}

}
