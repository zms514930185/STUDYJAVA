<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-11
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="height: 300px">
    <div style="text-align: center"><img src="/view/image/timg.gif"></div>
    <div>
        <form action="/a/u/upload" method="post" enctype="multipart/form-data">
            选择图片：<input type="file" name="file" /><br>
            <input type="submit" value="上传">
        </form>
    </div>
    ${urlPath}
</div>
