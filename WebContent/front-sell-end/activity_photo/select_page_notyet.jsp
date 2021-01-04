<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/sell_man.css">
    <!-- css boo-->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- js boo-->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<style>
    body {
            background-color: #E5E5E5;
        }
        /*上排*/
        #header {
            background: #E5E5E5;

            z-index: 1;
            height: 50px;
            width: 100%;
            position: fixed;
            top: 0;
            left: 0;
            margin-left: 188px;
            border-bottom: 2px groove #888;




        }


        /*上排超連結*/
        #header a {
            text-decoration: none;
            margin: 10px 10px;
        }

        /*左上圖標*/
        .sidebar .icon {
            position: fixed;
            top: 10px;
            left: 0.9%;
        }

        /*左排*/
        .sidebar {
            width: 188px;
            border-right: 1.5px solid #888;
            background-color:

        }

        /*bar 文字*/
        a {
            color: #818181;
        }

        /*點擊後改變顏色*/
        .nav-pills .nav-link.active, .nav-pills .show>.nav-link {
            color: #fff;
            background-color: #666;
        }

        /* 上bar 與下面的距離 */
        .mb-3, .my-3 {
            margin-bottom: 1rem !important;
        }


        /* 點取框框的弧度 */
        .nav-pills .nav-link {
            border-radius: .50rem;
        }

        /* 上bar 文字大小 */
        .sidebar li a {
            font-size: 3px;
        }
</style>

<body>
    <div id="mySidebar" class="sidebar">
        <a href="#" title="">
            <h2 class="icon">Super&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; Going</h2>
        </a>
        <br>
        <br>
        <br>
        <div class="nav flex-column nav-pills" id="v-pills-tab" role="tablist" aria-orientation="vertical">
            <a class="nav-link active" id="v-pills-home-tab" data-toggle="pill" href="#v-pills-home" role="tab" aria-controls="v-pills-home" aria-selected="true">活動管理</a>
            <a class="nav-link" id="v-pills-profile-tab" data-toggle="pill" href="#v-pills-profile" role="tab" aria-controls="v-pills-profile" aria-selected="false">週期管理</a>
            <a class="nav-link" id="v-pills-messages-tab" data-toggle="pill" href="#v-pills-messages" role="tab" aria-controls="v-pills-messages" aria-selected="false">活動訂單管理</a>
            <a class="nav-link" id="v-pills-settings-tab" data-toggle="pill" href="#v-pills-settings" role="tab" aria-controls="v-pills-settings" aria-selected="false">Settings</a>
            <ul>
                <li>
                    <FORM METHOD="post" ACTION="emp.do">
                        <b>選擇員工姓名:</b>
                        <select size="1" name="empno">
                            <c:forEach var="empVO" items="${empSvc.all}">
                                <option value="${empVO.empno}">${empVO.ename}
                            </c:forEach>
                        </select>
                        <input type="hidden" name="action" value="getOne_For_Display">
                        <input type="submit" value="送出">
                    </FORM>
                </li>
            </ul>
        </div>
        <div class="tab-content" id="v-pills-tabContent">
            <div class="tab-pane fade show active" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab">
                <!-- sidebar第一個 特產管理-->
                <div id=header>
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#pills-home" role="tab" aria-controls="pills-home" aria-selected="true">全部活動</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#pills-profile" role="tab" aria-controls="pills-profile" aria-selected="false">已上架活動</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-contact" role="tab" aria-controls="pills-contact" aria-selected="false">下架活動</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#pills-sell" role="tab" aria-controls="pills-sell" aria-selected="false">你是不是在哭</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="pills-tabContent">
                        <!-- 全部活動 -->
                        <!-- 加上滾輪自動滾 overflow -->
                        <div style="width:85.5%;height:500px;overflow:auto;" class="tab-pane fade show active" id="pills-home" role="tabpanel" aria-labelledby="pills-home-tab">
                            全部活動
                        </div>
                        <!-- 已上架特產 -->
                        <div class="tab-pane fade" id="pills-profile" role="tabpanel" aria-labelledby="pills-profile-tab">已上架活動</div>
                        <!-- 已下架特產 -->
                        <div class="tab-pane fade" id="pills-contact" role="tabpanel" aria-labelledby="pills-contact-tab">以下假活動</div>
                        <!-- 備用頁面 -->
                        <div class="tab-pane fade" id="pills-sell" role="tabpanel" aria-labelledby="pills-sell-tab">備用頁面 </div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-profile" role="tabpanel" aria-labelledby="v-pills-profile-tab">
                <!-- sidebar第二個 活動周期管理 -->
                <div id=header>
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#all_soudis" role="tab" aria-controls="all_soudis" aria-selected="true">活動週期設定</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#man_soudis" role="tab" aria-controls="man_soudis" aria-selected="false">待加入</a>
                        </li>
                        <li class="nav-item">
                            <!-- 備用格2 -->
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#spare2" role="tab" aria-controls="spare2" aria-selected="false">XXXXXXX</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="pills-tabContent">
                        <!-- 全部活動週期設定 -->
                        <div class="tab-pane fade show active" id="all_soudis" role="tabpanel" aria-labelledby="all_soudis-tab">活動週期設定的include</div>
                        <!-- 促銷商品管理 -->
                        <div class="tab-pane fade" id="man_soudis" role="tabpanel" aria-labelledby="man_soudis-tab">備用頁面.</div>
                        <!-- 備用格2 -->
                        <div class="tab-pane fade" id="spare2" role="tabpanel" aria-labelledby="spare2-tab">備用頁面</div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab">
                <!-- sidebar第三個 特產訂單管理 -->
                <div id=header>
                    <ul class="nav nav-pills mb-3" id="pills-tab" role="tablist">
                        <li class="nav-item">
                            <a class="nav-link active" id="pills-home-tab" data-toggle="pill" href="#s-order" role="tab" aria-controls="s-order" aria-selected="true">活動訂單</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-profile-tab" data-toggle="pill" href="#order_detail" role="tab" aria-controls="order_detail" aria-selected="false">活動明細</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#soudis_detail" role="tab" aria-controls="soudis_detail" aria-selected="false">活動訂單狀態</a>
                        </li>
                        <!-- 備用格 -->
                        <li class="nav-item">
                            <a class="nav-link" id="pills-contact-tab" data-toggle="pill" href="#spare" role="tab" aria-controls="spare
" aria-selected="false">XXXXXXX</a>
                        </li>
                    </ul>
                    <div class="tab-content" id="pills-tabContent">
                        <!-- 特產訂單頁面 -->
                        <div class="tab-pane fade show active" id="s-order" role="tabpanel" aria-labelledby="s-order-tab">Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod333333333333
                            tempor incididunt ut labore et it anim id est laborum.</div>
                        <!-- 一般特產明細頁面 -->
                        <div class="tab-pane fade" id="order_detail" role="tabpanel" aria-labelledby="order_detail-tab">第二r sint occaecat cupidatat non
                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                        <!-- 促銷特產明細頁面 -->
                        <div class="tab-pane fade" id="soudis_detail" role="tabpanel" aria-labelledby="soudis_detail-tab">第lum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</div>
                        <div class="tab-pane fade" id="spare" role="tabpanel" aria-labelledby="spare-tab">備用頁面</div>
                    </div>
                </div>
            </div>
            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab">
                <!-- sidebar第四個 -->
            </div>
        </div>
    </div>
    <div id="main">
    </div>
    <script>
    </script>
    <a href="#" id="login"> 員工登入/登出 </a>
    <!--裝飾用backSidebar-->
</body>


</html>