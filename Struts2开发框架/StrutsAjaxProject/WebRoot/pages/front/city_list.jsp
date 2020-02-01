<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jQuery + Struts 2.x</title>
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/city_list.js"></script>
  </head>
  <body>
  	<div id="cityDiv">
  		<table border="1" id="cityTab">
  			<tr>
  				<td>城市编号</td>
  				<td>城市名称</td>
  			</tr>
  		</table>
  	</div>
  </body>
</html>
