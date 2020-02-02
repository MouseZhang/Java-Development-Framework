package cn.ustb.util.interceptor;

import java.lang.reflect.Field;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

@SuppressWarnings("serial")
public class ValidateInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// 1、取得要操作的Action，根据发送的提交路径不同，Action对象也不同
		Object actionObject = invocation.getAction();
		// 2、为了确定要使用验证操作的成员，必须取出分发的操作代码
		String uri = ServletActionContext.getRequest().getRequestURI();
		if (uri != null) { // 判空验证
			// 3、取出关键业务方法的名称，即可取出“业务名称Rule”的验证规则
			uri = uri.substring(uri.lastIndexOf("!") + 1, uri.lastIndexOf("."));
			// 4、有了Action对象和名称，即可取得成员
			String filedName = uri + "Rule"; // 验证规则成员
			try { 
				// 5、根据成员名称取得对象内容，只能够依靠反射完成
				Field fieldRule = actionObject.getClass().getDeclaredField(filedName);
				fieldRule.setAccessible(true); // 取消封装处理
				String rule = (String) fieldRule.get(actionObject);
				System.out.println("【操作的验证规则】" + rule);
				// 6、代码验证通过
				if (ValidateUtil.validate(actionObject, rule, invocation.getInvocationContext().getParameters())) {
					return invocation.invoke();
				} else { // 跳转到错误页
					return uri + "VF"; // 跳转到指定页面
				}
			} catch (Exception e) { // 没有规则时抛出异常
			}
		}
		return invocation.invoke();
	}

}
