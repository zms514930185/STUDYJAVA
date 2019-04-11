<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-04-10
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<html>
<head>
    <title>StuList</title>
    <style>
        /**{border: 1px solid black}*/
        body{border: 0;background-color: #F5F5F5}
        td div{display: flex;justify-content: flex-end}
        .media a{margin-left: 20px;}
        p div{display: inline-block;}
        .button{position: relative;right: -30px}
    </style>
</head>
<body>
<div  style="display: flex">
    <div>
<table  border="1" cellspacing="0">
<tr>
    <td><input type="checkbox" ></td>
    <td>编号</td>
    <td>姓名</td>
    <td>QQ</td>
    <td>选修职业</td>
    <td>创建时间</td>
    <td>修改时间</td>
    <td>日报地址</td>
    <td>立愿</td>
    <td>修改</td>
    <td>删除</td>
</tr>
<c:forEach items="${list}" var="l" varStatus="st">
    <tr>
        <td><input type="checkbox" value="${l.id}"></td>
        <td>${l.id}</td>
        <td>${l.stuName}</td>
        <td>${l.qq}</td>
        <td>${l.job}</td>
        <td>${l.createAt}</td>
        <td>${l.updateAt}</td>
        <td>${l.dailyUrl}</td>
        <td>${l.flag}</td>
        <td><a href="/edit?id=${l.id}">修改</a></td>
        <td><a href="/delete?id=${l.id}">删除</a></td>
    </tr>
</c:forEach>
    <tr>
<td colspan="11" >
    <div class="media">

        <c:choose>
            <c:when test="${page.start!=0}">
                <a href="?start!=0">首页</a>
            </c:when>
            <c:otherwise>
                <a style="color: grey">首页</a>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${page.start!=0}">
                <a href="?start=${page.start-page.count}">上一页</a>
            </c:when>
            <c:otherwise>
                <a style="color: grey">上一页</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.start+page.count<=page.last}">
                <a href="?start=${page.start+page.count}">下一页</a>
            </c:when>
            <c:otherwise>
                <a style="color: grey">下一页</a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.start+page.count<=page.last}">
                <a href="?start=${page.last}">末页</a>
            </c:when>
            <c:otherwise>
                <a style="color: grey">末页</a>
            </c:otherwise>
        </c:choose>
    </div>
</td>
    </tr>
</table>
</div>
    <div class="button" style="display: inline-block;">
        <form action="/add" method="post">
            <p><div>姓名</div><input type="text" value="" name="stuName" autocomplete="off"></p>
            <p><div>QQ</div><input type="text" value="" name="qq" autocomplete="off"></p>
            <p><div>选修职业</div><input type="text" value="" name="job" autocomplete="off"></p>
            <p><div>日报地址</div><input type="text" value="" name="dailyUrl" autocomplete="off"></p>
            <p><div>立愿</div><input type="text" value="" name="flag" autocomplete="off"></p>

            <button type="submit" type="submit" style="border-radius: 10px;">提交</button>
        </form>
    </div>
</div>


<%--<td>--%>
<%--&lt;%&ndash;<!-- 通过jsp:userBean标签引入java.util.Date日期类 -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<jsp:useBean id="dateValue" class="java.util.Date"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- 使用jsp:setProperty标签将时间戳设置到Date的time属性中 -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<jsp:setProperty name="dateValue" property="time" value="${l.updateAt}"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;<!-- 转换格式 -->&ndash;%&gt;--%>
<%--&lt;%&ndash;<fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/>&ndash;%&gt;--%>
<%--&lt;%&ndash;long转换为date&ndash;%&gt;--%>
<%--<jsp:useBean id="data1" class="java.util.Date"/>--%>
<%--<jsp:setProperty name="data1" property="time" value="${l.createAt}"/>--%>
<%--&lt;%&ndash;data转为具体时间格式&ndash;%&gt;--%>
<%--<fmt:formatDate var="datecreate" value="${data1}" pattern="yyyy年MM月dd日HH点mm分ss秒"  />--%>
<%--${datecreate}--%>
<%--</td>--%>
</body>
</html>
