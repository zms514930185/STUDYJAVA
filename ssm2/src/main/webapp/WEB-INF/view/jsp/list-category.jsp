<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-04-06
  Time: 15:47
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>list-category</title>
</head>
<body>

<div style="width:500px;margin:0px auto;text-align:center">
    <table align="center" border="1" cellspacing="0">
        <tr>
            <td>id</td>
            <td>name</td>
        </tr>
        <c:forEach items="${list}" var="Category" varStatus="st">
            <tr>
                <td>${Category.id}</td>
                <td>${Category.name}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
