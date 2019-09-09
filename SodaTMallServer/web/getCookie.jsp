<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/9
  Time: 11:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Cookie[] cookies = request.getCookies();
    if (null != cookies)
        for (int d = 0; d <= cookies.length - 1; d++) {
            out.print(cookies[d].getName() + ":" + cookies[d].getValue() + "<br>");
        }
%>
</body>
</html>
