<%@ page import="com.vnpost.utils.SecurityUtils" %><%--<%@ page import="com.laptrinhjavaweb.util.SecurityUtils" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/common/taglib.jsp"></jsp:include>

<div id="navbar" class="navbar navbar-default" style="max-height: 45px">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
            <span class="sr-only">Toggle sidebar</span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>

            <span class="icon-bar"></span>
        </button>

        <div class="navbar-header pull-left">
            <a href="/admin/home" class="navbar-brand">
                <small>
                    <i class="fa fa-leaf"></i>
                    Ace Admin
                </small>
            </a>
        </div>

        <div class="navbar-buttons navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">



                <ul class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
                    <li class="dropdown-header">
                        <i class="ace-icon fa fa-check"></i>
                        4 Tasks to complete
                    </li>

                    <li class="dropdown-content">
                        <ul class="dropdown-menu dropdown-navbar">
                            <li>
                                <a href="#">
                                    <div class="clearfix">
                                        <span class="pull-left">Software Update</span>
                                        <span class="pull-right">65%</span>
                                    </div>

                                    <div class="progress progress-mini">
                                        <div style="width:65%" class="progress-bar"></div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="clearfix">
                                        <span class="pull-left">Hardware Upgrade</span>
                                        <span class="pull-right">35%</span>
                                    </div>

                                    <div class="progress progress-mini">
                                        <div style="width:35%" class="progress-bar progress-bar-danger"></div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="clearfix">
                                        <span class="pull-left">Unit Testing</span>
                                        <span class="pull-right">15%</span>
                                    </div>

                                    <div class="progress progress-mini">
                                        <div style="width:15%" class="progress-bar progress-bar-warning"></div>
                                    </div>
                                </a>
                            </li>

                            <li>
                                <a href="#">
                                    <div class="clearfix">
                                        <span class="pull-left">Bug Fixes</span>
                                        <span class="pull-right">90%</span>
                                    </div>

                                    <div class="progress progress-mini progress-striped active">
                                        <div style="width:90%" class="progress-bar progress-bar-success"></div>
                                    </div>
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="dropdown-footer">
                        <a href="#">
                            See tasks with details
                            <i class="ace-icon fa fa-arrow-right"></i>
                        </a>
                    </li>
                </ul>
                </li>





                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="/template/admin/assets/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
									<small>Welcome,</small>
									<%=SecurityUtils.getPrincipal().getFullName()%>
								</span>

                        <i class="ace-icon fa fa-caret-down"></i>
                    </a>

                    <ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="ace-icon fa fa-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="profile.html">
                                <i class="ace-icon fa fa-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="/logout">
                                <i class="ace-icon fa fa-power-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </div><!-- /.navbar-container -->
</div>