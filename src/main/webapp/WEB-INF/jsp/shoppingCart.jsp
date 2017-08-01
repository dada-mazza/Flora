<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="/categories"/>
            <!-- Sidebar end ======================================================================================= -->
            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active"> SHOPPING CART</li>
                </ul>
                <h3> SHOPPING CART [
                    <span>
                         <c:choose>
                             <c:when test="${not empty cart}"> ${cart.totalItems} </c:when>
                             <c:otherwise> 0 </c:otherwise>
                         </c:choose>
                     </span> Item(s) ]
                    <a href="/products" class="btn btn-large pull-right">
                        <i class="icon-arrow-left"></i> Continue Shopping
                    </a>
                </h3>
                <hr class="soft"/>

                <c:if test="${empty user}">
                    <table class="table table-bordered">
                        <tr>
                            <th> I AM ALREADY REGISTERED</th>
                        </tr>
                        <tr>
                            <td>
                                <form class="form-horizontal" action="/login" method="post">
                                    <div class="control-group">
                                        <label class="control-label" for="inputEmailLogin">Username</label>
                                        <div class="controls">
                                            <input type="text" name="inputEmailLogin" id="inputEmailLogin"
                                                   placeholder="email">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="inputPasswordLogin">Password</label>
                                        <div class="controls">
                                            <input type="password" name="inputPasswordLogin" id="inputPasswordLogin"
                                                   placeholder="password">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <input type="submit" class="btn" name="submit" value="Sign In"/>
                                            OR
                                            <a href="/register" class="btn">Register Now!</a>
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <a href="/forgotPassword" style="text-decoration:underline">
                                                Forgot password ?
                                            </a>
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </table>
                </c:if>

                <c:if test="${not empty cart}">
                    <table class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Product</th>
                            <th>Description</th>
                            <th>Quantity/Update</th>
                            <th>Price</th>
                            <th>Discount</th>
                            <th>Tax</th>
                            <th>Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="product" items="${cart.products}">
                            <tr>
                                <td><img width="60" src="themes/images/products/${product.id}.jpg" alt=""/></td>
                                <td>${product.name}</td>
                                <td>
                                    <div class="input-append">
                                        <input class="span1"
                                               style="max-width:34px"
                                               placeholder="1"
                                               id="appendedInputButtons"
                                               size="16"
                                               type="text"
                                               value="${product.quantity}"
                                        />
                                        <button class="btn" type="button"><i class="icon-minus"></i></button>
                                        <button class="btn" type="button"><i class="icon-plus"></i></button>
                                        <button class="btn btn-danger" type="button">
                                            <i class="icon-remove icon-white"></i>
                                        </button>
                                    </div>
                                </td>
                                <td> &#8372 ${product.price / 100}</td>
                                <td> &#8372 0.00</td>
                                <td> &#8372 0.00</td>
                                <td> ${product.price * product.quantity / 100}</td>
                            </tr>
                        </c:forEach>

                        <tr>
                            <td colspan="6" style="text-align:right">Total Price:</td>
                            <td> &#8372 ${cart.totalAmount / 100} </td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align:right">Total Discount:</td>
                            <td> &#8372 0.00</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align:right">Total Tax:</td>
                            <td> &#8372 0.00</td>
                        </tr>
                        <tr>
                            <td colspan="6" style="text-align:right">
                                <strong>TOTAL</strong>
                            </td>
                            <td class="label label-important" style="display:block">
                                <strong> &#8372 ${cart.totalAmount / 100} </strong>
                            </td>
                        </tr>
                        </tbody>
                    </table>

                    <table class="table table-bordered">
                        <tbody>
                        <tr>
                            <td>
                                <form class="form-horizontal">
                                    <div class="control-group">
                                        <label class="control-label"><strong> VOUCHERS CODE: </strong> </label>
                                        <div class="controls">
                                            <input type="text" class="input-medium" placeholder="CODE">
                                            <button type="submit" class="btn"> ADD</button>
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>

                        </tbody>
                    </table>

                    <table class="table table-bordered">
                        <tr>
                            <th>ESTIMATE YOUR SHIPPING</th>
                        </tr>
                        <tr>
                            <td>
                                <form class="form-horizontal">
                                    <div class="control-group">
                                        <label class="control-label" for="inputCountry">Country </label>
                                        <div class="controls">
                                            <input type="text" id="inputCountry" placeholder="Country">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <label class="control-label" for="inputPost">Post Code / Zipcode </label>
                                        <div class="controls">
                                            <input type="text" id="inputPost" placeholder="Postcode">
                                        </div>
                                    </div>
                                    <div class="control-group">
                                        <div class="controls">
                                            <button type="submit" class="btn">ESTIMATE</button>
                                        </div>
                                    </div>
                                </form>
                            </td>
                        </tr>
                    </table>
                </c:if>
                <a href="/products" class="btn btn-large"><i class="icon-arrow-left"></i> Continue Shopping </a>
                <a href="" class="btn btn-large pull-right">Pay <i class="icon-arrow-right"></i></a>

            </div>
        </div>
    </div>
</div>
<!-- MainBody End ================================================================================================== -->
<!-- Footer ======================================================================================================== -->
<%@include file="footer.jsp" %>
