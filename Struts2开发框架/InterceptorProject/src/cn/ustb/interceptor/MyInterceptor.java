package cn.ustb.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class MyInterceptor extends AbstractInterceptor {

	@Override
	public void init() {
		System.out.println("############ 拦截器初始化【init()】 ############");
	}
	
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		System.out.println("=============== 拦截器执行 ===============");
		return invocation.invoke(); // 将请求向下传递
	}
	
	@Override
	public void destroy() {
		System.out.println("############ 拦截器销毁【destory()】 ############");
	}
	
}
