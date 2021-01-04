<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.roomphoto.model.*"%>

<%
	RoomPhotoVO roomPhotoVO = (RoomPhotoVO) request.getAttribute("roomPhotoVO");
%>

<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

	<title>房間照片新增 - addRoomPhoto.jsp</title>
	<style>
	    #preview div .img-thumbnail {
            box-sizing: border-box;
            display: block;
            height: 150px;
		  	max-width: 100%;
            object-fit: cover;
        }
        .uploadBtn {
        	text-align: right;
        	margin-top: 20px;
        }

    </style>
</head>
<body>
	<jsp:useBean id="roomSvc" scope="page" class="com.room.model.RoomService" />
	<c:set var="roomList" scope="session" value="${roomSvc.all}" />
	<c:if test="${not empty sessionScope.sellMemLogin}">
		<c:set var="sellMemLogin" scope="session" value="${sessionScope.sellMemLogin}"/>
		<c:set var="roomList" scope="page" value="${roomSvc.getMemIdRoomList(sellMemLogin.sellMemId)}"/>
	</c:if>

<div class="container">
	<h3>房間照片新增 - addRoomPhoto.jsp</h3>

<br>

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
<div class="container">
	<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomphoto/roomphoto.do" enctype="multipart/form-data">

		<div>
			<label for="exampleFormControlInput1" class="form-label">房間編號</label>
			<select name="roomId">
				<c:forEach var="roomVO" items="${roomList}">
					<option value="${roomVO.roomId}"> ${roomVO.roomId} : ${roomVO.roomName}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<label for="exampleFormControlTextarea1" class="form-label">圖片描述</label>
			<textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="roomPhotoContent" placeholder="可以寫一下您的圖片是什麼房間喔~"></textarea>
		</div>
		<div>
			<label for="formFileMultiple" class="form-label">請選擇欲上傳的圖片</label>
			<input class="form-control" type="file" id="formFileMultiple"  name="roomPhoto" multiple>
			</div>
		<div class="row justify-content-start" id="preview">
		</div>
		<div class="uploadBtn">
			<input type="hidden" name="roomPhotoId" value="ROOMPH033">
			<input type="hidden" name="action" value="insert">
			<button type="submit" class="btn btn-secondary">確認上傳</button>
		</div>
	</FORM>
</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    
    <script type="text/javascript">
    	$(document).ready(function() {
    		
    		
    		$("#formFileMultiple").change(function() {
    			var photoList = [];
                for (let a = 0; a < this.files.length; a++) {
                	photoList.push(this.files[a]);
                }
    			var preview = document.getElementById("preview");
    			
                if (photoList) {
                	preview.innerHTML = ``;
                	
                    for (let i = 0; i < photoList.length; i++) {
                        let file = photoList[i];
                        if (file.type != undefined && file.type.indexOf('image') > -1) {
                            // 填入檔名
                            // filename.value = file.name;

                            // new a FileReader
                            let reader = new FileReader();
                            reader.addEventListener('load', function(e) {
                                let div = document.createElement('div');
                                div.classList.add("col-3");
                                div.innerHTML = `
                                <label name="roomPhotoName" id="` + file.name + `"> ` + file.name + `</label><br>
                                <div class="img-div"><img class="img-thumbnail object-fit" src="` + e.target.result + `"></div>`;
                                preview.append(div);
                            });
                            // 使用FileReader物件上的 readAsDataURL(file) 的方法，傳入要讀取的檔案，並開始進行讀取
                            reader.readAsDataURL(file);
                        }
                    }
                } else {
					// 彈出警告視窗 alert('請上傳圖片！');
					alert('請上傳圖片');
				}
    		});

		});
    	
		function selectPic(picName) {
			var tar = $("#" + picName)
            tar.click(function() {
            	tar.prop("checked", !tar.prop("checked"));
            })
            // console.log(ckbox.checked);
    	}

    </script>

</body>
</html>