<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.souvenir_order.model.*"%>


<%
SouvenirOrderVO soVO = (SouvenirOrderVO) request.getAttribute("soVO"); //SuvenirOrderServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>特產訂單資料修改 - update_souvenirorder_input.jsp</title>

<style>
 table {
		background-color: white;
		margin: 1px auto;
	}
	table, th, td {
		border: 0px solid #CCCCFF;
	}

	th, td {
    	padding: 1px;
	}
	table tr th.des {
  		width: 30%;
  		text-align: left;
	}
  .btn-primary {
  	float: right;
  }
</style>

</head>
<body>
<body bgcolor='white'>
 <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>

        <div id="page-content-wrapper">

<!-- <table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>員工資料修改 - update_news_input.jsp</h3> -->
<!-- 		 <h4><a href="/CEA101G4/back-end/news/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4> -->
<!-- 	</td></tr> -->
<!-- </table> -->


<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<div class="container">
<!-- <h3>特產訂單資料修改 - update_souvenirorder_input.jsp</h3> -->
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do" name="form2">
<table class="table align-middle">
	<tr>
		<td>訂單編號:<font color=red><b></b></font></td>
		<td><%=soVO.getSou_order_id()%></td>
	</tr>
	<tr>
		<td>員工編號:</td>
		<td><%= soVO.getEmp_id()%></td>
	</tr>
	<tr>
		<td>會員編號:</td>
		<td><%=soVO.getMem_id()%></td>
	</tr>
	<tr>
		<td>特產收貨人姓名:</td>
		<td><input type="TEXT" name="sou_receiver_name" size="45"
			 value="<%=soVO.getSou_receiver_name()%>" /></td>
	</tr>
	<tr>
		<td>特產收貨人地址:</td>
		<td><input type="TEXT" name="sou_receiver_address" size="45"
			 value="<%=soVO.getSou_receiver_address()%>" /></td>
	</tr>
	<tr>
		<td>特產收貨人連絡電話:</td>
		<td><input type="TEXT" name="sou_receiver_phone" size="45"
			 value="<%=soVO.getSou_receiver_phone()%>" /></td>
	</tr>
	<tr>
		<td>特產運費:</td>
		<td><input type="TEXT" name="sou_shipment_fee" size="45"
			 value="<%=soVO.getSou_shipment_fee()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單總價:</td>
		<td><input type="TEXT" name="sou_order_sum_price" size="45"
			 value="<%=soVO.getSou_order_sum_price()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單備註:</td>
		<td><input type="TEXT" name="sou_order_remarks" size="45"
			 value="<%=soVO.getSou_order_remarks()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單運送方式:</td>
		<td><input type="TEXT" name="sou_shipping_method" size="45"
			 value="<%=soVO.getSou_shipping_method()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單狀態:</td>
		<td><input type="TEXT" name="sou_order_status" size="45"
			 value="<%=soVO.getSou_order_status()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單付款狀態:</td>
		<td><input type="TEXT" name="sou_payment_status" size="45"
			 value="<%=soVO.getSou_payment_status()%>" /></td>
	</tr>
	<tr>
		<td>特產訂單出貨狀態:</td>
		<td><input type="TEXT" name="sou_shipment_status" size="45"
			 value="<%=soVO.getSou_shipment_status()%>" /></td>
	</tr>

	<tr>
		<td>特產訂購日期:<font color=red><b></b></font></td>
		<td><fmt:formatDate value="${soVO.sou_order_date}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
	</tr>
</table>
<br>
</div>
<input type="hidden" name="action" value="update">
<input type="hidden" name="sou_order_id" value="<%=soVO.getSou_order_id()%>">
<input type="hidden" name="emp_id" value="<%=soVO.getEmp_id()%>">
<input type="hidden" name="mem_id" value="<%=soVO.getMem_id()%>">
<input type="hidden" name="sou_order_date" size="45"value="<%=soVO.getSou_order_date()%>" />
<input type="submit" value="送出修改"></FORM>
</body>




</html>