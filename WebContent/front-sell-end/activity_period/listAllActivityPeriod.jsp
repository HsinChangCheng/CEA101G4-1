<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.activity_period.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    ActivityPeriodService actperSvc = new ActivityPeriodService();
    List<ActivityPeriodVO> list = actperSvc.getAll();
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
		 <h4><a href="<%= request.getContextPath() %>/front-sell-end/activity_period/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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
		<th>活動期別編號</th>
		<th>活動編號</th>
		<th>活動報名開始時間</th>
		<th>活動報名結束時間</th>
		<th>活動開始時間</th>
		<th>活動結束時間</th>
		<th>活動人數下限</th>
		<th>活動人數上限</th>
		<th>活動當下價格</th>
		<th>活動期別狀態</th>
		<th>活動已報名人數</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="actperVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${actperVO.act_period_id}</td>
			<td>${actperVO.act_id}</td>
			<td>${actperVO.act_sign_start}</td>
			<td>${actperVO.act_sign_end}</td>
			<td>${actperVO.act_period_start}</td>
			<td>${actperVO.act_period_end}</td> 
			<td>${actperVO.act_up_limit}</td>
			<td>${actperVO.act_low_limit}</td>
			<td>${actperVO.act_cur_price}</td>
			<td>${actperVO.act_period_status}</td>
			<td>${actperVO.act_sign_sum}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ActivityProduct/ActivityProduct.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="act_period_id"  value="${actperVO.act_period_id}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/ActivityPhoto/ActivityPhoto.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="act_photo_id" value="${actphoVO.act_photo_id}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
		
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>