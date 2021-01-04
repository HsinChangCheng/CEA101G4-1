<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.sellermemberrecord.model.*"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*,java.text.*"%>

<%
	SellMemRecordVO sellMemRecordVO = (SellMemRecordVO) request.getAttribute("sellMemRecordVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
	System.out.println(sellMemRecordVO);
%>
<%=sellMemRecordVO == null%>--${sellMemRecordVO.sellMemRecordId}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>員工資料修改 - update_sellMemberrecord_input.jsp</title>

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
				<h3>評論資料修改 - update_reply_input.jsp</h3>
				<h4>
					<a href="/CEA101G4/front-sellMeml-end/sellmemberrecord/select_page.jsp"><img
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
		ACTION="<%=request.getContextPath()%>/sellMemberRecord/sellMemberRecord.do"
		name="form1">
		<table>
			<tr>
				<td>評論編號:<font color=red><b>*</b></font></td>
				<td><%=sellMemRecordVO.getSellMemRecordId()%></td>
			</tr>
			</tr>			<tr>
				<td>會員編號:</td>
				<td><input type="TEXT" name="sellMemId" size="45"
					value="<%=sellMemRecordVO.getSellMemId()%>" /></td>
			</tr>
			</tr>
			<tr>
				<td>會員通知內容:</td>
				<td><input type="TEXT" name="sellMemRecordContent" size="45"
					value="<%=(sellMemRecordVO == null) ? "" : sellMemRecordVO.getSellMemRecordContent()%>" /></td>
			</tr>
			<tr>
				<td>活動評論時間:</td>
				<td><input name="sellMemRecordTime" type="TEXT"
					value="<%SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			out.print(ft.format(sellMemRecordVO.getSellMemRecordTime()));%>" /></td>
			</tr>
			<tr>
				<td>活動評論狀態:</td>
				<td><input type="radio" name="sellMemRecordRead" size="45"
					value="0" />未讀 <input type="radio" name="sellMemRecordRead" size="45"
					value="1" />已讀</td>
			</tr>


			<!-- 	<JSP:USEBEAN ID="REPLYSVC" SCOPE="PAGE" CLASS="COM.REPLY.MODEL.REPLYSERVICE" /> -->
			<!-- 	<tr> -->
			<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
			<!-- 		<td><select size="1" name="deptno"> -->
			<%-- 			<c:forEach var="deptVO" items="${replySvc.all}"> --%>
			<%-- 				<option value="${sellMemRecordVO.replyId}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
			<%-- 			</c:forEach> --%>
			<!-- 		</select></td> -->
			<!-- 	</tr> -->

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="sellMemRecordId"
			value="<%=sellMemRecordVO.getSellMemRecordId()%>"> <input
			type="submit" value="送出修改">
	</FORM>
</body>




</html>