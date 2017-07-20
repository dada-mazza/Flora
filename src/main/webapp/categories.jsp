<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<jsp:useBean id="categoriesBean" class="ua.itea.beans.CategoriesBean"/>

<li><a href="products.jsp">Всі</a></li>

<c:forEach var="category" items="${categoriesBean.categories}">

    <li><a href="products.jsp?categoryId=${category.id}">${category.name}</a></li>

</c:forEach>

