package cn.ustb.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


// 自定义链处理，检查操作
public class ValidateLoginFilter extends UsernamePasswordAuthenticationFilter {
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		String code = request.getParameter("code");
		// 取得生成的验证码
		String rand = (String) request.getSession().getAttribute("rand");
		// 此时指的是找到特定参数的信息，都可以在此处验证
		String username = super.obtainUsername(request).trim();
		String password = super.obtainPassword(request).trim();
		System.out.println("【用户名】：" + username);
		System.out.println("【密码】：" + password);
		if (code != null && rand.equalsIgnoreCase(code)) { // 验证码正确
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			return super.getAuthenticationManager().authenticate(token);
		} else {
			throw new AuthenticationServiceException("验证码不正确！"); // 如果有需要，可以继续判断用户名和密码的情况
		}
	}
	
}
