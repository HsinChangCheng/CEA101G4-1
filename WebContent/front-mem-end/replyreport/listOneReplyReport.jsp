<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.replyreport.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	ReplyReportVO replyReportVO = (ReplyReportVO) request.getAttribute("replyReportVO");
	//EmpServlet.java(Concroller), 存入req的replyReportVO物件
%>

<html>
<head>
<title>評論資料 - listOneReplyReport.jsp</title>

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
				<h3>評論編號資料 - ListOneReplyReport.jsp</h3>
				<h4>
					<a href="/CEA101G4/replyreport/select_page.jsp"><img
						src="images/灰底的老虎.png" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>評論檢舉編號</th>
			<th>員工編號</th>
			<th>評論編號</th>
			<th>會員編號</th>
			<th>評論檢舉結果</th>

		</tr>
		<tr>
			<%-- 			<td><%=replyReportVO.getReplyId()%></td> --%>

			<td>${replyReportVO.reportId}</td>
			<td>${replyReportVO.empId}</td>
			<td>${replyReportVO.replyId}</td>
			<td>${replyReportVO.memId}</td>
			<td>${replyReportVO.reportResult}</td>
		</tr>
	</table>

</body>
</html>