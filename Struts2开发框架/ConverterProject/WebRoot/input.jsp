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
   	<form action="InputAction!insert.action" method="post">
  		兴趣：<input type="checkbox" name="inst" id="inst" value="吃饭">吃饭
  			<input type="checkbox" name="inst" id="inst" value="睡觉">睡觉
  			<input type="checkbox" name="inst" id="inst" value="打牌">打牌
  			<input type="checkbox" name="inst" id="inst" value="麻将">麻将
  			<input type="checkbox" name="inst" id="inst" value="抽烟">抽烟<br>
  			<input type="submit" value="提交">
  	</form>
  </div>
    <div>
   	<form action="InputAction!update.action" method="post">
  		权限组：<input type="checkbox" name="gid" id="gid" value="1">管理员组
  			<input type="checkbox" name="gid" id="gid" value="2">新闻组
  			<input type="checkbox" name="gid" id="gid" value="3">公告组
  			<input type="checkbox" name="gid" id="gid" value="4">人力组
  			<input type="checkbox" name="gid" id="gid" value="5">系统组<br>
  			<input type="submit" value="提交">
  	</form>
  </div>
  </body>
</html>
