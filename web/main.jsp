<%--
  Created by IntelliJ IDEA.
  User: yummysghhz
  Date: 2017/12/11
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>main.jsp</title>
</head>
<body>
<%
    if (session.getAttribute("user") == null) response.sendRedirect("notLogin.jsp");
%>
当前用户：${sessionScope.user.name}<br>
${sessionScope.hello}

</body>
</html>
