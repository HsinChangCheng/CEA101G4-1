<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.*"%>
<%@ page import="com.sell.model.*"%>

<jsp:useBean id="sellSvc" scope="page" class="com.sell.model.SellService" />

<html>
<head>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
<title>所有民宿會員資料 - listAllSellRoom.jsp</title>
<style>


</style>
</head>
<body>
<h5>所有民宿會員資料 - listAllSellRoom.jsp</h5>
<div class="container" id="titleAndError">
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
</div>
<div class="container-fluied">
<table class="table table-striped table-hover align-middle" id="tableRoomList">
	<thead class=".thead-dark">
		<tr>
			<th>民宿會員編號</th>
			<th>民宿會員帳號</th>
			<th>民宿會員密碼</th>
			<th>民宿會員姓名</th>
			<th>民宿會員生日</th>
			<th>民宿會員電話</th>
			<th>民宿會員性別</th>
			<th>民宿會員信箱</th>
			<th>民宿會員身分證</th>
			<th>民宿名稱</th>
			<th>民宿地址</th>
			<th>民宿經度</th>
			<th>民宿緯度</th>
			<th>帳號狀態</th>
			<th>申請加入時間</th>
		</tr>
	</thead>
	<tbody>
	<c:forEach var="sellVO" items="${sellSvc.all}" >
		<tr>
			<td>${sellVO.sellMemId}</td>
			<td>${sellVO.sellMemAccount}</td>
			<td>${sellVO.sellMemPwd}</td>
			<td>${sellVO.sellMemName}</td>
			<td>${sellVO.sellMemBirth}</td>
			<td>${sellVO.sellMemTel}</td>
			<td>${sellVO.sellGender}</td>
			<td>${sellVO.sellMemMail}</td>
			<td>${sellVO.sellMemIdNumber}</td>
			<td>${sellVO.sellRoomName}</td>
			<td>${sellVO.sellMemAddress}</td>
			<td>${sellVO.sellLatitude}</td>
			<td>${sellVO.sellLongitud}</td>
			<td>${sellVO.sellAccStatus}</td>
			<fmt:formatDate value="${sellVO.sellJointime}" var="time" type="both" pattern="yyyy-MM-dd HH:mm:ss" />
			<td>${time}</td>
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<%-- <%@ include file="page2.file" %> --%>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

    
</body>
</html>