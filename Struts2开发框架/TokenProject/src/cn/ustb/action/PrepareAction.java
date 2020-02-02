package cn.ustb.action;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class PrepareAction extends ActionSupport {
	
	// 所有的JSP一定是由Action跳转过去的
	public String insertPre() {
		return "input.page";
	}
	
}
