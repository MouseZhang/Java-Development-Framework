package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class MessageAction extends ActionSupport {
	private String msg;
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void insert() {
		System.out.println("*** 输入的信息：" + this.msg);
	}
	
}
