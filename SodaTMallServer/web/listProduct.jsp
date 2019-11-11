<%--
  Created by IntelliJ IDEA.
  User: ray
  Date: 2019/11/11
  Time: 4:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>购物车</title>
</head>
<body>

<table align="center" border="1" cellspacing="0">
    <tr>
        <td>id</td>
        <td>名称</td>
        <td>价格</td>
        <td>购买</td>
    </tr>
    <c:forEach items="${products}" var="product" varStatus="st">
        <tr>
            <td>${product.id}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td align="center">
                <form method="post" action="" style="margin: 10px auto">
                    数量
                    <input type="number" value="1" name="num"/>
                    <input type="hidden" value="${product.id}" name="pid"/>
                    <input type="button" value="购买"/>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
