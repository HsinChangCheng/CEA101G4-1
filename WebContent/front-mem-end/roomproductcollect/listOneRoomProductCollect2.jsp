<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.roomproductcollect.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>


<%
RoomProductCollectService rpcSvc = new RoomProductCollectService();
List<RoomProductCollectVO> rpcListRoom = (List)request.getAttribute("rpcListRoom");
//rpcListMem.get(0)// 這只是你的第一台哀鳳 你要MEMID就是要GETMEMID


%>

<html>
<head>
<title>訂單資料 - listOneRoomProductCollect.jsp</title>

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
		 <h3>房間收藏 - ListOneRoomProductCollect.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-end/roomproductcollect/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>房間編號</th>
		<th>會員編號</th>
				
	</tr>
	<c:forEach var="getRoom" items="${rpcListRoom}">
		 <tr>
			<td>${getRoom.room_id}</td>
			<td>${getRoom.mem_id}</td>
			
		</tr>
	</c:forEach>
</table>


	
</body>
</html>