<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header ======================================================================================================== -->
<%@include file="header.jsp" %>
<!-- Header End ==================================================================================================== -->

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Change Password</li>
                </ul>
                <h3> Change Password</h3>
                <div class="well">

                    <%--
                    <div class="alert alert-info fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                    <div class="alert fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                     <div class="alert alert-block alert-error fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                    --%>

                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-block alert-error fade in">
                            <button type="button" class="close" data-dismiss="alert">×</button>
                            <strong>Error!</strong> ${errorMessage}
                        </div>
                    </c:if>

                    <form class="form-horizontal" action="/changePassword" method="post">
                        <h4>Your personal information</h4>

                        <%-- password --%>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                            <div class="controls">
                                <input type="email" id="inputEmail" placeholder="Email" required readonly
                                       value="${user.email}"
                                />
                            </div>
                        </div>

                        <%-- password --%>
                        <div class="control-group">
                            <label class="control-label" for="inputPassword">Password <sup>*</sup></label>
                            <div class="controls">
                                <input type="password" name="inputPassword" id="inputPassword" placeholder="Password"
                                       required value=""/>
                            </div>
                        </div>

                        <c:if test="${not empty validator.passwordErrorMessages}">
                            <div class=" alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.passwordErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- confirm password --%>
                        <div class="control-group">
                            <label class="control-label" for="inputConfirmPassword">Confirm Password
                                <sup>*</sup></label>
                            <div class="controls">
                                <input type="password" name="inputConfirmPassword" id="inputConfirmPassword"
                                       placeholder="Confirm Password" required value=""/>
                            </div>
                        </div>

                        <c:if test="${not empty validator.confirmPasswordErrorMessages}">
                            <div class=" alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.confirmPasswordErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <p><sup>*</sup>Required field </p>

                        <div class="control-group">
                            <div class="controls">
                                <input type="hidden" name="email">
                                <input class="btn btn-large btn-success" type="submit" name="submit"
                                       value="Change Password"/>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</div>

<!-- Footer ======================================================================================================== -->
<script src="../../themes/js/registration.js" type="text/javascript"></script>
<%@include file="footer.jsp" %>


