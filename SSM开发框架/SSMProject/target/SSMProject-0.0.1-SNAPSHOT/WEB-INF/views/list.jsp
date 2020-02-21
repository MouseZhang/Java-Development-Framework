<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>雇员列表</title>
    <script type="text/javascript" src="<%=basePath%>static/js/jquery-3.4.1.min.js"></script>
    <link href="<%=basePath%>static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
  	<script src="<%=basePath%>static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </head>
  <body>
  		<div class="container">
  			<!-- 标题 -->
  			<div class="row">
  				<div class="col-md-12">
  					<h1>SSM框架开发实战</h1>
  				</div>
  			</div>
  			<!-- 按钮 -->
  			<div class="row">
  				<div class="col-md-4 col-md-offset-8">
  					<button class="btn btn-primary">新增</button>
  					<button class="btn btn-danger">删除</button>
  				</div>
  			</div>
  			<!-- 表格 -->
  			<div class="row">
  				<div class="col-md-12">
  					<table class="table table-hover">
  						<tr>
  							<td><strong>编号</strong></td>
  							<td><strong>雇员姓名</strong></td>
  							<td><strong>雇员性别</strong></td>
  							<td><strong>邮箱地址</strong></td>
  							<td><strong>部门名称</strong></td>
  							<td><strong>操作类型</strong></td>
  						</tr>
  						<c:forEach items="${pageInfo.list}" var="emp">
							<tr>
	  							<td>${emp.empno}</td>
	  							<td>${emp.ename}</td>
	  							<td>${emp.sex=="M"?"男":"女"}</td>
	  							<td>${emp.email}</td>
	  							<td>${emp.dept.dname}</td>
	  							<td>
	  								<button class="btn btn-success btn-sm">
	  								<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	  									编辑
	  								</button>
	  								<button class="btn btn-warning btn-sm">
	  								<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	  									删除
	  								</button>
	  							</td>
  							</tr>
  						</c:forEach>
  					</table>
  				</div>
  			</div>
  			<!-- 分页 -->
  			<div class="row">
  				<!-- 分页信息 -->
  				<div class="col-md-6">
  					当前${pageInfo.pageNum}页，总${pageInfo.pages}页，总${pageInfo.total}条记录
  				</div>
  				<!-- 分页条信息 -->
  				<div class="col-md-6">
  					<nav aria-label="Page navigation">
					  <ul class="pagination">
					  	<li><a href="<%=basePath%>emps?pn=1">首页</a></li>
					  	<c:if test="${pageInfo.hasPreviousPage}">
						  	<li>
						      <a href="<%=basePath%>emps?pn=${pageInfo.pageNum-1}" aria-label="Previous">
						        <span aria-hidden="true">&laquo;</span>
						      </a>
						    </li>
					  	</c:if>
					    <c:forEach items="${pageInfo.navigatepageNums}" var="pageNum">
					    	<c:if test="${pageNum==pageInfo.pageNum}">
					    		<li class="active"><a href="#">${pageNum}</a></li>
					    	</c:if>
					    	<c:if test="${pageNum!=pageInfo.pageNum}">
					    		<li><a href="<%=basePath%>emps?pn=${pageNum}">${pageNum}</a></li>
					    	</c:if>
					    </c:forEach>
					    <c:if test="${pageInfo.hasNextPage}">
						    <li>
						      <a href="<%=basePath%>emps?pn=${pageInfo.pageNum+1}" aria-label="Next">
						        <span aria-hidden="true">&raquo;</span>
						      </a>
						    </li>
					    </c:if>
					   	<li><a href="<%=basePath%>emps?pn=${pageInfo.pages}">末页</a></li>
					  </ul>
					</nav>
  				</div>
  			</div>
  		</div>
  </body>
</html>
