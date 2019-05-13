<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-02
  Time: 22:30
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
    <%--<link rel="stylesheet" href="/view/css/task14.1/task14.1.css">--%>
<%--</head>--%>

<%--<body>--%>

<main>
    <!--轮播图-->
    <ul class="carousel-box">
        <a class="prev" href="#"></a>
        <a class="next" href="#"></a>
        <li class="pic1"></li>
        <li class="pic2"></li>
        <li class="pic3"></li>
        <div class="carousel"></div>
    </ul>

    <!--为什么选择这里-->
    <div class="container why">
        <div class="row">
            <div class="col-md-5 col-sm-10 col-20 rocket">
                <img src="/view/image/task14.1/rocket.png">
                <div class="why-word1">高效</div>
                <div class="why-word2">将五到七年的成长时间，缩短到一年到三年。
                </div>
            </div>
            <div class="col-md-5 col-sm-10 col-20 archive">
                <img src="/view/image/task14.1/archive.png">
                <div class="why-word1">规范</div>
                <div class="why-word2">标准的实战教程，不会走弯路。
                </div>
            </div>
            <div class="col-md-5 col-sm-10 col-20 shape">
                <img src="/view/image/task14.1/shape.png">
                <div class="why-word1">人脉</div>
                <div class="why-word2">同班好友，同院学长，技术大师，入学就混入职脉圈，为以后铺平道路。
                </div>
            </div>
            <div class="col-md-5 col-sm-10 col-20 user">
                <div class="user-part">
                    <img class="person" src="/view/image/task14.1/user.png">
                    <div class="why-word1">12400</div>
                    <div class="why-word2">累计在线学习人数</div>
                </div>
                <div class="user-part">
                    <img class="person" src="/view/image/task14.1/user.png">
                    <div class="why-word1">12400</div>
                    <div class="why-word2">学员已经找到满意工作</div>
                </div>
            </div>
        </div>
    </div>

    <!--如何学习-->
    <div class="container how">
        <div class="how-title">如何学习</div>
        <div class="row">
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">1</div>
                <div class="number-word">匹配你现在的个人情况寻找合适自己的岗位</div>
                <div class="arrow"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">2</div>
                <div class="number-word">了解职业前景薪金待遇、竞争压力等</div>
                <div class="arrow2"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">3</div>
                <div class="number-word">掌握行业内顶级技能</div>
                <div class="arrow"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">4</div>
                <div class="number-word2">查看职业目标任务</div>
                <div class="arrow3"></div>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">5</div>
                <div class="number-word">参考学习资源，掌握技能点，逐个完成任务</div>
                <div class="arrow"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">6</div>
                <div class="number-word">加入班级，和小伙伴们互帮互助，一块学习</div>
                <div class="arrow2"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">7</div>
                <div class="number-word">选择导师，一路引导，加速自己成长</div>
                <div class="arrow"></div>
            </div>
            <div class="col-lg-5 col-md-10 col-20 how-content">
                <div class="number">8</div>
                <div class="number-word2">完成职业技能，升级业界大牛</div>
                <div class="arrow3"></div>

            </div>
        </div>
    </div>

    <!--优秀学员展示-->
    <div class="container show">
        <div class="show-title">优秀学员展示</div>
        <div class="row">

            <c:forEach items="${list}" var="l" begin="1" end="4">
                <div class="col-lg-5 col-md-10 col-20">
                    <div class="show-content">
                        <img src="${l.image}">
                        <div class="who-show">${l.job}：${l.name}</div>
                        <div class="show-word">
                                ${l.company}${l.work}：${l.introduction}
                        </div>
                    </div>
                </div>
            </c:forEach>


            <%--<div class="col-lg-5 col-md-10 col-20">--%>
                <%--<div class="show-content">--%>
                    <%--<img src="${list.get(0).image}">--%>
                    <%--<div class="who-show">${list.get(0).job}：${list.get(0).name}</div>--%>
                    <%--<div class="show-word">--%>
                        <%--${list.get(0).company}${list.get(0).work}：${list.get(0).introduction}--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="col-lg-5 col-md-10 col-20">--%>
                <%--<div class="show-content">--%>
                    <%--<img src="${list.get(1).image}">--%>
                    <%--<div class="who-show">${list.get(1).job}：${list.get(1).name}</div>--%>
                    <%--<div class="show-word">--%>
                        <%--${list.get(1).company}${list.get(1).work}：${list.get(1).introduction}--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="col-lg-5 col-md-10 col-20">--%>
                <%--<div class="show-content">--%>
                    <%--<img src="${list.get(2).image}">--%>
                    <%--<div class="who-show">${list.get(2).job}：${list.get(2).name}</div>--%>
                    <%--<div class="show-word">--%>
                        <%--${list.get(2).company}${list.get(2).work}：${list.get(2).introduction}--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="col-lg-5 col-md-10 col-20">--%>
                <%--<div class="show-content">--%>
                    <%--<img src="${list.get(3).image}">--%>
                    <%--<div class="who-show">${list.get(3).job}：${list.get(3).name}</div>--%>
                    <%--<div class="show-word">--%>
                        <%--${list.get(3).company}${list.get(3).work}：${list.get(3).introduction}--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        </div>
        <ul>
            <li></li>
            <li></li>
            <li></li>
            <li></li>
        </ul>
    </div>

    <!--战略合作企业-->
    <div class="container partners">
        <div class="partners-title">战略合作企业</div>
        <div class="partner-box">
            <div class="partner">
                <img src="/view/image/task14.1/goldcloud.png">
            </div>
            <div class="partner">
                <img src="/view/image/task14.1/yuntong.png">
            </div>
            <div class="partner">
                <img src="/view/image/task14.1/alibaba.png">
            </div>
            <div class="partner">
                <img src="/view/image/task14.1/sevencow.png">
            </div>
            <div class="partner">
                <img src="/view/image/task14.1/beliebe.png">
            </div>
        </div>
    </div>

    <!--友情链接-->
    <div class="friendlink">
        <div class="container">
            <div class="friendlink-title">友情链接</div>
            <div class="row">
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
            </div>
            <div class="row">
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>教师招聘
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>手机软件
                    </a>
                </div>
                <div class="col-lg-2  col-sm-4 col-10 link">
                    <a href="">
                        <div class="link-circle"></div>找工作&emsp;
                    </a>
                </div>
            </div>
        </div>
    </div>
</main>

<%--</body>--%>

<%--</html>--%>