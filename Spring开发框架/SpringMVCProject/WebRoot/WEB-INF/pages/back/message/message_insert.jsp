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
 	<h1>消息新增页面</h1>
  	<form action="pages/back/message/message_insert.action" method="post">
  		消息编号：<input type="text" id="mid" name="mid" value="10"><br>
  		消息名称：<input type="text" id="title" name="title" value="USTB"><br>
  		消息价格：<input type="text" id="price" name="price" value="10000.0"><br>
  		发布日期：<input type="text" id="pubdate" name="pubdate" value="2020-02-02"><br>
  		消息类型：<input type="text" id="type.typeTitle" name="type.typeTitle" value="头条新闻"><br>
  		<input type="submit" value="提交">
  		<input type="reset" value="重置">
  	</form>
  </body>
</html>
