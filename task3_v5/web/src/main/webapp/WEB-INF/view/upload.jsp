<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-04-28
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
<form action="/a/u/uploadImage" method="post" enctype="multipart/form-data">
    选择图片：<input type="file" name="image" accept="image/*"/><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
