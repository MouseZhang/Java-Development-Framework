package cn.ustb.action;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class EchoAction extends ActionSupport {
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String execute() throws Exception { //执行操作
		// 取得4种内置对象
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		ServletContext application = ServletActionContext.getServletContext();
		HttpSession session = request.getSession();
		System.out.println("请求类型：" + request.getContentType());
		System.out.println("回应类型：" + response.getContentType());
		System.out.println("真实路径：" + application.getRealPath("/"));
		System.out.println("SESSION ID：" + session.getId());
		
		// 读取资源文件
		String msg = super.getText("info.msg", new String[] {"世界", "你好", "感冒", "解药", "头晕"});
		System.out.println(msg);
		
		this.msg = "ECHO: " + this.msg;
  		// return Action.SUCCESS;
		return "echo.page";		// 返回路径映射的key
	}
}