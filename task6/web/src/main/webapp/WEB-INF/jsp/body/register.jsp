<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-11
  Time: 22:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div style="height: 300px">--%>
    <%--<h1>${msg}</h1>--%>
<%--<form action="/a/register" method="post">--%>
    <%--<input type="text" name="username" placeholder="请输入手机号">--%>
    <%--<input type="text" name="password" placeholder="请输入密码">--%>
    <%--<input type="submit" value="注册">--%>
<%--</form>--%>
    <%--<div><a href="/a/login">返回登录</a> </div>--%>
<%--</div>--%>

<div style="background-color: #F5F5F5;padding: 100px 0 100px 0;height: 600px;display:flex;justify-content: space-around">
    <div >
        <img src="/view/image/login-ad_03.png">
    </div >
    <div style="background-color: #ffffff;border: 1px solid #999999;width: 400px;height: 350px;display: flex;justify-content: center">

        <form action="/a/register" method="post">
            <h2 style="color: #29b078;margin: 10px 10px;text-align: center">用户注册</h2>
            <div style="margin-bottom: 20px;margin-top: 20px">
                <input style="height: 50px;width: 250px;font-size: large" type="text" name="username" placeholder="请输入注册手机号">
            </div>
            <div style="margin-bottom: 20px">
                <input style="height: 50px;width: 250px;font-size: large" type="password" name="password" placeholder="请输入登陆密码">
            </div>
            <div style="margin: 10px 0 0 10px;"><strong>${msg}</strong></div>
            <div style="margin-top: 20px">
                <!--<input  type="submit" value="登陆" style="width: 120px;height: ">-->
                <button style="width: 250px;height: 50px;background-color: #29b078;color: white;font-size: large" type="submit">
                    提&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;交</button>
            </div>
            <div style="margin: 10px 10px 0 180px"><a style="font-size: small;color: #999999" href="/a/login">返回登录</a></div>
        </form>

    </div>
</div>