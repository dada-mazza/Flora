<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="product" items="${products}">
    <li class="span3">
        <div class="thumbnail">
            <a href="/productDetails?productId=${product.id}">
                <img src="/themes/images/products/${product.id}.png" alt="${product.name}"/>
            </a>
            <div class="caption">
                <h5>${product.name}</h5>
                <p>${product.name}</p>
                <h4 style="text-align:center">
                    <a class="btn" href="/productDetails?productId=${product.id}">
                        <i class="icon-zoom-in"></i>
                    </a>
                    <a class="btn" href="">
                        Add to <i class="icon-shopping-cart">
                        <div class="hide product">
                            <div class="productId">${product.id}</div>
                            <div class="productName">${product.name}</div>
                            <div class="productPrice">${product.price}</div>
                        </div>
                    </i>
                    </a>
                    <a class="btn btn-primary"
                       href="/shoppingCart/product?productId=${product.id}">
                        &#8372 ${product.price / 100}
                    </a>
                </h4>
            </div>
        </div>
    </li>
</c:forEach>