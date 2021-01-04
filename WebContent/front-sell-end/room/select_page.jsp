<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>CEA101G04 Room: Home</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<%@ include file="nbar.file" %>
<div class="container">
<h3>CEA101G04 Room: Home</h3>
<h4>( MVC )</h4>


<p>This is the Home page for CEA101G04 Room: Home</p>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<h3>資料查詢:</h3>
<ul>
  <li><a href='<%=request.getContextPath()%>/front-sell-end/room/listAllRoom.jsp'>List</a> all Rooms.　<br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/room/room.do" >
		輸入房間編號 (如ROOM001):
        <input type="text" name="roomId">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>
<jsp:useBean id="roomSvc" scope="page" class="com.room.model.RoomService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/room/room.do" >
       	選擇房間編號:
       <select size="1" name="roomId">
         <c:forEach var="roomVO" items="${roomSvc.all}" > 
          <option value="${roomVO.roomId}">${roomVO.roomId}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/room/room.do" >
       	選擇房間:
       <select size="1" name="roomId">
         <c:forEach var="roomVO" items="${roomSvc.all}" > 
          <option value="${roomVO.roomId}">${roomVO.roomName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>房間管理：新增</h3>

<ul>
  <li><a href='addRoom.jsp'>Add</a> a new Room.</li>
</ul>

</div>


</body>
</html>