<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/15/2020
  Time: 10:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>VN Post| ${newsItem.name}</title>

</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="col-md-3 hidden-xs">
            <%@include file="/common/web/menu.jsp"%>
        </div>
        <div class=" col-md-9  news-index-col">
            <div class="news-detail">
                <%--<c:forEach items="${newsItem}" var="item">--%>
                    <h1>${newsItem.name}</h1>
                    <label class="news-date"><fmt:formatDate type = "both"
                                                             dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy hh:mm" value = "${newsItem.createdDate}" />
                    </label>
                    <p>
                       ${newsItem.title}
                    </p>
                    <c:if test="${fn:length(newsItem.listParagraph)>0}">
                        <c:forEach items="${newsItem.listParagraph}" var="paragraph">
                            <div class="img-content">
                                <div style="width: 500px">
                                    <img src="<c:url value='/template/images/${paragraph.image}'/>"  alt="">
                                </div>
                                <p class="img-title">${paragraph.titleImage}</p>
                                <p>${paragraph.content}</p>
                            </div>
                        </c:forEach>
                    </c:if>
                    <div class="col-sm-12">
                        <label class="view">
                            <i class="fa fa-eye"></i>Lượt xem: ${newsItem.count}
                        </label>
                        <label  class="author">${newsItem.author}</label>
                    </div>
                <%--</c:forEach>--%>
            </div>
            <div class="col-sm-12 news-footer">
                <div class="header-news-footer">
                    <h2>Các tin khác</h2>
                </div>
                <div class="body-news-footer">
                    <ul>
                        <c:forEach items="${news}" var="item">
                            <li><a href="/bai-viet/chi-tiet/${item.id}">${item.name}</a>
                                <label class="news-date" style="margin-left: 20px;"><fmt:formatDate type = "both"
                                    dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy hh:mm" value = "${item.createdDate}" />
                                </label></li>
                        </c:forEach>

                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
