<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>Flora</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>

    <!-- Google-code-prettify -->
    <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
    <link href="themes/js/google-code-prettify/prettify.css" rel="stylesheet"/>
    <!-- Flora style responsive -->
    <link href="themes/css/flora-bootstrap.css" rel="stylesheet" media="screen"/>
    <link href="themes/css/flora-bootstrap-responsive.css" rel="stylesheet"/>
    <link href="themes/css/base.css" rel="stylesheet" media="screen"/>

    <!-- fav and touch icons -->
    <link rel="shortcut icon" href="themes/images/ico/flora.png"/>
    <link rel="apple-touch-icon" href="themes/images/ico/flora.png"/>
    <link rel="apple-touch-icon-precomposed" href="themes/images/ico/flora.png"/>
</head>
<body>
<div id="header">
    <div class="container">
        <div id="welcomeLine" class="row">
            <div class="span6">Welcome!<strong> User </strong></div>
            <div class="span6">
                <div class="pull-right">
                    <span class="btn btn-mini">999,99</span>
                    <a href="product_summary.jsp"><span class="">&#8372</span></a>
                    <a href="product_summary.jsp">
                        <span class="btn btn-mini btn-primary">
                            <i class="icon-shopping-cart icon-white"></i> [ 999 ] Itemes in your cart
                        </span>
                    </a>
                </div>
            </div>
        </div>
        <!-- Navbar ================================================== -->
        <div id="logoArea" class="navbar">
            <a id="smallScreen" data-target="#topMenu" data-toggle="collapse" class="btn btn-navbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </a>
            <div class="navbar-inner">
                <a class="brand" href="index.jsp">
                    <img src="themes/images/logo/logo.png" alt="Flora"/>
                </a>
                <form class="form-inline navbar-search" method="post" action="products.jsp">
                    <input id="srchFld" class="srchTxt" type="text"/>
                    <select class="srchTxt">
                        <option>All</option>
                        <option>CATEGORY</option>
                        <option>CATEGORY</option>
                        <option>CATEGORY</option>
                    </select>
                    <button type="submit" id="submitButton" class="btn btn-primary">Go</button>
                </form>
                <ul id="topMenu" class="nav pull-right">
                    <li class=""><a href="special_offer.jsp">Specials Offer</a></li>
                    <li class=""><a href="normal.jsp">Delivery</a></li>
                    <li class=""><a href="contact.jsp">Contact</a></li>
                    <li class="">
                        <a href="#login" role="button" data-toggle="modal"><span
                                class="btn btn-large btn-success">Login</span></a>
                        <div id="login" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="login"
                             aria-hidden="false">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                                <h3>Login Block</h3>
                            </div>
                            <div class="modal-body">
                                <form class="form-horizontal loginFrm">
                                    <div class="control-group">
                                        <input type="text" id="inputEmail" placeholder="Email">
                                    </div>
                                    <div class="control-group">
                                        <input type="password" id="inputPassword" placeholder="Password">
                                    </div>
                                    <div class="control-group">
                                        <label class="checkbox">
                                            <input type="checkbox"> Remember me
                                        </label>
                                    </div>
                                </form>
                                <button type="submit" class="btn btn-success">Sign in</button>
                                <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </div>
