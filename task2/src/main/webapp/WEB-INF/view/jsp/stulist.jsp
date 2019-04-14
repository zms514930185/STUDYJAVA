<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-04-10
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>StuList</title>
    <style>
        /**{border: 1px solid black}*/
        body{border: 0;background-color: #F5F5F5}
        td div{display: flex;justify-content: space-between}
        .media a{margin-left: 20px;}
        p div{display: inline-block;}
        .button{position: relative;right: -30px}
        button{ box-sizing: border-box;outline: none; }
        tr:nth-child(odd)  td  {
            background-color:#FFFFFF;
        }

        tr:nth-child(even)  td{
            background-color:#DCDCDC;
        }
        tr th{
            background-color: black;color: #FFFFFF;
        }
    </style>
</head>
<body>
<div  style="display: flex">
    <div>
<table  border="1" cellspacing="0">
<tr>
    <th><input type="checkbox" id="all" name="case" ></th>
    <th><fmt:message key="i18n.no"/></th>
    <th><fmt:message key="i18n.name"/></th>
    <th>QQ</th>
    <th><fmt:message key="i18n.job"/></th>
    <th><fmt:message key="i18n.createat"/></th>
    <th><fmt:message key="i18n.updateat"/></th>
    <th><fmt:message key="i18n.dailyurl"/></th>
    <th><fmt:message key="i18n.flag"/></th>
    <th><fmt:message key="i18n.edit"/></th>
    <th><fmt:message key="i18n.delete"/></th>
</tr>
<c:forEach items="${list}" var="l" varStatus="st">
    <tr>
        <td><input type="checkbox" value="${l.id}" name="id"></td>
        <td>${l.id}</td>
        <td>${l.stuName}</td>
        <td>${l.qq}</td>
        <td>${l.job}</td>
        <td><!-- 通过jsp:userBean标签引入java.util.Date日期类 -->
            <jsp:useBean id="create" class="java.util.Date"/>
            <!-- 使用jsp:setProperty标签将时间戳设置到Date的time属性中 -->
            <jsp:setProperty name="create" property="time" value="${l.createAt}"/>
            <!-- 转换格式 -->
            <fmt:formatDate value="${create}" pattern="yyyy-MM-dd HH:mm:ss"/>
                </td>
        <td><!-- 通过jsp:userBean标签引入java.util.Date日期类 -->
            <jsp:useBean id="update" class="java.util.Date"/>
            <!-- 使用jsp:setProperty标签将时间戳设置到Date的time属性中 -->
            <jsp:setProperty name="update" property="time" value="${l.updateAt}"/>
            <!-- 转换格式 -->
            <fmt:formatDate value="${update}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
        <td>${l.dailyUrl}</td>
        <td>${l.flag}</td>
        <td><a href="/edit?id=${l.id}"><fmt:message key="i18n.edit"/></a></td>
        <td><a href="/delete?id=${l.id}"><fmt:message key="i18n.delete"/> </a></td>
    </tr>
</c:forEach>
    <tr>
<td colspan="11" >

    <div class="media" >
        <div>
            <button id="del" disabled="disabled" ><s>批量删除</s></button>
        </div>
        <div>
        <c:choose>
            <c:when test="${page.start!=0}">
                <a href="?start!=0"><fmt:message key="i18n.start"/></a>
            </c:when>
            <c:otherwise>
                <a style="color: grey"><fmt:message key="i18n.start"/></a>
            </c:otherwise>
        </c:choose>

        <c:choose>
            <c:when test="${page.start!=0}">
                <a href="?start=${page.start-page.count}"><fmt:message key="i18n.prevous"/></a>
            </c:when>
            <c:otherwise>
                <a style="color: grey"><fmt:message key="i18n.prevous"/></a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.start+page.count<=page.last}">
                <a href="?start=${page.start+page.count}"><fmt:message key="i18n.next"/></a>
            </c:when>
            <c:otherwise>
                <a style="color: grey"><fmt:message key="i18n.next"/></a>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${page.start+page.count<=page.last}">
                <a href="?start=${page.last}"><fmt:message key="i18n.last"/></a>
            </c:when>
            <c:otherwise>
                <a style="color: grey"><fmt:message key="i18n.last"/></a>
            </c:otherwise>
        </c:choose>
        </div>
    </div>
</td>
    </tr>
</table>
</div>
    <div class="button" style="display: inline-block;">
        <form action="/add" method="post">
            <p><div><fmt:message key="i18n.name"/> </div><input type="text" value="" name="stuName" autocomplete="off"></p>
            <p><div>QQ</div><input type="text" value="" name="qq" autocomplete="off"></p>
            <p><div><fmt:message key="i18n.job"/> </div>
            <input list="source" name="job" autocomplete="off">
            <datalist id="source">
                <option value="ui">ui</option>
                <option value="pm">pm</option>
                <option value="java">java</option>
                <option value="css">css</option>
                <option value="js">js</option>
                <option value="qa">qa</option>
                <option value="op">op</option>
                <option value="动画师">动画师</option>
                <option value="运营">运营</option>
            </datalist>
            </input>
            </p>
            <p><div><fmt:message key="i18n.dailyurl"/> </div><input type="text" value="" name="dailyUrl" autocomplete="off"></p>
            <p><div><fmt:message key="i18n.flag"/> </div><input type="text" value="" name="flag" autocomplete="off"></p>

            <button type="submit" type="submit" style="border-radius: 10px;">提交</button>
        </form>
    </div>
</div>





<script type="text/javascript" src="statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    //全选
    var oall=document.getElementById("all");
    var oid=document.getElementsByName("id");
    oall.onclick=function(){
        for(var i=0;i<oid.length;i++){
            //所有的选择框和全选一致
            oid[i].checked=oall.checked;
        }
    };
    //点击复选框
    for(var i=0;i<oid.length;i++){
        oid[i].onclick=function(){
            //判断是否全部选中,遍历集合
            for(var j=0;j<oid.length;j++){
                if(oid[j].checked==false){
                    oall.checked=false;
                    break;
                }else{
                    oall.checked=true;
                }
            }
        };
    }
    // //点击删除
    // $("#del").click(function(){
    //     var chk_value="";
    //     var n=0;
    //     for(var i=0;i<oid.length;i++){
    //         if(oid[i].checked==true){//选中为true
    //             var id=oid[i].value;
    //             if(n==0){
    //                 chk_value+="chk_value="+id;
    //             }else{
    //                 chk_value+="&chk_value="+id;
    //             }
    //             n++;
    //         }
    //     }
    //     //上面会拼接出一个名为ids的数组ids=1&ids=2&ids=3&ids=4……
    //     $.get("/deleteMany",chk_value,function(data){
    //         if(data=="\"ok\""){
    //             alert("删除成功!");
    //             //删除成功后，调用action方法刷新页面信息
    //             location.href="findAllStandardList.html";
    //         }else{
    //             alert("删除失败!");
    //         }
    //     });
    // });
</script>

</body>
</html>
