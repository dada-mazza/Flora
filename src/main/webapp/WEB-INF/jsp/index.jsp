<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<%@include file="carousel.jsp" %>

<div id="mainBody">
    <div class="container">
        <div class="row">

            <%--   <jsp:include page="/categories"/> --%>
            <jsp:include page="products.jsp"/>

        </div>
    </div>
</div>

<%@include file="footer.jsp" %>