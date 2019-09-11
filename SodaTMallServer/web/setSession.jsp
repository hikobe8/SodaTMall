<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/11
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>session</title>
</head>
<body>
    <% session.setAttribute("name", "Kobe"); %>
    <a href="getSession.jsp">跳转到获取session的页面</a>
</body>
</html>
