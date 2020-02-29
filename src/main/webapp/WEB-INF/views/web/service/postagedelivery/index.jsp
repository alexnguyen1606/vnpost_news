<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/24/2020
  Time: 12:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VN Post | Bưu Chính Chuyển Phát</title>
</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <c:forEach items="${postagedelivery}" var="item">
            <div class="col-sm-6 col-xs-12 item-grid">
                <a href="/dich-vu/nhom/buu-chinh-chuyen-phat/${item.id}">
                    <img src="/images/${item.image}" alt="">
                    <h2 >${item.name}</h2>
                </a>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
