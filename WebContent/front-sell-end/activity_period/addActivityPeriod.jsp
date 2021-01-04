<%@ page contentType="text/html; charset=UTF-8" pageEncoding="big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity_product.model.*"%>

<%
  ActivityProductVO actproVO = (ActivityProductVO) request.getAttribute("actproVO");
%>
<%= actproVO==null %>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>活動資料新增 - addActivityProduct.jsp</title>

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
		 <h3>活動資料新增 - addActivityProduct.jsp</h3></td><td>
		 <h4><a href="<%=request.getContextPath() %>/front-sell-end/activity_product/select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ActivityProduct/ActivityProduct.do" name="form1">
<table>
	<tr>
		<td>民宿會員編號:</td>
		<td><input type="TEXT" name="sell_mem_id" size="45"
			 value="<%= (actproVO==null)? "SELL001" : actproVO.getSell_mem_id()%>" /></td>
	</tr>
	<tr>
		<td>活動種類編號</td>
		<td><input type="TEXT" name="act_type_id" size="45"
			 value="<%= (actproVO==null)? "AT001" : actproVO.getAct_type_id()%>" /></td>
	</tr>
	<tr>
		<td>活動商品:</td>
		<td><input type="TEXT" name="act_name" size="45"
			 value="<%= (actproVO==null)? "測試更新ㄉ活動" : actproVO.getAct_name()%>" /></td>
	</tr>
	<tr>
		<td>活動商品價格:</td>
		<td><input type="TEXT" name="act_price" size="45"
			 value="<%= (actproVO==null)? 100 : actproVO.getAct_price()%>" /></td>
	</tr>
	<tr>
		<td>活動敘述:</td>
		<td><input type="TEXT" name="act_des" size="45" 
		value="<%= (actproVO==null)? "":actproVO.getAct_des()%>" /></td>
	</tr>
	<tr>
		<td>活動地點:</td>
		<td><input type="TEXT" name="act_add" size="45" 
		value="<%= (actproVO==null)? "":actproVO.getAct_add()%>" /></td>
	</tr>

<%-- 	<jsp:useBean id="acttypeSvc" scope="page" class="com.activity_type.model.ActivityTypeService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>活動種類編號:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="act_type_id"> -->
<%-- 			<c:forEach var="acttypeVO" items="${acttypeSvc.all}"> --%>
<%-- 				<option value="${acttypeVO.act_type_id}" ${(actproVO.act_type_id==acttypeVO.act_type_id)? 'selected':'' } >${acttypeVO.act_type_name} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>



</html>