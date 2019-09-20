<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: cherry
  Date: 2019/9/16
  Time: 9:18 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="learn_servlet.bean.HeroBean" %>
<html>
<head>
    <title>英雄列表</title>
</head>
<body>
<a href='addHero.html' style="position:fixed; left:20px; top:20px">增加英雄</a>
<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>英雄名称</td>
        <td>血量</td>
        <td>伤害值</td>
        <td>操作</td>
    </tr>
    <jsp:useBean id="heros" scope="request" type="java.util.List"/>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a href='editHero?id=${hero.id}'>编辑</a>/<a href='delete?id=${hero.id}'>删除</a></td>
        </tr>
    </c:forEach>
</table>
</table>
</body>
</html>
