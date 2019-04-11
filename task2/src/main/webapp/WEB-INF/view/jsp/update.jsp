<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-04-10
  Time: 23:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>update</title>
    <style>
        /**{border: 1px solid black}*/
        .form{ display: flex;justify-content: space-around;width: 100vw}
        .form div{width: 25vw}
        input {font-size: large}
        button{ box-sizing: border-box;outline: none; }
        body{border: 0;background-color: #F5F5F5}
    </style>
</head>
<body>
<br/><br/><br/><br/><br/><br/>
<div >
<form action="/update" method="post">
    <div class="form">
<table>
    <tr>
        <td>编号<input type="text" value="${s.id}"  name="id" autocomplete="off"></td>
        <td>姓名<input type="text" value="${s.stuName}"  name="stuName" autocomplete="off"></td>
        <td>QQ<input type="text" value="${s.qq}" i name="qq" autocomplete="off"></td>
        <td>选修职业<input type="text" value="${s.job}"  name="job" autocomplete="off"></td>
        <%--<td>修改时间<input type="text" value="${l.updateAt}" id="updateAt"></td>--%>
        <td>日报地址<input type="text" value="${s.dailyUrl}"  name="dailyUrl" autocomplete="off"></td>
        <td>立愿<input type="text" value="${s.flag}" name="flag" autocomplete="off"></td>
    </tr>
</table>
    </div>
    <br/><br/><br/>
    <div class="form">
        <div></div>
        <a href="/"><button type="button" style="border-radius: 10px;width: 20vw;height: 5vh">返回</button></a>

        <button type="submit" style="border-radius: 10px;width: 20vw;height: 5vh">提交</button>
        <div></div>
    </div>
</form>

</div>

</body>

</html>
