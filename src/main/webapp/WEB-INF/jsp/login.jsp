<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header ======================================================================================================== -->
<%@include file="header.jsp" %>
<!-- Header End ==================================================================================================== -->

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="categories.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Login</li>
                </ul>
                <h3> Login </h3>

                <c:if test="${not empty errorMessage}">
                    <div class="alert alert-block alert-error fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Error!</strong> ${errorMessage}
                    </div>
                </c:if>

                <c:if test="${not empty validator}">
                    <div class="alert alert-block alert-error fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <ul>
                            <c:forEach var="errorMessage" items="${validator.emailErrorMessages}">
                                <li><strong>Error!</strong> ${errorMessage}</li>
                            </c:forEach>
                        </ul>
                    </div>
                </c:if>

                <hr class="soft"/>

                <div class="row">
                    <!-- Register ================================================================================== -->
                    <div class="span4">
                        <div class="well">
                            <h5>CREATE YOUR ACCOUNT</h5><br/>
                            Enter your e-mail address to create an account.<br/><br/><br/>
                            <form action="/registration/email" method="post">
                                <div class="control-group">
                                    <label class="control-label" for="inputEmailRegistration">E-mail address</label>
                                    <div class="controls">
                                        <input
                                                class="span3"
                                                type="text"
                                                name="inputEmailRegistration"
                                                id="inputEmailRegistration"
                                                placeholder="Email"
                                                value="${param.inputEmailRegistration}"
                                                required
                                        >
                                    </div>
                                </div>
                                <div class="controls">
                                    <button class="btn block" type="submit" name="submit" value="Sign Up Email">Create
                                        Your
                                        Account
                                    </button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- Register end ============================================================================== -->

                    <div class="span1"> &nbsp;</div>

                    <!-- Login ===================================================================================== -->
                    <div class="span4">
                        <div class="well">
                            <h5>ALREADY REGISTERED ?</h5>
                            <form action="/login" method="post">
                                <div class="control-group">
                                    <label class="control-label" for="inputEmailLogin">Email</label>
                                    <div class="controls">
                                        <input
                                                class="span3"
                                                type="email"
                                                name="inputEmailLogin"
                                                id="inputEmailLogin"
                                                placeholder="Email"
                                                value="${param.inputEmailLogin}"
                                                required
                                        >
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="inputPasswordLogin">Password</label>
                                    <div class="controls">
                                        <input
                                                class="span3"
                                                type="password"
                                                name="inputPasswordLogin"
                                                id="inputPasswordLogin"
                                                placeholder="Password"
                                                value="${param.inputPasswordLogin}"
                                                required
                                        >
                                    </div>
                                </div>
                                <div class="control-group">
                                    <div class="controls">
                                        <button type="submit" name="submit" class="btn" value="Sign In">Sign In</button>
                                        <a href="forgotPassword">Forgot password?</a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- Login end ================================================================================= -->
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>