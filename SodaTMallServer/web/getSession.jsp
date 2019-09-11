<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/11
  Time: 9:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取Session</title>
</head>
<body>
    <%
        String name = (String) session.getAttribute("name");
    %>
    <h1>你好, <%=name%></h1>
</body>
</html>
