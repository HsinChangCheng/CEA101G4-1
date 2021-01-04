<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.roomphoto.model.*"%>

<%
	RoomPhotoService roomPhotoSvc = new RoomPhotoService();
    List<RoomPhotoVO> list = roomPhotoSvc.getAll();
    pageContext.setAttribute("list",list);
%>

<jsp:useBean id="roomSvc" scope="page" class="com.room.model.RoomService" />
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front-sell-end/front-sell-listAllRoomPhoto.css">
<title>所有房間資料 - listAllRoom.jsp</title>

<style>
	* {
		font-family: "microSoft jhengHei";
	}
	.photoBox {
		padding: 5px;
		margin: 20px 0;
	} 
	.photoBox div {
		box-shadow: 3px 3px 5px #ccc;
		border-radius: 10px;
		padding: 10px;
	}
	.img-thumbnail {
		height:180px;
		object-fit:cover;
		width:100%;
	}
	#showPics button {
	  	position: absolute;
	  	right: 20px;
	  	top: 8px;
	}	
	
	#showOnePic button {
	  	position: absolute;
	  	right: 20px;
	  	bottom: 20px;
	}
	#lightBack {
		position: fixed;
		top: 0;
		left: 0;
		width: 100%;
		height: 100%;
		cursor: pointer;
		background-color: rgba(0, 0, 0, 0.3);
	}
	#showOnePic .container {
		background-color: rgba(255, 255, 255, 1);
		border-radius: 10px;
 		height: 350px;
 		width: 950px;
		position: absolute;
		padding: 10px;
		left: 50%;
		top: 50%;
        margin-top: -170px;
        margin-left: -475px;
	}
	#showOnePic .container row {
		line-height: 100%;

	}

	.imgBox img {
		max-width: 100%;
		max-height: 100%;
	}

  
</style>

</head>
<body>

<div class="container-fluid" id="titleAndError">
	<h5>此頁練習採用 EL 的寫法取值:</h5>
	<h5>所有房間圖片 - listAllRoomPhoto.jsp</h5>
	
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color:red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color:red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
</div>


<div class="container custom-width" id="showPics">
	<div class="row">
		<c:forEach var="roomPhotoVO" items="${list}" >
			<div class="col-12 col-sm-6 col-md-4 col-lg-4 photoBox">
				<div>
					<label>照片編號: ${roomPhotoVO.roomPhotoId}</label><br>
					<label>房間名稱: ${roomSvc.getOneRoom(roomPhotoVO.roomId).roomName}</label><br>
					<label>照片介紹: ${roomPhotoVO.roomPhotoContent}</label><br>
					<img src="<%=request.getContextPath()%>/roomphoto/roomphoto.do?roomPhotoId=${roomPhotoVO.roomPhotoId}&action=getOnePhoto" class="img-thumbnail object-fit">
					
					
					<input type="hidden" name="action" value="getOne_For_Update">
					<input type="hidden" name="roomPhotoId" value="${roomPhotoVO.roomPhotoId}">
					<button type="submit" class="btn btn-outline-info editBtn">修改</button>
				</div>
			</div>
		</c:forEach>
	
	</div>
	
</div>
<div class="container-fluid d-none" id="lightBack">

</div>
<div class="container-fluid d-none" id="showOnePic">

</div>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    
    <script>
    
	$(document).ready(function() {
// 		$("#showOnePic").click(function() {
// 			$("#showOnePic").addClass("d-none");
// 		})
		var urlTarget = "<%=request.getContextPath()%>/roomphoto/roomphoto.do"
		
		$(".editBtn").click(function() {
			
			$("#lightBack").removeClass("d-none");
			$("#showOnePic").removeClass("d-none");
			$.ajax({
				url: urlTarget,
				type: "POST",
				data: {
					"action": "getOne_For_Update",
					"roomPhotoId" : $(this).prev().val()
				},
				success: function(data) {
					console.log(data);
					$("#showOnePic").html(data);
				}
			});
		});
		$("#lightBack").click(function() {
			$("#lightBack").addClass("d-none");
			$("#showOnePic").addClass("d-none");
		})
	})
    </script>
</body>
</html>