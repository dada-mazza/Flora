<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<sidebar id="sidebar" class="span3">
    <div class="well well-small">
        <a id="myCart" href="/shoppingCart">
            <img src="../../themes/images/ico-cart.png" alt="cart">
            <span class="totalItemsCart">
                <c:choose>
                    <c:when test="${not empty cart}">[ ${cart.totalItems} ]</c:when>
                    <c:otherwise>0</c:otherwise>
                </c:choose>
            </span>
            Items in your cart
            <span class="badge badge-warning pull-right">
                <span> &#8372 </span>
                 <span class="totalAmountCart">
                        <c:choose>
                            <c:when test="${not empty cart}">${cart.totalAmount / 100}</c:when>
                            <c:otherwise>0</c:otherwise>
                        </c:choose>
                    </span>
            </span>
        </a>
    </div>
    <ul id="sideManu" class="nav nav-tabs nav-stacked">

        <c:forEach var="category" items="${categories}">
            <li class="subMenu">
                <a> ${category.name} [${category.numberOfItems}]</a>
                <ul class="hide">
                    <li>
                        <a class="active" href="/products/category?category=${category.id}">
                            <i class="icon-chevron-right"></i>All (${category.numberOfItems})
                        </a>
                    </li>
                    <c:forEach var="subCategory" items="${category.subCategories}">
                        <li>
                            <a href="/products/subCategory?category=${category.id}&subCategory=${subCategory.id}">
                                <i class="icon-chevron-right"></i>${subCategory.name} (${subCategory.numberOfItems})
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </li>
        </c:forEach>

    </ul>
    <br/>
    <div class="thumbnail">
        <img src="../../themes/images/example/products/14.png" title="Flora New Plant" alt="Flora New Plant"/>
        <div class="caption">
            <h5>Plant</h5>
            <h4 style="text-align:center">
                <a class="btn" href="/productDetails?productId={product.id}">
                    <i class="icon-zoom-in"></i>
                </a>
                <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i>
                </a>
                <a class="btn btn-primary" href="#">{999}</a>
            </h4>
        </div>
    </div>
    <br/>
    <div class="thumbnail">
        <img src="../../themes/images/example/products/15.png" title="Flora New Plant" alt="Flora New Plant"/>
        <div class="caption">
            <h5>Plant</h5>
            <h4 style="text-align:center">
                <a class="btn" href="/productDetails?productId={product.id}">
                    <i class="icon-zoom-in"></i>
                </a>
                <a class="btn" href="#">
                    Add to <i class="icon-shopping-cart"></i>
                </a>
                <a class="btn btn-primary" href="#">{999}</a>
            </h4>
        </div>
    </div>
    <br/>

    <div class="thumbnail">
        <img src="../../themes/images/payment_methods.png" title="Flora Payment Methods"
             alt="Payments Methods">
        <div class="caption">
            <h5>Payment Methods</h5>
        </div>
    </div>
</sidebar>