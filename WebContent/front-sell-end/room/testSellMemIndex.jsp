<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:useBean id="sellSvc" scope="page" class="com.sell.model.SellService" />
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/style.css">
<title>Select identifier</title>
</head>
<body>
<%@ include file="nbar.file" %>
	<div class="container">
		<form method="POST" action="<%=request.getContextPath()%>/front-sell-end/room/listAllRoom.jsp">
	        <select name="sellMemId">
	        	<c:forEach var="sellVO" items="${sellSvc.all}" >
	        	<option value="${sellVO.sellMemId}">${sellVO.sellMemName}
	        	</c:forEach>  

	        </select>
<!-- 			<input type="hidden" name="action" value="selectMem"> -->
	        <button type="submit" id="search" class="btn btn-secondary">查詢</button>
        </form>
    </div>



    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>


</body>
</html>