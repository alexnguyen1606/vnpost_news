
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 11/7/2019
  Time: 9:46 AM
  To change this template use File | Settings | File Templates.
--%>
<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title></title>
    <link rel="shortcut icon" href="/template/images/vnpost-logo-thumbnail.png" />

    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/font-awesome/4.2.0/css/font-awesome.min.css' />" />

    <!-- text fonts -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/fonts/fonts.googleapis.com.css' />" />

    <!-- ace styles -->
    <link rel="stylesheet" href="<c:url value='/template/admin/assets/css/ace.min.css' />" class="ace-main-stylesheet" id="main-ace-style" />

    <!-- ace settings handler -->
    <script src="<c:url value='/template/admin/assets/js/ace-extra.min.js' />"></script>

</head>

<body class="no-skin">
<%@include file="/common/admin/header.jsp" %>
<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>
    <%@include file="/common/admin/menu.jsp" %>
    <div class="main-content">
        <div class="main-content-inner" style="position: absolute;width: 88%">


          <sitemesh:write property='body'></sitemesh:write>
        </div>
    </div>

    <%--<%@ include file="/common/admin/footer.jsp"%>--%>
</div> <!-- main container -->
<%@include file="/common/admin/footer.jsp"%>
<script src="<c:url value='/template/admin/assets/js/jquery.2.1.1.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-extra.min.js'/>"></script>
<script src="<c:url value='/template/admin/assets/js/jquery-ui.custom.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.ui.touch-punch.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.easypiechart.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.sparkline.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.pie.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/jquery.flot.resize.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace-elements.min.js' />"></script>
<script src="<c:url value='/template/admin/assets/js/ace.min.js' />"></script>

<script src="<c:url value='/template/admin/js/category-edit.js'/> "></script>
<script src="<c:url value='/template/admin/js/category-list.js'/> "></script>
<script src="<c:url value='/template/admin/js/news-list.js'/> "></script>
<script src="<c:url value='/template/admin/js/news-edit.js'/> "></script>
<script src="<c:url value='/template/admin/js/user-edit.js'/> "></script>
<script src="<c:url value='/template/admin/js/user-list.js'/> "></script>
<script src="<c:url value='/template/admin/js/upload.js'/> "></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<%--<script src="<c:url value='https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js'/> "></script>--%>

</body>
</html>
