<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
    .col-sm-6.col-xs-12.col-right{
        margin-top: -20px;
    }
</style>
<div class="row main-service-wrapper">
    <div class="container">

    <!-- <h1 class="form-heading">login Form</h1> -->
    <div class="col-md-6 col-xs-12 login-form">
        <div class="main-div">
            <c:if test="${param.incorrectAccount != null}">
                <div class="alert alert-danger">
                    Username or password incorrect
                </div>
            </c:if>
            <c:if test="${param.accessDenied != null}">
                <div class="alert alert-danger">
                    you Not authorize
                </div>
            </c:if>
            <form action="j_spring_security_check" id="formLogin" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" id="userName" name="j_username" placeholder="Tên đăng nhập">
                </div>

                <div class="form-group">
                    <input type="password" class="form-control" id="password" name="j_password" placeholder="Mật khẩu">
                </div>
                <button type="submit" class="btn btn-primary" >Đăng nhập</button>
            </form>
        </div>
    </div>
</div>
</div>