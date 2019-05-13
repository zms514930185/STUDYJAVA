<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-02
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>

<%--<head>--%>
    <%--<meta charset="UTF-8">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1.0">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="ie=edge">--%>
    <%--<title>Document</title>--%>
    <%--<link rel="stylesheet" href="/static/css/task14.1/task14.1.css">--%>
<%--</head>--%>
<%--<body>--%>
<header>
    <div class="container">
        <div class="row header-top align-items-center">
            <div class="col-13  customService">客服热线：010-594-78634</div>
            <div class="col-7 justify-content-right ">
                <img class="icons" src="/static/image/task14.1/qq.png">
                <img class="icons" src="/static/image/task14.1/wechat.png">
                <img class="icons" src="/static/image/task14.1/sina.png">
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><a style="color: #333333;" href="#">${name}</a> </span>
                &nbsp;&nbsp;<span><a style="border-left: #999999 1px solid;padding-left:10px;color: #333333;" href="/a/logout">退出</a> </span>
            </div>
        </div>
    </div>
    <div class="header-bottom">
        <div class="container">
            <div class="row align-items-center header-bottom">
                <div class="col-sm-6 col-13">
                    <div class="tree">技能树</div>
                    <div class="url">www.jnshu.com</div>
                </div>
                <div class="col-sm-14 col-7 justify-content-right">
                    <ul class="nav">
                        <a href="/">
                            <li>首页</li>
                        </a>
                        <a href="/job">
                            <li>职业</li>
                        </a>
                        <a href="/company">
                            <li>推荐</li>
                        </a>
                        <a href="/a/u/vip">
                            <li>大厅</li>
                        </a>
                    </ul>

                    <button type="button">
                        <label for="boom">
                            <div class="menu">
                                <div class="line"></div>
                                <div class="line"></div>
                                <div class="line"></div>
                            </div>
                        </label>
                    </button>

                </div>
            </div>

        </div>
    </div>
    <input id="boom" type="checkbox">
    <ul class="collapsibleNav">
        <a href="##">
            <li>首页</li>
        </a>
        <a href="##">
            <li>职业</li>
        </a>
        <a href="##">
            <li>推荐</li>
        </a>
        <a href="">
            <li>关于</li>
        </a>
    </ul>
</header>
<%--</body>--%>
