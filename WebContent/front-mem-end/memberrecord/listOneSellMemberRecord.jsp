<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.sellermemberrecord.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	SellMemRecordVO sellMemRecordVO = (SellMemRecordVO) request.getAttribute("sellMemRecordVO");
%>

<html>
<head>
<title>���׸�� - listOneMemberRecord.jsp</title>

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

	<h4>�����Ƚm�߱ĥ� Script ���g�k����:</h4>
	<table id="table-1">
		<tr>
			<td>
				<h3>���׽s����� - ListOneSellMemberRecord.jsp</h3>
				<h4>
					<a href="/CEA101G4/front-sell-end/sellmemberrecord/select_page.jsp"><img
						src="images/�ǩ����Ѫ�.png" width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>�|���q���s��</th>
			<th>�|���s��</th>
			<th>�|���q�����e</th>
			<th>�|���q���ɶ�</th>
			<th>�q��Ū�����A</th>

		</tr>
		<tr>

			<td>${sellMemRecordVO.sellMemRecordId}</td>
			<td>${sellMemRecordVO.sellMemId}</td>
			<td>${sellMemRecordVO.sellMemRecordContent}</td>
			<td><fmt:formatDate value="${sellMemRecordVO.sellMemRecordTime}"
					type="both" /></td>
			<td>${sellMemRecordVO.sellMemRecordRead}</td>
		</tr>
	</table>

</body>
</html>