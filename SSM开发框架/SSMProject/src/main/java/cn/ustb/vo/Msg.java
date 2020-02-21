package cn.ustb.vo;

import java.util.HashMap;
import java.util.Map;

public class Msg {
	private Integer code; // 状态码：100（成功）、200（失败）
	private String msg; // 提示信息
	private Map<String, Object> extend = new HashMap<String, Object>(); // 用户返回给浏览器的数据

	public static Msg success() {
		Msg res = new Msg();
		res.setCode(100);
		res.setMsg("处理成功！");
		return res;
	}
	
	public static Msg failure() {
		Msg res = new Msg();
		res.setCode(200);
		res.setMsg("处理失败！");
		return res;
	}
	
	public Msg add(String key, Object value) {
		this.getExtend().put(key, value);
		return this;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Map<String, Object> getExtend() {
		return extend;
	}

	public void setExtend(Map<String, Object> extend) {
		this.extend = extend;
	}

}
