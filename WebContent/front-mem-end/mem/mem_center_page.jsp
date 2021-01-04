<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>
<%MemberVO memVO = (MemberVO) session.getAttribute("memVO");  %>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="https://kit.fontawesome.com/0316f9a1d0.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/front-mem-end/mem_center_page.css">
<title>Super Going</title>
</head>
<body>
<section id="sidebar">
        <div id="sidebar-nav">
            <ul>
                <li class="active"></li>
                <li><a href="#"><i class="fa fa-receipt"></i> 活動</a></li>
                <li><a href="#"><i class="fa fa-receipt"></i> 房間</a></li>
                <li><a href="#"><i class="fa fa-receipt"></i> 特產</a></li>
                <li><a href="#"><i class="fa fa-bookmark"></i> 收藏清單</a></li>
                <li><a href="${pageContext.request.contextPath}/front-mem-end/mem/listOneMem.jsp"><i class="fa fa-users"></i> 個人資料</a></li>
                <li><a href="#"><i class="fa fa-comment-dots"></i> 聯絡客服</a></li>
                <li><a href=" <%=request.getContextPath()%>/member/member.do?action=log_out"><i class="fa fa-receipt"></i>登出</a></li>
            </ul>
        </div>
    </section>
    
        <div id="header">
            <div class="white-label">
                <div class="nav-logo-image">
                    <a
						href="<%=request.getContextPath()%>/front-mem-end/front-index.jsp">
						<img src="<%=request.getContextPath()%>/image/LOGO/tiger2.png" alt="SuperGoing"></a>
                </div>
            </div>
            <div class="header-nav">

               <div class="nav">
                    <ul>
                        <li class="nav-settings">
                            <div class="font-icon"><i class="fa fa-tasks"></i></div>
                        </li>
                        <li class="nav-mail">
                            <div class="font-icon"><i class="fa fa-envelope-o"></i></div>
                        </li>
                        <li class="nav-calendar">
                            <div class="font-icon"><i class="fa fa-calendar"></i></div>
                        </li>
                        <li class="nav-chat">
                            <div class="font-icon"><i class="fa fa-comments-o"></i></div>
                        </li>
                        <li class="nav-profile">
                            <div class="nav-profile-image">
                                <div class="nav-profile-name"><%=memVO.getMem_name() %><i class="fa fa-caret-down"></i></div>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
        

</body>
</html>