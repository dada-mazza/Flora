<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:choose>
    <c:when test="${empty user}">
        <li><a href="registration">Реєстрація</a></li>
        <li><a href="login">Вхід</a></li>
        <li><a href="cart">Кошик</a></li>
    </c:when>
    <c:otherwise>
        <li><a href="profile">Профіль</a></li>
        <li><a href="logout">Вихід</a></li>
        <li><a href="cart">Кошик</a></li>
    </c:otherwise>
</c:choose>
