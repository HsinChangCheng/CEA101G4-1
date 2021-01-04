<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>backend-index</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="css/back-end/back-index-sidebar.css">
</head>
<style>
</style>

<body>
    <div id="wrapper">
        <%@ include file="/back-end/back-index-sidebar.jsp"%>
        <!-- 這邊是你原本sidebar的位置 -->
        <div id="page-content-wrapper">
            <br>
            <div>
                 <div class="container-fluid my-4">
                    <div class="row">
                        <div class="col-lg-3 col-6">
                            <div class="card h-100">
                                <div class="card-body d-flex justify-content-around align-items-center">
                                    <i class="far fa-money-bill-alt fa-3x text-secondary d-none d-sm-block"></i>
                                    <div class="text-center">
                                        <div class="h5">今日營收</div>
                                        <div class="h3">192,000</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-6">
                            <div class="card  h-100">
                                <div class="card-body d-flex justify-content-around align-items-center">
                                    <i class="fas fa-user fa-3x text-secondary d-none d-sm-block"></i>
                                    <div class="text-center">
                                        <div class="h5">會員增加</div>
                                        <div class="display-4">172</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-6">
                            <div class="card  h-100">
                                <div class="card-body d-flex justify-content-around align-items-center">
                                    <i class="fas fa-clipboard-list fa-3x text-secondary d-none d-sm-block"></i>
                                    <div class="text-center">
                                        <div class="h5">訂單數</div>
                                        <div class="display-4">320</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-6">
                            <div class="card  h-100">
                                <div class="card-body d-flex justify-content-around align-items-center">
                                    <i class="fas fa-box-open fa-3x text-secondary d-none d-sm-block"></i>
                                    <div class="text-center">
                                        <div class="h5">待出貨物</div>
                                        <div class="display-4">120</div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div><img id="tiger" src="<%=request.getContextPath()%>/image/back-index/透明的虎.png" alt="">
                <div>
                </div>
            </div>
            </div>
        </div>
    </div>
</body>

</html>