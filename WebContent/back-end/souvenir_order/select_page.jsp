<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>SouvenirOrder: Home</title>

<style>
  table#table-1 {
	width: 600px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>SouvenirOrder: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Souvenir_Order: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='/CEA101G4/back-end/souvenir_order/listAllSouvenirOrder.jsp'>List</a> all souvenir_orders.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do" >
        <b>輸入訂單編號 (如SO001):</b>
        <input type="text" name="sou_order_id">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="soSvc" scope="page" class="com.souvenir_order.model.SouvenirOrderService" />
   
  <li>
     <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do" >
       <b>選擇訂單編號:</b>
       <select size="1" name="sou_order_id">
         <c:forEach var="soVO" items="${soSvc.all}" > 
          <option value="${soVO.sou_order_id}">${soVO.sou_order_id}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
<!--   <li> -->
<%--      <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do" > --%>
<!--        <b>選擇員工編號:</b> -->
<!--        <select size="1" name="sou_order_id"> -->
<%--          <c:forEach var="souvenir_orderVO" items="${souvenir_orderSvc.all}" >  --%>
<%--           <option value="${souvenir_orderVO.sou_order_id}">${souvenir_orderVO.emp_id} --%>
<%--          </c:forEach>    --%>
<!--        </select> -->
<!--        <input type="hidden" name="action" value="getOne_For_Display"> -->
<!--        <input type="submit" value="送出"> -->
<!--      </FORM> -->
<!--   </li> -->
</ul>
<ul>  
  <li>   
    <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/souvenir_order/souvenir_order.do" name="form1">
        <b><font color=blue>萬用複合查詢:</font></b> <br>           
       <b>輸入會員編號:</b>
       <input type="text" name="mem_id" value="MEM001"><br>
       
       <b>輸入特產訂單運送方式:</b>
       <input type="text" name="sou_shipping_method" value="0"><br>
       <b>輸入特產訂單狀態:</b>
       <input type="text" name="sou_order_status" value="0"><br>
        <b>輸入特產訂單付款狀態:</b>
       <input type="text" name="sou_payment_status" value="0"><br>
		        
        <input type="submit" value="送出">
        <input type="hidden" name="action" value="listSouvenirOrders_ByCompositeQuery">
     </FORM>
  </li>
</ul>

<h3>會員管理</h3>

<ul>
  <li><a href='/CEA101G4/back-end/souvenir_order/addSouvenirOrder.jsp'>Add</a> a new souvenir_order.</li>
</ul>

</body>
</html>