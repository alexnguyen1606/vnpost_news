
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/13/2020
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>

<jsp:include page="/common/taglib.jsp"></jsp:include>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="shortcut icon" href="/template/images/vnpost-logo.png" />
    <link rel="stylesheet" type="text/css" href="<c:url value='/template/web/css/custom.css' />">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,400i,500,500i,700&display=swap" rel="stylesheet">
</head>
<body>
<%@include file="/common/web/pre-header.jsp"%>
<%@include file="/common/web/header.jsp"%>
<%@include file="/common/web/main-menu-wapper.jsp"%>

<sitemesh:write property='body'></sitemesh:write>
<%@include file="/common/web/pre-footer.jsp"%>
<%@include file="/common/web/footer.jsp"%>
</body>
</html>
