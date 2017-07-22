<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${not empty user}">
    <c:redirect url="login"/>
</c:if>

<%@include file="header.jsp" %>

<c:choose>
    <c:when test="${not empty errorMessage}">
        <h1 class="error">${errorMessage}</h1>
    </c:when>
    <c:otherwise>
        <h1>Welcome Back!</h1>
    </c:otherwise>
</c:choose>


<form action="login" method="post">

    <div class="field-wrap">
        <div class="label">
            Email Address<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="email" name="email" value="${param.email}" required/>
    </div>

    <div class="field-wrap">
        <div class="label">
            Password<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="password" name="password" value="${param.password}" required/>
    </div>

    <p class="forgot"><a href="#">Forgot Password?</a></p>

    <button type="submit" class="button button-block"/>
    Sign In
    </button>
</form>


<%@include file="footer.jsp" %>
