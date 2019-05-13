<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-11
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    * {
        margin: 0;
        padding: 0;
        -webkit-box-sizing: border-box;
        box-sizing: border-box;
    }

    html {
        font-size: 625%;
        line-height: 1;
    }

    body {
        font-size: initial;
        overflow: hidden auto;
    }

    ul {
        list-style: none;
    }

    a {
        text-decoration: none;
    }

    button {
        border: none;
        outline: none;
        background: transparent;
    }

    table {
        table-layout: fixed;
    }

    .container {
        padding: 0 15px;
        margin: 0 auto;
    }

    .row {
        margin: 0 -15px;
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -ms-flex-wrap: wrap;
        flex-wrap: wrap;
    }


    .col-7 {
        width: 35%;
        padding: 0 15px;
    }



    .col-13 {
        width: 65%;
        padding: 0 15px;
    }

    .

    .col-20 {
        width: 100%;
        padding: 0 15px;
    }

    @media screen and (max-width: 576px) {
        .container {
            width: auto;
        }

        .col-7 {
            width: 35%;
            padding: 0 15px;
        }

    }
    .col-13 {
        width: 65%;
        padding: 0 15px;
    }

    .col-20 {
        width: 100%;
        padding: 0 15px;
    }


    @media screen and (min-width: 576px) {
        .container {
            max-width: 540px;
        }

        .col-sm-6 {
            width: 30%;
            padding: 0 15px;
        }

        .col-sm-14 {
            width: 70%;
            padding: 0 15px;
        }

    }

    @media screen and (min-width: 768px) {
        .container {
            max-width: 720px;
        }

        .col-md-4 {
            width: 20%;
            padding: 0 15px;
        }

        .col-md-7 {
            width: 35%;
            padding: 0 15px;
        }

        .col-md-9 {
            width: 45%;
            padding: 0 15px;
        }

    }

    @media screen and (min-width: 992px) {
        .container {
            max-width: 960px;
        }


    }

    @media screen and (min-width: 1200px) {
        .container {
            max-width: 1140px;
        }
    }

    .text-center {
        text-align: center;
    }



    .justify-content-right {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-pack: end;
        -ms-flex-pack: end;
        justify-content: flex-end;
    }



    .align-items-center {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
    }

    @-webkit-keyframes handsome {
        0%,
        27% {
            background-position: 0 0;
        }
        33%,
        60% {
            background-position: -100vw 0;
        }
        66%,
        93% {
            background-position: -200vw 0;
        }
        99%,
        100% {
            background-position: -300vw 0;
        }
    }

    @keyframes handsome {
        0%,
        27% {
            background-position: 0 0;
        }
        33%,
        60% {
            background-position: -100vw 0;
        }
        66%,
        93% {
            background-position: -200vw 0;
        }
        99%,
        100% {
            background-position: -300vw 0;
        }
    }

    @-webkit-keyframes prev {
        100% {
            background-position: 200vw 0;
        }
    }

    @keyframes prev {
        100% {
            background-position: 200vw 0;
        }
    }

    @-webkit-keyframes next {
        100% {
            background-position: -200vw 0;
        }
    }

    @keyframes next {
        100% {
            background-position: -200vw 0;
        }
    }

    @-webkit-keyframes pic1 {
        100% {
            background-position: 0 0;
        }
    }

    @keyframes pic1 {
        100% {
            background-position: 0 0;
        }
    }

    @-webkit-keyframes pic2 {
        100% {
            background-position: -100vw 0;
        }
    }

    @keyframes pic2 {
        100% {
            background-position: -100vw 0;
        }
    }

    @-webkit-keyframes pic3 {
        100% {
            background-position: -200vw 0;
        }
    }

    @keyframes pic3 {
        100% {
            background-position: -200vw 0;
        }
    }



    .carousel-box .pic1, .carousel-box .pic2, .carousel-box .pic3 {
        width: .16rem;
        height: .16rem;
        border-radius: 50%;
        border: 1px solid rgba(255, 255, 255, 0.28);
        margin: 0.22rem .05rem;
    }

    .carousel-box .pic1:hover, .carousel-box .pic2:hover, .carousel-box .pic3:hover {
        background: #fff;
    }

    .carousel-box .pic1:hover ~ .carousel {
        -webkit-animation: pic1 1s forwards;
        animation: pic1 1s forwards;
    }

    .carousel-box .pic2:hover ~ .carousel {
        -webkit-animation: pic2 1s forwards;
        animation: pic2 1s forwards;
    }

    .carousel-box .pic3:hover ~ .carousel {
        -webkit-animation: pic3 1s forwards;
        animation: pic3 1s forwards;
    }

    .carousel-box .carousel {
        position: absolute;
        top: 0;
        left: 0;
        height: 31.2989vw;
        width: 100vw;
        background-size: 400vw 31.2989vw;
        background-position: 0 0;
        z-index: -2;
        -webkit-animation: handsome infinite 15s;
        animation: handsome infinite 15s;
    }

    .carousel-box .prev {
        position: absolute;
        left: 0;
        top: 0;
        width: 15%;
        height: 100%;
        z-index: -1;
    }

    .carousel-box .prev::before {
        content: "";
        position: absolute;
        top: calc(50% - .05rem);
        left: calc(50% - .05rem);
        width: .10rem;
        height: .10rem;
        border: 5px solid rgba(255, 255, 255, 0.28);
        border-right: none;
        border-bottom: none;
        -webkit-transform: rotate(-45deg);
        transform: rotate(-45deg);
    }

    .carousel-box .prev:visited ~ .carousel {
        -webkit-animation: prev 1s;
        animation: prev 1s;
    }

    .carousel-box .next {
        position: absolute;
        top: 0;
        right: 0;
        width: 15%;
        height: 100%;
        z-index: -1;
    }

    .carousel-box .next::after {
        content: "";
        position: absolute;
        top: calc(50% - .05rem);
        right: calc(50% - .05rem);
        width: .1rem;
        height: .1rem;
        border: 5px solid rgba(255, 255, 255, 0.28);
        border-left: none;
        border-bottom: none;
        -webkit-transform: rotate(45deg);
        transform: rotate(45deg);
    }

    .carousel-box .next:visited ~ .carousel {
        -webkit-animation: next 1s;
        animation: next 1s;
    }

    header {
        width: 100%;
        min-height: 1.4rem;
    }

    .header-top {
        min-height: .4rem;
        font-size: .14rem;
    }

    @media screen and (max-width: 576px) {
        .header-top {
            height: .3rem;
        }
    }

    .header-top .customService {
        color: #29B078;
    }

    .header-top .icons {
        width: .25rem;
        height: .24rem;
        margin-left: .16rem;
    }

    @media screen and (max-width: 576px) {
        .header-top .icons {
            margin-left: .1rem;
        }
    }

    .header-bottom {
        min-height: 1rem;
        background: #29b078;
    }

    .header-bottom .tree {
        margin-bottom: 0.04rem;
        font-size: .36rem;
        color: #fff;
    }

    .header-bottom .url {
        font-size: .1rem;
        color: #fff;
    }

    .header-bottom .nav {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        height: 1rem;
        margin-right: -.34rem;
    }

    @media screen and (max-width: 576px) {
        .header-bottom .nav {
            display: none;
        }
    }

    .header-bottom .nav li {
        position: relative;
        width: 1rem;
        height: 1rem;
        color: #fff;
        text-align: center;
        line-height: 1rem;
    }

    .header-bottom .nav li::after {
        display: none;
        content: "";
        position: absolute;
        top: .96rem;
        left: 0;
        width: 1rem;
        height: .04rem;
        background-color: #fff;
    }

    .header-bottom .nav li:hover::after {
        display: block;
    }

    .header-bottom .menu {
        display: none;
        width: 0.4rem;
        height: 0.4rem;
        background-color: transparent;
        border: 0.01rem solid #bec1c4;
        border-radius: 0.03rem;
    }

    .header-bottom .menu:hover {
        background-color: #1a6949;
    }

    @media screen and (max-width: 576px) {
        .header-bottom .menu {
            display: block;
        }
    }

    .header-bottom .menu .line {
        width: 0.25rem;
        height: 0.02rem;
        background-color: #999999;
        margin: 0.085rem auto 0 auto;
    }

    .collapsibleNav {
        height: 0rem;
        width: 100%;
        background-color: #29b078;
        overflow: hidden;
        -webkit-transition: height .5s;
        transition: height .5s;
    }

    @media screen and (min-width: 576px) {
        .collapsibleNav {
            display: none !important;
        }
    }

    .collapsibleNav li {
        height: .5rem;
        text-align: center;
        color: #fff;
        line-height: .5rem;
    }

    .collapsibleNav li:hover {
        background-color: #38c58a;
    }

    #boom {
        display: none;
    }

    #boom:checked ~ .collapsibleNav {
        height: 2rem;
    }

    footer {
        min-height: 2rem;
        width: 100%;
        color: #fff;
        background-color: #26a26f;
    }

    footer a {
        position: relative;
        color: #fff;
        font-size: .14rem;
        line-height: .14rem;
    }

    footer a::before {
        content: "";
        display: none;
        position: absolute;
        left: 0;
        bottom: -.06rem;
        height: .01rem;
        width: 100%;
        background-color: #fff;
    }

    footer a:hover::before {
        display: inherit;
    }

    footer .copyright {
        min-height: .3rem;
        line-height: .3rem;
        font-size: .14rem;
        border-top: 1px solid #32c086;
        word-break: keep-all;
    }

    .footer-left, .footer-middle {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-orient: vertical;
        -webkit-box-direction: normal;
        -ms-flex-direction: column;
        flex-direction: column;
        -webkit-box-pack: justify;
        -ms-flex-pack: justify;
        justify-content: space-between;
        height: 1.7rem;
        padding: .37rem .15rem 0.34rem;
    }

    @media screen and (max-width: 768px) {
        .footer-left, .footer-middle {
            height: 1.3rem;
            padding: .1rem .15rem;
            border-bottom: 1px solid #32c086;
        }
    }

    .footer-right {
        padding: .37rem .15rem 0.18rem;
    }

    @media screen and (max-width: 768px) {
        .footer-right {
            height: 1.4rem;
            padding: .1rem .15rem;
        }
    }

    .footer-right .two {
        margin: .07rem .02rem 0;
    }

    main {
        padding-bottom: 2.4rem;
        background-color: #fafafa;
    }



    .subnav a {
        color: #29B078;
    }



    .diraction li {
        line-height: .14rem;
        text-align: center;
    }

    .diraction a {
        padding: 3px;
        margin-left: 3%;
        color: #333;
    }

    .diraction a:hover {
        color: #fff;
        background-color: #29b078;
    }

    @media screen and (max-width: 768px) {
        .diraction a {
            padding: 0;
            width: 100%;
            height: .5rem;
            margin: 0;
            border-top: 1px solid #edf1f2;
        }
        .diraction a li {
            line-height: .49rem;
        }
    }



    .id-card tr {
        border-bottom: 1px solid #edf1f2;
    }

    .id-card img {
        margin-left: .1rem;
        vertical-align: middle;
    }

    .id-card .no-border {
        border: none;
    }

    .id-card .ios1, .id-card .ios2,
    .id-card .ios3 {
        display: none;
        position: absolute;
        width: 100%;
        height: 100%;
        background: rgba(0, 0, 0, 0.76);
        -webkit-box-shadow: 0px 1px 3px 0px rgba(8, 1, 3, 0.15);
        box-shadow: 0px 1px 3px 0px rgba(8, 1, 3, 0.15);
        border-radius: 3px;
    }

    .id-card .ios1 .ios-title, .id-card .ios2 .ios-title, .id-card .ios3 .ios-title {
        margin: 20% 0 0 calc(50% - .37rem);
        color: #fff;
    }

    .id-card .ios1 .ios-content, .id-card .ios2 .ios-content, .id-card .ios3 .ios-content {
        margin: 8% 9% 0;
        color: #fff;
        line-height: .22rem;
        text-indent: 32px;
    }

    .id-card:hover .ios1, .id-card:hover .ios2,
    .id-card:hover .ios3 {
        display: inherit;
        -webkit-animation: rotatein .7s;
        animation: rotatein .7s;
    }

    .id-card:hover .ios2 {
        -webkit-animation: flip .7s;
        animation: flip .7s;
    }

    .id-card:hover .ios3 {
        -webkit-animation: swing .7s;
        animation: swing .7s;
    }



    .row-one .man {
        -ms-flex-negative: 0;
        flex-shrink: 0;
        width: 1.39rem;
        height: 1.39rem;
        margin: 0 .09rem;
    }

    .row-one .row-one-right {
        margin-right: .1rem;
    }

    .row-one .row-one-right .row-one-title {
        margin-top: .07rem;
        font-weight: bold;
        font-size: .16rem;
    }

    .row-one .row-one-right .it-type-explain {
        margin-top: .07rem;
        font-size: .14rem;
        line-height: .21rem;
        word-break: break-all;
    }

    @media screen and (max-width: 576px) {
        .row-one .row-one-right .it-type-explain {
            margin-top: .05rem;
        }
    }



    .row-four .red-word {
        color: #F01400;
    }

    @-webkit-keyframes rotatein {
        0% {
            opacity: 0;
            -webkit-transform: rotate(-200deg);
        }
        100% {
            opacity: 1;
            -webkit-transform: rotate(0);
        }
    }

    @keyframes rotatein {
        0% {
            opacity: 0;
            -webkit-transform: rotate(-200deg);
        }
        100% {
            opacity: 1;
            -webkit-transform: rotate(0);
        }
    }

    @-webkit-keyframes flip {
        0% {
            -webkit-transform: perspective(400px) rotateX(90deg);
            opacity: 0;
        }
        40% {
            -webkit-transform: perspective(400px) rotateX(-10deg);
        }
        70% {
            -webkit-transform: perspective(400px) rotateX(10deg);
        }
        100% {
            -webkit-transform: perspective(400px) rotateX(0);
            opacity: 1;
        }
    }

    @keyframes flip {
        0% {
            -webkit-transform: perspective(400px) rotateX(90deg);
            opacity: 0;
        }
        40% {
            -webkit-transform: perspective(400px) rotateX(-10deg);
        }
        70% {
            -webkit-transform: perspective(400px) rotateX(10deg);
        }
        100% {
            -webkit-transform: perspective(400px) rotateX(0);
            opacity: 1;
        }
    }

    @-webkit-keyframes swing {
        20% {
            -webkit-transform: rotate(15deg);
        }
        40% {
            -webkit-transform: rotate(-10deg);
        }
        60% {
            -webkit-transform: rotate(5deg);
        }
        80% {
            -webkit-transform: rotate(-5deg);
        }
        100% {
            -webkit-transform: rotate(0);
        }
    }

    @keyframes swing {
        20% {
            -webkit-transform: rotate(15deg);
        }
        40% {
            -webkit-transform: rotate(-10deg);
        }
        60% {
            -webkit-transform: rotate(5deg);
        }
        80% {
            -webkit-transform: rotate(-5deg);
        }
        100% {
            -webkit-transform: rotate(0);
        }
    }
    /*# sourceMappingURL=task14.3.css.map */



