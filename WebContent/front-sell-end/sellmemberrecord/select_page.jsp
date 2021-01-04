<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM SellMemberRecord: Home</title>

<style>
</style>

</head>
<body>


	<p>This is the Home page for IBM SellMemberRecord: Home</p>

	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a
			href='/CEA101G4/front-sell-end/sellmemberrecord/listAllSellMemberRecord.jsp'>List</a>
			allMemRecords. <br> <br></li>


		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/sellMemberRecord/sellMemberRecord.do">
				<b>輸入民宿會員通知編號 (ex:SELR001):</b> <input type="text" name="sellMemRecordId">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="sellMemRecordSvc" scope="page"
			class="com.sellermemberrecord.model.SellMemRecordService" />

		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/sellMemberRecord/sellMemberRecord.do">
				<b>選擇民宿會員通知編號 :</b> <select size="1" name="sellMemRecordId">
					<c:forEach var="sellMemRecordVO" items="${sellMemRecordSvc.all}">
						<option value="${sellMemRecordVO.sellMemRecordId}">${sellMemRecordVO.sellMemRecordId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/sellMemberRecord/sellMemberRecord.do">
				<b>選擇民宿會員通知編號:</b> <select size="1" name="sellMemRecordId">
					<c:forEach var="sellMemRecordVO" items="${sellMemRecordSvc.all}">
						<option value="${sellMemRecordVO.sellMemRecordId}">${sellMemRecordVO.sellMemId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


	<h3>評論管理</h3>

	<ul>
		<li><a
			href='/CEA101G4/front-sell-end/sellmemberrecord/addSellMemberRecord.jsp'>Add</a>
			a new SellMemberRecord.</li>
	</ul>

</body>
</html>