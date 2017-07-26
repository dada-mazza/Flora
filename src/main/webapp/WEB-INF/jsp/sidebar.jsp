<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>



<div id="sidebar" class="span3">
    <div class="well well-small">
        <a id="myCart" href="product_summary.jsp">
            <img src="../../themes/images/ico-cart.png" alt="cart"> 999 Items in your cart <span
                class="badge badge-warning pull-right"> &#8372 999.99 </span>
        </a>
    </div>
    <ul id="sideManu" class="nav nav-tabs nav-stacked">

        <c:forEach var="categoryEntity" items="${categories}">
            <li class="subMenu">
                <a> ${categoryEntity.engName} [{999}]</a>
                <ul class="hide">
                    <li>
                        <a class="active" href="products.jsp?categoryEntity=${categoryEntity.id}">
                            <i class="icon-chevron-right"></i>All ({999})
                        </a>
                    </li>
                    <c:forEach var="subCategoryEntity" items="${categoryEntity.subCategories}">
                        <li>
                            <a href="products.jsp?subCategoryEntity=${subCategoryEntity.id}">
                                <i class="icon-chevron-right"></i>${subCategoryEntity.engName} ({999})
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
                <a class="btn" href="product_details.jsp">
                    <i class="icon-zoom-in"></i>
                </a>
                <a class="btn" href="#">Add to <i class="icon-shopping-cart"></i>
                </a>
                <a class="btn btn-primary" href="#">$222.00</a>
            </h4>
        </div>
    </div>
    <br/>
    <div class="thumbnail">
        <img src="../../themes/images/example/products/15.png" title="Flora New Plant" alt="Flora New Plant"/>
        <div class="caption">
            <h5>Plant</h5>
            <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                    class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                    class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">$222.00</a></h4>
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
</div>