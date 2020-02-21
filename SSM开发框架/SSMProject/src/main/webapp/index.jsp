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
  
  <!-- 雇员修改模态框 -->
	<div class="modal fade" id="empUpdateModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabelUpdate">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title">修改雇员信息</h4>
	      </div>
	      <div class="modal-body">
			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="enameUpdateInput" class="col-sm-2 control-label">雇员姓名</label>
			    <div class="col-sm-10">
					<p class="form-control-static" id="enameUpdateInput"></p>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="sexUpdateInput" class="col-sm-2 control-label">雇员性别</label>
			    <div class="col-sm-10">
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex1UpdateInput" value="M" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex2UpdateInput" value="F"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="emailUpdateInput" class="col-sm-2 control-label">邮箱地址</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="emailUpdateInput" placeholder="email@example.com">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="dnameUpdateInput" class="col-sm-2 control-label">部门名称</label>
			    <div class="col-sm-4">
					<select class="form-control" name="dno" id="dnameUpdateInput"></select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="empUpdateBut">更新</button>
	      </div>
	    </div>
	  </div>
	</div>
	
  <!-- 雇员添加模态框 -->
	<div class="modal fade" id="empAddModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="myModalLabel">新增雇员信息</h4>
	      </div>
	      <div class="modal-body">
			<form class="form-horizontal">
			  <div class="form-group">
			    <label for="enameAddInput" class="col-sm-2 control-label">雇员姓名</label>
			    <div class="col-sm-10">
			      <input type="text" name="ename" class="form-control" id="enameAddInput" placeholder="SMITH">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="sexAddInput" class="col-sm-2 control-label">雇员性别</label>
			    <div class="col-sm-10">
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex1AddInput" value="M" checked="checked"> 男
					</label>
					<label class="radio-inline">
					  <input type="radio" name="sex" id="sex2AddInput" value="F"> 女
					</label>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="emailAddInput" class="col-sm-2 control-label">邮箱地址</label>
			    <div class="col-sm-10">
			      <input type="text" name="email" class="form-control" id="emailAddInput" placeholder="email@example.com">
			      <span id="helpBlock2" class="help-block"></span>
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="dnameAddInput" class="col-sm-2 control-label">部门名称</label>
			    <div class="col-sm-4">
					<select class="form-control" name="dno" id="dnameAddInput">
					</select>
			    </div>
			  </div>
			</form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
	        <button type="button" class="btn btn-primary" id="empSaveBut">保存</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
  		<div class="container">
  			<!-- 标题 -->
  			<div class="row">
  				<div class="col-md-12">
  					<h1 class="text-center">SSM框架开发实战</h1>
  				</div>
  			</div>
  			<!-- 按钮 -->
  			<div class="row">
  				<div class="col-md-4 col-md-offset-10">
  					<button class="btn btn-primary" id="empInsertBut">新增</button>
  					<button class="btn btn-danger" id="empDeleteAllBut">删除</button>
  				</div>
  			</div>
  			<!-- 表格 -->
  			<div class="row">
  				<div class="col-md-12">
  					<table class="table table-hover" id="empsTb">
  						<thead>
	  						<tr>
	  							<td><input type="checkbox" id="checkAll"/></td>
	  							<td><strong>编号</strong></td>
	  							<td><strong>雇员姓名</strong></td>
	  							<td><strong>雇员性别</strong></td>
	  							<td><strong>邮箱地址</strong></td>
	  							<td><strong>部门名称</strong></td>
	  							<td><strong>操作类型</strong></td>
	  						</tr>
  						</thead>
  						<tbody>
  						</tbody>
  					</table>
  				</div>
  			</div>
  			<!-- 分页 -->
  			<div class="row">
  				<!-- 分页信息 -->
  				<div class="col-md-6" id="pageCountTd"></div>
  				<!-- 分页条信息 -->
  				<div class="col-md-6" id="pageNavTd">
  					
  				</div>
  			</div>
  		</div>
  		<script type="text/javascript">
  			var totalRecord; // 全局保存总记录数
  			var currentPage; // 全局保存当前页
  			// 页面加载完成后，直接发送Ajax请求获取分页数据
  			// 1、解析并显示雇员数据 empsTable
  			// 2、解析并显示分页统计数据 pageCount
  			// 3、解析并显示分页条数据 pageNav
			$(function(){
				toPage(1); // 进入首页
			});
			
			function toPage(pn) {
				$.ajax({
					url:"<%=basePath%>emps",
					data:"pn=" + pn,
					type:"GET",
					success:function(result){
						console.log(result);
						// 解析表格数据
						empsTable(result);
						// 解析分页统计数据
						pageCount(result);
						// 解析分页条数据
						pageNav(result);
					}
				});
			}
			
			function empsTable(data) {
				// 构建数据之前，首先清空数据
				$("#empsTb tbody").empty();
				var emps = data.extend.pageInfo.list;
				$.each(emps,function(index,item){
					var checkboxTd = $("<td><input type='checkbox' class='checkItem'/></td>");
					var empnoTd = $("<td></td>").append(item.empno);
					var enameTd = $("<td></td>").append(item.ename);
					var sexTd =  $("<td></td>").append(item.sex == 'M' ? "男": "女");
					var emailTd = $("<td></td>").append(item.email);
					var dnameTd = $("<td></td>").append(item.dept.dname);
					/**
					编辑按钮：
					<button class="btn btn-success btn-sm">
	  					<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
	  					编辑
	  				</button>
					 */
					var editBut = $("<button></button>").addClass("btn btn-success btn-sm editBut")
														.append($("<span></span>").addClass("glyphicon glyphicon-pencil"))
														.append("编辑");
					// 为编辑按钮添加自定义属性，用于保存传入的雇员id
					editBut.attr("editId", item.empno);								
					var delBut = $("<button></button>").addClass("btn btn-warning btn-sm delBut")
														.append($("<span></span>").addClass("glyphicon glyphicon-trash"))
														.append("删除");
					// 为编辑按钮添加自定义属性，用于保存传入的雇员id
					delBut.attr("delId", item.empno);		
					var butTd = $("<td></td>").append(editBut).append(" ").append(delBut);
					$("<tr></tr>").append(checkboxTd)
								  .append(empnoTd)
								  .append(enameTd)
								  .append(sexTd)
								  .append(emailTd)
								  .append(dnameTd)
								  .append(butTd)
								  .appendTo("#empsTb tbody");
				});
			}
			
			function pageCount(data) {
				// 构建数据之前，首先清空数据
				$("#pageCountTd").empty();
				$("#pageCountTd").append("当前" + data.extend.pageInfo.pageNum + "页，总" + data.extend.pageInfo.pages + "页，总" + data.extend.pageInfo.total + "条记录");
				totalRecord = data.extend.pageInfo.total;
				currentPage = data.extend.pageInfo.pageNum;
			}
			
			function pageNav(data) {
				// 构建数据之前，首先清空数据
				$("#pageNavTd").empty();
				var ul = $("<ul></ul>").addClass("pagination");
				var firstPageLi = $("<li></li>").append($("<a></a>").append("首页").attr("href","#"));
				var prePageLi = $("<li></li>").append($("<a></a>").append("&laquo;"));
				if (!data.extend.pageInfo.hasPreviousPage) {
					firstPageLi.addClass("disabled");
					prePageLi.addClass("disabled");
				} else {
					// 为首页添加点击事件
					firstPageLi.click(function(){
						toPage(1);
					});
					prePageLi.click(function(){
						toPage(data.extend.pageInfo.pageNum - 1);
					});
				}
				var lastPageLi = $("<li></li>").append($("<a></a>").append("末页").attr("href","#"));
				var nextPageLi = $("<li></li>").append($("<a></a>").append("&raquo;"));
				if (!data.extend.pageInfo.hasNextPage) {
					lastPageLi.addClass("disabled");
					nextPageLi.addClass("disabled");
				} else {
					// 为末页添加点击事件
					lastPageLi.click(function(){
						toPage(data.extend.pageInfo.pages);
					});
					nextPageLi.click(function(){
						toPage(data.extend.pageInfo.pageNum + 1);
					});
				}
				ul.append(firstPageLi).append(prePageLi);
				$.each(data.extend.pageInfo.navigatepageNums,function(index,item){
					var numLi = $("<li></li>").append($("<a></a>").append(item));
					if (data.extend.pageInfo.pageNum == item) {
						numLi.addClass("active");
					}
					numLi.click(function(){
						toPage(item);
					});
					ul.append(numLi);
				});
				ul.append(nextPageLi).append(lastPageLi);
				var navEle = $("<nav></nav>").append(ul).appendTo("#pageNavTd");
			}
			
			// 清空表单样式及内容
			function resetForm(ele) {
				$(ele)[0].reset(); // 取出DOM对象，调用reset方法，表单内容重置
				$(ele).find("*").removeClass("has-success has-error"); // 表单样式重置
				$(ele).find(".help-block").text(""); // 信息提示框重置样式
			}
			
			// 添加新增雇员的事件
			$("#empInsertBut").click(function(){
				// 每次新增雇员时，都应清除上一次的表单数据
				resetForm("#empAddModal form");
				// 发送Ajax请求，查询部门信息，显示在下拉列表框中
				$("#dnameAddInput").empty();
				getDepts("#dnameAddInput");
				// 弹出模态框
				$("#empAddModal").modal({
					backdrop: "static"			
				});
			});
			
			function getDepts(ele) {
				// 清空上次下拉列表的值
				$(ele).empty();
				$.ajax({
					url:"<%=basePath%>depts",
					type:"GET",
					success:function(result) {
						console.log(result);
						$.each(result.extend.depts,function(index,item){
							var optionEle = $("<option></option>").append(item.dname).attr("value",item.deptno);
							optionEle.appendTo(ele);
						});
					}
				});
			}
			
			function validateMsg(ele, status, msg) {
				// 每次显示数据前都应该清空元素之前的样式
				$(ele).parent().removeClass("has-success has-error");
				$(ele).next("span").text("");
				if ("success" == status) {
					$(ele).parent().addClass("has-success");
					$(ele).next("span").text(msg);
				} else if ("error" == status) {
					$(ele).parent().addClass("has-error");
					$(ele).next("span").text(msg);
				}
			}
			
			function validateForm() {
				// 校验雇员姓名
				var ename = $("#enameAddInput").val();
				var enameRegex = /(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})/;
				if (!enameRegex.test(ename)) {
					validateMsg("#enameAddInput", "error", "用户名可以是2-5位中文或者6-16位英文和数字的组合！");
					return false;
				} else {
					validateMsg("#enameAddInput", "success", "用户名格式正确！");
				}
				
				// 校验邮箱地址
				var email = $("#emailAddInput").val();
				var emailRegex = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailRegex.test(email)) {
					validateMsg("#emailAddInput", "error", "邮箱地址格式有误！");
					return false;
				} else {
					validateMsg("#emailAddInput", "success", "邮箱格式正确！");
				}
				return true;
			}
			
			$("#enameAddInput").change(function(){
				var name = this.value;
				// 校验用户名是否可用
				$.ajax({
					url:"<%=basePath%>checkName",
					data:"ename="+ name,
					type:"POST",
					success:function(result) {
						if (result.code == 100) {
							validateMsg("#enameAddInput", "success", "用户名可以注册！");
							$("#empSaveBut").attr("changeAjax", "success");
						} else if (result.code == 200) {
							validateMsg("#enameAddInput", "error", result.extend.validateName);
							$("#empSaveBut").attr("changeAjax", "error");
						}
					}
				});
			});
			
			// 添加雇员信息保存的事件
			$("#empSaveBut").click(function(){
				// 前台校验
			//	if (!validateForm()) {
			//		return false;
			//	}
				// 判断change事件的Ajax校验是否成功
				if ($(this).attr("changeAjax") == "error") {
					validateMsg("#enameAddInput", "error", "用户名已被占用，请重新输入！");
					return false;
				}
				// 提交模态框表单数据，发送Ajax请求保存雇员数据
				$.ajax({
					url:"<%=basePath%>emp",		
					data:$("#empAddModal form").serialize(),
					type:"POST",
					success:function(result){
						if (result.code == 100) {
							alert(result.msg);
							// 关闭模态框
							$("#empAddModal").modal('hide'); 
							// 回到末页，发送Ajax请求最后一页即可
							toPage(totalRecord); // 或者toPage(999999999);
						} else if (result.code == 200) {
							// 显示失败信息
							if (undefined != result.extend.errorFields.email) {
								// 显示邮箱错误信息
								validateMsg("#emailAddInput", "error", result.extend.errorFields.email);
							}
							if (undefined != result.extend.errorFields.ename) {
								// 显示雇员姓名错误信息
								validateMsg("#enameAddInput", "error", result.extend.errorFields.ename);
							}
						}
					}
				});
			});
			
			function getEmp(id) {
				$.ajax({
					url:"<%=basePath%>emp/" + id,
					type:"GET",
					success:function(result) {
						console.log(result);
						var empData = result.extend.emp;
						$("#enameUpdateInput").text(empData.ename);
						// 为单选框赋值
						$("#empUpdateModal input[name=sex]").val([empData.sex]);
						// 为input框赋值
						$("#emailUpdateInput").val(empData.email);
						// 为下拉列表赋值
						$("#empUpdateModal select[name=dno]").val([empData.dno]);
					}
				});
			}
			
			// 为编辑按钮绑定事件，有如下3中方法：
			// 1、在创建按钮的时候绑定 2、绑定点击live()方法 3、on()方法
			$(document).on("click",".editBut",function(){
				// 每次编辑雇员时，都应清除上一次的表单数据
				resetForm("#empUpdateModal form");
				getDepts("#dnameUpdateInput");
				getEmp($(this).attr("editId"));
				// 将雇员编号传递给模态框更新按钮
				$("#empUpdateBut").attr("editId", $(this).attr("editId"));
				// 弹出模态框
				$("#empUpdateModal").modal({
					backdrop: "static"			
				});
			});
			
			// 为单个删除按钮绑定事件
			$(document).on("click",".delBut",function(){
				// 弹出是否确认删除对话框
				var ename = $(this).parents("tr").find("td:eq(2)").text(); // 找删除按钮祖先下第2个td
				var empno = $(this).attr("delId");
				if (confirm("确定要删除 " + ename + " 用户数据吗？")) {
					// 发送Ajax请求进行删除
					$.ajax({
						url:"<%=basePath%>emp/" + empno,
						type:"DELETE",
						success:function(result) {
							// 删除后回到本页
							toPage(currentPage);
						}
					});
				}
			});
			
			// 为更新按钮绑定事件
			$("#empUpdateBut").click(function(){
				// 校验邮箱地址
				var email = $("#emailUpdateInput").val();
				var emailRegex = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
				if (!emailRegex.test(email)) {
					validateMsg("#emailUpdateInput", "error", "邮箱地址格式有误！");
					return false;
				} else {
					validateMsg("#emailUpdateInput", "success", "邮箱格式正确！");
				}
				// 发送Ajax请求，保存雇员数据
				$.ajax({
					url:"<%=basePath%>emp/"+$(this).attr("editId"),
					type:"PUT", // type:"POST",
					data:$("#empUpdateModal form").serialize(), // data:$("#empUpdateModal form").serialize()+"&_method=PUT"
					success: function(result) {
						// 关闭模态框
						$("#empUpdateModal").modal("hide");
						// 回到本页面
						toPage(currentPage);
					}
				});
			});
			
			// 完成checkbox全选、全不选功能
			$("#checkAll").click(function(){
				// attr获取checked是undefined，dom原生属性推荐使用prop获取属性值，attr获取自定义的值
				$(this).prop("checked");
				$(".checkItem").prop("checked",$(this).prop("checked"));
			});
			
			// checkItem绑定事件
			$(document).on("click",".checkItem",function(){
				// 判断当前选中的元素是否为5个，使用checked选择器
				var flag = $(".checkItem:checked").length==$(".checkItem").length;
				$("#checkAll").prop("checked",flag);
			});
			
			// 批量删除按钮
			$("#empDeleteAllBut").click(function(){
				var enames = "";
				var empnos = "";
				$.each($(".checkItem:checked"),function(){
					enames+=$(this).parents("tr").find("td:eq(2)").text()+",";
					// 组装雇员编号字符串
					empnos+=$(this).parents("tr").find("td:eq(1)").text()+"|";
				});
				// 取出最后一个逗号
				enames = enames.substring(0, enames.length-1);
				if (confirm("确定要删除 " + enames + " 用户数据吗？")) {
					// 发送Ajax批量删除数据
					$.ajax({
						url:"<%=basePath%>emp/"+empnos,
						type:"DELETE",
						success:function(result) {
							alert(result.msg);
							// 回到当前页
							toPage(currentPage);
						}
					});
				}
			});
			
  		</script>
  </body>
</html>
