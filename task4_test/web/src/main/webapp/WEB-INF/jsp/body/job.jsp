<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-04
  Time: 22:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<main>
    <div class="container">
        <div class="subnav">首页><a href="#">职业</a></div>
        <ul class="diraction">
            方向：
            <a href="">
                <li>全部</li>
            </a>
            <a href="#web">
                <li>前端方向</li>
            </a>
            <a href="#java">
                <li>后端方向</li>
            </a>
            <a href="#qa">
                <li>用户体验方向</li>
            </a>
            <a href="#ui">
                <li>运维方向</li>
            </a>
        </ul>
    </div>
    <!--前端开发-->
    <div class="container">
        <div class="it-style" id="web">前端开发方向</div>
        <div class="row">
            <c:forEach items="${front}" var="f">
            <div class="col col-md-10 col-20">
                <table class="id-card">
                    <!--ios工程师-->
                    <tr>
                        <td colspan="2">
                            <div class="ios1">
                                <div class="ios-title">
                                    ${f.job}工程师
                                </div>
                                <div class="ios-content">${f.introduction}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第一行-->
                    <tr>
                        <td colspan="2">
                            <div class="row-one">
                                <div class="man"></div>
                                <div class="row-one-right">
                                    <div class="row-one-title">${f.job}工程师</div>
                                    <div class="it-type-explain">
                                        ${f.description}
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">门槛</span>
                            <c:forEach begin="1" end="${f.threshold}">
                                <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">难易程度</span>
                            <c:forEach begin="1" end="${f.difficult}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">成长周期</span><span class="red-word">&emsp;${f.growth}</span>年
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">稀缺程度</span><span class="red-word">&emsp;${f.demands}</span>家公司需要
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr class="no-border">
                        <td colspan="2">
                            <table class="son-table">
                                <tr>
                                    <td rowspan="3" class="row-three-left">
                                        <span class="gray-word">薪资待遇</span>
                                    </td>
                                    <td class="row-three-right">
                                        <div>0-1年</div>
                                        <div>${f.payone}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>1-3年</div>
                                        <div>${f.paysec}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>3-5年</div>
                                        <div>${f.paythr}/月</div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td colspan="2" class="row-four">
                            有<span class="red-word">${f.job}</span>人正在学
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td colspan="2" class="row-two-right">
                            <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                        </td>
                    </tr>
                </table>
            </div>
            </c:forEach>
        </div>
    </div>
    <!--后端开发-->
    <div class="container">
        <div class="it-style" id="java">后端开发方向</div>
        <div class="row">
            <c:forEach items="${behind}" var="b">
            <div class="col col-md-10 col-20">
                <table class="id-card">
                    <!--ios工程师-->
                    <tr>
                        <td colspan="2">
                            <div class="ios1">
                                <div class="ios-title">
                                    ${b.job}工程师
                                </div>
                                <div class="ios-content">${b.introduction}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第一行-->
                    <tr>
                        <td colspan="2">
                            <div class="row-one">
                                <div class="man"></div>
                                <div class="row-one-right">
                                    <div class="row-one-title">${b.job}工程师</div>
                                    <div class="it-type-explain">
                                        ${b.description}
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">门槛</span>
                            <c:forEach begin="1" end="${b.threshold}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">难易程度</span>
                            <c:forEach begin="1" end="${b.difficult}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">成长周期</span><span class="red-word">&emsp;${b.growth}</span>年
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">稀缺程度</span><span class="red-word">&emsp;${b.demands}</span>家公司需要
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr class="no-border">
                        <td colspan="2">
                            <table class="son-table">
                                <tr>
                                    <td rowspan="3" class="row-three-left">
                                        <span class="gray-word">薪资待遇</span>
                                    </td>
                                    <td class="row-three-right">
                                        <div>0-1年</div>
                                        <div>${b.payone}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>1-3年</div>
                                        <div>${b.paysec}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>3-5年</div>
                                        <div>${b.paythr}/月</div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td colspan="2" class="row-four">
                            有<span class="red-word">286</span>人正在学
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td colspan="2" class="row-two-right">
                            <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                        </td>
                    </tr>
                </table>
            </div>
            </c:forEach>
        </div>
    </div>
    <!--用户体验-->
    <div class="container">
        <div class="it-style" id="qa">用户体验方向</div>
        <div class="row">
            <c:forEach items="${user}" var="u">
            <div class="col col-md-10 col-20">
                <table class="id-card">
                    <!--ios工程师-->
                    <tr>
                        <td colspan="2">
                            <div class="ios3">
                                <div class="ios-title">
                                    ${u.job}
                                </div>
                                <div class="ios-content">${u.introduction}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第一行-->
                    <tr>
                        <td colspan="2">
                            <div class="row-one">
                                <div class="man"></div>
                                <div class="row-one-right">
                                    <div class="row-one-title">${u.job}</div>
                                    <div class="it-type-explain">
                                            ${u.description}
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">门槛</span>
                            <c:forEach begin="1" end="${u.threshold}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">难易程度</span>
                            <c:forEach begin="1" end="${u.difficult}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">成长周期</span><span class="red-word">&emsp;${u.growth}</span>年
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">稀缺程度</span><span class="red-word">&emsp;${u.demands}</span>家公司需要
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr class="no-border">
                        <td colspan="2">
                            <table class="son-table">
                                <tr>
                                    <td rowspan="3" class="row-three-left">
                                        <span class="gray-word">薪资待遇</span>
                                    </td>
                                    <td class="row-three-right">
                                        <div>0-1年</div>
                                        <div>${u.payone}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>1-3年</div>
                                        <div>${u.paysec}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>3-5年</div>
                                        <div>${u.paythr}/月</div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td colspan="2" class="row-four">
                            有<span class="red-word">286</span>人正在学
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td colspan="2" class="row-two-right">
                            <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                        </td>
                    </tr>
                </table>
            </div>
            </c:forEach>
        </div>
    </div>
    <!--运维-->
    <div class="container">
        <div class="it-style" id="ui">运维方向</div>
        <div class="row">
            <c:forEach items="${maintain}" var="m">
            <div class="col col-md-10 col-20">
                <table class="id-card">
                    <!--ios工程师-->
                    <tr>
                        <td colspan="2">
                            <div class="ios1">
                                <div class="ios-title">
                                    ${m.job}
                                </div>
                                <div class="ios-content">${m.introduction}
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第一行-->
                    <tr>
                        <td colspan="2">
                            <div class="row-one">
                                <div class="man"></div>
                                <div class="row-one-right">
                                    <div class="row-one-title">${m.job}</div>
                                    <div class="it-type-explain">
                                        ${m.description}
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                    <!--第二行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">门槛</span>
                            <c:forEach begin="1" end="${m.threshold}">
                            <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">难易程度</span>
                            <c:forEach begin="1" end="${m.difficult}">
                                <img src="view/image/task14.3/star.png">
                            </c:forEach>
                        </td>
                    </tr>
                    <!--第三行-->
                    <tr>
                        <td class="row-two-left">
                            <span class="gray-word">成长周期</span><span class="red-word">&emsp;${m.growth}</span>年
                        </td>
                        <td class="row-two-right">
                            <span class="gray-word">稀缺程度</span><span class="red-word">&emsp;${m.demands}</span>家公司需要
                        </td>
                    </tr>
                    <!--第四行-->
                    <tr class="no-border">
                        <td colspan="2">
                            <table class="son-table">
                                <tr>
                                    <td rowspan="3" class="row-three-left">
                                        <span class="gray-word">薪资待遇</span>
                                    </td>
                                    <td class="row-three-right">
                                        <div>0-1年</div>
                                        <div>${m.payone}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>1-3年</div>
                                        <div>${m.paysec}/月</div>
                                    </td>
                                </tr>
                                <tr>
                                    <td class="row-three-right">
                                        <div>3-5年</div>
                                        <div>${m.paythr}/月</div>
                                    </td>
                                </tr>
                            </table>
                        </td>
                    </tr>
                    <!--第五行-->
                    <tr>
                        <td colspan="2" class="row-four">
                            有<span class="red-word">286</span>人正在学
                        </td>
                    </tr>
                    <!--第六行-->
                    <tr>
                        <td colspan="2" class="row-two-right">
                            <div class="gray-word">提示:在你学习之前你应该已经掌握XXXXX、XXXXX、XX等语言基础</div>
                        </td>
                    </tr>
                </table>
            </div>
            </c:forEach>
        </div>
    </div>
</main>