<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.souvenir_order_detail.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	SouvenirOrderDetailVO sodVO = (SouvenirOrderDetailVO) request.getAttribute("sod"); //EmpServlet.java(Concroller), �s�Jreq��empVO����
%>

<html>
<head>
<title>�S���q����Ӹ�� - listOneSouvenir_Order_detail.jsp</title>

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
	width: 1200px;
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

	<!-- <h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4> -->
	<table id="table-1">
		<tr>
			<td>
				<h3>�S���q�� - ListOneSouvenir_Order_detail.jsp</h3>
				<h4>
					<a href="/CEA101G4/back-end/souvenir_order_detail/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<
			<th>�S���q��s��</th>
			<th>�S���s��</th>
			<th>�S���q�ʼƶq</th>
			<th>�S���ӫ~���</th>
		</tr>
		<tr>
			<td>${sodVO.sou_order_id}</td>
			<td>${sodVO.sou_id}</td>
			<td>${sodVO.sou_order_amount}</td>
			<td>${sodVO.sou_price}</td>
		</tr>
	</table>

</body>
</html>