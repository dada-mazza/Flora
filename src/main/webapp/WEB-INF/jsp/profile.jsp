<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>
<!-- Header End====================================================================== -->
<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9" id="mainCol">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Profile</li>
                </ul>
                <h3> Profile </h3>
                <hr class="soft"/>

                <div class="span6">
                    <div class="well" style="padding: 8px 0;">
                        <ul class="nav nav-list">
                            <li class="nav-header">Menu</li>
                            <li class="active">
                                <a href="/">
                                    <i class="icon-white icon-home"></i>
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="/shoppingCart">
                                    <i class="icon-shopping-cart"></i>
                                    Shopping Cart
                                </a>
                            </li>
                            <li>
                                <a href="/orders">
                                    <i class="icon-briefcase"></i>
                                    My Orders
                                </a>
                            </li>
                            <li>
                                <a href="/wishList">
                                    <i class="icon-star"></i>
                                    Wish List
                                </a>
                            </li>

                            <li class="nav-header">Profile</li>
                            <li>
                                <a href="/personalData">
                                    <i class="icon-user"></i>
                                    Personal Data
                                </a>
                            </li>
                            <li>
                                <a href="/changePassword">
                                    <i class="icon-lock"></i>
                                    Change Password
                                </a>
                            </li>
                            <li>
                                <a href="/settings">
                                    <i class="icon-cog"></i>
                                    Settings
                                </a>
                            </li>
                            <li>
                                <a href="/logout">
                                    <i class="icon-warning-sign"></i>
                                    Log Out
                                </a>
                            </li>
                            <li class="divider"></li>
                            <li>
                                <a href="/help">
                                    <i class="icon-flag"></i>
                                    Help
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>