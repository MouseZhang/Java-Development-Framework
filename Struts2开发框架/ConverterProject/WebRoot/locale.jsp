<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Struts 2.x开发实战</title>
  </head>
  <body>
  <div>
   	<form action="LocaleAction!insert.action" method="post">
		请选择语言：<select name="loc">
					<option value="zh_CN">中文显示</option>
					<option value="en_US">英文显示</option>
				</select>
  			<input type="submit" value="提交">
  	</form>
  </div>
  </body>
</html>
