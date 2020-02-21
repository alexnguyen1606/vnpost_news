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
        <form class="form-horizontal" role="form" id="formEdit">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="image">Ảnh 1 </label>

                <div class="col-sm-9">
                    <input type="file" id="image" name="image" value=""  placeholder="Chọn ảnh" accept="image/x-png,image/gif,image/jpeg" class="col-xs-10 col-sm-5" />
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-5">
                    <button type="button" class="btn btn-sm btn-success " id="btnUpload" style="left:450px;">
                        Submit
                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                    </button>
                </div>
            </div>
        </form>
    </div><!-- /.col -->
</div><!-- /.row -->
<script>

</script>
</body>
</html>
