<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:if test="${not empty errorMsgs}">
		<div class="container">
	
			<div class="alert alert-danger" role="alert">
			<strong>更新失敗，請修正以下錯誤:</strong>
			<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li>${message}
			</c:forEach>
			</ul>
			</div>
		</div>
	</c:if>