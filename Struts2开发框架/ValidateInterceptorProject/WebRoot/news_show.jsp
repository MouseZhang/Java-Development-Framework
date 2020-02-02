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
    
    <title>jQuery + Struts 2.x</title>
  </head>
  <body>
	<h1>新闻编号：<s:property value="news.nid"/></h1>
	<h1>新闻标题：<s:property value="news.title"/></h1>
	<h1>新闻内容：<s:property value="news.content"/></h1>
	<h1>发布日期：<s:property value="news.pubdate"/></h1>
  </body>
</html>
