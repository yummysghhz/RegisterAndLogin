<%--
  Created by IntelliJ IDEA.
  User: yummysghhz
  Date: 2017/12/11
  Time: 13:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="error" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>login.jsp</title>
</head>
<body>
<h1>login.jsp</h1>

<error:forEach items="${requestScope.errorMap}" var="err">
    ${err.value}<br>
</error:forEach>

<form method="post" action="loginServlet">
    <table>
        <tr>
            <td>用户</td>
            <td><input type="text" name="name" value=""/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type="password" name="password" value=""/></td>
        </tr>
    </table>
    <input type="submit" name="loginbtn" value="登陆"/>

    <a href="register.jsp">注册</a>
</form>
</body>
</html>
