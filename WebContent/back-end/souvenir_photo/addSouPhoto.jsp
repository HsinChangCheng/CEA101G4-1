<%@page import="com.souvenir_photo.model.SouvenirPhotoVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%
	SouvenirPhotoVO souphVO = (SouvenirPhotoVO) request.getAttribute("souphVO");
%>
<%-- <%= soupVO==null %>--${soupVO.deptno}-- --%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>特產照片新增</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>

<style>

/*---------------------------------------------------------*/
body {
	background-color: #E5E5E5;
}

.press, input[type=submit] {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f9f9f9
		), color-stop(1, #d9d9d9));
	background: -moz-linear-gradient(top, #f9f9f9 5%, #d9d9d9 100%);
	background: -webkit-linear-gradient(top, #f9f9f9 5%, #d9d9d9 100%);
	background: -o-linear-gradient(top, #f9f9f9 5%, #d9d9d9 100%);
	background: -ms-linear-gradient(top, #f9f9f9 5%, #d9d9d9 100%);
	background: linear-gradient(to bottom, #f9f9f9 5%, #d9d9d9 100%);
	filter: progid: DXImageTransform.Microsoft.gradient(startColorstr='#f9f9f9',
		endColorstr='#d9d9d9', GradientType=0);
	background-color: #f9f9f9;
	border: 2px solid #dcdcdc;
	display: inline-block;
	cursor: pointer;
	color: #666666;
	font-size: 16px;
	padding: 10px 50px;
	border-radius: 5px;
	text-decoration: none;
	text-shadow: 0px 1px 0px #ffffff;
}

.press:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #d9d9d9
		), color-stop(1, #f9f9f9));
	background: -moz-linear-gradient(top, #d9d9d9 5%, #f9f9f9 100%);
	background: -webkit-linear-gradient(top, #d9d9d9 5%, #f9f9f9 100%);
	background: -o-linear-gradient(top, #d9d9d9 5%, #f9f9f9 100%);
	background: -ms-linear-gradient(top, #d9d9d9 5%, #f9f9f9 100%);
	background: linear-gradient(to bottom, #d9d9d9 5%, #f9f9f9 100%);
	filter: progid: DXImageTransform.Microsoft.gradient(startColorstr='#d9d9d9',
		endColorstr='#f9f9f9', GradientType=0);
	background-color: #d9d9d9;
}

.press:active {
	position: relative;
	top: 1px;
}
/*image字*/
input[type=file] {
	color: #000000;
	font-size: 12px;
	background: #f5f5f5;
	padding: 9px 9px 9px 9px;
	border: solid 2px #c9c9c9;
	text-decoration: none;
	display: inline-block;
	font-family: inherit;
	font-size: inherit;
	line-height: inherit;
	width: 300px;
	margin-left: -4px;
}

.red.press {
	border: 2px solid #8a2a21;
	border-top: 2px solid #d02718;
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #f24437
		), color-stop(1, #c62d1f));
	background: -moz-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background: -webkit-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background: -o-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background: -ms-linear-gradient(top, #f24437 5%, #c62d1f 100%);
	background: linear-gradient(to bottom, #f24437 5%, #c62d1f 100%);
	filter: progid: DXImageTransform.Microsoft.gradient(startColorstr='#f24437',
		endColorstr='#c62d1f', GradientType=0);
	background-color: #f24437;
	color: white;
	text-shadow: 0px 1px 0px #810e05;
}

.red.press:hover {
	background: -webkit-gradient(linear, left top, left bottom, color-stop(0.05, #c62d1f
		), color-stop(1, #f24437));
	background: -moz-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background: -webkit-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background: -o-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background: -ms-linear-gradient(top, #c62d1f 5%, #f24437 100%);
	background: linear-gradient(to bottom, #c62d1f 5%, #f24437 100%);
	filter: progid: DXImageTransform.Microsoft.gradient(startColorstr='#c62d1f',
		endColorstr='#f24437', GradientType=0);
	background-color: #c62d1f;
}
/** TEXT AREA, INPUTTING TEXT **/
input[type="text"], .textareastyle {
	resize: none;
	display: inline-block;
	margin: 0;
	width: 300px;
	font-family: inherit;
	font-size: 14px;
	padding: 10px;
	border: solid 2px #c9c9c9;
	transition: border 0.3s;
	appearance: none;
	box-shadow: none;
	border-radius: none;
}

input[type="text"]:focus, .textareastyle:focus {
	outline: none;
	border: solid 2px #969696;
}
/*select*/
select#soflow, select#soflow-color {
	-webkit-appearance: button;
	-webkit-box-shadow: 0px 1px 0px rgba(0, 0, 0, 0.1);
	-webkit-padding-end: 20px;
	-webkit-padding-start: 2px;
	-webkit-user-select: none;
	/* background-image: url(http://i62.tinypic.com/15xvbd5.png), -webkit-linear-gradient(#FAFAFA, #F4F4F4 40%, #E5E5E5); */
	background-position: 98% center;
	background-repeat: no-repeat;
	border: solid 2px #c9c9c9;
	color: #555;
	font-size: 14px;
	font-family: inherit;
	margin: 0px;
	overflow: hidden;
	padding: 2px 10px;
	text-overflow: ellipsis;
	white-space: nowrap;
	width: 300px;
	height: 40px;
}

select#soflow-color {
	color: #fff;
	background-image: url(http://i62.tinypic.com/15xvbd5.png),
		-webkit-linear-gradient(#779126, #779126 40%, #779126);
	background-color: #779126;
	-webkit-border-radius: 20px;
	-moz-border-radius: 20px;
	border-radius: 20px;
	padding-left: 15px;
}
/** main containers and divs **/
.gamecontainer {
	width: 550px;
}

.gamecontainer label {
	display: inline-block;
	width: 7em;
	text-align: left;
	padding-right: 0.5em;
	color: white;
}

.gamescontainer {
	background: #888;
	border: 1px solid #2e91aa;
	border-radius: 2px;
	display: inline-block;
	margin-top: 30px;
}

.my-icon {
	vertical-align: middle;
}
</style>

</head>
<body bgcolor='white'>
	<div id="wrapper">

		<!-- 		這邊是你原本放sidebar的位置 include你的sidebar進來           -->
		<%@ include file="/back-end/back-index-sidebar.jsp"%>

		<div id="page-content-wrapper">

			<div align="center">
				<%-- 錯誤表列 --%>
				<c:if test="${not empty errorMsgs}">
					<font style="color: red">請修正以下錯誤:</font>
					<ul>
						<c:forEach var="message" items="${errorMsgs}">
							<li style="color: red">${message}</li>
						</c:forEach>
					</ul>
				</c:if>

				<FORM METHOD="post"
					ACTION="<%=request.getContextPath()%>/souvenir_photo/SouvenirPhotoServlet"
					name="form1" enctype="multipart/form-data">
					<table>

						<div class="gamescontainer">
							<input type="hidden" name="vorp" value="p"> <input
								type="hidden" name="thisblid" value="0">
							<div class="gamecontainer">
								<p></p>

								<p>
									<jsp:useBean id="soupSvc" scope="page"
										class="com.souvenir_product.model.SouvenirProductService" />
									<label for="typelabel">特產編號:</label> <SELECT size="1"
										name=sou_id id="soflow">
										<c:forEach var="soupVO" items="${soupSvc.all}">
											<option value="${soupVO.sou_id}"
												${(souphVO.sou_id==soupVO.sou_id)? 'selected':'' }>${soupVO.sou_id}
										</c:forEach>
									</SELECT>
								</p>

								<p>
									<label for="longdescriptionlabel" style="vertical-align: top;">特產描述</label>
									<TEXTAREA class="textareastyle" cols=40 rows=5
										name="sou_photo_content">
									<%=(souphVO == null) ? "" : souphVO.getSou_photo_content()%>
							
        							</TEXTAREA>
								</p>

								<p>
									<label for="filelabel">特產照片:</label> <INPUT type="file"
										id="file" name="sou_photo" accept="image/*" size="45"
										value="${souphVO.sou_photo}" onchange="loadImageFile(event)" />

								</p>
								<img style="width:0px" id="preview" src="#">
							</div>
						</div>

					</table>
					<br> <input type="hidden" name="action" value="insert">
					<input class="press" type="submit" value="送出新增">
				</FORM>


			</div>
		</div>
	</div>
</body>





<!-- 前端預覽圖片 -->
<script>
	// 	function init() {
	// 		let photo = document.getElementsByName('sou_photo')[0];
	// 		photo.addEventListener('change', function(e) {
	// 			let files = e.target.files; // 檔案的基本資訊，包括：檔案的名稱、大小與文件型態
	// 			console.log(files[0])
	// 			if (files && files[0]) {
	// 				let file = files[0];
	// 				if (file.type.indexOf('image') > -1) {
	// 					let reader = new FileReader(); // new a FileReader
	// 					reader.onload = function(e) { // 註冊FileReader檔案讀取load的事件 (3)
	// 						let img = document.createElement("img");
	// 						img.setAttribute("src", e.target.result);
	// 						img.style.height = '200px';
	// 						let node = document.getElementById("preview"); // remove all children
	// 						while (node.lastChild) {
	// 							node.removeChild(node.lastChild);
	// 						}
	// 						node.appendChild(img);
	// 					}
	// 					reader.readAsDataURL(file); // trigger onload event
	// 				} else {
	// 					alert('Please upload an image file. ');
	// 				}
	// 			}
	// 		});

	// 	}

	// 	window.onload = init;

	function readURL(input) {
		if (input.files && input.files[0]) {
			var reader = new FileReader();
			reader.onload = function(e) {
				$('#preview').attr('src', e.target.result);
			}
			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#file").change(
			function() {
				readURL(this);
				$("#preview").css("width", "200px").css("height", "150px").css(
						"margin-bottom", "20px");
			});
</script>
</html>