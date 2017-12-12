<%--
  Created by IntelliJ IDEA.
  User: yummysghhz
  Date: 2017/12/11
  Time: 13:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="error" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>register.jsp</title>
</head>
<body>
<h1>register.jsp</h1>

<error:forEach items="${requestScope.errorMap}" var="err">
    ${err.value}<br>
</error:forEach>

<form action="registerServlet" method="post">
    <table>
        <tr>
            <td>ID:</td>
            <td><input name="id" type="text" size="20"/></td>
        </tr>
        <tr>
            <td>登录名：</td>
            <td><input name="name" type="text" size="20"/></td>
        </tr>
        <tr>
            <td>密码:</td>
            <td><input name="password" type="password" size="21"/></td>
        </tr>
    </table>
    <input type="submit" value="注册">
    <input type="reset" value="重置">
</form>
<br>
<a href="login.jsp">登陆</a>
</body>
</html>
