<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.souvenir_order.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%-- 萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位 --%>
<%-- 此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能--%>

<jsp:useBean id="listSouvenirOrders_ByCompositeQuery" scope="request" type="java.util.List<SouvenirOrderVO>" />



<html>
<head><title>複合查詢 - listSouvenirOrders_ByCompositeQuery.jsp</title>

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
	width: 1100px;
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

body {
	background-color: #E5E5E5;
	text-align: center;
	border-radius: 30px;
}




h4 {
	color: blue;
	display: inline;
}
</style>

<style>
th, td {
	padding: 5px;
	text-align: center;
}


a {
	font-size: 15px;
	color: black;
}

a:hover {
	text-decoration: none;
	color: white;
}

a#local {
	font-size: 30px;
}

input.input-group-text:hover {
	opacity: 0.5;
}

font {
	color: green;
}

#pageselect {
	display: flex;
	flex-direction: row;
	justify-content: center;
}

table#table-1 {
	background-color: #888;
	text-align: center;
	border: solid black 2px;
	color:#fffde5;
}
table.table.table-dark.table-striped {
    background-color: #666;
    width:1100px;
      position: fixed;
        left: 50%;
        transform: translateX(-50%);
        color:#fffde5;
}
</style>

</head>
<body bgcolor='white'>
 <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>

        <div id="page-content-wrapper">
<div class="container-fluid">
<h4>
<!-- ☆萬用複合查詢  - 可由客戶端 select_page.jsp 隨意增減任何想查詢的欄位<br> -->
<!-- ☆此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能</h4> -->
</div>

<table class="table table-dark table-striped">
	<tr>
		<th>特產編號</th>
		<th>員工編號</th>
		<th>會員編號</th>
		<th>特產收貨人姓名</th>
		<th>特產收貨人地址</th>
		<th>特產收貨人聯絡電話</th>
		<th>特產運費</th>
		<th>特產訂單總價</th>
		<th>特產訂單備註</th>
		<th>特產訂單運送方式</th>
		<th>特產訂單狀態</th>
		<th>特產訂單付款狀態</th>
		<th>特產訂單出貨狀態</th>
		<th>特產訂購日期</th>
	</tr>
	<c:forEach var="soVO" items="${listSouvenirOrders_ByCompositeQuery}">
		
		<tr>
			<td>${soVO.sou_order_id}</td>
			<td>${soVO.emp_id}</td>
			<td>${soVO.mem_id}</td>
			<td>${soVO.sou_receiver_name}</td>
			<td>${soVO.sou_receiver_address}</td>
			<td>${soVO.sou_receiver_phone}</td>
			<td>${soVO.sou_shipment_fee}</td>
			<td>${soVO.sou_order_sum_price}</td>
			<td>${soVO.sou_order_remarks}</td>
			<td>${soVO.sou_shipping_method}</td>
			<td>${soVO.sou_order_status}</td>  
			<td>${soVO.sou_payment_status}</td>  
			<td>${soVO.sou_shipment_status}</td>  
			<td><fmt:formatDate value="${soVO.sou_order_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
		</tr>
	</c:forEach>
</table>
</div>
</div>
</body>
</html>