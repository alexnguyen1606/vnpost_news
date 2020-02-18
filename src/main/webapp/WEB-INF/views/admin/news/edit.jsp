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
    <title>Bài viết</title>
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
                <a href="/admin/news"><i class="ace-icon fa fa-angle-double-right"></i>
                    Tòa nhà</a>
            </small>
            <small>
                <a href="/admin/news"><i class="ace-icon fa fa-angle-double-right"></i>
                    EDIT</a>
            </small>
        </h1>
    </div><!-- /.page-header -->
</div>
<div class="row">
    <div class="col-sm-12">
        <form:form action="/admin/news/post"  modelAttribute="newsItem" method="post" cssClass="form-horizontal"  enctype="multipart/form-data" >
        <form:input path="id" type="hidden" ></form:input>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name">Tên bài viết </label>
                <div class="col-sm-9">
                    <form:input type="text" id="name" path="name" value="${newsItem.name}" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name">Title</label>
                <div class="col-sm-9">
                    <form:input type="text" id="name" path="title" value="${newsItem.title}" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="status">Enable/Disable</label>
                <div class="col-sm-3">
                <form:select path="status" cssClass="form-control">
                    <form:option value="1"  >Enable</form:option>
                <form:option value="0">Disable</form:option>
                </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right">Chuyên mục</label>
                <div class="col-sm-3">
                    <form:select path="category" cssClass="form-control">
                        <c:forEach items="${category}" var="item">
                            <form:option value="${item}">${item.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-5">
                    <form:button type="submit" class="btn btn-sm btn-sucess" style="left:450px;">Submit
                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></form:button>
                </div>
            </div>
        </form:form>
    </div><!-- /.col -->
</div><!-- /.row -->
</body>
</html>
