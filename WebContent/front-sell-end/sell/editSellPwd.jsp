<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" />
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front-sell-end/front-sell-sideBar.css" />
    
	<title>民宿會員修改密碼</title>

</head>
    <body>
        <div id="viewport">
            <%@ include file="/front-sell-end/sellMemSideBar.jsp"%>
            <div id="content">
                <%@ include file="/front-sell-end/sellNavBar.jsp"%>
                <div class="container-fluid">
					<div class="container">
					    <div class="row">
					        <div class="col-lg-8 col-lg-offset-1">
					            <div class="page-header">
					                <h2>修改密碼</h2>
					            </div>
					
					            <form method="post" class="form-horizontal" action="<%=request.getContextPath()%>/sell/sell.do" id="pwdForm">
					                <div class="form-group">
					                    <label class="col-lg-3 control-label">請輸入原始密碼: </label>
					                    <div class="col-lg-5">
					                        <input type="password" class="form-control" name="oriSellMemPwd" />
					                    </div>
					                </div>
					
					                <div class="form-group">
					                    <label class="col-lg-3 control-label">請輸入新密碼: </label>
					                    <div class="col-lg-5">
					                        <input type="password" class="form-control" name="sellMemPwd" />
					                    </div>
					                </div>
					
					                <div class="form-group">
					                    <label class="col-lg-3 control-label">請再次輸入新密碼: </label>
					                    <div class="col-lg-5">
					                        <input type="password" class="form-control" name="sellMemPwdRe" />
					                    </div>
					                </div>
					
					                <div class="form-group">
					                    <div class="col-lg-9 col-lg-offset-7">
					                    	<input type="hidden" name="sellMemId" value="${sellVO.sellMemId}">
					                    	<input type="hidden" name="location" value="<%=request.getContextPath()%>/sell/editSellPwd.jsp">
					                    	<input type="hidden" name="contextPath" value="<%=request.getContextPath()%>">
											<input type="hidden" name="action" value="updatePassword">
					                        <button type="submit" class="btn btn-primary">確定修改</button>
					                    </div>
					                </div>
					            </form>
					        </div>
					    </div>
					    <div class="row">
							<c:if test="${not empty errorMsgs}">
								<%-- 錯誤表列 from Servlet --%>
								<div class="alert alert-danger col-lg-6 col-lg-offset-1" role="alert" id="titleAndError">
									<font style="color:red">請修正以下錯誤:</font>
									<ul>
										<c:forEach var="message" items="${errorMsgs}">
											<li style="color:red">${message}</li>
										</c:forEach>
									</ul>
								</div>
							</c:if>
						</div>
					</div>
				</div>
			</div>
		</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>	
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/front-sell-end/front-sell-editSellPwd.js"></script>

</body>

</html>