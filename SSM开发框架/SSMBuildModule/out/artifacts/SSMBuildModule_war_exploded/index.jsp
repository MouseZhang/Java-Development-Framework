<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SSM框架开发</title>
  <!-- 导入Bootstrap -->
  <link href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
        a {
          text-decoration: none;
          color: black;
          font-size: 18px;
        }
        h3 {
          width:180px;
          height: 38px;
          margin: 100px auto;
          text-align: center;
          line-height: 38px;
          background: deepskyblue;
          border-radius: 5px;
        }
    </style>
</head>
<body>
  <h1 class="text-center">SSM框架整合———书籍管理系统</h1>
  <h3>
      <a href="${pageContext.request.contextPath}/books/allBooks">进入书籍展示页面</a>
  </h3>
</body>
</html>
