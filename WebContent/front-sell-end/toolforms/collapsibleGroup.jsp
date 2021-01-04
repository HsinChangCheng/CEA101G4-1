<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<c:if test="${not empty errorMsgs}">
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-lg-offset-2">
                <div class="page-header">
                    <h2>Using with Bootstrap Collapse</h2>
                </div>
                <div class="panel-group" id="steps">
                    <!-- Step 1 -->
                    <div class="panel panel-default">
                        <a data-toggle="collapse" href="#step1">
                            <div class="panel-heading">
                                <h4 class="panel-title">Account</h4>
                            </div>
                        </a>
                        <div id="step1" class="panel-collapse collapse">
                            <div class="panel-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
                        </div>
                    </div>
                    <!-- Step 2 -->
                    <div class="panel panel-default">
                        <a data-toggle="collapse" href="#step2">
                            <div class="panel-heading">
                                <h4 class="panel-title">Account</h4>
                            </div>
                        </a>
                        <div id="step2" class="panel-collapse collapse">
                            <div class="panel-body">
                                Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
                                tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
                                quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
                                consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
                                cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
                                proident, sunt in culpa qui officia deserunt mollit anim id est laborum.
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	</c:if>