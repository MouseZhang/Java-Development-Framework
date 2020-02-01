package cn.ustb.interceptor;

import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class LoginInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 取得所有的Session属性
		Map<String, Object> map = invocation.getInvocationContext().getSession();
		System.out.println("【LoginInterceptor】" + map);
		if (map.get("mid") != null) { // 登陆过，在session中设置过属性
			return invocation.invoke(); // 正常访问
		} else { // 无session属性，跳转登录页面
			ServletActionContext.getRequest().setAttribute("msg", "您还未登录，请先登录！");
			ServletActionContext.getRequest().setAttribute("url", "login.jsp");
			return "forward.page"; // 全局跳转提示页面
		}
	}
	
}
