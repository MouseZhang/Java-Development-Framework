<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMVC</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      function go() {
        $.post({
            url: "${pageContext.request.contextPath}/ajaxResp",
            data: {"name": $("#username").val()},
            success: function (data, status) {
                console.log("data: " + data);
                console.log("status: " + status); // 200：成功；300：重定向/转发；400：客户端错误；500：服务器端错误
            },
            error: function (data) {

            }
        });
      }
    </script>
  </head>
  <body>
    <!-- 失去焦点的时候，触发Ajax请求到后台 -->
    用户名：<input type="text" id="username" onblur="go()">
  </body>
</html>
