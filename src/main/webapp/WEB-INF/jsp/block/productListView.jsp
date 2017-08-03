<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:forEach var="product" items="${products}">
    <div class="row">
        <div class="span2">
            <img src="/themes/images/products/${product.id}.png"
                 alt="{product.name}"/>
        </div>
        <div class="span4">
            <h3>New | Available</h3>
            <hr class="soft"/>
            <h5>${product.name}</h5>
            <p>${product.name}</p>
            <a class="btn btn-small pull-right" href="/productDetails?productId=${product.id}">View
                Details</a>
            <br class="clr"/>
        </div>
        <div class="span3 alignR">
            <form class="form-horizontal qtyFrm">
                <h3> &#8372 ${product.price / 100}</h3>
                <label class="checkbox">
                    <input type="checkbox"> Adds product to compair
                </label>
                <br/>
                <a href="/shoppingCart/addProduct?productId=${product.id}"
                   class="btn btn-large btn-primary">
                    Add to <i class=" icon-shopping-cart"></i>
                </a>
                <a href="/productDetails?productId=${product.id}" class="btn btn-large">
                    <i class="icon-zoom-in"></i>
                </a>
            </form>
        </div>
    </div>
    <hr class="soft"/>
</c:forEach>