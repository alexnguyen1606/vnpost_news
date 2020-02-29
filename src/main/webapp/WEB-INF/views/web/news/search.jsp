<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/20/2020
  Time: 3:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="col-md-12 black-header">
            <h1>Tìm kiếm</h1>
        </div>
        <div class="col-md-12 col-sm-12">
            <div class="search-box">
                <div class="input-group">
                        <input class="search-input" id="searchInput" value="${key}">
                        <span class="input-group-btn">
                    <button class="btn btn-primary" type="button" onclick="clickSearch()" style="height: 36px"><i class="fa fa-search"></i></button>
                    </span>
                </div>
            </div>
            <div class="search-result">
            <h2>Kết quả tìm kiếm</h2>
                <c:forEach items="${news}" var="item">
                    <div class="form-group">
                        <h4><a href="/bai-viet/chi-tiet/${item.id}">${item.name}</a></h4>
                        <br>
                        <span>${item.title}</span>
                    </div>
                </c:forEach>
            </div>
            <%--<div class="col-md-12 col-sm-12 col-xs-12 ">--%>
                <%--<nav aria-label="Page navigation">--%>
                    <%--<ul class="pagination" id="pagination"></ul>--%>
                <%--</nav>--%>
            <%--</div>--%>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script >
    <%--var totalPages = ${model.totalPages};--%>
    <%--var currentPages =${model.page};--%>
    <%--var size = ${model.size};--%>
    <%--var key = ${key};--%>
    <%--$(function () {--%>
        <%--window.pagObj = $('#pagination').twbsPagination({--%>
            <%--// totalPages: totalPages,--%>
            <%--visiblePages: 10,--%>
            <%--startPage:currentPages,--%>
            <%--onPageClick: function (event, page) {--%>
                <%--if (currentPages!=page){--%>
                    <%--window.location.href="http://localhost:8080/tin-tuc/tim-kiem?key="+key;--%>
                <%--}--%>
            <%--}--%>
        <%--}).on('page', function (event, page) {--%>
            <%--console.info(page + ' (from event listening)');--%>
        <%--});--%>
    <%--});--%>
    var onEnter = document.getElementById("searchInput");
    onEnter.addEventListener("keyup",function (ev) {
        if (ev.keyCode ===13){
            ev.preventDefault();
            clickSearch();
        }
    });
</script>
</body>
</html>
