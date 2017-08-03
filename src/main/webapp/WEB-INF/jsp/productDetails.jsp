<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->
            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li><a href="/products">Products</a> <span class="divider">/</span></li>
                    <li class="active">Product Details</li>
                </ul>
                <div class="row">
                    <div id="gallery" class="span3">
                        <a href="/themes/images/products/large/${product.id}.jpg" title="${product.name}">
                            <img src="/themes/images/products/large/${product.id}.jpg" style="width:100%"
                                 alt="${product.name}"/>
                        </a>
                        <br/><br/>
                        <div id="differentview" class="moreOptopm carousel slide">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:30%" src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/>
                                    </a>
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:30%" src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/>
                                    </a>
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:30%" src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/>
                                    </a>
                                </div>
                                <div class="item">
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:29%"
                                             src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/></a>
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:29%"
                                             src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/></a>
                                    <a href="/themes/images/products/large/${product.id}.jpg">
                                        <img style="width:29%"
                                             src="/themes/images/products/large/${product.id}.jpg"
                                             alt=""/></a>
                                </div>
                            </div>
                            <!--
                            <a class="left carousel-control" href="#myCarousel" data-slide="prev">‹</a>
                            <a class="right carousel-control" href="#myCarousel" data-slide="next">›</a>
                            -->
                        </div>

                        <div class="btn-toolbar">
                            <div class="btn-group">
                                <span class="btn"><i class="icon-envelope"></i></span>
                                <span class="btn"><i class="icon-print"></i></span>
                                <span class="btn"><i class="icon-zoom-in"></i></span>
                                <span class="btn"><i class="icon-star"></i></span>
                                <span class="btn"><i class="icon-thumbs-up"></i></span>
                                <span class="btn"><i class="icon-thumbs-down"></i></span>
                            </div>
                        </div>
                    </div>
                    <div class="span6">
                        <h3>${product.name}</h3>
                        <small>${product.name}</small>
                        <hr class="soft"/>
                        <form class="form-horizontal qtyFrm" action="/shoppingCart/addProductWithQuantity"
                              method="post">
                            <div class="control-group">
                                <label class="control-label">&#8372 <span>${product.price / 100}</span></label>
                                <div class="controls">
                                    <input type="hidden" name="inputProductId" value="${product.id}"/>
                                    <input type="number" name="inputProductQuantity" class="span1" placeholder="Qty."/>
                                    <button type="submit" class="btn btn-large btn-primary pull-right">
                                        Add to cart <i class=" icon-shopping-cart"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <hr class="soft"/>
                        <h4>{888} items in stock</h4>
                        <hr class="soft clr"/>
                        <p>${product.description} </p>
                        <a class="btn btn-small pull-right" href="#detail">More Details</a>
                        <br class="clr"/>
                        <a href="#" name="detail"></a>
                        <hr class="soft"/>
                    </div>

                    <div class="span9">
                        <ul id="productDetail" class="nav nav-tabs">
                            <li class="active"><a href="#home" data-toggle="tab">Product Details</a></li>
                            <li><a href="#profile" data-toggle="tab">Related Products</a></li>
                        </ul>
                        <div id="myTabContent" class="tab-content">
                            <div class="tab-pane fade active in" id="home">
                                <h4>Product Information</h4>
                                <table class="table table-bordered">
                                    <tbody>
                                    <tr class="techSpecRow">
                                        <th colspan="2">Product Details</th>
                                    </tr>
                                    <tr class="techSpecRow">
                                        <td class="techSpecTD1">Бренд:</td>
                                        <td class="techSpecTD2">Barenbrug</td>
                                    </tr>
                                    <tr class="techSpecRow">
                                        <td class="techSpecTD1">Контейнер:</td>
                                        <td class="techSpecTD2">5л</td>
                                    </tr>
                                    <tr class="techSpecRow">
                                        <td class="techSpecTD1">Розмір:</td>
                                        <td class="techSpecTD2">300-320 см</td>
                                    </tr>
                                    <tr class="techSpecRow">
                                        <td class="techSpecTD1">Вирощено:</td>
                                        <td class="techSpecTD2">Україна</td>
                                    </tr>
                                    </tbody>
                                </table>

                                <h5>Features</h5>
                                <p>
                                    ${product.description}
                                </p>
                            </div>
                            <div class="tab-pane fade" id="profile">
                                <div id="myTab" class="pull-right">
                                    <a href="#listView" data-toggle="tab"><span class="btn btn-large"><i
                                            class="icon-list"></i></span></a>
                                    <a href="#blockView" data-toggle="tab"><span class="btn btn-large btn-primary"><i
                                            class="icon-th-large"></i></span></a>
                                </div>
                                <br class="clr"/>
                                <hr class="soft"/>
                                <div class="tab-content">
                                    <div class="tab-pane" id="listView">
                                        <jsp:include page="block/productListView.jsp"/>
                                    </div>
                                    <div class="tab-pane active" id="blockView">
                                        <ul class="thumbnails">
                                            <jsp:include page="block/productBlockView.jsp"/>
                                        </ul>
                                        <hr class="soft"/>
                                    </div>
                                </div>
                                <br class="clr">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- MainBody End ================================================================================================== -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>
