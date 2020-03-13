<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMVC</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      function validateName() {
          $.post({
              url: "${pageContext.request.contextPath}/login",
              data: {"name": $("#name").val()},
              success: function (data) {
                if (data.toString() == 'OK') {
                    $("#userMsg").css("color","green");
                } else {
                    $("#userMsg").css("color","red");
                }
                $("#userMsg").html(data);
              }
          });
      }
      function validatePwd() {
        $.post({
          url: "${pageContext.request.contextPath}/login",
          data: {"password": $("#pwd").val()},
          success: function (data) {
            if (data.toString() == 'OK') {
              $("#pwdMsg").css("color","green");
            } else {
              $("#pwdMsg").css("color","red");
            }
            $("#pwdMsg").html(data);
          }
        });
      }
    </script>
  </head>
  <body>
    <p>
      用户名：<input type="text" id="name" onblur="validateName()">
      <span id="userMsg"></span>
    </p>
    <p>
      密码：<input type="text" id="pwd" onblur="validatePwd()">
      <span id="pwdMsg"></span>
    </p>
  </body>
</html>
