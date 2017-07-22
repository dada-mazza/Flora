<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<link href="../css/product.css" rel="stylesheet" type="text/css"/>

<jsp:useBean id="productsBean" class="ua.itea.beans.ProductsBean">
    <jsp:setProperty name="productsBean" property="categoryId" value="${param.categoryId}"/>
</jsp:useBean>


<c:forEach var="product" items="${productsBean.products}">
    <table class="product">
        <tr>
            <th>
                    ${product.name}
            </th>
        </tr>
        <tr>
            <td>
                <a href="images/products/${product.id}.jpg">
                    <img src="images/products/${product.id}.jpg" alt="${product.name}">
                </a>
            </td>
            <td class="description">
                    ${product.description}
            </td>
        </tr>
        <tr>
            <td>
                    ${product.price / 100} &#8372
            </td>
            <td>
                <button>Купити</button>
            </td>
        </tr>
    </table>
    <br/>
</c:forEach>

<%@include file="footer.jsp" %>
