<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<div id="sidebar" class="sidebar responsive">
    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
    </script>

    <div class="sidebar-shortcuts" id="sidebar-shortcuts">
        <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
            <button class="btn btn-success">
                <i class="ace-icon fa fa-signal"></i>
            </button>

            <button class="btn btn-info">
                <i class="ace-icon fa fa-pencil"></i>
            </button>

            <button class="btn btn-warning">
                <i class="ace-icon fa fa-users"></i>
            </button>

            <button class="btn btn-danger">
                <i class="ace-icon fa fa-cogs"></i>
            </button>
        </div>

        <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
            <span class="btn btn-success"></span>

            <span class="btn btn-info"></span>

            <span class="btn btn-warning"></span>

            <span class="btn btn-danger"></span>
        </div>
    </div><!-- /.sidebar-shortcuts -->

    <ul class="nav nav-list">
        <li class="active">
            <a href="/admin">
                <i class="menu-icon fa fa-tachometer"></i>
                <span class="menu-text"> Dashboard </span>
            </a>

            <b class="arrow"></b>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa fa-newspaper-o"></i>
                <span class="menu-text">
								Bài viết
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="/admin/news" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách bài viết
                    </a>
                </li>
                <li class="">
                    <a href="/admin/news/create" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm bài viết
                    </a>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa  fa-list-alt"></i>
                <span class="menu-text">
								Chuyên mục
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="/admin/category" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách chuyên mục
                    </a>
                </li>
                <li class="">
                    <a href="/admin/category/create" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm chuyên mục
                    </a>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa  fa-list-alt"></i>
                <span class="menu-text">
                    Bưu chính chuyển phát
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="/admin/postage-delivery" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách
                    </a>
                </li>
                <li class="">
                    <a href="/admin/postage-delivery/service" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Dịch vụ
                    </a>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa  fa-list-alt"></i>
                <span class="menu-text">
								Tài chính bưu chính
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="/admin/category" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách dịch vụ
                    </a>
                </li>
            </ul>
        </li>
        <li class="">
            <a href="#" class="dropdown-toggle">
                <i class="menu-icon fa  fa-list-alt"></i>
                <span class="menu-text">
								Phân phối truyền thông
							</span>

                <b class="arrow fa fa-angle-down"></b>
            </a>

            <b class="arrow"></b>

            <ul class="submenu">
                <li class="">
                    <a href="/admin/category" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Danh sách dịch vụ
                    </a>
                </li>
                <li class="">
                    <a href="/admin/category/create" >
                        <i class="menu-icon fa fa-caret-right"></i>
                        Thêm chuyên mục
                    </a>
                </li>
            </ul>
        </li>
            <li class="">
                <a href="#" class="dropdown-toggle">
                    <i class="menu-icon fa fa-users"></i>
                    <span class="menu-text">
								Quản lý tài khoản
							</span>

                    <b class="arrow fa fa-angle-down"></b>
                </a>

                <b class="arrow"></b>

                <ul class="submenu">
                    <li class="">
                        <a href="/admin/user" >
                            <i class="menu-icon fa fa-caret-right"></i>
                            Danh sách tài khoản
                        </a>
                    </li>
                    <li class="">
                        <a href="/admin/user/create" >
                            <i class="menu-icon fa fa-caret-right"></i>
                            Thêm tài khoản
                        </a>
                    </li>
                </ul>
            </li>
    </ul><!-- /.nav-list -->

    <div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
        <i class="ace-icon fa fa-angle-double-left" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
    </div>

    <script type="text/javascript">
        try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
    </script>
</div>