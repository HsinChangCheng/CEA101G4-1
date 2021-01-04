<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.faq.model.*"%>

<%
FAQVO faqVO = (FAQVO) request.getAttribute("faqVO");
%>


<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/back-end/FAQ-add.css">
<title>會員資料新增 - addFAQ.jsp</title>


</head>
<body>
<div id="wrapper">
<%@ include file="/back-end/back.jsp" %> 
<div id="page-content-wrapper"><br>
<div>
<h3>新增常見問答集</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/faq/faq.do" name="form1" >
<div class="row">
	<div class="col-4">
	 <label for="question" class="text-small-uppercase">問與答提問:</label>
    </div>
    <div class="col-8">   
           <input class="text-body" id="faqq" type="TEXT" name="faq_question" size="45" required
			 value="<%= (faqVO==null)? "我好像被詐騙了，該怎麼辦？" : faqVO.getFaq_question()%>" />
    </div>
</div>
<div class="row">
	<div class="col-4">  
	<label for="answer" class="text-small-uppercase">問與答解答:</label>
    </div>  
    <div class="col-8">   
           <input class="text-body" id="faqa" type="TEXT" name="faq_answer" size="45" required
			 value="<%= (faqVO==null)? "您認為遇到了與 本網站相關的網路詐騙，請盡速與我們聯繫。我們全年 24 小時提供支援。？" : faqVO.getFaq_answer()%>" />
    </div>
</div>
<div class="row">
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增">
</div>
</FORM>
</div>
</div>
</div>


</body>
</html>