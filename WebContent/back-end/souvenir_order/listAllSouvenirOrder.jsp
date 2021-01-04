<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.souvenir_order.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	SouvenirOrderService souvenir_orderSvc = new SouvenirOrderService();
	List<SouvenirOrderVO> list = souvenir_orderSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<title>所有特產訂單資料 - listAllSouvenir_Order.jsp</title>

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
#souvenirOrderList td {
	vertical-align: middle;
}

</style>

</head>
<body>

 <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>

        <div id="page-content-wrapper">


<!-- 	<table id="table-1"> -->
<!-- 		<tr> -->
<!-- 			<td> -->
<!-- 				<h4> -->
<%-- 					<a href="<%=request.getContextPath()%>/back-end/backend.jsp" title=""> <img id="leftImg" src="<%=request.getContextPath()%>/back-end/image/專題標籤.png" alt=""></a> --%>
<!-- 				</h4> -->
<!-- 			</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table class="table table-striped table-hover align-middle"
		id="souvenirOrderList">
		<thead class=".thead-dark">
			<tr>
				<th>特產編號</th>
				<th>員工編號</th>
				<th>會員編號</th>
				<th>特產收貨人姓名</th>
				<th>特產收貨人地址</th>
				<th>特產收貨人聯絡電話</th>
				<th>特產運費</th>
				<th>特產訂單總價</th>
				<th >特產訂單備註</th>
				<th>特產訂單運送方式</th>
				<th>特產訂單狀態</th>
				<th>特產訂單付款狀態</th>
				<th>特產訂單出貨狀態</th>
				<th>特產訂購日期</th>
				<th>修改</th>
				<th>刪除</th>
			</tr>
		</thead>
		<tbody>
			<%-- 	<%@ include file="page1.file" %>  --%>
			<%-- 	<c:forEach var="soVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>"> --%>
			<c:forEach var="soVO" items="${list}">
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
					<td><fmt:formatDate value="${soVO.sou_order_date}"
							pattern="yyyy-MM-dd HH:mm:ss" /></td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do"
							style="margin-bottom: 0px;">
							<input type="submit" value="修改"> <input type="hidden"
								name="sou_order_id" value="${soVO.sou_order_id}"> <input
								type="hidden" name="action" value="getOne_For_Update">
						</FORM>
					</td>
					<td>
						<FORM METHOD="post"
							ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do"
							style="margin-bottom: 0px;">
							<input type="submit" value="刪除"> <input type="hidden"
								name="sou_order_id" value="${soVO.sou_order_id}"> <input
								type="hidden" name="action" value="delete">
						</FORM>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<%-- 	<%@ include file="page2.file" %> --%>
	</div>
	</div>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>