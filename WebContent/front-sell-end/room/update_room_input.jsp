<%@page import="java.util.Date"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.room.model.*"%>
<%
	RoomVO roomVO = (RoomVO) request.getAttribute("roomVO"); 
	//EmpServlet.java (Concroller) 存入req的roomVO物件 (包括幫忙取出的roomVO, 也包括輸入資料錯誤時的roomVO物件)
%>
<html>

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front-sell-end/front-sell-listAllRoom.css">
    <title>房間資料修改 - update_room_input.jsp</title>
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

<body>
	<c:if test="${not empty errorMsgs}">
		<div class="container">
		<%-- 錯誤表列 --%>
			<div class="alert alert-danger" role="alert">
				<strong>更新失敗，請修正以下錯誤:</strong>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li>${message}
					</c:forEach>
				</ul>
			</div>
		</div>
	</c:if>

    <div class="container">
        <h3>房間資料修改</h3>


        <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/room/room.do" name="form1">
            <table class="table align-middle">
<% 
	String roomId = roomVO.getRoomId();
	String sellMemId = roomVO.getSellMemId();
%>
                <tr>
                    <td>房間名稱:</td>
                    <td><input type="TEXT" name="roomName" size="45" value="<%=roomVO.getRoomName()%>" /></td>
                </tr>
                <tr>
                    <td>民宿價格/天:</td>
                    <td><input type="TEXT" name="roomPrice" size="45" value="<%=roomVO.getRoomPrice()%>" /></td>
                </tr>
                <tr>
                    <td>可容納人數:</td>
                    <td><input type="TEXT" name="roomCapacity" size="45" value="<%=roomVO.getRoomCapacity()%>" /></td>
                </tr>
                <tr>
                    <td class="des">民宿介紹:</td>
                    <% 
                    String desPlaceholder = "";
                    String desText = "";
                    
                    if(roomVO.getRoomDes()==null){
                    	desPlaceholder = "漂亮的民宿，歡迎大家參觀~";
                    } else {
                    	desText = roomVO.getRoomDes();
                    }
                    %>
                    <td><textarea name="roomDes" cols="70" rows="9" placeholder="<%=desPlaceholder%>"><%=desText%></textarea></td>
                </tr>
                <tr>
                    <td>民宿房間狀態:</td>
                    <td><input type="radio" id="roomSta0" name="roomStatus" value="0" <%=(roomVO.getRoomStatus()==0) ? "checked" :""%> >
                        <label for="roomSta0">下架   </label>
                        <input type="radio" id="roomSta1" name="roomStatus" value="1" <%=(roomVO.getRoomStatus()==1) ? "checked" :""%> >
                        <label for="roomSta1">上架</label></td>
                </tr>
	<% 
		java.sql.Timestamp dts = new java.sql.Timestamp(System.currentTimeMillis());
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(dts);
	%>
                <tr>
                    <td><br>
                    	<input type="hidden" name="roomId" value="<%=roomId%>">
                    	<input type="hidden" name="roomCollect" value="<%=roomVO.getRoomCollect()%>">
                        <input type="hidden" name="sellMemId" value="<%=sellMemId%>">
                        <input type="hidden" name="roomOnTime" id="f_date1" value="<%=time%>">
                        <input type="hidden" name="action" value="update"></td>
                    <td>
                        <button type="submit" class="btn btn-primary">確認更新</button></td>
                </tr>
            </table>
        </FORM>
    </div>
</body>

</html>