</div>
<!-- Header End====================================================================== -->
<div id="carouselBlk">
    <div id="myCarousel" class="carousel slide">
        <div class="carousel-inner">
            <div class="item active">
                <div class="container">
                    <a href="special_offer.jsp">
                        <img style="width:100%" src="themes/images/example/carousel/1.png" alt="special offers"/>
                    </a>
                    <div class="carousel-caption">
                        <h4>Second Thumbnail label</h4>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                            gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="container">
                    <a href="special_offer.jsp">
                        <img style="width:100%" src="themes/images/example/carousel/2.png" alt=""/>
                    </a>
                    <div class="carousel-caption">
                        <h4>Second Thumbnail label</h4>
                        <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta
                            gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
                    </div>
                </div>
            </div>

        </div>
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
</div>
<div id="mainBody">
    <div class="container">
        <div class="row">
            <!-- Sidebar ================================================== -->
            <div id="sidebar" class="span3">
                <div class="well well-small">
                    <a id="myCart" href="product_summary.jsp">
                        <img src="themes/images/ico-cart.png" alt="cart"> 999 Items in your cart <span
                            class="badge badge-warning pull-right"> &#8372 999.99 </span>
                    </a>
                </div>
                <ul id="sideManu" class="nav nav-tabs nav-stacked">
                    <li class="subMenu open">
                        <a> ELECTRONICS [230]</a>
                        <ul>
                            <li>
                                <a class="active" href="products.jsp">
                                    <i class="icon-chevron-right"></i>Cameras (100)
                                </a>
                            </li>
                            <li>
                                <a href="products.jsp">
                                    <i class="icon-chevron-right"></i>Computers, Tablets & laptop (30)
                                </a>
                            </li>
                            <li>
                                <a href="products.jsp">
                                    <i class="icon-chevron-right"></i>Mobile Phone (80)
                                </a>
                            </li>
                            <li>
                                <a href="products.jsp">
                                    <i class="icon-chevron-right"></i>Sound & Vision (15)
                                </a>
                            </li>
                        </ul>
                    </li>
                    <li class="subMenu"><a> CLOTHES [840] </a>
                        <ul style="display:none">
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Women's Clothing (45)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Women's Shoes (8)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Women's Hand Bags (5)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Men's Clothings (45)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Men's Shoes (6)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Kids Clothing (5)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Kids Shoes (3)</a></li>
                        </ul>
                    </li>
                    <li class="subMenu"><a>FOOD AND BEVERAGES [1000]</a>
                        <ul style="display:none">
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Angoves (35)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Bouchard Aine & Fils (8)</a>
                            </li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>French Rabbit (5)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Louis Bernard (45)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>BIB Wine (Bag in Box) (8)</a>
                            </li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Other Liquors & Wine (5)</a>
                            </li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Garden (3)</a></li>
                            <li><a href="products.html"><i class="icon-chevron-right"></i>Khao Shong (11)</a></li>
                        </ul>
                    </li>
                    <li><a href="products.html">HEALTH & BEAUTY [18]</a></li>
                    <li><a href="products.html">SPORTS & LEISURE [58]</a></li>
                    <li><a href="products.html">BOOKS & ENTERTAINMENTS [14]</a></li>
                </ul>
                <br/>
                <div class="thumbnail">
                    <img src="themes/images/example/products/panasonic.jpg" alt="Bootshop panasonoc New camera"/>
                    <div class="caption">
                        <h5>Panasonic</h5>
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
                    <img src="themes/images/example/products/kindle.png" title="Bootshop New Kindel"
                         alt="Bootshop Kindel">
                    <div class="caption">
                        <h5>Kindle</h5>
                        <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                class="icon-shopping-cart"></i></a> <a class="btn btn-primary" href="#">$222.00</a></h4>
                    </div>
                </div>
                <br/>
                <div class="thumbnail">
                    <img src="themes/images/payment_methods.png" title="Bootshop Payment Methods"
                         alt="Payments Methods">
                    <div class="caption">
                        <h5>Payment Methods</h5>
                    </div>
                </div>
            </div>
            <!-- Sidebar end=============================================== -->
            <div class="span9">
                <div class="well well-small">
                    <h4>Featured Products
                        <small class="pull-right">200+ featured products</small>
                    </h4>
                    <div class="row-fluid">
                        <div id="featured" class="carousel slide">
                            <div class="carousel-inner">
                                <div class="item active">
                                    <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp">
                                                    <img src="themes/images/example/products/b1.jpg" alt="">
                                                </a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4>
                                                        <a class="btn" href="product_details.jsp">VIEW</a>
                                                        <span class="pull-right">$222.00</span>
                                                    </h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp">
                                                    <img src="themes/images/example/products/b2.jpg" alt="">
                                                </a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4>
                                                        <a class="btn" href="product_details.jsp">VIEW</a>
                                                        <span class="pull-right">$222.00</span>
                                                    </h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/b3.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/b4.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="item">
                                    <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/5.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <i class="tag"></i>
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/6.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/7.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/8.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="item">
                                    <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/9.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/10.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/11.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/1.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                                <div class="item">
                                    <ul class="thumbnails">
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/2.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/3.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/4.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="span3">
                                            <div class="thumbnail">
                                                <a href="product_details.jsp"><img
                                                        src="themes/images/example/products/5.jpg"
                                                        alt=""></a>
                                                <div class="caption">
                                                    <h5>Product name</h5>
                                                    <h4><a class="btn" href="product_details.jsp">VIEW</a> <span
                                                            class="pull-right">$222.00</span></h4>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <a class="left carousel-control" href="#featured" data-slide="prev">‹</a>
                            <a class="right carousel-control" href="#featured" data-slide="next">›</a>
                        </div>
                    </div>
                </div>
                <h4>Latest Products </h4>
                <ul class="thumbnails">
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/6.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>

                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/7.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>
                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/8.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>
                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/9.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>
                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/10.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>
                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                    <li class="span3">
                        <div class="thumbnail">
                            <a href="product_details.jsp"><img src="themes/images/example/products/11.jpg" alt=""/></a>
                            <div class="caption">
                                <h5>Product name</h5>
                                <p>
                                    Lorem Ipsum is simply dummy text.
                                </p>
                                <h4 style="text-align:center"><a class="btn" href="product_details.jsp"> <i
                                        class="icon-zoom-in"></i></a> <a class="btn" href="#">Add to <i
                                        class="icon-shopping-cart"></i></a> <a class="btn btn-primary"
                                                                               href="#">$222.00</a></h4>
                            </div>
                        </div>
                    </li>
                </ul>

            </div>
        </div>
    </div>
