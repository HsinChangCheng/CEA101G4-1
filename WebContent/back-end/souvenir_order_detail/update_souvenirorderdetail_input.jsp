<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.souvenir_order_detail.model.*"%>

<%
SouvenirOrderDetailVO sodVO = (SouvenirOrderDetailVO) request.getAttribute("sodVO"); //SuvenirOrderServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
%>
<%= sodVO==null %>--${sodVO.sou_order_id}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>�S���q���ƭק� - update_souvenirOrderDetail_input.jsp</title>

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
	width: 500px;
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
		 <h3>�S���q���ƭק� - update_souvenirOrderDetail_input.jsp</h3>
		 <h4><a href="/CEA101G4/back-end/souvenir_order_detail/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order_detail/souvenir_order_detail.do" name="form2">
<table>
	<tr>
		<td>�S���q��s��:<font color=red><b></b></font></td>
		<td><%=sodVO.getSou_order_id()%></td>
	</tr>
	<tr>
		<td>�S���ӫ~�s��:</td>
		<td><input type="TEXT" name="sou_id" size="45"
			 value="<%=sodVO.getSou_id()%>" /></td>
	</tr>
	<tr>
		<td>�S���q�ʼƶq:</td>
		<td><input type="TEXT" name="sou_order_amount" size="45"
			 value="<%=sodVO.getSou_order_amount()%>" /></td>
	</tr>
	<tr>
		<td>�S���ӫ~���:</td>
		<td><input type="TEXT" name="sou_price" size="45"
			 value="<%=sodVO.getSou_price()%>" /></td>
	</tr>
	
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="sou_order_id" value="<%=sodVO.getSou_order_id()%>">
<input type="submit" value="�e�X�ק�"></FORM>
</body>




</html>