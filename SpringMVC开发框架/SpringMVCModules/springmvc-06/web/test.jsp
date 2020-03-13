<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>SpringMVC</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      $(function () {
        $("#btn").click(function () {
            /*
                简写：$.post(url,param[可省略],success)
             */
          $.post("${pageContext.request.contextPath}/ajaxUser",function (data) {
              console.log(data);
              var html = "";
              for (let i = 0; i < data.length; i++) {
                html += "<tr>" +
                        "<td>" + data[i].name + "</td>" +
                        "<td>" + data[i].age + "</td>" +
                        "<td>" + data[i].sex + "</td>" +
                        "</tr>"
              }
              $("#content").html(html);
          });
        });
      });
    </script>
  </head>
  <body>
    <input type="button" value="加载数据" id="btn">
    <table>
      <tr>
        <td>姓名</td>
        <td>年龄</td>
        <td>性别</td>
      </tr>
      <tbody id="content">
        <!-- 数据从后台取 -->

      </tbody>
    </table>
  </body>
</html>
