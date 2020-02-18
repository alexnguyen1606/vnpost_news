<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<div class="left-pan">
    <h2 class="hidden-xs">Chuyên Mục</h2>
    <div class="content-col">
        <ul>
            <c:if test="${fn:length(category)>0}">
                <c:forEach items="${category}" var="item">
                    <li><a href="/bai-viet/nhom/id/${item.id}/key/${item.url}">
                        <div class="clearfix">
                            <div class="col-left col-sm-10 col-xs-10">
                                <label>${item.name}</label>
                            </div>
                        </div>
                    </a>
                    </li>
                </c:forEach>
            </c:if>
        </ul>
        <div class="hotline-box">
            <label>Đường dây nóng</label>
            <h2>1900 54 54 81</h2>
        </div>
    </div>
</div>