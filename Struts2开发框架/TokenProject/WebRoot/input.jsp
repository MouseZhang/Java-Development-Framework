<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
	<h1><s:actionerror/></h1>
	<form action="MessageAction!insert.action" method="post">
		请输入信息：<input type="text" name="msg">
		<s:token name="repeat"/>
		<input type="submit" value="提交">
	</form>
  </body>
</html>
