<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>
<!-- Header End====================================================================== -->
<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Products</li>
                </ul>
                <h3> Products Name
                    <small class="pull-right"> ${products.size()} products are available</small>
                </h3>
                <hr class="soft"/>
                <p>
                    ${category.name}
                    <c:if test="${not empty subCategory}"> / ${subCategory.name}</c:if>
                </p>
                <hr class="soft"/>
                <form class="form-horizontal span6">
                    <div class="control-group">
                        <label class="control-label alignL">Sort By </label>
                        <select>
                            <option>Product name A - Z</option>
                            <option>Product name Z - A</option>
                            <option>Price Biggest first</option>
                            <option>Price Lowest first</option>
                        </select>
                    </div>
                </form>

                <div id="myTab" class="pull-right">
                    <a href="#listView" data-toggle="tab">
                        <span class="btn btn-large">
                            <i class="icon-list"></i>
                        </span>
                    </a>
                    <a href="#blockView" data-toggle="tab">
                        <span class="btn btn-large btn-primary">
                            <i class="icon-th-large"></i>
                        </span>
                    </a>
                </div>
                <br class="clr"/>

                <div class="tab-content">
                    <div class="tab-pane  active" id="blockView">
                        <ul class="thumbnails">
                            <c:forEach var="product" items="${products}">
                                <li class="span3">
                                    <div class="thumbnail">
                                        <a href="/product_details?productId=${product.id}">
                                            <img src="/themes/images/products/${product.id}.png" alt="${product.name}"/>
                                        </a>
                                        <div class="caption">
                                            <h5>${product.name}</h5>
                                            <p>${product.name}</p>
                                            <h4 style="text-align:center">
                                                <a class="btn" href="/product_details?productId=${product.id}">
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
                        </ul>
                        <hr class="soft"/>
                    </div>

                    <div class="tab-pane" id="listView">
                        <c:forEach var="product" items="${products}">
                            <div class="row">
                                <div class="span2">
                                    <img src="/themes/images/products/${product.id}.png"
                                         alt="{product.name}"/>
                                </div>
                                <div class="span4">
                                    <h3>Available</h3>
                                    <hr class="soft"/>
                                    <h5>${product.name}</h5>
                                    <p>${product.description}</p>
                                    <a class="btn btn-small pull-right" href="/product_details?productId=${product.id}">View
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
                                        <a href="" class="btn btn-large btn-primary">
                                            Add to <i class=" icon-shopping-cart"></i>
                                        </a>
                                        <a href="/product_details?productId=${product.id}" class="btn btn-large">
                                            <i class="icon-zoom-in"></i>
                                        </a>
                                    </form>
                                </div>
                            </div>
                            <hr class="soft"/>
                        </c:forEach>
                    </div>

                </div>

                <a href="compair" class="btn btn-large pull-right">Compair Product</a>

                <div class="pagination">
                    <ul>
                        <li><a href="#">&lsaquo;</a></li>
                        <li><a href="#">1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">...</a></li>
                        <li><a href="#">10</a></li>
                        <li><a href="#">&rsaquo;</a></li>
                    </ul>
                </div>
                <br class="clr"/>
            </div>
        </div>
    </div>
</div>
<!-- MainBody End ================================================================================================== -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>