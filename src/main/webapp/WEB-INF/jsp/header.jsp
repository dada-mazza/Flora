<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Flora</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <!-- Google-code-prettify -->
    <link href="../../themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
    <!-- Flora style responsive -->
    <link href="../../themes/css/flora-bootstrap.css" rel="stylesheet" media="screen"/>
    <link href="../../themes/css/flora-bootstrap-responsive.css" rel="stylesheet"/>
    <link href="../../themes/css/base.css" rel="stylesheet" media="screen"/>

    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="../../themes/images/ico/flora.png"/>
    <link rel="apple-touch-icon" href="../../themes/images/ico/flora.png"/>
    <link rel="apple-touch-icon-precomposed" href="../../themes/images/ico/flora.png"/>

</head>
<body>
<div id="header">
    <div class="container">
        <div id="welcomeLine" class="row">
            <div class="span6">Welcome! <strong> ${user.firstName} ${user.lastName} </strong></div>
            <div class="span6">
                <div class="pull-right">
                    <span class="btn btn-mini totalAmountCart">
                        <c:choose>
                            <c:when test="${not empty cart}">${cart.totalAmount / 100}</c:when>
                            <c:otherwise>0</c:otherwise>
                        </c:choose>
                    </span>
                    <a href="product_summary."><span class="">&#8372</span></a>
                    <a href="product_summary">
                        <span class="btn btn-mini btn-primary">
                            <i class="icon-shopping-cart icon-white"></i>
                            <span class="totalItemsCart">
                            <c:choose>
                                <c:when test="${not empty cart}">[ ${cart.totalItems} ]</c:when>
                                <c:otherwise>[ 0 ]</c:otherwise>
                            </c:choose>
                         </span>
                            Itemes in your cart
                        </span>
                    </a>
                </div>
            </div>
        </div>
        <!-- Navbar ================================================================================================ -->
        <div id="logoArea" class="navbar">
            <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="navbar-inner">
                <a class="brand" href="/">
                    <img src="../../themes/images/logo/logo.png" alt="Flora"/>
                </a>
                <form class="form-inline navbar-search" method="post" action="products">
                    <input id="srchFld" class="srchTxt" type="text"/>
                    <select class="srchTxt">
                        <option>All</option>
                        <option>CATEGORY</option>
                        <option>CATEGORY</option>
                        <option>CATEGORY</option>
                    </select>
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <ul id="topMenu" class="nav pull-right">
                    <li class=""><a href="special_offer">Specials Offer</a></li>
                    <li class=""><a href="normal">Delivery</a></li>
                    <li class=""><a href="contact">Contact</a></li>

                    <!-- Login ==================================================================================== -->
                    <c:if test="${empty user}">
                        <li class="">
                            <a href="login">
                                <span class="btn btn-large btn-success">Login</span>
                            </a>
                        </li>
                    </c:if>
                    <c:if test="${not empty user}">
                        <li class="">
                            <a href="logout">
                                <span class="btn btn-large btn-success">Logout</span>
                            </a>
                        </li>
                    </c:if>
                    <!-- Login end ================================================================================= -->
                </ul>
            </div>
        </div>
    </div>
</div>