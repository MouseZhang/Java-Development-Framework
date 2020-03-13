<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SpringMVC</title>
</head>
<body>
  <h1>登录页</h1>
  <!-- 在/WEB-INF/目录下的所有页面或资源，只能通过controller或者servlet进行访问 -->
  <form action="${pageContext.request.contextPath}/user/login" method="post">
    用户名：<input type="text" name="username">
    密&nbsp;&nbsp;码：<input type="password" name="password">
    <input type="submit" value="提交">
  </form>
</body>
</html>
