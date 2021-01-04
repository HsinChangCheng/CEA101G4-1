<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.activity_period.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  ActivityPeriodVO actperVO = (ActivityPeriodVO) request.getAttribute("actperVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>員工資料 - listOneActivityPeriodt.jsp</title>

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

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>活動資料 - listOneActivityPeriod.jsp.jsp</h3>
		 <h4><a href="<%= request.getContextPath() %>/front-sell-end/activity_period/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

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
</table>

</body>
</html>