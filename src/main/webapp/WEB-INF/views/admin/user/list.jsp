<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="ctag" uri="WEB-INF/customtag/custom.tld" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2019
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="newsURL" value="/admin/news"/>
<html>
<head>
    <title>Danh sách tòa nhà</title>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="/">Home</a>
        </li>
        <li class="active">Dashboard</li>
    </ul><!-- /.breadcrumb -->
</div>
<div class="page-content">
    <%@ include file="/common/admin/ace-setting.jsp"%>
    <div class="page-header">
        <h1>
            Dashboard
            <small>
                <a href="/admin/user"><i class="ace-icon fa fa-angle-double-right"></i>
                    Tài khoản</a>
            </small>
        </h1>
    </div><!-- /.page-header -->

    <div class="row">
        <div class="col-sm-12">
            <div class="pull-right">
                <a href="/admin/user/create" class="btn btn-primary " data-toggle="tooltip" title="Thêm tài khoản"><i class="fa fa-plus"></i></a>
                <button class="btn btn-danger "  id="btnResetUser" data-toggle="tooltip" title="Reset Password"><i class="fa fa-refresh" ></i></button>
                <button class="btn btn-warning "  id="btnDisableUser" data-toggle="tooltip" title="Block tài khoản"><i class="fa fa-lock" ></i></button>
                <button class="btn btn-success "  id="btnEnableUser" data-toggle="tooltip" title="Active Tài khoản"><i class="fa fa-unlock-alt" ></i></button>
                <button class="btn btn-danger "  id="btnDeleteUser" data-toggle="tooltip" title="Xóa tài khoản"><i class="fa fa-trash" ></i></button>
            </div>
        </div>
        <div class="col-sm-12">
            <table class="table table-striped table-hover" id="userList">
                <thead>
                <th></th>
                <th>Họ và tên</th>
                <th>Username</th>
                <th>Trạng thái</th>
                <th>Ngày tạo</th>
                <th>Thao tác</th>
                </thead>
                <tbody id="bodyBuildingList">
                <c:if test="${fn:length(users) >0}">
                    <c:forEach items="${users}" var="item">
                        <tr>
                            <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                            <td>${item.fullName}</td>
                            <td>${item.userName}</td>
                            <td>${item.status == 1 ? "Enable" : "Disable"}  </td>
                            <td><fmt:formatDate type = "both"
                                                dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy" value = "${item.createdDate}" /></td>
                            <td>
                                <a href="/admin/user/edit/${item.id}" class="btn btn-success"  data-toggle="tooltip"
                                   title="Chỉnh sửa tài khoản ">
                                    <i class="fa fa-pencil"></i>
                                </a>
                                <a href="/admin/user/delete/${item.id}" class="btn btn-danger" title="Xóa tài khoản"
                                   data-toggle="tooltip"><i class="fa fa-trash" ></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
            <div class="col-sm-12 col-xs-12">
                <nav aria-label="Page navigation">
                    <ul class="pagination" id="pagination"></ul>
                </nav>
            </div>
        </div>
    </div><!-- /.row -->
</div><!-- /.page-content -->
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript">

    $(function () {
        var totalPages = ${model.totalPages};
        var currentPages = ${model.page};
        var size = ${model.size};
        window.pagObj = $('#pagination').twbsPagination({
            totalPages:totalPages,
            startPage:currentPages,
            visiblePages: 10,
            onPageClick: function (event, page) {
                if (currentPages!=page) {
                    window.location.href="http://localhost:8080/admin/user?page="+page+"&size="+size;
                }
            }
        }).on('page', function (event, page) {
            console.info(page + ' (from event listening)');
        });
    });
</script>
</body>
</html>
