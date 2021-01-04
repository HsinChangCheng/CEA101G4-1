<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.memberrecord.model.*"%>

<%
	MemRecordVO memRecordVO = (MemRecordVO) request.getAttribute("memRecordVO");
%>
<%-- <%= memRecordVO==null %>--${memRecordVO.deptno}-- --%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>���ׯd���s�W - addMemberRecord.jsp</title>

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
				<h3>���u��Ʒs�W - addMemberRecord.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="/CEA101G4/front-mem-end/memberrecord/select_page.jsp"><img
						src="images/tomcat.png" width="100" height="100" border="0"><br>�^����</a>
				</h4>
			</td>
		</tr>
	</table>

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
		ACTION="<%=request.getContextPath()%>/memberRecord/memberRecord.do"
		name="form1">
		<table>
			<tr>
				<td>�|���s��:</td>
				<td><input type="TEXT" name="memId" size="45"
					value="<%=(memRecordVO == null) ? "MEM00" : memRecordVO.getMemId()%>" /></td>
			</tr>
			<tr>
				<td>�|���q�����e:</td>
				<td><input type="TEXT" name="memRecordContent" size="45"
					value="<%=(memRecordVO == null) ? "" : memRecordVO.getMemRecordContent()%>" /></td>
			</tr>
			<tr>
				<td>���ʵ��ת��A:</td>
				<td><input type="radio" name="memRecordRead" size="45" value="0" />��Ū
					<input type="radio" name="memRecordRead" size="45" value="1" />�wŪ
					</td>
			</tr>

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W">
	</FORM>
</body>



<!-- =========================================�H�U�� datetimepicker �������]�w========================================== -->


</html>