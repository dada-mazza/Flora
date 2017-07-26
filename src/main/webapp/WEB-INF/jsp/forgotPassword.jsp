<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header ======================================================================================================== -->
<%@include file="header.jsp" %>
<!-- Header End ==================================================================================================== -->

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="/categories"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Forgot password</li>
                </ul>
                <h3> FORGOT YOUR PASSWORD? </h3>
                <hr class="soft"/>

                <div class="row">
                    <!-- retrieve password ========================================================================= -->
                    <div class="span9">
                        <div class="well">
                            <h5>Reset your password</h5><br/>
                            Please enter the email address for your account. A verification code will be sent to you.
                            Once you have received the verification code, you will be able to choose a new password for
                            your account.<br/><br/><br/>
                            <form action="forgotPassword">
                                <div class="control-group">
                                    <label class="control-label" for="inputEmail1">E-mail address</label>
                                    <div class="controls">
                                        <input class="span3" type="text" id="inputEmail1" placeholder="Email">
                                    </div>
                                </div>
                                <div class="controls">
                                    <button type="submit" class="btn block">Submit</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- retrieve password end ===================================================================== -->
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>