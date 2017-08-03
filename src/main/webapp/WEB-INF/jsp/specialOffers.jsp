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
                    <li class="active">Special offers</li>
                </ul>
                <h3> Special offers
                    <small class="pull-right"> ${offers.size()} products are available</small>
                </h3>
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
                            <jsp:include page="block/productBlockView.jsp"/>
                        </ul>
                        <hr class="soft"/>
                    </div>

                    <div class="tab-pane" id="listView">
                        <jsp:include page="block/productListView.jsp"/>
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