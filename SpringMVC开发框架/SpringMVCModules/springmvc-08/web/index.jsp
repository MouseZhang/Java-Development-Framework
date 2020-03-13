<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>SpringMVC</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post">
  <input type="file" name="file"/>
  <input type="submit">
</form>
<a href="${pageContext.request.contextPath}/upload/测试下载文件.txt">下载文件</a>
</body>
</html>
