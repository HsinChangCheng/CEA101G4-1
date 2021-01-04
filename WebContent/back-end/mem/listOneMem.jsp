<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.member.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  MemberVO memVO = (MemberVO) request.getAttribute("memVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>

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
				<h3>員工資料 - ListOneEmp.jsp</h3>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/member/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>會員編號</th>
			<th>會員帳號</th>
			<th>會員密碼</th>
			<th>會員姓名</th>
			<th>會員生日</th>
			<th>會員電話</th>
			<th>會員地址</th>
			<th>會員信箱</th>
			<th>會員身分證字號</th>
			<th>會員帳號狀態</th>
			<th>會員性別</th>
			<th>會員加入時間</th>


		</tr>
		<tr>
			<td><%=memVO.getMem_id()%></td>
			<td><%=memVO.getMem_account()%></td>
			<td><%=memVO.getMem_pwd()%></td>
			<td><%=memVO.getMem_name()%></td>
			<td><%=memVO.getMem_birth()%></td>
			<td><%=memVO.getMem_tel()%></td>
			<td><%=memVO.getMem_address()%></td>
			<td><%=memVO.getMem_mail()%></td>
			<td><%=memVO.getMem_id_number()%></td>
			<td><%=memVO.getMem_acc_status()%></td>
			<td><%=memVO.getMem_gender()%></td>
			<td><%=memVO.getMem_jointime()%></td>


		</tr>
	</table>

</body>
</html>