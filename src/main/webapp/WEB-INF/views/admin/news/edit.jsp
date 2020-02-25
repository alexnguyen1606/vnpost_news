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
<div class="row">
    <div class="col-sm-12">
        <form:form action="/admin/news/edit"  modelAttribute="viewmodel" method="post"  cssClass="form-horizontal"  enctype="multipart/form-data" >
        <form:input path="id" type="hidden" ></form:input>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="name">Tên bài viết </label>
                <div class="col-sm-9">
                    <form:input type="text"  path="name" value="${viewmodel.name}" required="required" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="title">Title</label>
                <div class="col-sm-9">
                    <form:input type="text"  path="title" value="${viewmodel.title}" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" >Ảnh Thumbnail</label>
                <div class="col-sm-9">
                    <form:input type="file"  path="thumbnailMultipartFile" accept="image/*" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="title">Tác giả</label>
                <div class="col-sm-9">
                    <form:input type="text"  path="author" value="${viewmodel.author}" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="status">Enable/Disable</label>
                <div class="col-sm-4">
                <form:select path="status" cssClass="form-control ">
                    <form:option value="1"  >Enable</form:option>
                    <form:option value="0">Disable</form:option>
                </form:select>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right">Chuyên mục</label>
                <div class="col-sm-4">
                    <form:select path="category.id" cssClass="form-control ">
                        <c:forEach items="${category}" var="item">
                            <form:option value="${item.id}">${item.name}</form:option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <form:input path="paragraph1.id" value="${viewmodel.paragraph1.id}" type="hidden" ></form:input>
            <form:input path="paragraph2.id" value="${viewmodel.paragraph2.id}" type="hidden" ></form:input>
            <form:input path="paragraph3.id" value="${viewmodel.paragraph3.id}" type="hidden" ></form:input>
            <form:input path="paragraph1.image" value="${viewmodel.paragraph1.image}" type="hidden" ></form:input>
            <form:input path="paragraph2.image" value="${viewmodel.paragraph1.image}" type="hidden" ></form:input>
            <form:input path="paragraph3.image" value="${viewmodel.paragraph1.image}" type="hidden" ></form:input>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" >Ảnh Đoạn 1</label>
                <div class="col-sm-9">
                    <form:input type="file"  path="paragraph1.multipartFile" accept="image/*" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" >Mô tả ảnh</label>
                <div class="col-sm-9">
                    <form:input type="text"  path="paragraph1.titleImage" value="${viewmodel.paragraph1.titleImage}"  cssClass="col-xs-10 col-sm-5" ></form:input>
                </div>
            </div>
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" >Nội dung đoạn 1</label>
                <div class="col-sm-9">
                    <form:textarea type="text"  path="paragraph1.content" value="${viewmodel.paragraph1.content}" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:textarea>
                </div>
            </div>
            <div class="modal fade" id="myModal" role="dialog">
                <div class="modal-dialog">
                    <!-- Modal content-->
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal">&times;</button>
                            <h4 class="modal-title">Thêm nội dung</h4>
                        </div>
                        <div class="modal-body">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Ảnh Đoạn 2</label>
                                <div class="col-sm-9">
                                    <form:input type="file"  path="paragraph2.multipartFile" accept="image/*" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Mô tả ảnh</label>
                                <div class="col-sm-9">
                                    <form:input type="text"  path="paragraph2.titleImage"  cssClass="col-xs-10 col-sm-5" ></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Nội dung đoạn 2</label>
                                <div class="col-sm-9">
                                    <form:textarea type="text"  path="paragraph2.content"  placeholder="" cssClass="col-xs-10 col-sm-5" ></form:textarea>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Ảnh Đoạn 3</label>
                                <div class="col-sm-9">
                                    <form:input type="file"  path="paragraph3.multipartFile" accept="image/*" placeholder="" cssClass="col-xs-10 col-sm-5" ></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Mô tả ảnh</label>
                                <div class="col-sm-9">
                                    <form:input type="text"  path="paragraph3.titleImage" value="${viewmodel.paragraph3.titleImage}" cssClass="col-xs-10 col-sm-5" ></form:input>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" >Nội dung đoạn 3</label>
                                <div class="col-sm-9">
                                    <form:textarea type="text"  path="paragraph3.content"  value="${viewmodel.paragraph3.content}" cssClass="col-xs-10 col-sm-5" ></form:textarea>
                                </div>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                        </div>
                    </div>

                </div>
            </div>
            <button type="button" onclick="openModalParapraph()" class="btn btn-sm btn-sucess" style="left: 340px" data-toggle="tooltip">Thêm nội dung
                <i class="ace-icon fa fa-bars icon-on-right bigger-110"></i></button>
            <div class="form-group">
                <div class="col-sm-5">
                    <button type="submit" class="btn btn-sm btn-sucess" style="left:450px;">Submit
                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i></button>
                </div>
            </div>
        </form:form>

    </div><!-- /.col -->
</div><!-- /.row -->

</body>
</html>
