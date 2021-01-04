<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity_product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ActivityProductService actproSvc = new ActivityProductService();
    List<ActivityProductVO> list = actproSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有員工資料 - listAllActivityProduct.jsp</title>

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
		 <h3>所有活動資料 - listAllActivityProduct.jsp</h3>
		 <h4><a href="<%= request.getContextPath() %>/front-sell-end/activity_product/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

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
		<th>活動編號</th>
		<th>民宿會員編號</th>
		<th>活動種類編號</th>
		<th>活動商品名稱</th>
		<th>活動商品價格</th>
		<th>活動敘述</th>
		<th>活動地點</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="actproVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${actproVO.act_id}</td>
			<td>${actproVO.sell_mem_id}</td>
			<td>${actproVO.act_type_id}</td>
			<td>${actproVO.act_name}</td>
			<td>${actproVO.act_price}</td>
			<td>${actproVO.act_des}</td> 
			<td>${actproVO.act_add}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ActivityProduct/ActivityProduct.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="act_id"  value="${actproVO.act_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
		
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>