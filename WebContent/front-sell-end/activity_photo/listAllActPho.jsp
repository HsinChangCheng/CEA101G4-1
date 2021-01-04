<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity_photo.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
ActivityPhotoService actphoSvc = new ActivityPhotoService();
    List<ActivityPhotoVO> list = actphoSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<title>所有活動照片 - listAllActivityPhoto.jsp</title>

<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
}
img.QQ {
height:100px;
width:100px;}
</style>

</head>
<body bgcolor='white'>

	<h4>此頁練習採用 EL 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>所有活動照片 - listAllActivityPhoto.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-sell-end/activity_photo/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">活動照片編號</th>
				<th scope="col">活動編號</th>
				<th scope="col">活動照片</th>
				<th scope="col">活動照片內容</th>
				<th></th>
				<th></th>
				
			</tr>
		</thead>
		<%@ include file="page1.file"%>
		<c:forEach var="actphoVO" items="${list}" begin="<%=pageIndex%>" 
		end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${actphoVO.act_photo_id}</td>
				<td>${actphoVO.act_id}</td>
				<td><img class="QQ" src="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do?act_photo_id=${actphoVO.act_photo_id}&action=getOneActPho"></td>
				<td>${actphoVO.act_photo_content}</td>
			

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="act_photo_id" value="${actphoVO.act_photo_id}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="act_photo_id" value="${actphoVO.act_photo_id}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>