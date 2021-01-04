<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.reply.model.*"%>
<%@ page import="java.io.*,java.util.*,javax.servlet.*,java.text.*"%>

<%
	ReplyVO replyVO = (ReplyVO) request.getAttribute("replyVO"); //EmpServlet.java (Concroller) �s�Jreq��empVO���� (�]�A�������X��empVO, �]�]�A��J��ƿ��~�ɪ�empVO����)
	System.out.println(replyVO);
%>
<%=replyVO == null%>--${replyVO.replyId}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>���u��ƭק� - update_reply_input.jsp</title>

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
	width: 450px;
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
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>���׸�ƭק� - update_reply_input.jsp</h3>
				<h4>
					<a href="/CEA101G4/front-mem-end/reply/select_page.jsp"><img
						src="images/back1.gif" width="100" height="32" border="0">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>���׸�ƭק�:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/reply/reply.do" name="form1">
		<table>
			<tr>
				<td>���׽s��:<font color=red><b>*</b></font></td>
				<td><%=replyVO.getReplyId()%></td>
			</tr>
			<tr>
				<td>���ʴ��O�s��:</td>
				<td><input type="TEXT" name="actPeriodId" size="45"
					value="<%=replyVO.getActPeriodId()%>" /></td>
			</tr>
			<tr>
				<td>�|���s��:</td>
				<td><input type="TEXT" name="memId" size="45"
					value="<%=replyVO.getMemId()%>" /></td>
			</tr>
			<tr>
				<td>���ʵ��פ��e:</td>
				<td><input name="replyContent" type="TEXT"
					value="<%=replyVO.getReplyContent()%>" /></td>
			</tr>
			<tr>
				<td>���ʵ��׮ɶ�:</td>
				<td><input name="replyTime" type="TEXT"
					value="<%
					SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					out.print(ft.format(replyVO.getReplyTime()));%>" /></td>
			</tr>
			<tr>
				<td>���ʵ��ת��A:</td>
				<td><input type="radio" name="replyVisible" size="45" value="0" />�����
					<input type="radio" name="replyVisible" size="45" value="1" />���</td>
			</tr>


			<!-- 	<JSP:USEBEAN ID="REPLYSVC" SCOPE="PAGE" CLASS="COM.REPLY.MODEL.REPLYSERVICE" /> -->
			<!-- 	<tr> -->
			<!-- 		<td>����:<font color=red><b>*</b></font></td> -->
			<!-- 		<td><select size="1" name="deptno"> -->
			<%-- 			<c:forEach var="deptVO" items="${replySvc.all}"> --%>
			<%-- 				<option value="${replyVO.replyId}" ${(empVO.deptno==deptVO.deptno)?'selected':'' } >${deptVO.dname} --%>
			<%-- 			</c:forEach> --%>
			<!-- 		</select></td> -->
			<!-- 	</tr> -->

		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="replyId" value="<%=replyVO.getReplyId()%>">
		<input type="submit" value="�e�X�ק�">
	</FORM>
</body>




</html>