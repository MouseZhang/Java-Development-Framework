package cn.ustb.interceptor;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MyHandlerInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("##### 【执行前拦截】 #####");
		HandlerMethod handm = (HandlerMethod) handler; // 实现转型操作
		System.out.println("操作的Action对象：" + handm.getBean() + "，类型：" + handm.getBeanType()
				+ "，方法名称：" + handm.getMethod());
		MethodParameter[] mp = handm.getMethodParameters();
		for (int i = 0; i < mp.length; i++) {
			System.out.println("方法：" + mp[i].getMethod() + "，参数名称：" + mp[i].getParameterName() + "，参数类型：" + mp[i].getParameterType());
		}
		// 定义一个专门用于保存错误信息的Map集合
		Map<String, String> errors = new HashMap<String, String>();
		// 取得每一个验证规则的名称
		String fieldName = handm.getMethod().getName() + "Rule"; // 取得验证规则
		try {
			Field field = handm.getBean().getClass().getDeclaredField(fieldName);
			field.setAccessible(true); // 取消封装
			String rules = (String) field.get(handm.getBean()); // 取得规则信息
			System.out.println("***** 规则信息：" + rules);
			String[] result = rules.split("\\|"); // 拆分验证规则
			for (int i = 0; i < result.length; i++) {
				String[] temp = result[i].split(":");
				String paramValue = request.getParameter(temp[0]);
				System.out.println("【参数名称】：" + temp[0] + "，参数内容：" + paramValue + "，验证规则：" + temp[1]);
				if (paramValue == null) { // 有错误
					errors.put(temp[0], "数据内容不允许为空！");
				} else {
					if ("int".equalsIgnoreCase(temp[1])) {
						if (!paramValue.matches("\\d+")) {
							errors.put(temp[0], "数据类型必须为整数！");
						}
					}
				}
			}
		} catch (Exception e) {}
		boolean flag = true;
		if (errors.size() > 0) { // 有错误信息
			flag = false;
		} else { // 表示现在基础的验证操作完成，下面需要判断是否有上传文件
			MultipartResolver mr = new CommonsMultipartResolver();
			if (mr.isMultipart(request)) { // 如果有文件上传
				MultipartRequest mreq = (MultipartRequest) request; // 为了取得上传表单内容
				Map<String, MultipartFile> map = mreq.getFileMap(); // 取得所有的上传文件
				if (map.size() > 0) {
					Field field = handm.getBean().getClass().getDeclaredField("mimeRule");
					field.setAccessible(true); // 取消封装
					String mimeRule = (String) field.get(handm.getBean()); // 取得规则信息
					String[] resultMime = mimeRule.split(",");
					Iterator<Map.Entry<String, MultipartFile>> iter = map.entrySet().iterator();
					while (iter.hasNext()) {
						Map.Entry<String, MultipartFile> me = iter.next();
						String paramName = me.getKey(); // 取得文件名称
						MultipartFile file = me.getValue(); // 取得文件内容
						System.out.println("文件名称：" + paramName + "，文件内容：" + file);
						System.out.println("****" + file.getContentType());
						if (!this.isExists(resultMime, file.getContentType())) { // 符合上传规则
							errors.put(paramName, "上传了非法文件");
							flag = false;
							break;
						}
					}
				}
			}
		}
		if (flag == false) {
			System.out.println(errors);
			request.getRequestDispatcher("/errors.jsp").forward(request, response);
			return false;
		}
		return true;
	}
	
	public boolean isExists(String[] data, String str) {
		for (int i = 0; i < data.length; i++) {
			if (str.equals(data[i])) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("##### 【执行中拦截】 #####");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("##### 【执行后拦截】 #####");
	}

}
