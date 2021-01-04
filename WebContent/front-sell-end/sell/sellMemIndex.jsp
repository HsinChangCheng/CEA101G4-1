<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>民宿會員首頁</title>
		
        <script
            src="https://cdnjs.cloudflare.com/ajax/libs/modernizr/2.8.3/modernizr.min.js"
            type="text/javascript"
        ></script>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
		<link rel="stylesheet"  href="https://cdnjs.cloudflare.com/ajax/libs/material-design-iconic-font/2.2.0/css/material-design-iconic-font.min.css" />
        <link rel="stylesheet" href="<%=request.getContextPath()%>/css/front-sell-end/front-sell-sideBar.css" />
        <style>
            .calendar thead tr td {
                font-weight: bold;
                color: DodgerBlue;
                font-size: 16px;
            }
            .calendar td {
                text-align: center;
                width: 50px;
                height: 35px;
                font-size: 14px;
            }
            .calendar .passedDate {
                background-color: #ccc;
            }

            .calendar a .panel-heading {
                background-color: #f5f5f5;
            }
            .calendar a:hover,
            .calendar a:focus {
                text-decoration: none;
            }
            .calendarCol {
                border-radius: 10px;
                box-shadow: 3px 3px 5px #ccc;
            }
        </style>
    </head>
    <body>
        <div id="viewport">
            <%@ include file="/front-sell-end/sellMemSideBar.jsp"%>
            <div id="content">
                <%@ include file="/front-sell-end/sellNavBar.jsp"%>
                <div class="container-fluid">
                    <div class="container">
                        <div class="row">
                            <div class="col calendarCol">
                                <form>
                                    <select id="yearList" name="calendarYear"></select>
                                    <select id="monthList" name="calendarMonth">
                                        <option value="0">JAN</option>
                                        <option value="1">FEB</option>
                                        <option value="2">MAR</option>
                                        <option value="3">APR</option>
                                        <option value="4">MAY</option>
                                        <option value="5">JUN</option>
                                        <option value="6">JUL</option>
                                        <option value="7">AUG</option>
                                        <option value="8">SEP</option>
                                        <option value="9">OCT</option>
                                        <option value="10">NOV</option>
                                        <option value="11">DEC</option>
                                    </select>
                                </form>
                                <table class="calendar">
                                    <thead>
                                        <tr>
                                            <td>SUN</td>
                                            <td>MON</td>
                                            <td>TUE</td>
                                            <td>WED</td>
                                            <td>THU</td>
                                            <td>FRI</td>
                                            <td>SAT</td>
                                        </tr>
                                    </thead>
                                    <tbody></tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
        <script>
            function isLeapYear(year) {
                // 西元年份除以4不可整除，為平年。
                // 西元年份除以4可整除，且除以100不可整除，為閏年。
                // 西元年份除以100可整除，且除以400不可整除，為平年
                // 西元年份除以400可整除，為閏年。
                if (year % 4 !== 0) {
                    return false
                } else if (year % 400 === 0) {
                    return true
                } else if (year % 100 === 0) {
                    return false
                } else {
                    return true
                }
            }

            let delCal = function (firstDateOfMonth, callback) {
                $('tbody').html('')
                callback(firstDateOfMonth)
            }

            Date.prototype.yyyymmdd = function () {
                var mm = this.getMonth() + 1 // getMonth is zero-based
                var dd = this.getDate()

                return [this.getFullYear(), (mm > 9 ? '' : '0') + mm, (dd > 9 ? '' : '0') + dd].join('-')
            }

            let isPassedDate = function (compareDate) {
                let today = new Date()
                if (compareDate.getFullYear() < today.getFullYear()) {
                    return true
                }

                if (compareDate.getFullYear() === today.getFullYear() && compareDate.getMonth() < today.getMonth()) {
                    return true
                }

                if (
                    compareDate.getFullYear() === today.getFullYear() &&
                    compareDate.getMonth() === today.getMonth() &&
                    compareDate.getDate() < today.getDate()
                ) {
                    return true
                }

                return false
            }

            let drawCal = function (firstDateOfMonth) {
                let monthDays = [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
                let tr, td
                let startFrom = firstDateOfMonth.getDay()

                let day = 0
                let i = 0
                let selectedMonthDays = monthDays[firstDateOfMonth.getMonth()]

                // 判斷閏年2月
                if (firstDateOfMonth.getMonth() === 1) {
                    if (isLeapYear(firstDateOfMonth.getFullYear())) {
                        selectedMonthDays = 29
                    }
                }

                let tb = document.getElementsByTagName('tbody')[0]
                // 迴圈停止條件: 該行滿7格，且日期已填完
                while (day < selectedMonthDays || i % 7 !== 0) {
                    tr = document.createElement('tr')
                    for (let j = 0; j < 7; j++) {
                        td = document.createElement('td')
                        if (i >= startFrom && day < selectedMonthDays) {
                            day++
                            td.innerText = day.toString()
                            let setDate = new Date(firstDateOfMonth.getFullYear(), firstDateOfMonth.getMonth(), day)
                            td.setAttribute('value', setDate.yyyymmdd())
                            if (isPassedDate(setDate)) td.classList.add('passedDate')
                        }
                        tr.appendChild(td)
                        i++
                    }
                    tb.appendChild(tr)
                }
            }

            $(document).ready(function () {
                let monthList = document.getElementById('monthList')
                let changeMonth = function () {
                    delCal(new Date(yearList.value, monthList.value, 1), drawCal)
                }

                $('#yearList').change(changeMonth)
                monthList.addEventListener('change', changeMonth)
                let today = new Date()

                for (let i = 1971; i <= 2050; i++) {
                    let option = document.createElement('option')
                    yearList.appendChild(option)
                    option.value = i
                    option.innerText = i
                    if (i === today.getFullYear()) option.selected = true
                }

                let monOptions = monthList.getElementsByTagName('option')
                for (let i = 0; i < monOptions.length; i++) {
                    if (monOptions[i].value === today.getMonth().toString()) monOptions[i].selected = true
                }
                drawCal(new Date(today.getFullYear(), today.getMonth(), 1))
            })
        </script>
    </body>
</html>
