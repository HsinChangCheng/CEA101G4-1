<%@ page contentType="text/html; charset=UTF-8" pageEncoding="utf8"%>
<%@ page import="com.foodspot.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
FoodSpotVO fsVO = (FoodSpotVO) request.getAttribute("fsVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>美食與景點資料 - listOneFoodSpot.jsp</title>

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
  img{
  width:100px;
  height:auto;
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
		 <h3>美食與景點資料 - ListOneFoodSpot.jsp</h3>
		 <h4><a href="/CEA101G4/front-end/foodspot/select_page.jsp"><img src="<%=request.getContextPath()%>/front-end/foodspot/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>美食與景點編號</th>
		<th>民宿會員編號</th>
		<th>美食與景點名稱</th>
		<th>美食景點地址</th>
		<th>美食景點敘述</th>
		<th>美食景點圖片</th>
		<th>美食景點經度</th>
		<th>美食景點緯度</th>
			
		
	</tr>
	<tr>
		<td><%=fsVO.getFas_id()%></td>
		<td><%=fsVO.getSell_mem_id()%></td>
		<td><%=fsVO.getFas_spot_name()%></td>
		<td><%=fsVO.getFas_add()%></td>
		<td><%=fsVO.getFas_des()%></td>
		<td><img src="${pageContext.request.contextPath}/foodspot/foodspot.do?fas_id=${fsVO.fas_id}&action=getFSPhoto"></td>
		<td><%=fsVO.getFas_longitud()%></td>
		<td><%=fsVO.getFas_latitude()%></td>
		
		
		
	</tr>
</table>

</body>
</html>