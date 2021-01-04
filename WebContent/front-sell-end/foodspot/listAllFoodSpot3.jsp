<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.foodspot.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    FoodSpotService fsSvc = new FoodSpotService();
    List<FoodSpotVO> list = fsSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>

<title>所有美食景點資料 - listAllFoodSpot.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
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
  img{
  width:100px;
  height:auto;
  }
</style>

<style>
  table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有美食景點資料 - listAllFoodSpot.jsp</h3>
		 <h4><a href="/CEA101G4/front-sell-end/foodspot/select_page.jsp"><img src="<%=request.getContextPath()%>/front-end/foodspot/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" >
        <b>輸入美食與景點編號 (如FAS001):</b>
        <input type="text" name="fas_id" id="fas_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出" id="search">
    </FORM>
    <div id="show"></div>
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<table>
	<tr>
		<th>美食與景點編號</th>
		<th>民宿會員編號</th>
		<th>美食與景點名稱</th>
		<th>美食景點地址</th>
		<th>美食景點敘述</th>
		<th>美食景點圖片</th>
		<th>美食景點經度</th>
		<th>美食景點緯度</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="fsVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
		<td>${fsVO.fas_id}</td>
		<td>${fsVO.sell_mem_id}</td>
		<td>${fsVO.fas_spot_name}</td>
		<td>${fsVO.fas_add}</td>
		<td>${fsVO.fas_des}</td>
		<td><img src="${pageContext.request.contextPath}/foodspot/foodspot.do?fas_id=${fsVO.fas_id}&action=getFSPhoto"></td>					
		<td>${fsVO.fas_longitud}</td>
		<td>${fsVO.fas_latitude}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="fas_id"  value="${fsVO.fas_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="fas_id"  value="${fsVO.fas_id}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>
<script>
$('#search').click(function() { 

         $.ajax({ 
          type: "Post", 
          url:"<%=request.getContextPath()%>/foodspot/foodspot.do", 
          dataType:"JSON",
          data:{
        	  "action":"getOne_For_Display",
        	  "fas_id":$("#fas_id").val()
          },
          success: function(data) { 
        	  console.log(data);
        	  $('#show').show(data);
        	  var json = JSON.parse(data);
              console.log("success", json); 
          }, 
          error: function(ob,errStr) { 
            

          } 
         }); 

         }); 
</script>
</body>
</html>