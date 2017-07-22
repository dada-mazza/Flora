<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${empty user}">
    <c:redirect url="logout"/>
</c:if>

<%@include file="header.jsp" %>

<h1>Ви хочете нас покинути?</h1>

<form action="logout" method="post">

    <button type="submit" name="SignOutAction" class="button button-block" value="yes"/>
    Так
    </button>

    <button type="submit" name="SignOutAction" class="button button-block" value="no"/>
    Ні
    </button>

</form>

<%@include file="footer.jsp" %>
