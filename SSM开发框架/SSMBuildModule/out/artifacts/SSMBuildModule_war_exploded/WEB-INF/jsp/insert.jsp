<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>SSM框架开发</title>
    <!-- 导入Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body>
    <h1>书籍新增页</h1>
    <div class="container">
        <div class="row clearfix">
            <div class="col-md-12 column">
                <div class="page-header">
                    <h1>
                        <small>
                            【书籍新增】 请添加书籍信息
                        </small>
                    </h1>
                </div>
            </div>
        </div>
        <form action="${pageContext.request.contextPath}/books/insertBooks" method="post">
            <div class="form-group">
                <label>书籍名称</label>
                <input type="text" name="bookName" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍数量</label>
                <input type="text" name="bookCounts" class="form-control" required>
            </div>
            <div class="form-group">
                <label>书籍详情</label>
                <input type="text" name="details" class="form-control" required>
            </div>
            <div class="form-group">
                <input type="submit" class="btn btn-success" value="添加">
            </div>
        </form>
    </div>
</body>
</html>
