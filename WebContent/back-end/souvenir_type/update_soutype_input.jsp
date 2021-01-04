<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.souvenir_type.model.SouvenirTypeVO"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
	SouvenirTypeVO soutVO = (SouvenirTypeVO) request.getAttribute("soutVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%=soutVO == null%>--${soutVO.sou_type_id}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>特產種類修改 - update_soutype_input.jsp</title>

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
				<h3>特產種類修改 - update_soutype_input.jsp</h3>
				<h4>
					<a href="/CEA101G4/back-end/souvenir_type/select_soutype_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

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
		ACTION="<%=request.getContextPath()%>/souvenir_type/SouvenirTypeServlet"
		name="form1">
		<table>
			<tr>
				<td>特產種類編號:<font color=red><b>*</b></font></td>
				<td><%=soutVO.getSou_type_id()%></td>
			</tr>

			<tr>
				<td>特產種類名稱:</td>
				<td><input type="TEXT" name="sou_type_name" size="45"
					value="<%=soutVO.getSou_type_name()%>" /></td>
			</tr>
			
		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="sou_type_id" value="<%=soutVO.getSou_type_id()%>"> <input
			type="submit" value="送出修改">
	</FORM>
</body>

</html>