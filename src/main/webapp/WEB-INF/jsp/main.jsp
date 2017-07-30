<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<%@include file="carousel.jsp" %>

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="/categories"/>
            <!-- Sidebar end ======================================================================================= -->

            <jsp:include page="featuredProducts.jsp"/>

        </div>
    </div>
</div>

<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>
