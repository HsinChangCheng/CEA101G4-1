<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.room.model.*"%>
<%
	RoomVO roomVO = (RoomVO) request.getAttribute("roomVO"); 
//EmpServlet.java(Concroller), 存入req的roomVO物件
%>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
<title>房間資料 - listOneRoom.jsp</title>

</head>
<body>

<div class="container">
<h3>房間資料 - ListOneRoom.jsp</h3>

<table>
	<tr>
		<th>房間編號</th>
		<th>民宿會員編號</th>
		<th>房間名稱</th>
		<th>住宿價格/天</th>
		<th>房間容納人數</th>
		<th>上架時間</th>
		<th>房間敘述</th>
		<th>按讚次數</th>
		<th>房間狀態</th>
	</tr>
	<tr>
		<td><%=roomVO.getRoomId()%></td>
		<td><%=roomVO.getSellMemId()%></td>
		<td><%=roomVO.getRoomName()%></td>
		<td><%=roomVO.getRoomPrice()%></td>
		<td><%=roomVO.getRoomCapacity()%></td>
<% 
	String time = "";
	java.sql.Timestamp dts = new java.sql.Timestamp(System.currentTimeMillis());
	java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	System.out.println(roomVO);
	if (roomVO == null || roomVO.getRoomOnTime() == null){
			time = df.format(dts);
		} else {
			time = df.format(roomVO.getRoomOnTime());
		}
%>		
		<td><%=time%></td>
		<td><%=(roomVO.getRoomDes()==null)? "": roomVO.getRoomDes()%></td>
		<td><%=roomVO.getRoomCollect()%></td>
		<td><%=roomVO.getRoomStatus()%></td>
	</tr>
</table>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>