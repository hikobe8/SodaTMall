<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/9
  Time: 11:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8"
         import="javax.servlet.http.Cookie" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie c = new Cookie("name", "Gareen");
    c.setMaxAge(60 * 24 * 60);
    c.setPath("/");
    response.addCookie(c);
%>

<a href="getCookie.jsp">跳转到获取cookie的页面</a>
</body>
</html>
