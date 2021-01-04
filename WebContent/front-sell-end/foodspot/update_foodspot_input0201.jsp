<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.foodspot.model.*"%>

<%
  FoodSpotVO fsVO = (FoodSpotVO) request.getAttribute("fsVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%--<%= fsVO==null %>--${fsVO.fas_id}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/front-sell-end/food.css">
<title>修改美食景點 </title>
</head>
<body bgcolor='white'>
<%@ include file="/front-sell-end/frontSellBar.jsp" %>

<table id="table-1">
	<tr><td>
		 <h3>美食景點資料資料修改 - update_foodspot_input.jsp</h3>
		 <h4><a href="/CEA101G4/front-end/foodspot/select_page.jsp"><img src="<%=request.getContextPath()%>/front-end/foodspot/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/foodspot/foodspot.do" name="form1" enctype="multipart/form-data">
<table>
	<tr>
		<td>美食景點編號:<font color=red><b>*</b></font></td>
		<td><%=fsVO.getFas_id()%></td>
	</tr>
	
	<tr>
		<td>民宿會員編號:</td>
		<td><input type="TEXT" name="sell_mem_id" size="45" 
			 value="<%= (fsVO==null)? "SELL001" : fsVO.getSell_mem_id()%>" /></td>
	</tr>
	<tr>
	<td>美食與景點名稱:</td>
		<td><input type="TEXT" name="fas_spot_name" size="45" 
			 value="<%= (fsVO==null)? "路邊攤" : fsVO.getFas_spot_name()%>" /></td>
	</tr>
	<tr>
	<td>美食與景點地址:</td>
		<td><input type="TEXT" name="fas_add" size="45" 
			 value="<%= (fsVO==null)? "桃園市中壢區提把米路" : fsVO.getFas_add()%>" /></td>
	</tr>
	
	<tr>
		<td>美食景點敘述:</td>
		<td><input type="TEXT" name="fas_des" size="45" 
			 value="<%= (fsVO==null)? "有吃又有拿" : fsVO.getFas_des()%>" /></td>
	</tr>
	
	<tr>
		<td>美食與景點照片:</td>
	</tr>	
	<td>
		
<form>
  <input type="file" name="fas_photo" onchange="preview()" accept="image/*" value="${fsVO.fas_photo}">
  <img id="frame" src="${pageContext.request.contextPath}/foodspot/foodspot.do?fas_id=${fsVO.fas_id}&action=getFSPhoto" width="100px" height="100px"/>
</form></td>
				
	<tr>
		<td>美食景點經度</td>
		<td><input type="TEXT" name="fas_longitud" size="45"
			 value="<%= (fsVO==null)? "24.12345678" : fsVO.getFas_longitud()%>" /></td>
	</tr>
	<tr>
		<td>美食景點經度:</td>
		<td><input type="TEXT" name="fas_latitude" size="45"
			value="<%= (fsVO==null)? "121.3456788" : fsVO.getFas_latitude()%>" /></td>
	</tr>
	
	
	

<%-- 	<jsp:useBean id="memSvc" scope="page" class="com.member.model.MemberService" /> --%>
<!-- 	<tr> -->
<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
<!-- 		<td><select size="1" name="deptno"> -->
<%-- 			<c:forEach var="deptVO" items="${memSvc.all}"> --%>
<%-- 				<option value="${memVO.mem_id}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
<%-- 			</c:forEach> --%>
<!-- 		</select></td> -->
<!-- 	</tr> -->

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="fas_id" value="<%=fsVO.getFas_id()%>">
<input type="submit" value="送出修改">
</FORM>
<script>

function preview() {
    frame.src=URL.createObjectURL(event.target.files[0]);
}
</script>
</body>




</html>