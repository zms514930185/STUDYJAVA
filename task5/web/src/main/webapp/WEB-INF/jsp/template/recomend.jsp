<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019-05-03
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<tiles:insertAttribute name="head"/>

<body>
<tiles:insertAttribute name="header"/>


<main>
    <div class="banner"></div>
    <div class="container">
        <div class="subnav">首页><a href="" class="qiye">合作企业</a></div>
        <div class="row">
            <tiles:insertAttribute name="menu"/>
            <tiles:insertAttribute name="body"/>
        </div>
    </div>
</main>



<tiles:insertAttribute name="footer"/>
</body>

</html>




