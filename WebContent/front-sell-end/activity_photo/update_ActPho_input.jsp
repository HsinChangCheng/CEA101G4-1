<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity_photo.model.*"%>

<%
  ActivityPhotoVO actphoVO = (ActivityPhotoVO) request.getAttribute("actphoVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%= actphoVO==null %>--${actphoVO.act_photo_id}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>資料修改 - update_ActPho_input.jsp</title>

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
img.QQ{
width:100px;
height:100px;}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>活動照片修改 - update_ActPho_input.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath() %>/front-sell-end/activity_photo/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

<!-- 	錯誤表列 -->
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM 
		ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do" name="form1" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>活動照片編號:<font color=red><b>*</b></font></td>
				<td><%=actphoVO.getAct_photo_id()%></td>
			</tr>
			<tr>
				<td>活動編號:</td>
				<td><%=actphoVO.getAct_id()%></td>
			</tr>
			<tr>
				<td>活動照片:</td>
				<td>
				<input type="file" name="upfile1" id="myFile">
				<input type="hidden" name="act_photo" value="<%=actphoVO.getAct_photo()%>" />
				<img class="QQ" src="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do?act_photo_id=
				${actphoVO.act_photo_id}&action=getOneActPho"></td>
			</tr>
			<tr>
				<td>活動照片內容:</td>
				<td><input type="TEXT" name="act_photo_content" size="45"
					value="<%=actphoVO.getAct_photo_content()%>" /></td>
			</tr>
			

		</table>
		<br> <input type="hidden" name="action" value="update"> 
		<input type="hidden" name="act_photo_id" value="<%=actphoVO.getAct_photo_id()%>">
		<input type="hidden" name="act_id" value="<%=actphoVO.getAct_id()%>">
	    <input type="submit" value="送出修改">
	</FORM>
</body>




</html>