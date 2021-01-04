<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.room.model.*"%>

<%
	RoomVO roomVO = (RoomVO) request.getAttribute("roomVO");
%>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<title>房間資料新增 - addRoom.jsp</title>

<style>
  table {
	background-color: white;
	margin: 1px auto;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
  
  .btn-primary {
  	float: right;
  }
  

</style>

</head>
<body bgcolor='white'>
<%@ include file="nbar.file" %>

<table id="table-1">
	<tr><td>
		 <h3>房間資料新增 - addRoom.jsp</h3></td><td>
	</td></tr>
</table>



<div class="container">
	<%-- 錯誤表列 --%>
	
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/room/room.do">
	<table>
		<tr>
			<td>民宿會員編號:</td>
			<td><input type="TEXT" name="sellMemId" size="45"
				 value="<%= (roomVO==null)? "SELL003" : roomVO.getSellMemId()%>" /></td>
		</tr>
		<tr>
			<td>房間名稱:</td>
			<td><input type="TEXT" name="roomName" size="45"
				 value="<%= (roomVO==null)? "山水房" : roomVO.getRoomName()%>" /></td>
		</tr>
		<tr>
			<td>民宿價格/天:</td>
			<td><input type="TEXT" name="roomPrice" size="45"
				 value="<%= (roomVO==null)? "1199" : roomVO.getRoomPrice()%>" /></td>
		</tr>
		<tr>
			<td>可容納人數:</td>
			<td><input type="TEXT" name="roomCapacity" size="45"
				 value="<%= (roomVO==null)? "55" : roomVO.getRoomCapacity()%>" /></td>
		</tr>
		<tr>
			<td>民宿上架時間:</td>
			<% 
				String time = "";
				java.sql.Timestamp dts = new java.sql.Timestamp(System.currentTimeMillis());
				java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				if (roomVO==null){
					time = df.format(dts);
				} else {
					time = df.format(roomVO.getRoomOnTime());
				}
			%>
			<td><input type="TEXT" name="roomOnTime" size="45" id="f_date1" value="<%=time%>" /></td>
		</tr>
		<tr>
			<td>民宿按讚次數:</td>
			<td><input type="TEXT" name="roomCollect" size="45"
				 value="<%= (roomVO==null)? "3" : roomVO.getRoomCollect()%>" /></td>
		</tr>
		<tr>
			<td>民宿房間狀態:</td>
			<td><input type="TEXT" name="roomStatus" size="45"
				 value="<%= (roomVO==null) ? "0" : roomVO.getRoomStatus()%>" /></td>
		</tr>
		<tr>
			<td>民宿介紹:</td>
			<td><textarea name="roomDes" cols="48" rows="5"><%= (roomVO==null)? "漂亮的民宿，歡迎大家參觀~" : roomVO.getRoomDes()%></textarea></td>
		</tr>
		<tr><td><br>
			<input type="hidden" name="roomId" value="<%= (roomVO==null)? "ROOM987" : roomVO.getRoomId()%>" />
			<input type="hidden" name="action" value="insert"></td>
			<td><br><br>
			<button type="submit" class="btn btn-primary">送出新增</button></td>
		</tr>
	
	</table>
</FORM>
	<br>

</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

</body>


<% 
  java.sql.Timestamp roomOnTime = null;
  try {
	  roomOnTime = java.sql.Timestamp.valueOf(request.getParameter("roomOnTime").trim());
   } catch (Exception e) {
	   roomOnTime = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>


<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
 	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=roomOnTime%>', 
		   minDate: new Date(),
		   // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           // startDate: '2020/12/14',  // 起始日	            '2017/07/10',
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
</script>

</html>