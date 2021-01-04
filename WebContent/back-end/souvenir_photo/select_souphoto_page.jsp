<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Sou: Home</title>

<style>

</style>

</head>
<body bgcolor='white'>

<div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>
          <div id="page-content-wrapper">



<p>This is the Home page for Souvenir: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='/CEA101G4/back-end/souvenir_photo/listAllSouPhoto.jsp'>List</a> all Souvenir.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_photo/SouvenirPhotoServlet" >
        <b>輸入特產照片編號 (如SOUPH001):</b>
        <input type="text" name="sou_photo_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="souphSvc" scope="page" class="com.souvenir_photo.model.SouvenirPhotoService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_photo/SouvenirPhotoServlet" >
       <b>選擇特產照片編號:</b>
       <select size="1" name="sou_photo_id">
         <c:forEach var="souphVO" items="${souphSvc.all}" > 
          <option value="${souphVO.sou_photo_id}">${souphVO.sou_photo_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_photo/SouvenirPhotoServlet" >
       <b>選擇特產商品:</b>
       <select size="1" name="sou_photo_id">
         <c:forEach var="souphVO" items="${souphSvc.all}" > 
          <option value="${souphVO.sou_photo_id}">${souphVO.sou_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>



<h3>特產管理</h3>

<ul>
  <li><a href='/CEA101G4/back-end/souvenir_photo/addSouPhoto.jsp'>Add</a> a new Souvenir.</li>
</ul>
</div>
</div>
</body>
</html>