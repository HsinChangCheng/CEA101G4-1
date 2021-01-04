<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.activity_photo.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ActivityPhotoVO actphoVO = (ActivityPhotoVO) request.getAttribute("actphoVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title> listOneActPho.jsp</title>

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
				<h3> ListOneActPho.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath() %>/front-end/activity_photo/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動照片編號</th>
			<th>活動編號</th>
			<th>活動照片</th>
			<th>活動照片內容</th>
			


		</tr>
		<tr>
			<td><%=actphoVO.getAct_photo_id()%></td>
			<td><%=actphoVO.getAct_id()%></td>
			<td><img class="QQ" src="<%=request.getContextPath()%>
			/ActivityPhoto/ActivityPhoto.do?act_photo_id=${actphoVO.act_photo_id}&action=getOneActPho"></td></td>
			<td><%=actphoVO.getAct_photo_content()%></td>
			


		</tr>
	</table>

</body>
</html>