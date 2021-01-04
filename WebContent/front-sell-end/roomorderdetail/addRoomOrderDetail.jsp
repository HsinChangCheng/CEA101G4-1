<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.roomorderdetail.model.*"%>

<%
RoomOrderDetailVO rodVO = (RoomOrderDetailVO) request.getAttribute("rodVO");
%>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/front-sell-end/roomorderdetail-add.css">
<title>房間訂單明細新增</title>



</head>

<%@ include file="/front-sell-end/frontSellBar.jsp" %> 

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
<h3>新增房間明細</h3>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomorderdetail/roomorderdetail.do" name="form1">
	<div class="row">
		<div class="col-4">
			<label for="roid" class="text-small-uppercase">房間訂單編號:</label>
		</div>
		<div class="col-8">	
			<input type="TEXT" name="room_order_id" size="30" 
			 value="<%= (rodVO==null)? "RO001" : rodVO.getRoom_order_id()%>" />
		</div>
	</div>
	<div class="row">
		<div class="col-4">
			<label for="rid" class="text-small-uppercase">房間編號:</label>
		</div>
		<div class="col-8">	
			<input type="TEXT" name="room_id" size="30" 
			 value="<%= (rodVO==null)? "ROOM001" : rodVO.getRoom_id()%>" />
		</div>
	</div>
	<div class="row">
		<div class="col-4">
			<label for="rprice" class="text-small-uppercase">房間價格:</label>
		</div>
		<div class="col-8">
			<input type="TEXT" name="room_cur_price" size="30" 
			 value="<%= (rodVO==null)? "7788" : rodVO.getRoom_cur_price()%>" />
		</div>
	</div>
	
	<div class="row">
		<input type="hidden" name="action" value="insert">
		<input type="submit" value="送出新增">
	</div>
	</FORM>
</div>
</body>
</html>