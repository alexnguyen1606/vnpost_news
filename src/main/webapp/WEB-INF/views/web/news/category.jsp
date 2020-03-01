<%@ page import="com.vnpost.dto.NewsDTO" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/15/2020
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VN Post|Bài Viết</title>

</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="col-md-3">
            <%@include file="/common/web/menu.jsp"%>
        </div>
        <div class=" col-md-9  news-index-col">
            <div class="col-md-12 black-header">
                <h1>Tin Tức</h1>
            </div>
            <div class="col-md-12 list-news">

                <c:forEach var="item" items="${news}">
                    <div class="col-md-6 news-item">
                        <div class="col-md-12 ">
                            <h2 class="">
                                <a href="/bai-viet/chi-tiet/${item.id}">${item.name}</a>
                            </h2>
                        </div>
                        <div class="col-md-6">
                            <img src="/images/${item.thumbnail}" alt="">
                            <%--<img src="${item.thumbnail}" alt="">--%>
                        </div>
                        <div class="col-md-6 news-short-content">
                            <label ><fmt:formatDate type = "both"
                                                          dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy hh:mm" value = "${item.createdDate}" />
                            </label>
                            <p class="limit-text">
                                ${item.title}
                            </p>
                        </div>
                    </div>
                </c:forEach>
                <div class="col-md-12 col-sm-12 col-xs-12 ">
                    <nav aria-label="Page navigation">
                        <ul class="pagination" id="pagination"></ul>
                    </nav>
                </div>
            </div>
        </div>
    </div>

</div>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script >

    var totalPages = ${model.totalPages};
    var currentPages =${model.page};
    var size = ${model.size};
    var id = ${model.id};
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
            startPage:currentPages,
            onPageClick: function (event, page) {
                if (currentPages!=page){
                    window.location.href="http://localhost:8080/bai-viet/nhom/"+id+"?page="+page+"&size="+size;
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>
