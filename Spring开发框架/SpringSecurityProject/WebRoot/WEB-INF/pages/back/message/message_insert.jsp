<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "pages/back/message/message_insert.action";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Spring Security开发</title>
  </head>
  <body>
  	<form action="<%=insertUrl%>" method="post">
  		消息编号：<input type="text" name="mid" id="mid" value="10001"><br>
  		新闻标题：<input type="text" name="title" id="title" value="今日头条"><br>
  		新闻内容：<input type="text" name="content" id="content" value="今天是个好日子啊！"><br>
  		<input type="submit" value="提交">
  		<input type="reset" value="重置">
  	</form>
  </body>
</html>
