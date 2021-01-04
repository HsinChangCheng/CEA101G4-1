<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>最難ㄉ圖片</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
    text-align: center;
  }
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Emp: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Emp: Home</p>

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
  <li><a href='<%=request.getContextPath()%>/front-sell-end/activity_photo/listAllActPho.jsp'>List</a> all ActPho.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do" >
        <b>輸入活動照片編號 (ACT001):</b>
        <input type="text" name="act_photo_id">
        <input type="hidden" name="action" value="get_Photo_By_Act_photo_id">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="actphoSvc" scope="page" class="com.activity_photo.model.ActivityPhotoService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do" >
       <b>選擇活動照片編號:</b>
       <select size="1" name="act_photo_id">
         <c:forEach var="actphoVO" items="${actphoSvc.all}" > 
          <option value="${actphoVO.act_photo_id}">${actphoVO.act_photo_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="get_Photo_By_Act_photo_id">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  
</ul>


<h3>活動照片管理</h3>

<ul>
  <li><a href="<%=request.getContextPath()%>/front-sell-end/activity_photo/Upload_Photo.jsp">新增</a>活動照片</li>
</ul>
<ul>
  <li><a href="<%=request.getContextPath()%>/front-sell-end/activity_photo/upLoad_PhotoM.jsp">上傳多張</a>活動照片</li>
</ul>
</body>
</html>