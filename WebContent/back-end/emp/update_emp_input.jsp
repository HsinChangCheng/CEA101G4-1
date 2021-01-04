<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.emp.model.*"%>

<%
  EmpVO empVO = (EmpVO) request.getAttribute("empVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%-- <%= empVO==null %>--${empVO.emp_id}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>

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
 <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>

        <div id="page-content-wrapper">
<table id="table-1">
	<tr><td>
		 <h3>員工資料修改</h3>
		
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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" name="form1">
<table>
	<tr>
		<td>員工編號:<font color=red><b></b></font></td>
		<td><%=empVO.getEmp_id()%></td>
	</tr>
	<tr>
		<td>員工帳號:</td>
		<td><input type="TEXT" name="emp_account" size="45" value="<%=empVO.getEmp_account()%>" /></td>
	</tr>
	<tr>
		<td>員工密碼:</td>
		<td><input type="TEXT" name="emp_pwd" size="45"	value="<%=empVO.getEmp_pwd()%>" /></td>
	</tr>
	<tr>
		<td>員工名字:</td>
		<td><input type="TEXT" name="emp_name" size="45"	value="<%=empVO.getEmp_name()%>" /></td>
	</tr>
	<tr>
		<td>員工帳號狀態:</td>
		<td><input type="TEXT" name="emp_acc_status" size="45"	value="<%=empVO.getEmp_acc_status()%>" /></td>
	</tr>
	<tr>
		<td>員工性別:</td>
		<td><input type="TEXT" name="emp_gender" size="45" value="<%=empVO.getEmp_gender()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="emp_id" value="<%=empVO.getEmp_id()%>">
<input type="submit" value="送出修改"></FORM>
</div>
</div>
</body>




</html>