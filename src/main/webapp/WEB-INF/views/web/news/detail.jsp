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
<div class="row main-service-wrapper">
    <div class="container">
        <div class="col-md-3">
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
                                <img src="${paragraph.image}" alt="">
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
        </div>
    </div>
</div>
</body>
</html>
