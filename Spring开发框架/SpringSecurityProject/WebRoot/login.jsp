<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Spring Security开发</title>
  </head>
  <body>
  	<h1>${param.error==true?"登录失败，错误的用户名或密码！":""}</h1>
  	<%
  		if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION") != null) {
  			String str = session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION").toString();
  			if (str.contains("DisabledException")) {
  	%>
  				<h3>此用户已经被锁定，请与管理员联系！</h3>
  	<%
  			}
  			if (str.contains("BadCredentialsException")) {
   	%>
  				<h3>输入的验证码有误！</h3>
  	<%			}
  		}
  	 %>
  	 ${SPRING_SECURITY_LAST_EXCEPTION}
  	<form action="<%=basePath%>login" method="post">
  		用户名：<input type="text" name="j_username" id="j_username"><br>
  		密&nbsp;&nbsp;码：<input type="password" name="j_password" id="j_password"><br>
  		验证码：<input type="text" name="code" id="code"><img src="ImageCode"><br>
  		<input type="checkbox" name="_spring_security_remember_me" value="true">记住密码<br>
  		<input type="submit" value="提交">
  		<input type="reset" value="重置">
  	</form>
  </body>
</html>
