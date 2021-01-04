<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.activity_product.model.*"%>
<%@ page import="java.util.List"%>
<%@ page import="com.sell.model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	SellVO sellVO = (SellVO) session.getAttribute("sellVO");
	String sell_mem_id=sellVO.getSellMemId();
	ActivityProductService actproSvc=new ActivityProductService();
	List<ActivityProductVO>list = 
			actproSvc.getAllbySellMemId(sell_mem_id);
	pageContext.setAttribute("actproSvc", actproSvc);
	pageContext.setAttribute("list",list );
%>

<html>
<head>
<title>員工資料 - listOneActivityProduct.jsp</title>

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
</style>

<style>
  table {
	width: 600px;
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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>活動資料 - listOneActivityProduct.jsp.jsp</h3>
		 <h4><a href="<%= request.getContextPath() %>/front-sell-end/activity_product/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>活動編號</th>
		<th>民宿會員編號</th>
		<th>活動種類編號</th>
		<th>活動商品名稱</th>
		<th>活動商品價格</th>
		<th>活動敘述</th>
		<th>活動地點</th>
	</tr>
	<c:forEach var="actproVO" items="${list}">
	<tr>
			<td>${actproVO.act_id}</td>
			<td>${actproVO.sell_mem_id}</td>
			<td>${actproVO.act_type_id}</td>
			<td>${actproVO.act_name}</td>
			<td>${actproVO.act_price}</td>
			<td>${actproVO.act_des}</td> 
			<td>${actproVO.act_add}</td>
	</tr>
	</c:forEach>
</table>


</body>
</html>