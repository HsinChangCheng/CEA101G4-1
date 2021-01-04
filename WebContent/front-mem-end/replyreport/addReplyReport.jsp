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
<title>���ׯd���s�W - addReplyReport.jsp</title>

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




	<h3>���u��Ʒs�W - addReplyReport.jsp</h3>

	<h4>
		<a
			href="<%=request.getContextPath()%>/front-mem-end/replyreport/front_select_replyreport.jsp"
			class="btn btn-dark"></a>s
	</h4>



	<h3>��Ʒs�W:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
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
			<!-- 	<td>���׽s��:</td> -->
			<!-- 		<td><input type="TEXT" name="replyId" size="45"  -->
			<%-- 			 value="<%= (replyReportVO==null)? "RPL000" : replyReportVO.getReplyId()%>" /></td> --%>
			<!-- 			</tr> -->
			<tr>
				<td>���ʴ��O�s��:</td>
				<td><input type="TEXT" name="empId" size="45"
					value="<%=(replyReportVO == null) ? "EMP00" : replyReportVO.getEmpId()%>" /></td>
			</tr>
			<tr>
				<td>�|���s��:</td>
				<td><input type="TEXT" name="memId" size="45"
					value="<%=(replyReportVO == null) ? "MEM00" : replyReportVO.getMemId()%>" /></td>
			</tr>

			<tr>
				<td>���פ��e:</td>
				<td><input type="TEXT" name="replyId" size="45"
					value="<%=(replyReportVO == null) ? "RPL00" : replyReportVO.getReplyId()%>" /></td>
			</tr>
			<tr>
				<td>���|���G���A:</td>
				<td><input type="radio" name="reportResult" size="45" value="0" />�ݳB�z
					<input type="radio" name="reportResult" size="45" value="1" />�w�B�z�P�N
					<input type="radio" name="reportResult" size="45" value="2" />�w�B�z���P�N
				</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>
</body>


</html>