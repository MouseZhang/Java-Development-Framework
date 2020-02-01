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
  	<h1>资源文件内容：<s:i18n name="Messages">
  		<s:text name="info.msg">
  			<s:param>周末愉快</s:param>
  			<s:param>天冷保暖</s:param>
  			<s:param>预防感冒</s:param>
  			<s:param>小心自拍</s:param>
  			<s:param>我要吃饭</s:param>
  		</s:text>
  	</s:i18n></h1>
  	<h1>雇佣日期：<s:property value="emp.hiredate"/></h1>
  	<h1>雇佣日期：<s:date name="emp.hiredate" format="yyyy-MM-dd HH:mm:ss"/></h1>
  	<h1>生日：<s:date name="#request.birthday" format="yyyy-MM-dd HH:mm:ss"/></h1>
  	<form action="EmpAction.action" method="post">
  		雇员编号：<input type="text" name="emp.empno" value="10009"><br>
  		雇员姓名：<input type="text" name="emp.ename" value="张三"><br>
  		雇员工资：<input type="text" name="emp.sal" value="1000.1"><br>
  		雇佣日期：<input type="text" name="emp.hiredate" value="2020-01-01"><br>
  		部门编号：<input type="text" name="emp.dept.deptno" value="20"><br>
  		部门名称：<input type="text" name="emp.dept.dname" value="开发部"><br>
  		<input type="submit" value="提交">
  	</form>
  </body>
</html>
