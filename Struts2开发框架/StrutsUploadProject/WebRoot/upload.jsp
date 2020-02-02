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
  	<h1>${fieldErrors['photo'][0]}</h1>
  	<form action="UploadAction!insert.action" method="post" enctype="multipart/form-data">
  		姓名：<input type="text" name="name"><br>
  		照片：<input type="file" name="photo"><br>
  		<input type="submit" value="提交">
  	</form>
  </body>
</html>
