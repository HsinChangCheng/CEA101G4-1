<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<!DOCTYPE html>
<html>
<head>
<link
	href=https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css
	rel="stylesheet" id="bootstrap-css">
<script src="https://kit.fontawesome.com/0316f9a1d0.js"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/front-reply.css">


</head>
<style>
.nav-profile-name {
	font-size: 12px;
}

body {
	margin-top: 0px;
	margin-left: 0px;
}

.nav {
	float: right;
}

ul {
	font-size: 12px;
}
</style>
<body id=body>
	<section id="sidebar">
		<div class="white-label">
			<div class="nav-logo-image">
				<a
					href="<%=request.getContextPath()%>/front-mem-end/front-index.jsp">
					<img src="<%=request.getContextPath()%>/image/LOGO/tiger2.png"
					alt="SuperGoing">
				</a>
			</div>
		</div>
		<div id="sidebar-nav">
			<ul>
				<li class="active"><a
					href="<%=request.getContextPath()%>/front-mem-end/front-index.jsp"><i
						class="fa"></i> 首頁</a></li>
				<li><a
					href="<%=request.getContextPath()%>/front-mem-end/reply/front_select_reply.jsp"><i
						class="fa"></i>評論查詢</a></li>
				<li><a
					href="<%=request.getContextPath()%>/front-mem-end/replyreport/front_select_replyreport.jsp"><i
						class="fa"></i>評論檢舉查詢</a></li>
				<li><a href="#"><i class="fa"></i>會員通知查詢</a></li>
				<li><a href="#"><i class="fa"></i>民宿會員通知查詢</a></li>
				<li><a href="#"><i class="fa"></i>FAQ</a></li>

			</ul>
		</div>
	</section>
	<section id="content">

		<div class="header-nav">

			<div class="nav">
				<ul>
					<li class="nav-settings">
						<div class="font-icon">
							<i class="fa fa-tasks"></i>
						</div>
					</li>
					<li class="nav-mail">
						<div class="font-icon">
							<i class="fa fa-envelope-o"></i>
						</div>
					</li>
					<li class="nav-calendar">
						<div class="font-icon">
							<i class="fa fa-calendar"></i>
						</div>
					</li>
					<li class="nav-chat">
						<div class="font-icon">
							<i class="fa fa-comments-o"></i>
						</div>
					</li>
					<li class="nav-profile">
						<div class="nav-profile-name">
							<a
								href="<%=request.getContextPath()%>/front-mem-end/mem/memLogin.jsp">
								使用者<i class="fa fa-caret-down"></i>
							</a>
						</div>
					</li>
				</ul>
			</div>
		</div>

		<div class="content">
			<div class="content-header">
				<h1>評論資料查詢</h1>
			</div>
			<%@ include file="/front-mem-end/reply/select_page.jsp"%>
		</div>
	</section>
</body>
</html>