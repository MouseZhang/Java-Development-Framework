<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String insertUrl = basePath + "MemberAction!insert.action";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Struts 2.x + Hibernate联合开发实战</title>
  </head>
  <body>
  	<form action="<%=insertUrl%>" method="post">
		编号：<input type="text" name="member.mid" value="10"><br>
		姓名：<input type="text" name="member.name" value="ALLEN"><br>
		年龄：<input type="text" name="member.age" value="18"><br>
		工资：<input type="text" name="member.salary" value="10000.0"><br>
		生日：<input type="text" name="member.birthday" value="1999-01-20"><br>	
		介绍：<input type="text" name="member.note" value="大家好，我叫ALLEN！"><br> 
		<input type="submit" value="提交">
		<input type="reset" value="重置">
  	</form>
  </body>
</html>
