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
  	<s:form action="FormAction.action" method="post" theme="simple">
  		用户名：<s:textfield key="name" id="name" theme="simple"/><br>
  		<!-- 利用标签生成下拉列表框 -->
  		<s:select list="#request.allDepts" listKey="deptno" listValue="dname" id="dept" name="dept" theme="simple"></s:select><br>
  		<!-- 利用标签生成复选框 -->
  		部门：<s:checkboxlist list="#request.allDepts" listKey="deptno" listValue="dname" name="dno" id="dno"></s:checkboxlist><br>
  		<s:submit value="发送" theme="simple"/>
  	</s:form>
  </body>
</html>
