<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.faq.model.*"%>

<%
  FAQVO faqVO = (FAQVO) request.getAttribute("faqVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back-end/FAQ-upd.css">
<title>美食景點修改 - update_faq_input.jsp</title>

</head>
<body>
<div id="wrapper">
<%@ include file="/back-end/back.jsp" %> 
<div id="page-content-wrapper">
 <br>
<div>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>
<h3>修改常見問題集</h3>
<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" name="form1" >
<div class="row">
	<div class="col-4">
	 <span>問與答編號:</span>
    </div>
    <div class="col-8" style="padding-top: 10px;">   
         <%=faqVO.getFaq_id()%>
    </div>
</div>
<div class="row">
		<div class="col-4">
	 <label for="question" class="text-small-uppercase">問與答提問:</label>
    </div>
    <div class="col-8">   
           <input class="text-body" id="faqq" type="TEXT" name="faq_question" size="45" required
			 value="<%=faqVO.getFaq_question()%>" />
			 </div>
			 </div>
			
	<div class="row">
	<div class="col-4">  
	<label for="answer" class="text-small-uppercase">問與答解答:</label>
    </div>  
    <div class="col-8">   
           <input class="text-body" id="faqa" type="TEXT" name="faq_answer" size="45" required
			 value="<%=faqVO.getFaq_answer()%>" />
    </div>
</div>
<div class="row">
<input type="hidden" name="action" value="update">
<input type="hidden" name="faq_id" value="<%=faqVO.getFaq_id()%>">
<input type="submit" value="送出修改">
</FORM>
</div>
</div>
</div>
</body>




</html>