<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM ActivityPeriod: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM ActivityPeriod: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM ActivityPeriod: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='<%=request.getContextPath() %>/front-sell-end/activity_period/listAllActivityPeriod.jsp'>List</a> all ActivityProducts.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/ActivityPeriod/ActivityPeriod.do" >
        <b>輸入活動期別編號 (如AP001):</b>
        <input type="text" name="act_period_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="actperSvc" scope="page" class="com.activity_period.model.ActivityPeriodService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath() %>/ActivityPeriod/ActivityPeriod.do" >
       <b>選擇活動期別編號:</b>
       <select size="1" name="act_period_id">
         <c:forEach var="actperVO" items="${actperSvc.all}" > 
          <option value="${actperVO.act_period_id}">${actperVO.act_period_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  
  
  
</ul>




<h3>員工管理</h3>

<ul>
  <li><a href='<%=request.getContextPath() %>/front-sell-end/activity_period/addActivityPeriod.jsp'>Add</a> a new ActivityPeriod.</li>
</ul>

</body>
</html>