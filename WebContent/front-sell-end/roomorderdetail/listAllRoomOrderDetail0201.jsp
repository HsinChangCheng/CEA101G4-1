<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.roomorderdetail.model.*"%>

<%
    RoomOrderDetailService rodSvc = new RoomOrderDetailService();
    List<RoomOrderDetailVO> list = rodSvc.getAll();
    pageContext.setAttribute("list",list);
%>
<jsp:useBean id="roomSvc" scope="page" class="com.room.model.RoomService" />

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="https://kit.fontawesome.com/0316f9a1d0.js" crossorigin="anonymous"></script>
<script src="js/jquery-3.2.1.min.js"></script>
<title>所有訂單資料 - listAllRoomOrderDetail.jsp</title>

<style>
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
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
 
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body>
 <%@ include file="/front-sell-end/frontSellBar.jsp"%>
           
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>



 	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomorderdetail/roomorderdetail.do " >
 	
        <b>查詢房間訂單編號 (如RO001):</b> 
        <span class="icon"><i class="fa fa-search"></i></span>
        <input type="text" name="room_order_id" id="search" placeholder="Search...">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出" id="find">
 	</FORM>


	<div id="popDiv">
   		<table id="content-table" bgcolor="#FFFAFA" border="0" cellspacing="0" cellpadding="0">
   			<tbody id="content_table_body">
   				<!-- 动态查询出来的数据显示在这里 -->
   			</tbody>
   		</table>
   	</div>




<table>
	<tr>
		<th>房間訂單編號</th>
		<th>房間名稱</th>
		<th>房間價格</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="rodVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${rodVO.room_order_id}</td>
			<td>${roomSvc.getOneRoom(rodVO.room_id).roomName}</td>
			<td>${rodVO.room_cur_price}</td>
			

			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomorderdetail/roomorderdetail.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			      <input type="hidden" name="room_order_id"  value="${rodVO.room_order_id}">
			      <input type="hidden" name="room_id"  value="${rodVO.room_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomorderdetail/roomorderdetail.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="room_order_id"  value="${rodVO.room_order_id}">
			     <input type="hidden" name="room_id"  value="${rodVO.room_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
  
  


</body>
</html>