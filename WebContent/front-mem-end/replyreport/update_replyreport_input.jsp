<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.replyreport.model.*"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*,java.text.*"%>

<%
	ReplyReportVO replyReportVO = (ReplyReportVO) request.getAttribute("replyReportVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	System.out.println(replyReportVO);
%>
<%=replyReportVO == null%>--${replyReportVO.reportId}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>員工資料修改 - update_replyreport_input.jsp</title>

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

	<table id="table-1">
		<tr>
			<td>
				<h3>評論資料修改 - update_replyreport_input.jsp</h3>
				<h4>
					<a href="/CEA101G4/replyreport/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>評論資料修改:</h3>

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
		ACTION="<%=request.getContextPath()%>/replyReport/replyReport.do" name="form1">
		<table>
			<tr>
				<td>檢舉編號:<font color=red><b>*</b></font></td>
				<td><%=replyReportVO.getReportId()%></td>
			</tr>
			<tr>
				<td>員工編號:</td>
				<td><input type="TEXT" name="empId" size="45"
					value="<%=replyReportVO.getEmpId()%>" /></td>
			</tr>
			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="memId" size="45"
					value="<%=replyReportVO.getMemId()%>" /></td>
			</tr>
			<tr>
				<td>評論編號:</td>
				<td><input name="replyId" type="TEXT"
					value="<%=replyReportVO.getReplyId()%>" /></td>
			</tr>
			<tr>
				<td>檢舉結果狀態:</td>
				<td><input type="radio" name="reportResult" size="45" value="0" />待處理
					<input type="radio" name="reportResult" size="45" value="1" />已處理同意
					<input type="radio" name="reportResult" size="45" value="2" />已處理不同意</td>
			</tr>


			<!-- 	<JSP:USEBEAN ID="REPLYSVC" SCOPE="PAGE" CLASS="COM.REPLY.MODEL.REPLYSERVICE" /> -->
			<!-- 	<tr> -->
			<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
			<!-- 		<td><select size="1" name="deptno"> -->
			<%-- 			<c:forEach var="deptVO" items="${replySvc.all}"> --%>
			<%-- 				<option value="${replyReportVO.reportId}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
			<%-- 			</c:forEach> --%>
			<!-- 		</select></td> -->
			<!-- 	</tr> -->

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="reportId" value="<%=replyReportVO.getReportId()%>">
		<input type="submit" value="送出修改">
	</FORM>
</body>




</html>