</style>
<%--<div style="height: 300px">--%>
    <%--<div style="display: inline-block">--%>
        <%--<img src="http://jns.img.bucket.ks3-cn-beijing.ksyun.com/skill/skill_html/images/login-ad_03.png">--%>
    <%--</div>--%>
    <%--<hi>${msg}</hi>--%>
<%--<form action="/a/login" method="post">--%>
<%--<input type="text" name="username" placeholder="请输入手机号">--%>
    <%--<br>--%>
    <%--<input type="password" name="password" placeholder="请输入登陆密码">--%>
    <%--<input type="submit" value="登陆">--%>
<%--</form>--%>
    <%--<div><a href="/a/register">立即注册</a></div>--%>
<%--</div>--%>

<div style="background-color: #F5F5F5;padding: 100px 0 100px 0;height: 600px;display:flex;justify-content: space-around">
    <div >
        <img src="/static/image/login-ad_03.png">
    </div >
    <div style="background-color: #ffffff;border: 1px solid #999999;width: 400px;height: 350px;display: flex;justify-content: center">

        <form action="/a/login" method="post">
            <h2 style="color: #29b078;margin: 10px 10px;text-align: center">用户登陆</h2>
            <div style="margin-bottom: 20px;margin-top: 20px">
                <input style="height: 50px;width: 250px;font-size: large" type="text" name="username" placeholder="请输入手机号">
            </div>
            <div style="margin-bottom: 20px">
                <input style="height: 50px;width: 250px;font-size: large" type="password" name="password" placeholder="请输入登陆密码">
            </div>
            <div style="margin: 10px 0 0 10px;"><strong>${msg}</strong></div>
            <div style="margin-top: 20px">
                <!--<input  type="submit" value="登陆" style="width: 120px;height: ">-->
                <button style="width: 250px;height: 50px;background-color: #29b078;color: white;font-size: large" type="submit">
                    登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</button>
            </div>
            <div style="margin: 10px 10px 0 180px"><a style="font-size: small;color: #999999" href="/a/register">立即注册</a></div>
        </form>

    </div>
</div>
