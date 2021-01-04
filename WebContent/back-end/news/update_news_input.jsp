<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.news.model.*"%>

<%
NewsVO newsVO = (NewsVO) request.getAttribute("newsVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%-- <%= newsVO==null %>--${newsVO.news_id}-- --%>
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
	width: 800px;
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
<body>
<body bgcolor='white'>
 <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>

        <div id="page-content-wrapper">

<!-- <table id="table-1"> -->
<!-- 	<tr><td> -->
<!-- 		 <h3>員工資料修改 - update_news_input.jsp</h3> -->
<!-- 		 <h4><a href="/CEA101G4/back-end/news/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4> -->
<!-- 	</td></tr> -->
<!-- </table> -->

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

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/news/news.do" name="form1">
<table>
	<tr>
		<td>消息編號:<font color=red><b></b></font></td>
		<td><%=newsVO.getNews_id()%></td>
	</tr>
	<tr>
		<td>最新消息內容:</td>
		<td><textarea name="news_content" style="width:400px;height:200px;"><%= (newsVO==null)? "123456" : newsVO.getNews_content()%></textarea></td>
	</tr>
	<tr>
		<td>最新消息日期:</td>
		<td><input type="TEXT" name="news_date" size="45"
			 value="<%= (newsVO==null)? "2020-12-10 22:10:10" : newsVO.getNews_date()%>" /></td>
	</tr>

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="news_id" value="<%=newsVO.getNews_id()%>">
<input type="submit" value="送出修改"></FORM>
</div>
</div>
</body>




</html>