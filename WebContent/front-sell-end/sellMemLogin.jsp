<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<html>
<head>
    <meta charset="UTF-8">
    <title>民宿會員登入 / 註冊</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front-sell-end/front-sell-sellMemLogin.css">
</head>

<body>
    <!-- partial:index.partial.html -->
    <div class="login-page">
    <input type="hidden" name="contextPath" value="<%=request.getContextPath()%>">
        <div class="form">
            <form class="register-form" method="POST" action="<%=request.getContextPath()%>/sell/sell.do">
                <input type="text" name="sellMemAccount" placeholder="username" />
                <input type="password" placeholder="password" />
                <input type="text" placeholder="email address" />
                <button type="button">create</button>
                <p class="message">Already registered? <a href="#">Sign In</a></p>
            </form>
            
            <form class="login-form" method="POST" action="<%=request.getContextPath()%>/sell/sell.do">
                <input type="text" placeholder="username" name="sellMemAccount" />
                <input type="password" placeholder="password" name="sellMemPwd" />
                <input type="hidden" name="action" value="sellMemLogin" />
                <button type="submit">login</button>
                <p class="message">Not registered? <a href="#">Create an account</a></p>
            </form>
        </div>
    </div>
    <!-- partial -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
    <script src="<%=request.getContextPath() %>/js/front-sell-end/front-sell-sellMemLogin.js"></script>
</body>

</html>