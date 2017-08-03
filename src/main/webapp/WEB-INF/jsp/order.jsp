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
                    <li class="active">Order</li>
                </ul>
                <h3> Замовлення </h3>
                <hr class="soft"/>

                <h4> Номер замовлення : ${order.number}</h4>
                <h5> Вартість замовлення : ${order.totalAmount / 100}</h5>

                <p>
                    Ми з'яжемося для уточнення деталей
                </p>

            </div>
        </div>
    </div>
</div>
<!-- MainBody End ============================= -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>