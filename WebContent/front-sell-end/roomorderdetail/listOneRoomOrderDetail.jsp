<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf-8"%>
<%@ page import="com.roomorderdetail.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  RoomOrderDetailVO rodVO = (RoomOrderDetailVO) request.getAttribute("rodVO"); //EmpServlet.java(Concroller), 存入req的rodVO物件
%>

<html>
<head>
<title>訂單資料 - listOneRoomOrderDetail.jsp</title>

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
	<tr><td>
		 <h3>訂單資料 - ListOneRoomOrderDetail.jsp</h3>
		 <h4><a href="/CEA101G4/front-end/roomorderdetail/select_page.jsp"><img src="<%=request.getContextPath()%>/front-end/roomorderdetail/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>房間訂單編號</th>
		<th>房間編號</th>
		<th>房間當下價格</th>
				
	</tr>
	<tr>
		<td><%=rodVO.getRoom_order_id()%></td>
		<td><%=rodVO.getRoom_id()%></td>
		<td><%=rodVO.getRoom_cur_price()%></td>
		
		
		
	</tr>
</table>

</body>
</html>