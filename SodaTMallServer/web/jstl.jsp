<%@ page import="java.util.Random" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/12
  Time: 5:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>使用jstl</title>
</head>
<body>
<c:set var="name" value="${'Kobe'}" scope="request"/>

通过jstl标签获取name = <c:out value="${name}"/> <br/>

<c:remove var="name" scope="request"/>

移除过后，通过jstl标签获取name = <c:out value="${name}"/>

<h1>使用jstl判断</h1>
<c:set var="score" value="<%= new Random().nextInt(10)%>" scope="request"/>
<span>最佳球员: </span>
<c:if test="${score < 5}">
    <span>郭艾伦</span>
</c:if>
<c:if test="${!(score < 5)}">
    <span>周琦</span>
</c:if>
<br/>
<%
    List<String> names = new ArrayList<String>();
    names.add("Kobe");
    names.add("Jordan");
    names.add("James");
    names.add("Rose");
    names.add("Wade");
    request.setAttribute("names", names);
%>
<table border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${names}" var="player" varStatus="st">
        <tr>
            <td><c:out value="${st.count}"/></td>
            <td><c:out value="${player}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
