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
    <title>Title</title>
</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="header-service">
            <h1>Phân Phối - Truyền Thông</h1>
        </div>
        <c:forEach items="${services}" var="item">
            <div class="col-sm-4 col-xs-12 item-grid">
                <a href="/dich-vu/buu-chinh-chuyen-phat/chi-tiet/${item.id}">
                    <img src="/images/${item.image}" alt="">
                    <h2>${item.name}</h2>
                    <p class="limit-text-2">${item.shortDescription}</p>
                </a>
            </div>
        </c:forEach>
        <div class="col-md-12 col-sm-12 col-xs-12 ">
            <nav aria-label="Page navigation">
                <ul class="pagination" id="pagination"></ul>
            </nav>
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
