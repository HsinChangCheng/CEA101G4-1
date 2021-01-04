<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.replyreport.model.*"%>

<%
	ReplyReportService replyReportSvc = new ReplyReportService();
	List<ReplyReportVO> list = replyReportSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>�Ҧ��������|��� - listAllReplyReport.jsp</title>
</head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>Document</title>
<style>
h4 {
	color: blue;
	display: inline;
}

table {
	width: 60%;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

#tbody:hover {
	background-color: white;
}

/* table, th, td { */
/* 	border: 1px solid #CCCCFF; */
/* } */
th, td {
	padding: 5px;
	text-align: center;
}

#page {
	text-align: center;
}

h2 {
	text-align: center;
}
</style>

<body bgcolor='white'>


	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>���|�s��</th>
				<th>���u�s��</th>
				<th>���׽s��</th>
				<th>�|�����e</th>
				<th>���|���G���A</th>
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%@ include file="page1.file"%>
			<c:forEach var="replyReportVO" items="${list}" begin="<%=pageIndex%>"
				end="<%=pageIndex+rowsPerPage-1%>">
		</thead>
		<tbody id=tbody>
			<tr>
				<td>${replyReportVO.reportId}</td>
				<td>${replyReportVO.empId}</td>
				<td>${replyReportVO.replyId}</td>
				<td>${replyReportVO.memId}</td>
				<td>${replyReportVO.reportResult}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/replyReport/replyReport.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�ק�" class="btn btn-info"> <input
							type="hidden" name="reportId" value="${replyReportVO.reportId}">
						<input type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/replyReport/replyReport.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="�R��" class="btn btn-danger"> <input
							type="hidden" name="reportId" value="${replyReportVO.reportId}">
						<input type="hidden" name="action" value="delete">
					</FORM>
				</td>
				</c:forEach>
			</tr>
		</tbody>
	</table>
	<section id=page>
		<%@ include file="page2.file"%>
		<br>
		<h2>
			<a
				href="<%=request.getContextPath()%>/front-mem-end/replyreport/front_select_replyreport.jsp"
				class="btn btn-dark">�^����</a>
		</h2>
	</section>
</body>
</html>