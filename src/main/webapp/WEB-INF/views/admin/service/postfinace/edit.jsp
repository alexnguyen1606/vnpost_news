<%@include file="/common/taglib.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="container-fluid">
    <div class="row">
        <div class="col-sm-12">
            <%--<div class="widget-box">--%>
            <%--<div class="widget-body">--%>
            <%--<div class="widget-main">--%>
            <div class="row">
                <form:form action="/admin/postage-delivery/service/edit"  modelAttribute="service" method="post"  cssClass="form-horizontal"  enctype="multipart/form-data" >
                    <form:input path="id" type="hidden" value="${service.id}" ></form:input>
                    <div class="col-sm-6">
                        <label class=" control-label" for="name">Tên dịch vụ </label>
                        <form:input type="text"  path="name" value="${service.name}" required="required" cssClass="form-control" ></form:input>
                    </div>
                    <div class="col-sm-6">
                        <label class=" control-label " for="shortDescription">Mô tả ngắn</label>
                        <form:input type="text"  path="shortDescription" value="${service.shortDescription}" placeholder="" cssClass="form-control" ></form:input>
                    </div>
                    <div class="col-sm-6">
                        <label class=" control-label " >Ảnh Thumbnail</label>
                        <form:input type="file"  path="multipartFile" accept="image/*" placeholder="" cssClass="form-control" ></form:input>
                    </div>
                    <div class="col-sm-12">
                        <label class=" control-label" >Nội dung </label>
                        <form:textarea type="text"  path="content" value="${service.content}" rows="7" cssClass="form-control" ></form:textarea>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-5">
                            <button type="submit" class="btn btn-sm btn-sucess" style="left:450px;">Submit
                                <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></button>
                        </div>
                    </div>
                </form:form>
            </div>
            <%--</div>--%>
            <%--</div>--%>
            <%--</div>--%>



        </div><!-- /.col -->
    </div><!-- /.row -->
</div>

<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script>
    $(document).ready(function () {
        var editor =  CKEDITOR.replace('content');
        CKFinder.setupCKEditor(editor)
    })
</script>
</body>
</html>