</div>
<!-- Footer ================================================================== -->
<div id="footerSection">
    <div class="container">
        <div class="row">
            <div class="span3">
                <h5>ACCOUNT</h5>
                <a href="login.jsp">YOUR ACCOUNT</a>
                <a href="login.jsp">PERSONAL INFORMATION</a>
                <a href="login.jsp">ADDRESSES</a>
                <a href="login.jsp">DISCOUNT</a>
                <a href="login.jsp">ORDER HISTORY</a>
            </div>
            <div class="span3">
                <h5>INFORMATION</h5>
                <a href="contact.jsp">CONTACT</a>
                <a href="register.jsp">REGISTRATION</a>
                <a href="legal_notice.jsp">LEGAL NOTICE</a>
                <a href="tac.jsp">TERMS AND CONDITIONS</a>
                <a href="faq.jsp">FAQ</a>
            </div>
            <div class="span3">
                <h5>OUR OFFERS</h5>
                <a href="#">NEW PRODUCTS</a>
                <a href="#">TOP SELLERS</a>
                <a href="special_offer.jsp">SPECIAL OFFERS</a>
                <a href="#">MANUFACTURERS</a>
                <a href="#">SUPPLIERS</a>
            </div>
            <div id="socialMedia" class="span3 pull-right">
                <h5>SOCIAL MEDIA </h5>
                <a href="#">
                    <img width="60" height="60"
                         src="themes/images/social/facebook.png" title="facebook" alt="facebook"/>
                </a>
                <a href="#">
                    <img width="60" height="60"
                         src="themes/images/social/twitter.png" title="twitter" alt="twitter"/>
                </a>
                <a href="#">
                    <img width="60" height="60"
                         src="themes/images/social/youtube.png" title="youtube" alt="youtube"/>
                </a>
            </div>
        </div>
        <p class="pull-right">&copy; Flora</p>
    </div><!-- Container End -->
</div>
<!-- Placed at the end of the document so the pages load faster ============================================= -->
<script src="themes/js/jquery.js" type="text/javascript"></script>
<script src="themes/js/bootstrap.min.js" type="text/javascript"></script>
<script src="themes/js/flora.js" type="text/javascript"></script>
<script src="themes/js/jquery.lightbox-0.5.js" type="text/javascript"></script>

</body>
</html>