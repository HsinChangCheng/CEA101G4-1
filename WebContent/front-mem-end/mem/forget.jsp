<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF8">
<title>忘記密碼</title>
</head>
<body>
<body>
	
<body>
	<div class="container">
		<form class="well form-horizontal" METHOD="post"
			ACTION="<%=request.getContextPath()%>/member/member.do" name="form1"
			id="contact_form_forget">
			<fieldset id="test">
				<!-- Form Name -->
				<legend align="center" id="enroll">忘記密碼</legend>
				
				
				<div class="form-group" id="account_color">
					<label class="col-md-4 control-label">帳號</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon glyphicon-user" id="account_icon"></i>
								</i></span> <input name="mem_account" placeholder="帳號" class="form-control"
								type="text" trigger="blur">
						</div>
					</div>
				</div>
				
				
				<div class="form-group">
					<label class="col-md-4 control-label">E-Mail</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-envelope"></i></span> <input name="mem_mail"
								placeholder="E-Mail Address" class="form-control" type="text">
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-4 control-label">生日</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-gift"></i></span> <input name="mem_birth"
								placeholder="2000/01/01" class="form-control date-picker"
								id="mem_birth" type="date">
						</div>
					</div>
				</div>
				<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label> <input
							type="hidden" name="action" value="mem_forget_pwd">
						<div class="col-md-12" style="text-align: center;">
							<button type="submit" class="btn btn-warning">
								送出 <span class="glyphicon glyphicon-send"></span>
							</button>
							
						</div>
					</div>
			</fieldset>
		</form>
	</div>

</body>
	<script id="rendered-js">
	var urlTarget = "<%=request.getContextPath()%>/member/member.do";
		$(document).ready(function() {
				
			
				//前端攔截=================================================================
					
				

					
	
					$('#contact_form_forget').bootstrapValidator({
						// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},

						fields : {
							
							mem_birth : {
								validators : {
									 date: {
										   format: 'YYYY/MM/DD',
										   message: 'The format is YYYY/MM/DD'
										 },

									notEmpty : {
										message : '請輸入您的生日'
									}
								}
							},

							mem_mail : {
								
									trigger:"blur",
		                            validators: {
		                              
		                                notEmpty: {
		                                    message: '請輸入email'
		                                },
		                                remote: {
		                                    url: urlTarget,
		                                    delay: 1000,
		                                    type: "POST",
		                                    data: {
		                    					"action": "get_mail_check",
		                    					"mem_mail" : $(this).val(),
		                    				},
		                                    message: '該email已註冊',
		                    				
		                                },
		                                

									emailAddress : {
										message : '請提供有效的Email'
									}
								}
							},

						}
					});

					
					
					
					
					
				})
</script>
</html>