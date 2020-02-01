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
  <!-- OGNL表达式操作 #属性范围，不用#符，只能把dept定义在DeptAction execute方法外面 -->
  <h1>部门编号：<s:property value="#request.dept.deptno"/></h1>
  <h1>部门名称：<s:property value="#request.dept.dname"/></h1>
  <hr>
  <!-- 方式一：-->
  <s:if test="allDepts!=null">
  	<ul>
  		<s:iterator value="allDepts" var="dp">
  		<!-- <li>部门编号：<s:property value="deptno"/>，部门位置：<s:property value="dname"/></li> -->
  			<li>部门编号：${dp.deptno}，部门位置：${dp.dname}</li> <!-- 使用EL输出 -->
  		</s:iterator>
  	</ul>
  </s:if>
    <!-- 方式二：-->
    <s:if test="#request.allDepts!=null">
  	<ul>
  		<s:iterator value="#request.allDepts" var="dp">
  			<li>部门编号：${dp.deptno}，部门位置：${dp.dname}</li> <!-- 使用EL输出 -->
  		</s:iterator>
  	</ul>
  </s:if>
  </body>
</html>
