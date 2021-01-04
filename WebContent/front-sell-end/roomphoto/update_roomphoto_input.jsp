<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="roomSvc" scope="page" class="com.room.model.RoomService" />
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomphoto/roomphoto.do">
	<div class="container" id="updateRoomPhotoInput">
		<div class="row justify-content-center align-items-center ">

			<div class="col-6 imgBox align-items-center">
				<img src="<%=request.getContextPath()%>/roomphoto/roomphoto.do?roomPhotoId=${roomPhotoVO.roomPhotoId}&action=getOnePhoto">
			</div>
			
			<div class="col-6 align-items-start">
				<p>房間名稱: ${roomSvc.getOneRoom(roomPhotoVO.roomId).roomName} </p>
				<p>照片敘述: <textarea name="roomPhotoContent" type="text" name="roomPhotoContent" cols="30" rows="2">${roomPhotoVO.roomPhotoContent}</textarea></p>
			</div>
			<input type="hidden" name="roomPhotoId" value="${roomPhotoVO.roomPhotoId}">
			<input type="hidden" name="roomId" value="${roomPhotoVO.roomId}">
			<input type="hidden" name="action" value="update">
			<button type="submit" class="btn btn-outline-info">確定修改</button>

		</div>
	</div>
</FORM>