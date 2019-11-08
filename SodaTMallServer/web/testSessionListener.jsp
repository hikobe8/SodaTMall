<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 2019/11/8
  Time: 5:52 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试SessionListener</title>
</head>
<body>
<%
    session.setAttribute("name", "ray");
    session.removeAttribute("name");
%>
</body>
</html>
