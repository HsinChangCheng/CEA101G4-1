<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.replyreport.model.*"%>

<%
	ReplyReportVO replyReportVO = (ReplyReportVO) request.getAttribute("replyReportVO");
%>
<%-- <%= replyReportVO==null %>--${replyReportVO.deptno}-- --%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>評論留言新增 - addReplyReport.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>

</head>
<body bgcolor='white'>




	<h3>員工資料新增 - addReplyReport.jsp</h3>

	<h4>
		<a
			href="<%=request.getContextPath()%>/front-mem-end/replyreport/front_select_replyreport.jsp"
			class="btn btn-dark"></a>s
	</h4>



	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/replyReport/replyReport.do"
		name="form1">
		<table>
			<!-- 	<tr> -->
			<!-- 	<td>評論編號:</td> -->
			<!-- 		<td><input type="TEXT" name="replyId" size="45"  -->
			<%-- 			 value="<%= (replyReportVO==null)? "RPL000" : replyReportVO.getReplyId()%>" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td>活動期別編號:</td>
				<td><input type="TEXT" name="empId" size="45"
					value="<%=(replyReportVO == null) ? "EMP00" : replyReportVO.getEmpId()%>" /></td>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="memId" size="45"
					value="<%=(replyReportVO == null) ? "MEM00" : replyReportVO.getMemId()%>" /></td>
			</tr>

			<tr>
				<td>評論內容:</td>
				<td><input type="TEXT" name="replyId" size="45"
					value="<%=(replyReportVO == null) ? "RPL00" : replyReportVO.getReplyId()%>" /></td>
			</tr>
			<tr>
				<td>檢舉結果狀態:</td>
				<td><input type="radio" name="reportResult" size="45" value="0" />待處理
					<input type="radio" name="reportResult" size="45" value="1" />已處理同意
					<input type="radio" name="reportResult" size="45" value="2" />已處理不同意
				</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>


</html>