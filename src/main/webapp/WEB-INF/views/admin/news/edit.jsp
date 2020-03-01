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
                            <form:form action="/admin/news/edit"  modelAttribute="viewmodel" method="post"  cssClass="form-horizontal"  enctype="multipart/form-data" >
                                <form:input path="id" type="hidden" ></form:input>
                                    <div class="col-sm-6">
                                        <label class=" control-label" for="name">Tên bài viết </label>
                                        <form:input type="text"  path="name" value="${viewmodel.name}" required="required" cssClass="form-control" ></form:input>
                                    </div>
                                    <div class="col-sm-6">
                                        <label class=" control-label " for="title">Title</label>
                                        <form:input type="text"  path="title" value="${viewmodel.title}" placeholder="" cssClass="form-control" ></form:input>
                                    </div>
                                    <div class="col-sm-6">
                                        <label class=" control-label " >Ảnh Thumbnail</label>
                                        <form:input type="file"  path="thumbnailMultipartFile" accept="image/*" placeholder="" cssClass="form-control" ></form:input>
                                    </div>
                                <%--<div class="col-lg-6">--%>
                                    <%--<h3>B. Ckfinder Button</h3>--%>
                                    <%--<div class="avatar">--%>
                                        <%--<img id="imgpreview"--%>
                                             <%--src="https://yt3.ggpht.com/-f6NCDKG2Ukw/AAAAAAAAAAI/AAAAAAAAAAA/MqMm3rgmqCY/s48-c-k-no-mo-rj-c0xffffff/photo.jpg"--%>
                                             <%--class="img-fluid" style="max-width: 300px; max-height: 300px;" />--%>
                                    <%--</div>--%>
                                    <%--<div class="file-field">--%>
                                        <%--<p>--%>
                                            <%--<strong id="xImagePath">Selected Image URL</strong><br /> <form:input path="thumbnail"--%>
                                                <%--class="btn btn-primary btn-sm waves-effect waves-light"--%>
                                                <%--type="button" value="Browse Image"--%>
                                                <%--onclick="BrowseServer( 'Images:/', 'xImagePath' );" ></form:input>--%>
                                        <%--</p>--%>
                                    <%--</div>--%>

                                    <%--<p>Note: You should select square image !</p>--%>
                                <%--</div>--%>
                                    <div class="col-sm-6">
                                        <label class=" control-label" for="title">Tác giả</label>
                                        <form:input type="text"  path="author" value="${viewmodel.author}" placeholder="" cssClass="form-control" ></form:input>
                                    </div>
                                <div class="col-sm-6">
                                    <label class=" control-label ">Chuyên mục</label>
                                    <form:select path="category.id" cssClass="form-control ">
                                        <c:forEach items="${category}" var="item">
                                            <form:option value="${item.id}">${item.name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                </div>
                                    <div class="col-sm-4">
                                        <label class=" control-label" for="status">Enable/Disable</label>
                                        <form:select path="status" cssClass="form-control ">
                                            <form:option value="1"  >Enable</form:option>
                                            <form:option value="0">Disable</form:option>
                                        </form:select>
                                    </div>
                                <div class="col-sm-12">
                                    <label class=" control-label" >Nội dung </label>
                                        <form:textarea type="text"  path="content" value="${viewmodel.content}" rows="7" cssClass="form-control" ></form:textarea>
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
    var editor =CKEDITOR.replace('content',
        {
            filebrowserBrowseUrl : '/ckfinder/ckfinder.html',
            filebrowserImageBrowseUrl : '/ckfinder/ckfinder.html?type=Images',
            filebrowserFlashBrowseUrl : '/ckfinder/ckfinder.html?type=Flash',
            filebrowserUploadUrl : '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Files',
            filebrowserImageUploadUrl : '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Images',
            filebrowserFlashUploadUrl : '/ckfinder/core/connector/java/connector.java?command=QuickUpload&type=Flash'
        });
    CKFinder().setupCKEditor(editor);
})

    /*Avatar start*/
    function BrowseServer(startupPath, functionData) {
        // You can use the "CKFinder" class to render CKFinder in a page:
        var finder = new CKFinder();

        // The path for the installation of CKFinder (default = "/ckfinder/").
        finder.basePath = '../';

        //Startup path in a form: "Type:/path/to/directory/"
        finder.startupPath = startupPath;

        // Name of a function which is called when a file is selected in CKFinder.
        finder.selectActionFunction = SetFileField;

        // Additional data to be passed to the selectActionFunction in a second argument.
        // We'll use this feature to pass the Id of a field that will be updated.
        finder.selectActionData = functionData;

        // Name of a function which is called when a thumbnail is selected in CKFinder. Preview img
        // finder.selectThumbnailActionFunction = ShowThumbnails;

        // Launch CKFinder
        finder.popup();
    }

    // This is a sample function which is called when a file is selected in CKFinder.
    function SetFileField(fileUrl, data) {
        document.getElementById(data["selectActionData"]).innerHTML = this
            .getSelectedFile().name;
        document.getElementById("imgpreview").src = fileUrl;
        $('#thumbnail').val(fileUrl);
    }
    /*Avatar end*/
</script>
</body>
</html>
