<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-22
  Time: 00:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>getcode</title>
</head>
<body>
<div style="height: 500px">
<form action="/a/code" method="post">
    <input type="text" name="mobilOrEmail" placeholder="请输入手机号码或邮箱..">
    <input type="submit" value="获取验证码">
    ${msg}
</form>
</div>
</body>
</html>
