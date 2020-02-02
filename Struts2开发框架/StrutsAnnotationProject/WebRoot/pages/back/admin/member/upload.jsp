<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "pages/back/admin/member/MemberAction!insert.action";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Struts 2.x开发实战</title>
  </head>
  <body>
  	<form action="<%=insertUrl%>" method="post" enctype="multipart/form-data">
  		文件：<input type="file" name="photo"><br>
  		<input type="submit" value="提交">
  	</form>
  </body>
</html>
