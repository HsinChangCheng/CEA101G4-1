<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM MemberRecord: Home</title>

<style>
</style>

</head>
<body>


	<p>This is the Home page for IBM MemberRecord: Home</p>

	<h3>��Ƭd��:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<ul>
		<li><a href='/CEA101G4/front-mem-end/memberrecord/listAllMemberRecord.jsp'>List</a>
			allMemRecords. <br> <br></li>


		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/memberRecord/memberRecord.do">
				<b>��J���׽s�� (ex:MR001):</b> <input type="text" name="memRecordId">
				<input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<jsp:useBean id="memRecordSvc" scope="page"
			class="com.memberrecord.model.MemRecordService" />

		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/memberRecord/memberRecord.do">
				<b>��ܵ��׽s�� :</b> <select size="1" name="memRecordId">
					<c:forEach var="memRecordVO" items="${memRecordSvc.all}">
						<option value="${memRecordVO.memRecordId}">${memRecordVO.memRecordId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post"
				ACTION="<%=request.getContextPath()%>/memberRecord/memberRecord.do">
				<b>��ܷ|���s��:</b> <select size="1" name="memRecordId">
					<c:forEach var="memRecordVO" items="${memRecordSvc.all}">
						<option value="${memRecordVO.memRecordId}">${memRecordVO.memId}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="�e�X">
			</FORM>
		</li>
	</ul>


	<h3>���׺޲z</h3>

	<ul>
		<li><a href='/CEA101G4/front-mem-end/memberrecord/addMemberRecord.jsp'>Add</a> a new MemberRecord.</li>
	</ul>

</body>
</html>