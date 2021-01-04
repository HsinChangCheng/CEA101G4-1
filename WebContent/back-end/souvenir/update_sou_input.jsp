<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.souvenir_product.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%
	SouvenirProductVO soupVO = (SouvenirProductVO) request.getAttribute("soupVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>
<%-- <%=soupVO == null%>--${soupVO.sou_id}-- --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>特產資料修改 - update_sou_input.jsp</title>

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

<div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>
          <div id="page-content-wrapper">

	<table id="table-1">
		<tr>
			<td>
				<h3>特產資料修改 - update_sou_input.jsp</h3>
				<h4>
					<a href="/CEA101G4/back-end/souvenir/select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料修改:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post"
		ACTION="<%=request.getContextPath()%>/souvenir_product/SouvenirProductServlet"
		name="form1">
		<table>
			<tr>
				<td>特產編號:<font color=red><b>*</b></font></td>
				<td><%=soupVO.getSou_id()%></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td>特產類別:</td> -->
<!-- 				<td><input type="TEXT" name="sou_type_id" size="45" -->
<%-- 					value="<%=soupVO.getSou_type_id()%>" /></td> --%>
<!-- 			</tr> -->

					<jsp:useBean id="soutSvc" scope="page" class="com.souvenir_type.model.SouvenirTypeService" />
	<tr>
		<td>特產種類:<font color=red><b>*</b></font></td>
		<td><select size="1" name=sou_type_id>
			<c:forEach var="soutVO" items="${soutSvc.all}">
				<option value="${soutVO.sou_type_id}" ${(soupVO.sou_id==soutVO.sou_type_id)? 'selected':'' } >${soutVO.sou_type_name}
			</c:forEach>
		</select></td>
	</tr>


			<tr>
				<td>特產名稱:</td>
				<td><input type="TEXT" name="sou_name" size="45"
					value="<%=soupVO.getSou_name()%>" /></td>
			</tr>
			<tr>
				<td>特產價格:</td>
				<td><input name="sou_price" type="TEXT"
					value="<%=soupVO.getSou_price()%>" /></td>
			</tr>
			<tr>
				<td>特產上架日期:</td>
				<td><input type="TEXT" id="f_date1" name="sou_on_date" size="45"
					value="<%=soupVO.getSou_on_date()%>" /></td>
			</tr>
			<tr>
				<td>特產下架日期:</td>
				<td><input type="TEXT" id="f_date2" name="sou_off_date" size="45"
					value="<%=soupVO.getSou_off_date()%>" /></td>
			</tr>
			<tr>
				<td>特產累積按讚次數:</td>
				<td><input type="TEXT" name="sou_like_count" size="45"
					value="<%=soupVO.getSou_like_count()%>" /></td>
			</tr>

			<tr>
				<td>特產敘述:</td>
				<td><input type="TEXT" name="sou_des" size="45"
					value="<%=soupVO.getSou_des()%>" /></td>
			</tr>

			<tr>
				<td>特產商品狀態:</td>
				<td><input type="TEXT" name="sou_status" size="45"
					value="<%=soupVO.getSou_status()%>" /></td>
			</tr>


		</table>
		<br> <input type="hidden" name="action" value="update"> <input
			type="hidden" name="sou_id" value="<%=soupVO.getSou_id()%>"> <input
			type="submit" value="送出修改">
	</FORM>
	
	</div>
	</div>
</body>
<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<%

  java.sql.Timestamp sou_on_date = null;
  try {
	  sou_on_date = soupVO.getSou_on_date();
   } catch (Exception e) {
	   sou_on_date = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>

<%

  java.sql.Timestamp sou_off_date = null;
  try {
	  sou_off_date = soupVO.getSou_off_date();
   } catch (Exception e) {
	   sou_off_date = new java.sql.Timestamp(System.currentTimeMillis());
   }
%>


<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 5,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=sou_on_date%>', // value:   new Date(),
		   
		   

           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
        $.datetimepicker.setLocale('zh');
        $('#f_date2').datetimepicker({
	       theme: '',              //theme: 'dark',
	       timepicker:true,       //timepicker:true,
	       step: 5,                //step: 60 (這是timepicker的預設間隔60分鐘)
	       format:'Y-m-d H:i:s',         //format:'Y-m-d H:i:s',
		   value: '<%=sou_off_date%>', // value:   new Date(),
		   
		   

           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

            // 1.以下為某一天之前的日期無法選擇
              var somedate1 = new Date('2017-06-15 21:56:56');
              $('#f_date1').datetimepicker({
                  beforeShowDay: function(date) {
                	  if (  date.getYear() <  somedate1.getYear() || 
        		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
                      ) {
                           return [false, ""]
                      }
                      return [true, ""];
              }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>



</html>