<%@include file="/common/taglib.jsp" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/8/2019
  Time: 1:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Chuyên mục</title>
</head>
<body>
<div class="breadcrumbs" id="breadcrumbs">
    <script type="text/javascript">
        try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
    </script>

    <ul class="breadcrumb">
        <li>
            <i class="ace-icon fa fa-home home-icon"></i>
            <a href="/admin">Home</a>
        </li>
        <li class="active">Dashboard</li>
    </ul><!-- /.breadcrumb -->
</div>
<div class="page-content">
    <%@include file="/common/admin/ace-setting.jsp"%>
    <div class="page-header">
        <h1>
            Dashboard
            <small>
                <a href="/admin/user"><i class="ace-icon fa fa-angle-double-right"></i>
                    Tài khoản</a>
            </small>
            <small>
                <a href="/admin/user"><i class="ace-icon fa fa-angle-double-right"></i>
                    EDIT</a>
            </small>
        </h1>
    </div><!-- /.page-header -->
</div>
<div class="row">
    <div class="col-sm-12">
        <%--<form:form action="/admin/user/edit" method="post" modelAttribute="viewmodel" class="form-horizontal" role="form" >--%>
            <%--<form:input type="hidden" path="id" value="${viewmodel.id}"></form:input>--%>
            <%--<form:input type="hidden" path="password" value="${viewmodel.password}"></form:input>--%>
            <%--<div class="form-group">--%>
                <%--<label class="col-sm-3 control-label no-padding-right" for="fullName">Họ tên </label>--%>

                <%--<div class="col-sm-9">--%>
                    <%--<form:input type="text" path="fullName"  value="${viewmodel.fullName}" placeholder="" class="col-xs-10 col-sm-5" />--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="col-sm-3 control-label no-padding-right" for="userName">Username </label>--%>

                <%--<div class="col-sm-9">--%>
                    <%--<form:input type="text"  path="userName" value="${viewmodel.userName}" required="required"  placeholder="" class="col-xs-10 col-sm-5" />--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="col-sm-3 control-label no-padding-right" for="status">Status</label>--%>

                <%--<div class="col-sm-9">--%>
                    <%--<form:select class="col-sm-4" path="status">--%>
                        <%--<form:option value="1"  class="col-xs-10 col-sm-5">Enable</form:option>--%>
                        <%--<form:option value="0"  class="col-xs-10 col-sm-5">disable</form:option>--%>
                    <%--</form:select>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label class="col-sm-3 control-label no-padding-right" >Quyền tài khoản</label>--%>
                <%--<div class="col-sm-9">--%>
                    <%--<c:forEach items="${roles}" var="item">--%>
                        <%--<label class="checkbox-inline">--%>
                            <%--<form:checkbox path="listRole"  value="${item.code}"></form:checkbox>--%>
                                <%--${item.name}</label>--%>
                    <%--</c:forEach>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<div class="col-sm-5">--%>
                    <%--<button type="button" class="btn btn-sm btn-success " id="btnAddUser" style="left:450px;">--%>
                        <%--Submit--%>
                        <%--<i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>--%>
                    <%--</button>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</form:form>--%>
            <form class="form-horizontal" role="form" id="formEdit">
                <input type="hidden" id="id" name="id" value="${viewmodel.id}">
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="fullName">Họ tên </label>

                    <div class="col-sm-9">
                        <input type="text" id="fullName" name="fullName" value="${viewmodel.fullName}" placeholder="" class="col-xs-10 col-sm-5" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="userName">Username </label>

                    <div class="col-sm-9">
                        <input type="text" id="userName" name="userName" value="${viewmodel.userName}" required="required"  placeholder="" class="col-xs-10 col-sm-5" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="status">Status</label>

                    <div class="col-sm-9">
                        <select class="col-sm-4" name="status" id="status">
                            <option value="1" ${viewmodel.status==1 ? "selected":""} class="col-xs-10 col-sm-5">Enable</option>
                            <option value="0" ${viewmodel.status == 0 ? "selected":""} class="col-xs-10 col-sm-5">disable</option>
                        </select>
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" >Quyền tài khoản</label>
                    <div class="col-sm-9">
                        <c:forEach items="${roles}" var="item">
                            <label class="checkbox-inline"><input type="checkbox"
                                ${fn:contains(user.roles,item )? "checked":""}     name="listRole"  value="${item.code}">${item.name}</label>
                        </c:forEach>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-5">
                        <button type="button" class="btn btn-sm btn-success " id="btnAddUser" style="left:450px;">
                            Submit
                            <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                        </button>
                    </div>
                </div>
            </form>
    </div><!-- /.col -->
</div><!-- /.row -->
</body>
</html>
