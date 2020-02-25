<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div class="container-fluid pre-header">
    <div class="row">
        <div class="col-sm-12 col-right ">
            <div class="col-sm-4 col-xs-12 pull-left hotline-header col-left">
                <i class="fa fa-phone" ></i>
                <span class="hotline-caption">Đường dây nóng hỗ trợ</span>&nbsp;
                <span class="hotline-number">1900 54 54 81</span>
            </div>
            <div class="col-sm-8 col-xs-12 pull-right col-right ">
                <ul class="list-unstyled list-inline" style="float: right;">
                    <li><a href="">Giới thiệu</a></li>
                    <li><a href="">Hỏi đáp</a></li>
                    <li><a href="">Liên hệ</a></li>
                    <li><a type="#" id="subcrib" onclick="openModalSubcrib()">Đăng ký</a></li>
                    <li><a href="/login">Login</a></li>
                    <li>
                        <div class="language-object">
                                <span title="Tiếng việt ( Việt Nam )">
                                    <a href="#"><img src="/template/images/vi-VN.gif" alt=""></a>
                                </span>
                                <span title="English ( US )">
                                    <a href="#"><img src="/template/images/en-US.gif" alt=""></a>
                                </span>
                        </div>
                    </li>
                    <li>
                            <span class="search-icon">
                                <i class="fa fa-search" ></i>
                                <%--<form method="get" action="/tin-tuc/tim-kiem">--%>
                                    <input placeholder="Tìm kiếm" name="search" id="search" type="text" class="search-form-index">
                                <%--</form>--%>

                            </span>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModalSubcrib" role="dialog">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Thêm nội dung</h4>
            </div>
            <div class="modal-body">
                <form role="form" name="formSubcrib" id="formSubcrib" class="form-horizontal">
                    <input type="hidden"  name="id" value="">
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name">Email </label>

                        <div class="col-sm-9">
                            <input type="text" id="email" name="email" value="" placeholder="" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-3 control-label no-padding-right" for="name">Tên người đăng ký </label>

                        <div class="col-sm-9">
                            <input type="text" id="name" name="name" value="" placeholder="" class="col-xs-10 col-sm-5" />
                        </div>
                    </div>
                </form>
            <div class="modal-footer">
                <div class="col-sm-5">
                    <button type="button" class="btn btn-sm btn-success " id="btnAddSubcrib" style="left:450px;">
                        Đăng ký
                        <i class="ace-icon fa fa-arrow-right icon-on-right bigger-110"></i>
                    </button>
                </div>
                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
            </div>
        </div>

    </div>
</div>
</div>