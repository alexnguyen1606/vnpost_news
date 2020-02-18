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
<div class="row main-service-wrapper">
    <div class="container">
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
                                <a href="/bai-viet/chi-tiet/id/${item.id}/key/${item.url}">${item.name}</a>
                            </h2>
                            <img src="/template/images/188241_di-tung-ngo.jpg" alt="">
                        </div>
                        <div class="col-md-12 news-short-content">
                            <label ><fmt:formatDate type = "both"
                                                          dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy hh:mm" value = "${item.createdDate}" />
                            </label>
                            <p>
                                ${item.title}
                            </p>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </div>
</div>
</body>
</html>
