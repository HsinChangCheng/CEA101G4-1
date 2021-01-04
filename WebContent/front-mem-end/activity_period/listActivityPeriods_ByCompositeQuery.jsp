<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.activity_period.model.*"%>

<%-- 萬用複合查詢-可由客戶端select_page.jsp隨意增減任何想查詢的欄位 --%>
<%-- 此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能--%>

<jsp:useBean id="listActivityPeriods_ByCompositeQuery" scope="request" type="java.util.List<ActivityPeriodVO>" />
<jsp:useBean id="actperSvc" scope="page" class="com.activity_period.model.ActivityPeriodService" />


<html>
<head><title>複合查詢 - listEmps_ByCompositeQuery.jsp</title>

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

<h4>
☆萬用複合查詢  - 可由客戶端 select_page.jsp 隨意增減任何想查詢的欄位<br>
☆此頁只作為複合查詢時之結果練習，可視需要再增加分頁、送出修改、刪除之功能</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有員工資料 - listAllEmp.jsp</h3>
		 <h4><a href="<%=request.getContextPath()%>/front-mem-end/front-index.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>


<table>
	<tr>
		<<th>活動期別編號</th>
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
	<c:forEach var="actperVO" items="${listActivityPeriods_ByCompositeQuery}">
		<tr align='center' valign='middle'>
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
			</tr>
	
	</c:forEach>
</table>

</body>
</html>