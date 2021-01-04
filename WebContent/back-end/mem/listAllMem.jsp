<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.member.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	MemberService memSvc = new MemberService();
	List<MemberVO> list = memSvc.getAll();
	pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有員工資料 - listAllEmp.jsp</title>

   <style>
        body{
    		margin: 0px auto;
    		background-color:#fff;
    	}
        table#table-1 {
	background-color: #ccc;
	margin: 0px atuo;
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

        table {
	width: 800px;
	background-color: #ccc;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 0.5px solid #fff;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
	text-align: center;
	width: 50px;
}
th{
	white-space:nowrap;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>一般會員資料管理 </h3>
				<h4>
					<a
						href="<%=request.getContextPath()%>/front-end/member/select_page.jsp"><img
						src="<%=request.getContextPath() %>/image/LOGO/tiger2.png" width="100px"  border="0">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<table>
		<tr>
			<th>會員編號</th>
			<th>會員帳號</th>
			<th>會員姓名</th>
			<th>會員生日</th>
			<th>會員電話</th>
			<th>會員地址</th>
			<th>會員信箱</th>
			<th>會員身分證字號</th>
			<th>會員帳號狀態</th>
			<th>會員性別</th>
			<th>會員加入時間</th>
		</tr>
		<%@ include file="/page1.file"%>
		<c:forEach var="memVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${memVO.mem_id}</td>
				<td>${memVO.mem_account}</td>
				<td>${memVO.mem_name}</td>
				<td>${memVO.mem_birth}</td>
				<td>${memVO.mem_tel}</td>
				<td>${memVO.mem_address}</td>
				<td>${memVO.mem_mail}</td>
				<td>${memVO.mem_id_number}</td>
				<td>${memVO.mem_acc_status}</td>
				<td>${memVO.mem_gender ==0? "男":"女"}</td>
				<td>${memVO.mem_jointime}</td>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/member/member.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="mem_id" value="${memVO.mem_id}"> <input
							type="hidden" name="action" value="getOne_For_Update_Back_end">
					</FORM>
				</td>
			
			</tr>
		</c:forEach>
	</table>
	<%@ include file="/page2.file"%>

</body>
</html>