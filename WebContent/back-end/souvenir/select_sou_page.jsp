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
  <li><a href='/CEA101G4/back-end/souvenir/listAllSou.jsp'>List</a> all Souvenir.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_product/SouvenirProductServlet" >
        <b>輸入特產編號 (如SOU001):</b>
        <input type="text" name="sou_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="souSvc" scope="page" class="com.souvenir_product.model.SouvenirProductService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_product/SouvenirProductServlet" >
       <b>選擇特產編號:</b>
       <select size="1" name="sou_id">
         <c:forEach var="soupVO" items="${souSvc.all}" > 
          <option value="${soupVO.sou_id}">${soupVO.sou_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_product/SouvenirProductServlet" >
       <b>選擇特產商品:</b>
       <select size="1" name="sou_id">
         <c:forEach var="soupVO" items="${souSvc.all}" > 
          <option value="${soupVO.sou_id}">${soupVO.sou_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>



<h3>特產管理</h3>

<ul>
  <li><a href='/CEA101G4/back-end/souvenir/addSou.jsp'>Add</a> a new Souvenir.</li>
</ul>
</div>
</div>
</body>
</html>