<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SpringMVC</title>
</head>
<body>
  <h1>首页</h1>
  <h2>欢迎光临！</h2>
  <span>
      ${username}&nbsp;,您好！
  </span>
  <p><a href="${pageContext.request.contextPath}/user/logout">注销</a></p>
</body>
</html>
