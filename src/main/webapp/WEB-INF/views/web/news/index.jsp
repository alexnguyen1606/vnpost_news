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
    <title>VN Post| Tin tức</title>

</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="col-md-3">
        <%@include file="/common/web/menu.jsp"%>    
        </div>
        <div class=" col-md-9  news-index-col">
            <div class="container-fluid">
                <div class="col-sm-12 header-category">
                    <ul class="list-unstyled list-inline">
                        <c:forEach items="${category}" var="item">
                            <li class=""><a href="/bai-viet/nhom/${item.id}?page=1&size=8">${item.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>

            </div>
            <div class="container-fluid content-news-group">
                <div class="col-md-6 lastest-news">
                    <div class="container-fulid">
                        <h2><a href="/bai-viet/chi-tiet/${newest.id}">
                            ${newest.name}</a></h2>
                        <div class="  col-img">
                            <img src="<c:url value='/template/images/${newest.thumbnail}'/>" alt="">
                        </div>
                        <div class=" short-content limit-text">
                            <p>${newest.title}</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-3 older-news ">
                    <ul>
                        <c:forEach items="${lastedNews}" var="item">
                            <li><a class=""  href="/bai-viet/chi-tiet/${item.id}">${item.name}</a></li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="col-md-3 most-view-news">
                    <img src="<c:url value='/template/images/${mostViews.thumbnail}'/>" alt="">
                    <h2>
                        <a href="/bai-viet/chi-tiet/${mostViews.id}">
                            ${mostViews.name}</a>
                    </h2>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
