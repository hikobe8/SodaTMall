<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/7
  Time: 5:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" %>
<html>
<head>
    <title>Hello JSP</title>
</head>
<body>
<h1>Hello, JSP</h1>
<%=new Date().toLocaleString()%><br/>
<%out.println("System.out.println()");%>
<%--<%out.println("hello");%> 与 <%="hello"%> 效果一样--%>
<%--for循环--%>
<%for (int i = 1; i < 6; i++) {%>
<div><%="中国队员" + i%>
</div>
<%}%>
<a href="hello.jsp?type=client">客户端跳转</a><br/>
<a href="hello.jsp?type=server">服务端跳转</a><br/>
<%
    String type = request.getParameter("type");
    if (type == null || type.length() < 1){
        return;
    }
    if ("client".equals(type)) {
        response.sendRedirect("jump.jsp?type=" + type);
    } else {
        request.getRequestDispatcher("jump.jsp?type=" + type).forward(request, response);
    }
%>
</body>
</html>
