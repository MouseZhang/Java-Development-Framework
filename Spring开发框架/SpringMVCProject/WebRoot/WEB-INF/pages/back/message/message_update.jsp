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
  	<h1>消息修改页面</h1>
  	<form action="pages/back/message/message_update.action" method="post">
  		消息编号：<input type="text" id="mid" name="mid" value="22"><br>
  		消息名称：<input type="text" id="title" name="title" value="USTB"><br>
  		消息价格：<input type="text" id="price" name="price" value="8888"><br>
  		发布日期：<input type="text" id="pubdate" name="pubdate" value="2022-02-22"><br>
  		消息类型：<input type="text" id="typeTitle" name="typeTitle" value="今日热点"><br>
  		<input type="submit" value="修改">
  		<input type="reset" value="重置">
  	</form>
  </body>
</html>
