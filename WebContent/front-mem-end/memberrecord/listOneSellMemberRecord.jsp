<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.sellermemberrecord.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	SellMemRecordVO sellMemRecordVO = (SellMemRecordVO) request.getAttribute("sellMemRecordVO");
%>

<html>
<head>
<title>評論資料 - listOneMemberRecord.jsp</title>

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
	width: 600px;
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
</style>

</head>
<body bgcolor='white'>

	<h4>此頁暫練習採用 Script 的寫法取值:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>評論編號資料 - ListOneSellMemberRecord.jsp</h3>
				<h4>
					<a href="/CEA101G4/front-sell-end/sellmemberrecord/select_page.jsp"><img
						src="images/灰底的老虎.png" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>會員通知編號</th>
			<th>會員編號</th>
			<th>會員通知內容</th>
			<th>會員通知時間</th>
			<th>通知讀取狀態</th>

		</tr>
		<tr>

			<td>${sellMemRecordVO.sellMemRecordId}</td>
			<td>${sellMemRecordVO.sellMemId}</td>
			<td>${sellMemRecordVO.sellMemRecordContent}</td>
			<td><fmt:formatDate value="${sellMemRecordVO.sellMemRecordTime}"
					type="both" /></td>
			<td>${sellMemRecordVO.sellMemRecordRead}</td>
		</tr>
	</table>

</body>
</html>