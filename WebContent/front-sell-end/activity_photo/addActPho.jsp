<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>

<%
MemberVO memVO = (MemberVO) request.getAttribute("memVO");
%>
<%-- <%= memberVO==null %>--${memVO.deptno}-- --%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>會員資料新增 - addEmp.jsp</title>

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
		<tr>
			<td>
				<h3>員工資料新增 - addMem.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="<%=request.getContextPath()%>/front-end/member/select_page.jsp"><img
						src="images/tomcat.png" width="100" height="100" border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/member/member.do" name="form1">
		<table>
			<tr>
				<td>會員帳號:</td>
				<td><input type="TEXT" name="mem_account" size="45"
					value="<%= (memVO==null)? "TEST213123" : memVO.getMem_account()%>" /></td>
			</tr>
			<tr>
				<td>會員密碼:</td>
				<td><input type="TEXT" name="mem_pwd" size="45"
					value="<%= (memVO==null)? "1321" : memVO.getMem_name()%>" /></td>
			</tr>
			<tr>
				<td>會員姓名:</td>
				<td><input type="TEXT" name="mem_name" size="45"
					value="<%= (memVO==null)? "吳永志" : memVO.getMem_name()%>" /></td>
			</tr>

			<tr>
				<td>會員生日:</td>
				<td><input type="TEXT" name="mem_birth" size="45"
					value="<%= (memVO==null)? "2005-03-02" : memVO.getMem_birth()%>" /></td>
			</tr>
			<tr>
				<td>會員電話:</td>
				<td><input type="TEXT" name="mem_tel" size="45"
					value="<%= (memVO==null)? "09555555555" : memVO.getMem_tel()%>" /></td>
			</tr>
			<tr>
				<td>會員地址:</td>
				<td><input name="mem_address" type="TEXT"
					value="
		<%= (memVO==null)? "09555555555" : memVO.getMem_address()%>" /></td>
			</tr>
			<tr>
				<td>會員信箱:</td>
				<td><input type="TEXT" name="mem_mail" size="45"
					value="<%= (memVO==null)? "@gmail.com" : memVO.getMem_mail()%>" /></td>
			</tr>
			<tr>
				<td>會員身份證字號:</td>
				<td><input type="TEXT" name="mem_id_number" size="45"
					value="<%= (memVO==null)? "A123456789" : memVO.getMem_id_number()%>" /></td>
			</tr>
			<tr>
				<td>會員帳號狀態:</td>
				<td><input type="TEXT" name="mem_acc_status" size="45"
					value="<%= (memVO==null)? "0" : memVO.getMem_acc_status()%>" /></td>
			</tr>
			<tr>
				<td>會員性別:</td>
				<td><input type="TEXT" name="mem_gender" size="45"
					value="<%= (memVO==null)? "1" : memVO.getMem_gender()%>" /></td>
			</tr>
			<tr>
				<td>會員加入時間:</td>
				<td><input type="TEXT" name="mem_jointime" size="45"
					value="<%= (memVO==null)? "2020-12-12 11:52:46" : memVO.getMem_jointime()%>" /></td>
			</tr>

			<%-- 	<jsp:useBean id="deptSvc" scope="page" class="com.member.model.MemberService" /> --%>
			<!-- 	<tr> -->
			<!-- 		<td>部門:<font color=red><b>*</b></font></td> -->
			<!-- 		<td><select size="1" name="deptno"> -->
			<%-- 			<c:forEach var="deptVO" items="${MemSvc.all}"> --%>
			<%-- 				<option value="${deptVO.deptno}" ${(empVO.deptno==deptVO.deptno)? 'selected':'' } >${deptVO.dname} --%>
			<%-- 			</c:forEach> --%>
			<!-- 		</select></td> -->
			<!-- 	</tr> -->

		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增">
	</FORM>
</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->


</html>