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
  <h1><s:property value="msg"/></h1>
  	<s:form action="EchoAction.action" method="post">
  		<s:textfield key="msg" label="请输入信息"></s:textfield>
  		<s:submit value="发送"/>
  	</s:form>
  </body>
</html>
