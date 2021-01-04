<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.roomphoto.model.*"%>


<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    
	<title>員工資料 - listOneRoomPhoto.jsp</title>
</head>
<body>

	<c:if test="${not empty sessionScope.sellMemLogin}">
		<c:set var="sellMemLogin" scope="session" value="${sessionScope.sellMemLogin}"/>
		<c:set var="list" scope="page" value="${roomSvc.getMemIdRoomList(sellMemLogin.sellMemId)}"/>
	</c:if>
	
	
</body>

