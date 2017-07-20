<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<!--
Design by Free CSS Templates
http://www.freecsstemplates.org
Released for free under a Creative Commons Attribution 2.5 License

Name : Photoshoot
Description: A two-column, fixed-width design with dark color scheme.
Version : 1.0
Released : 20110926

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <title>Flora</title>
    <link rel="icon" href="images/ico/flora.png" type="image/png">
    <link href="css/PhotoshootStyle.css" rel="stylesheet" type="text/css" media="screen"/>
</head>
<body>
<div id="header" class="container">
    <div id="logo">
        <h1><a href="/">Flora</a></h1>
    </div>
    <div id="menu">
        <ul>
            <li class="current_page_item"><a href="/">Головна</a></li>
            <li><a href="products">Товари</a></li>
            <%@include file="menu.jsp" %>
        </ul>
    </div>
</div>
<!-- end #header -->
<div id="poptrox">
    <!-- start -->
    <ul id="gallery">
        <li><a href="images/header/chamomile_960x600.jpg">
            <img src="images/header/chamomile_210x130.jpg"
                 title="flower"
                 alt=""/>
        </a>
        </li>
        <li><a href="images/header/convalia_960x600.jpg">
            <img src="images/header/convalia_210x130.jpg"
                 title="flower"
                 alt=""/>
        </a>
        </li>
        <li><a href="images/header/glycine_960x600.jpg">
            <img src="images/header/glycine_210x130.jpg"
                 title="flower"
                 alt=""/>
        </a>
        </li>
        <li><a href="images/header/snowdrop_960x600.jpg">
            <img src="images/header/snowdrop_210x130.jpg"
                 title="flower"
                 alt=""/>
        </a>
        </li>
    </ul>
    <br class="clear"/>
    <!-- end -->
</div>
<div id="page">
    <div id="bg1">
        <div id="bg2">
            <div id="bg3">
                <div id="content">
