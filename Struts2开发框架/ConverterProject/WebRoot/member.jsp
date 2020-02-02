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
   	<form action="MemberAction!insert.action" method="post">
  		成员A 编号：<input type="text" name="allMembers[0].mid" value="1" size="2" maxlength="2">
  		姓名：<input type="text" name="allMembers[0].name" value="张三" size="5" maxlength="5">
  		成绩：<input type="text" name="allMembers[0].score" value="95.5" size="5" maxlength="5">
  		生日：<input type="text" name="allMembers[0].birthday" value="2011-11-01" size="10" maxlength="10"><br>
		成员B 编号：<input type="text" name="allMembers[1].mid" value="2" size="2" maxlength="2">
  		姓名：<input type="text" name="allMembers[1].name" value="李四" size="5" maxlength="5">
  		成绩：<input type="text" name="allMembers[1].score" value="90.5" size="5" maxlength="5">
  		生日：<input type="text" name="allMembers[1].birthday" value="2015-11-01" size="10" maxlength="10"><br>  	
		成员C 编号：<input type="text" name="allMembers[2].mid" value="3" size="2" maxlength="2">
  		姓名：<input type="text" name="allMembers[2].name" value="王五" size="5" maxlength="5">
  		成绩：<input type="text" name="allMembers[2].score" value="89.5" size="5" maxlength="5">
  		生日：<input type="text" name="allMembers[2].birthday" value="2012-06-01" size="10" maxlength="10"><br>   	
  		<input type="submit" value="提交">
  	</form>
  </div>
  </body>
</html>
