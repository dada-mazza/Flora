<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div class="span9">
    <div class="well well-small">
        <h4>Featured Products
            <small class="pull-right">200+ featured products</small>
        </h4>
        <div class="row-fluid">
            <div id="featured" class="carousel slide">
                <div class="carousel-inner">
                    <c:forEach var="img" begin="1" end="4">
                        <div class="item  <c:if test="${img == 1}">active</c:if>">
                            <ul class="thumbnails">
                                <c:forEach var="img" begin="1" end="4">
                                    <li class="span3">
                                        <div class="thumbnail">
                                            <i class="tag"></i>
                                            <a href="/product_details?productId={product.id}">
                                                <img src="/themes/images/example/products/b${img}.png" alt="">
                                            </a>
                                            <div class="caption">
                                                <h5>Product name</h5>
                                                <h4>
                                                    <a class="btn"
                                                       href="/product_details?productId={product.id}">VIEW</a>
                                                    <span class="pull-right">$222.00</span>
                                                </h4>
                                            </div>
                                        </div>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </c:forEach>
                </div>
                <a class="left carousel-control" href="#featured" data-slide="prev">‹</a>
                <a class="right carousel-control" href="#featured" data-slide="next">›</a>
            </div>
        </div>
    </div>
    <%-- Latest Product =========================================================================================== --%>
    <h4>Latest Products </h4>
    <ul class="thumbnails">
        <c:forEach var="img" begin="1" end="12">
            <li class="span3">
                <div class="thumbnail">
                    <a href="/product_details?productId={product.id}">
                        <img src="/themes/images/example/products/f${img}.jpg" alt=""/>
                    </a>
                    <div class="caption">
                        <h5>Product name</h5>
                        <p>
                            Lorem Ipsum is simply dummy text.
                        </p>
                        <h4 style="text-align:center">
                            <a class="btn" href="/product_details?productId={product.id}">
                                <i class="icon-zoom-in"></i>
                            </a>
                            <a class="btn" href="#">
                                Add to <i class="icon-shopping-cart"></i>
                            </a>
                            <a class="btn btn-primary" href="#">$222.00</a></h4>
                    </div>
                </div>
            </li>
        </c:forEach>

    </ul>

</div>