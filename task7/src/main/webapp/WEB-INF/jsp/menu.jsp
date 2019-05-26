<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-03
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="col-lg-5 col-20">
    <div class="side-nav">
        <div class="side-nav-title">合作企业</div>
        <ul class="side-nav-content">
            <c:forEach items="${list}" var="l">
            <li><a href="/company?id=${l.id}">${l.company}</a></li>
            </c:forEach>
        </ul>
    </div>
</div>
