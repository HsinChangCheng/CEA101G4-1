<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.roomproductcollect.model.*"%>

<%
RoomProductCollectVO rpcVO = (RoomProductCollectVO) request.getAttribute("rpcVO");
%>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>收藏管理 - addRoomProductCollect.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>房間收藏新增 - addRoomProductCollect.jsp</h3></td><td>
		 <h4><a href="<%=request.getContextPath()%>/front-end/roomproductcollect/select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/roomproductcollect/roomproductcollect.do" name="form1">
<table>
	<tr>
	<td>會員編號:</td>
		<td><input type="TEXT" name="mem_id" size="45" 
			 value="<%= (rpcVO==null)? "MEM001" : rpcVO.getMem_id()%>" /></td>
	</tr>
	<tr>
	<td>房間編號:</td>
		<td><input type="TEXT" name="room_id" size="45" 
			 value="<%= (rpcVO==null)? "ROOM001" : rpcVO.getRoom_id()%>" /></td>
	</tr>
	</table>
	<br>
	

	

<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.member.model.MemberService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${MemSvc.all}"> --%>
<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->



<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>
</html>