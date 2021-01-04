<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title> FoodSpot: Home</title>

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
   <tr><td><h3>FoodSpot: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for FoodSpot: Home</p>

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
  <li><a href="<%=request.getContextPath()%>/front-sell-end/foodspot/listAllFoodSpot.jsp">List</a> all FoodSpot.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" >
        <b>輸入美食與景點編號 (如FAS001):</b>
        <input type="text" name="fas_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="fsSvc" scope="page" class="com.foodspot.model.FoodSpotService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" >
       <b>選擇美食與景點編號:</b>
       <select size="1" name="fas_id">
         <c:forEach var="fsVO" items="${fsSvc.all}" > 
          <option value="${fsVO.fas_id}">${fsVO.fas_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" >
       <b>選擇美食與景點姓名:</b>
       <select size="1" name="fas_id">
         <c:forEach var="fsVO" items="${fsSvc.all}" > 
          <option value="${fsVO.fas_id}">${fsVO.fas_spot_name}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>美食景點管理</h3>

<ul>
  <li><a href="<%=request.getContextPath()%>/front-sell-end/foodspot/addFoodSpot.jsp">Add</a> a new FoodSpot.</li>
</ul>

</body>
</html>