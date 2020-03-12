<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM框架开发</title>
    <!-- 导入Bootstrap -->
    <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <h1>书籍展示页</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>
                            【书籍列表】 显示所有书籍
                        </small>
                    </h1>
                </div>
            </div>
            <div class="row">
                <div class="col-md-4 column">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/books/insertPre">新增书籍</a>
                </div>
                <div class="col-md-4 column"></div>
                <div class="col-md-4 column">
                    <form class="form-inline" action="${pageContext.request.contextPath}/books/searchBooks" method="post" style="float: right">
                        <span style="color: red;font-weight: bold">${error}</span>
                        <input type="text" name="bkName" class="form-control" placeholder="请输入书籍名称">
                        <input type="submit" class="btn btn-success" value="查询">
                    </form>
                </div>
            </div>
        </div>

        <div class="row clearfix">
            <div class="col-md-12 column">
                <table class="table table-hover table-striped">
                    <thead>
                        <tr>
                            <th>书籍编号</th>
                            <th>书籍名称</th>
                            <th>书籍数量</th>
                            <th>书籍详情</th>
                            <th>操&nbsp;&nbsp;&nbsp;作</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="book" items="${books}">
                            <tr>
                                <td>${book.bookID}</td>
                                <td>${book.bookName}</td>
                                <td>${book.bookCounts}</td>
                                <td>${book.details}</td>
                                <td>
                                    <a class="btn btn-info" href="${pageContext.request.contextPath}/books/updatePre?id=${book.bookID}">修改</a>
                                        &nbsp;
                                    <a class="btn btn-danger" href="${pageContext.request.contextPath}/books/deleteBooks/${book.bookID}">删除</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</body>
</html>
