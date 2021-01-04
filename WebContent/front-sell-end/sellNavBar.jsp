<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.sell.model.*"%> 
<% SellVO sellVO = (SellVO) request.getAttribute("sellVO"); %>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <ul class="nav navbar-nav navbar-right">
            <li>
                <a href="#"><i class="zmdi zmdi-notifications text-danger"></i> </a>
            </li>
            <li>
            	<a href='<%=request.getContextPath()%>/sell/sell.do?action=sellMemLogout'>${ not empty sellVO ? sellVO.sellMemName: "User" }</a>
            </li>
        </ul>
    </div>
</nav>
