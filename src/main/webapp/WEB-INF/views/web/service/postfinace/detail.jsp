<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2/24/2020
  Time: 12:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container main-service-wrapper">
    <div class="row">
        <div class="header-service">
            <h1>${service.name}</h1>
        </div>
        <div class="col-md-12">
        </div>
        <div class="col-md-12 detail-content">
            <p><b>${service.shortDescription}</b></p>
            ${service.content}
        </div>
    </div>
</div>
</body>
</html>
