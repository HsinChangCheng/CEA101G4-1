<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.reply.model.*"%>
<%-- �����Ƚm�߱ĥ� Script ���g�k���� --%>

<%
	ReplyVO replyVO = (ReplyVO) request.getAttribute("replyVO");

	//EmpServlet.java(Concroller), �s�Jreq��replyVO����
%>

<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<title>���׸�� - listOneReply.jsp</title>

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
	/* 	margin-left: 48%; */
	margin-top: 400px;
	color: blue;
	display: inline;
	color: blue;
	color: blue;
}
</style>

<style>
table {
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 8px;
	text-align: center;
}

#tbody:hover {
	background-color: white;
}

#backhome {
	margin-top: 40px;
	text-align: center;
}
</style>

</head>
<body bgcolor='white'>
	<h3>���׽s�����</h3>

	<table class="table">
		<thead class="thead-dark">
			<tr>
				<th>���׽s��</th>
				<th>���ʴ��O�s��</th>
				<th>�|���s��</th>
				<th>���ʵ��פ��e</th>
				<th>���ʵ��׮ɶ�</th>
				<th>���ʵ��ת��A</th>
			</tr>
		</thead>
		<tbody id=tbody>
			<tr>


				<td>${replyVO.replyId}</td>
				<td>${replyVO.actPeriodId}</td>
				<td>${replyVO.memId}</td>
				<td>${replyVO.replyContent}</td>
				<td><fmt:formatDate value="${replyVO.replyTime}" type="both" /></td>
				<td>${replyVO.replyVisible}</td>
			</tr>
		</tbody>
	</table>
	<br>
	<div id=backhome>
		<tr>
			<td>
				<h3>
					<a href="/CEA101G4/front-mem-end/reply/front_select_reply.jsp"
						class="btn btn-dark">�^����</a>
				</h3>
			</td>
		</tr>
	</div>



</body>
</html>