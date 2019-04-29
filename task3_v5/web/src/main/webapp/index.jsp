<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
<h2>Hello World!</h2>

<%--<a href="WEB-INF/view/upload.jsp">upload</a>--%>

<br><br><br><br><br><br><br><br><br><br>


<form action="/uploadImage" method="post" enctype="multipart/form-data">
    选择图片：<input type="file" name="image" accept="image/*"/><br>
    <input type="submit" value="上传">
</form>
</body>
</html>
