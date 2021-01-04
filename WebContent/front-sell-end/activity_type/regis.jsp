<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.member.model.*"%>
<%
	MemberVO memVO = (MemberVO) request.getAttribute("memVO");
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<!--  index -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<!--   <link rel="stylesheet" type="text/css" href="css/style.css"> -->
<!--   enroll -->
<link rel="apple-touch-icon" type="image/png"
	href="https://cpwebassets.codepen.io/assets/favicon/apple-touch-icon-5ae1a0698dcc2402e9712f7d01ed509a57814f994c660df9f7a952f3060705ee.png" />
<meta name="apple-mobile-web-app-title" content="CodePen">
<link rel="shortcut icon" type="image/x-icon"
	href="<%=request.getContextPath()%>/image/LOGO/tiger.png" />
<link rel="mask-icon" type=""
	href="https://cpwebassets.codepen.io/assets/favicon/logo-pin-8f3771b1072e3c38bd662872f6b673a722f4b3ca2421637d5596661b4e2132cc.svg"
	color="#111" />
<title>註冊加入會員</title>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
	type="text/javascript"></script>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css'>
<link rel='stylesheet'
	href='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css'>
<link rel='stylesheet'
	href='https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css'>
<style>
#success_message {
	display: none;
}

#enroll {
	font-size: 28px;
}

.container {
	border: 1px, solid;
}

.container:hover {
	opacity: 1;
}

#btn {
	text-align: center;
}
</style>
<script>
	window.console = window.console || function(t) {
	};
</script>
<script>
	if (document.location.search.match(/type=embed/gi)) {
		window.parent.postMessage("resize", "*");
	}
</script>
</head>

<body>
<body translate="no">
	<div class="container">
		<form class="well form-horizontal" METHOD="post"
			ACTION="<%=request.getContextPath()%>/member/member.do" name="form1"
			id="contact_form">
			<fieldset id="test">
				<!-- Form Name -->
				<legend align="center" id="enroll">會員註冊</legend>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">帳號</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon glyphicon-user"></i> </i></span> <input
								name="mem_account" placeholder="帳號" class="form-control"
								type="text">
						</div>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">密碼</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-lock"></i> </i></span> <input name="mem_pwd"
								placeholder="密碼8~12碼" class="form-control" type="password">
						</div>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">名字</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-user"></i></span> <input name="mem_name"
								placeholder="名字" class="form-control" type="text">
						</div>
					</div>
				</div>
				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">生日</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-gift"></i></span> <input name="mem_birth"
								placeholder="2000/01/01" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">連絡電話</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-earphone"></i></span> <input name="mem_tel"
								placeholder="0900-000-000" class="form-control" type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<div class="form-group">
					<label class="col-md-4 control-label">聯絡地址</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon-home"></i></span> <input name="mem_address"
								placeholder="住址" class="form-control" type="text">
						</div>
					</div>
				</div>
				<!-- Text input-->
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
					<label class="col-md-4 control-label">身分證字號</label>
					<div class="col-md-4 inputGroupContainer">
						<div class="input-group">
							<span class="input-group-addon"><i
								class="glyphicon glyphicon glyphicon-user"></i> </i></span> <input
								name="mem_id_number" placeholder="身分證字號" class="form-control"
								type="text">
						</div>
					</div>
				</div>

				<!-- Text input-->
				<!-- radio checks -->
				<div class="form-group">
					<label class="col-md-4 control-label">性別</label>
					<div class="col-md-4">
						<div class="radio">
							<label> <input type="radio" name="mem_gender" value="0" />
								男
							</label> <label> <input type="radio" name="mem_gender" value="1" />
								女
							</label>
						</div>
					</div>
					<!-- Success message -->
					<div class="alert alert-success" role="alert" id="success_message">
						註冊成功 <i class="glyphicon glyphicon-thumbs-up"></i> 謝謝您的註冊
					</div>
					<!-- Button -->
					<div class="form-group">
						<label class="col-md-4 control-label"></label> <input
							type="hidden" name="action" value="insert"> <input
							type="hidden" name="mem_acc_status" value="1">
						<div class="col-md-4">
							<button type="submit" class="btn btn-warning">
								送出 <span class="glyphicon glyphicon-send"></span>
							</button>
						</div>
					</div>
			</fieldset>
		</form>
	</div>
	</div>
	<!-- /.container -->
	<script
		src="https://cpwebassets.codepen.io/assets/common/stopExecutionOnTimeout-157cd5b220a5c80d4ff8e0e70ac069bffd87a61252088146915e8726e5d9f147.js"></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script
		src='https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js'></script>
	<script
		src='https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js'></script>
	<script id="rendered-js">
		$(document).ready(
				function() {
					$('#contact_form').bootstrapValidator({
						// To use feedback icons, ensure that you use Bootstrap v3.1.0 or later
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},

						fields : {
							mem_account : {
								validators : {
									stringLength : {
										min : 8
									},

									notEmpty : {
										message : '請輸入帳號,且長度要超過8'
									}
								}
							},

							mem_pwd : {
								validators : {
									stringLength : {
										min : 8
									},

									notEmpty : {
										message : '請輸入密碼，有效長度至少為8'
									}
								}
							},

							mem_name : {
								validators : {
									stringLength : {
										min : 6
									},

									notEmpty : {
										message : '有名子嗎?'
									}
								}
							},

							mem_birth : {
								validators : {
									stringLength : {
										min : 10
									},

									notEmpty : {
										message : '請輸入您的生日'
									}
								}
							},
							mem_tel : {
								validators : {
									notEmpty : {
										message : '請輸入您的連絡電話'
									},

									phone : {
										country : '台灣',
										message : '請提供有效的聯絡電話'
									}
								}
							},
							mem_address : {
								validators : {
									stringLength : {
										min : 8
									},

									notEmpty : {
										message : '請輸入您的地址'
									}
								}
							},

							mem_mail : {
								validators : {
									notEmpty : {
										message : '請輸入您的Email'
									},

									emailAddress : {
										message : '請提供有效的Email'
									}
								}
							},
							mem_id_number : {
								validators : {
									stringLength : {
										min : 10
									},

									notEmpty : {
										message : '請輸入身分證字號'
									}
								}
							},
							mem_id_number : {
								validators : {
									stringLength : {
										min : 10,
										max : 10,
									},

									notEmpty : {
										message : '請輸入身分證字號'
									}
								}
							},

							mem_gender : {
								validators : {
									notEmpty : {
										message : '請選擇性別'
									}
								}
							},
						}
					}).

					on(
							'success.form.bv',
							function(e) {
								$('#success_message').slideDown({
									opacity : "show"
								}, "slow"); // Do something ...
								$('#contact_form').data('bootstrapValidator')
										.resetForm();

								// Prevent form submission
								e.preventDefault();

								// Get the form instance
								var $form = $(e.target);

								// Get the BootstrapValidator instance
								var bv = $form.data('bootstrapValidator');

								// Use Ajax to submit form data
								$.post($form.attr('action'), $form.serialize(),
										function(result) {
											console.log(result);
										}, 'json');
							});
				});
		//# sourceURL=pen.js
	</script>
</body>

</html>