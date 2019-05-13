<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-02
  Time: 22:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <%--<title>Document</title>--%>
    <%--<link rel="stylesheet" href="/static/css/task14.1/task14.1.css">--%>
<%--</head>--%>
<tiles:insertAttribute name="head"/>
<body>

<tiles:insertAttribute name="header"/>

<tiles:insertAttribute name="body"/>

<tiles:insertAttribute name="footer"/>
</body>
</html>