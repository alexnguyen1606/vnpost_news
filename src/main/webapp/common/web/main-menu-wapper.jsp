<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<div class="row main-menu-wapper">
    <div class="container main-menu">
        <%--<div class="tracking-block">--%>
            <%--<label class="quick-access-label collapsed  " role="button" data-togle="collapse"--%>
                   <%--href="#collapseExample" aria-expanded="false" aria-controls="collapseExample">--%>
                <%--<span class="quick-access-caption">Tra cứu - Định vị</span>--%>
                <%--<span class="carpet"></span>--%>
            <%--</label>--%>
            <%--<div class="row collapse" id="collapseExample">--%>
                <%--<ul class="quick-tool-menu">--%>
                    <%--<li class="tracking-item first-item">--%>
                        <%--<a href="">--%>
                            <%--<i class="fa fa-map-marker"></i>--%>
                            <%--Định vị bưu gửi--%>
                        <%--</a>--%>
                        <%--<div class="input-group">--%>

                        <%--</div>--%>
                    <%--</li>--%>
                    <%--<li></li>--%>
                <%--</ul>--%>
            <%--</div>--%>
        <%--</div>--%>

        <nav class="navbar ">
            <div class="container-fluid ">
                <ul class="nav navbar-nav ">
                    <li class=""><a href="#">Bưu Chính Chuyển phát</a></li>
                    <li><a href="#">Tài chính bưu chính</a></li>
                    <li><a href="#">Phân phối-Truyền thông</a></li>
                    <li><a href="/tin-tuc">Tin tức</a></li>
                    <li><a href="">EMAIL</a></li>
                    <%--<c:forEach items="${menu-wapper}" var="item">--%>
                        <%--<li><a href="${item.key}">${item.value}</a></li>--%>
                    <%--</c:forEach>--%>
                </ul>
            </div>
        </nav>
    </div>
</div>