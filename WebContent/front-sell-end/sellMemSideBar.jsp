<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="sidebar">
    <header>
        <a href="#">Super Going</a>
    </header>
    <ul class="nav">
        <li>
            <a href="<%=request.getContextPath()%>/front-sell-end/sell/sellMemIndex.jsp">
            	<i class="zmdi zmdi-view-dashboard"></i> 民宿會員首頁 </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/front-sell-end/sell/listOneSell.jsp">
            	<i class="zmdi zmdi-link"></i> 民宿會員基本資料管理
            </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/front-sell-end/room/listAllRoom.jsp">
            	<i class="zmdi zmdi-widgets"></i> 房間管理 </a>
        </li>
        <li>
            <a href="#"> <i class="zmdi zmdi-calendar"></i> 房間訂單管理 </a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/front-sell-end/activity_product/listOneActivityProduct.jsp"> <i class="zmdi zmdi-calendar"></i> 活動管理 </a>
        </li>
         <li>
            <a href="#"> <i class="zmdi zmdi-calendar"></i> 活動訂單管理 </a>
        </li>
         <li>
            <a href="#"> <i class="zmdi zmdi-calendar"></i> 活動週期管理 </a>
        </li>
        <li>
            <a href="#"> <i class="zmdi zmdi-settings"></i> 美食與景點管理 </a>
        </li>
        <li>
            <a href="#"> <i class="zmdi zmdi-comment-more"></i> Contact </a>
        </li>
    </ul>
</div>
