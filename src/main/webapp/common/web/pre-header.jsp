<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
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
                    <li><a href="">Liên hệ</a></li>
                    <li><a href="">Hỏi đáp</a></li>
                    <li><a href="">Liên hệ</a></li>
                    <li><a type="#" id="subcrib" onclick="openModalSubcrib()">Đăng ký</a></li>
                    <li><a href="/admin">Quản trị</a></li>
                    <li>
                        <div class="language-object">
                                <span title="Tiếng việt ( Việt Nam )">
                                    <a href="?lang=vi"><img src="/template/images/vi-VN.gif" alt=""></a>
                                </span>
                                <span title="English ( US )">
                                    <a href="?lang=en"><img src="/template/images/en-US.gif" alt=""></a>
                                </span>
                        </div>
                    </li>
                    <li>
                            <span class="search-icon">
                                <i class="fa fa-search" ></i>
                                    <input placeholder="Tìm kiếm" name="search" id="searchInput2" type="text" class="search-form-index">
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
                <h4 class="modal-title">Đăng ký</h4>
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
<%--<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>--%>
<script>
    var onEnter = document.getElementById("searchInput2");
    onEnter.addEventListener("keyup",function (ev) {
        if (ev.keyCode ===13){
            ev.preventDefault();
            clickSearch2();
        }
    });
    // $( "#searchInput2" ).autocomplete({
    //     source: "/api/web/news/search"
    //
    // });
</script>