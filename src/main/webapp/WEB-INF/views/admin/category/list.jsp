<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2019
  Time: 9:52 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:url var="newsURL" value="/"/>
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
                <a href="${buildingURL}?action=LIST"><i class="ace-icon fa fa-angle-double-right"></i>
                    Tòa nhà</a>
            </small>
        </h1>
    </div><!-- /.page-header -->

    <div class="row">

        <div class="col-sm-12">
            <div class="pull-right">
                <a href="/admin/category/edit" class="btn btn-primary " data-toggle="tooltip" title="Thêm chuyện mục"><i class="fa fa-plus"></i></a>
                <button class="btn btn-danger "  id="btnDeleteBuilding" data-toggle="tooltip" title="Xóa chuyên mục"><i class="fa fa-trash" ></i></button>
                <%--<button class="btn btn-danger "  id="btnDisableNews" data-toggle="tooltip" title="Ẩn bài viết"><i class="fa fa-lock-alt" ></i></button>--%>
                <%--<button class="btn btn-danger "  id="btnEnableNews" data-toggle="t ooltip" title="Hiển thị bài viết"><i class="fa fa-unlock-alt" ></i></button>--%>
            </div>
        </div>
        <div class="col-sm-12">
            <table class="table table-striped table-hover" id="buildingList">
                <thead>
                <th></th>
                <th>Tên chuyên mục</th>
                <th>key</th>
                <th>Ngày tạo</th>
                <th>Thao tác</th>
                </thead>
                <tbody id="bodyBuildingList">
                <c:if test="${fn:length(category) >0}">
                    <c:forEach items="${category}" var="item">
                        <tr>
                            <td><input type="checkbox" value="${item.id}" id="checkbox_${item.id}"></td>
                            <td>${item.name}</td>
                            <td>${item.url}</td>
                            <td><fmt:formatDate type = "both"
                                                dateStyle = "short" timeStyle = "short" pattern="dd-M-yyyy" value = "${item.createdDate}" /></td>
                            <td>
                                <a href="/admin/category/edit/${item.id}" class="btn btn-success"  data-toggle="tooltip"
                                   title="Chỉnh sửa tòa nhà ">
                                    <i class="fa fa-pencil"></i>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </c:if>
                </tbody>
            </table>
        </div>
    </div><!-- /.row -->
</div><!-- /.page-content -->
<div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Danh sách nhân viên</h4>
            </div>
            <div class="modal-body">
                <table class="table table-hover" id="staffList">
                    <thead>
                    <tr>
                        <th>Check</th>
                        <th>Tên nhân viên</th>
                    </tr>
                    </thead>
                </table>
                <input type="hidden" id="buildingId" name="buildingId" value="">
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-success" id="btnAssignBuilding">Giao tòa nhà</button>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</body>
</html>
