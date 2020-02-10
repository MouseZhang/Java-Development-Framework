<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Spring MVC开发</title>
  </head>
  <body>
 	<h1>News图片上传页面</h1>
  	<form action="pages/hello/insert.action" method="post" enctype="multipart/form-data">
  		新闻编号：<input type="text" id="nid" name="nid" value="10"><br>
  		新闻标题：<input type="text" id="title" name="title" value="USTB"><br>
  		新闻图片：<input type="file" id="pic" name="pic"><br>
  		<input type="submit" value="提交">
  		<input type="reset" value="重置">
  	</form>
  </body>
</html>
