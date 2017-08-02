<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Header ======================================================================================================== -->
<%@include file="header.jsp" %>
<!-- Header End ==================================================================================================== -->

<div id="mainBody">
    <div class="container">
        <div class="row">

            <!-- Sidebar =========================================================================================== -->
            <jsp:include page="sidebar.jsp"/>
            <!-- Sidebar end ======================================================================================= -->

            <div class="span9">
                <ul class="breadcrumb">
                    <li><a href="/">Home</a> <span class="divider">/</span></li>
                    <li class="active">Personal Data</li>
                </ul>
                <h3> Personal Data</h3>
                <div class="well">

                    <%--
                    <div class="alert alert-info fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                    <div class="alert fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply dummy</strong> text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                     <div class="alert alert-block alert-error fade in">
                        <button type="button" class="close" data-dismiss="alert">×</button>
                        <strong>Lorem Ipsum is simply</strong> dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s
                     </div>
                    --%>

                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-block alert-error fade in">
                            <button type="button" class="close" data-dismiss="alert">×</button>
                            <strong>Error!</strong> ${errorMessage}
                        </div>
                    </c:if>

                    <form class="form-horizontal" action="/personalData" method="post">
                        <h4>Your personal information</h4>

                        <%-- email --%>
                        <div class="control-group">
                            <label class="control-label" for="inputEmail">Email <sup>*</sup></label>
                            <div class="controls">
                                <input type="email"
                                       id="inputEmail" placeholder="Email" required readonly
                                       value="${user.email}"
                                />
                            </div>
                        </div>

                        <%-- first name --%>
                        <div class="control-group">
                            <label class="control-label" for="inputFirstName">First name <sup>*</sup></label>
                            <div class="controls">
                                <input type="text" name="inputFirstName" id="inputFirstName"
                                       placeholder="First Name" required
                                        <c:choose>
                                            <c:when test="${not empty param.inputFirstName}">
                                                value="${param.inputFirstName}"
                                            </c:when>
                                            <c:otherwise>
                                                value="${user.firstName}"
                                            </c:otherwise>
                                        </c:choose>
                                />
                            </div>
                        </div>
                        <c:if test="${not empty validator.firstNameErrorMessages}">
                            <div class=" alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.firstNameErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- last name --%>
                        <div class="control-group">
                            <label class="control-label" for="inputLastName">Last name <sup>*</sup></label>
                            <div class="controls">
                                <input type="text" name="inputLastName" id="inputLastName"
                                       placeholder="Last Name" required
                                        <c:choose>
                                            <c:when test="${not empty param.inputLastName}">
                                                value="${param.inputLastName}"
                                            </c:when>
                                            <c:otherwise>
                                                value="${user.lastName}"
                                            </c:otherwise>
                                        </c:choose>
                                />
                            </div>
                        </div>
                        <c:if test="${not empty validator.lastNameErrorMessages}">
                            <div class=" alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage"
                                               items="${validator.lastNameErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- Date of Birth --%>
                        <div class="control-group">
                            <label class="control-label">Date of Birth <sup>*</sup></label>
                            <div class="controls">
                                <select class="span1" name="selectYear" required>
                                    <c:forEach var="yearOfBirth" begin="1900" end="2015">
                                        <c:choose>
                                            <c:when test="${not empty param.selectYear}">
                                                <option value="${yearOfBirth}"
                                                        <c:if test="${param.selectYear eq yearOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${yearOfBirth}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${yearOfBirth}"
                                                        <c:if test="${(user.dateOfBirth.year + 1900) eq yearOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${yearOfBirth}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <select class="span1" name="selectMonth" required>
                                    <c:forEach var="monthOfBirth" begin="1" end="12">
                                        <c:choose>
                                            <c:when test="${not empty param.selectMonth}">
                                                <option value="${monthOfBirth}"
                                                        <c:if test="${param.selectMonth eq monthOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${monthOfBirth}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${monthOfBirth}"
                                                        <c:if test="${(user.dateOfBirth.month  + 1) eq monthOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${monthOfBirth}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <select class="span1" name="selectDay" required>
                                    <c:forEach var="dayOfBirth" begin="1" end="31">
                                        <c:choose>
                                            <c:when test="${not empty param.selectDay}">
                                                <option value="${dayOfBirth}"
                                                        <c:if test="${param.selectDay eq dayOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${dayOfBirth}
                                                </option>
                                            </c:when>
                                            <c:otherwise>
                                                <option value="${dayOfBirth}"
                                                        <c:if test="${user.dateOfBirth.date eq dayOfBirth}">
                                                            selected
                                                        </c:if>
                                                >
                                                        ${dayOfBirth}
                                                </option>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </select>
                                <span>year-month-day</span>
                            </div>
                        </div>
                        <c:if test="${not empty validator.dateOfBirthErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage"
                                               items="${validator.dateOfBirthErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- gender --%>
                        <div class="control-group">
                            <label class="control-label">Gender <sup>*</sup></label>
                            <div class="controls">
                                <select class="span1" name="selectGender" required>
                                    <option value="">-</option>
                                    <option value="Male"
                                            <c:choose>
                                                <c:when test="${not empty param.selectGender &&  param.selectGender eq 'Male'}">
                                                    selected
                                                </c:when>
                                                <c:when test="${user.gender eq 'Male'}">
                                                    selected
                                                </c:when>
                                            </c:choose>
                                    >
                                        Male
                                    </option>
                                    <option value="Female"
                                            <c:choose>
                                                <c:when test="${not empty param.selectGender &&  param.selectGender eq 'Female'}">
                                                    selected
                                                </c:when>
                                                <c:when test="${user.gender eq 'Female'}">
                                                    selected
                                                </c:when>
                                            </c:choose>
                                    >
                                        Female
                                    </option>
                                </select>
                            </div>
                        </div>
                        <c:if test="${not empty validator.genderErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.genderErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <h4>Your address</h4>

                        <%-- Address --%>
                        <div class="control-group">
                            <label class="control-label" for="inputAddress">Address<sup>*</sup></label>
                            <div class="controls">
                                <input type="text" name="inputAddress" id="inputAddress"
                                       placeholder="Adress" required
                                        <c:choose>
                                            <c:when test="${not empty param.inputAddress}">
                                                value="${param.inputAddress}"
                                            </c:when>
                                            <c:otherwise>
                                                value="${user.address}"
                                            </c:otherwise>
                                        </c:choose>
                                />
                                <span>Apartment, building, street address</span>
                            </div>
                        </div>
                        <c:if test="${not empty validator.addressErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.addressErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- City --%>
                        <div class="control-group">
                            <label class="control-label" for="inputCity">City <sup>*</sup></label>
                            <div class="controls">
                                <input type="text" name="inputCity" id="inputCity" placeholder="City" required
                                        <c:choose>
                                            <c:when test="${not empty param.inputCity}">
                                                value="${param.inputCity}"
                                            </c:when>
                                            <c:otherwise>
                                                value="${user.city}"
                                            </c:otherwise>
                                        </c:choose>
                                />
                            </div>
                        </div>
                        <c:if test="${not empty validator.cityErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage" items="${validator.cityErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- Phone --%>
                        <div class="control-group">
                            <label class="control-label" for="inputPhoneNumber">Phone <sup>*</sup></label>
                            <div class="controls">
                                <input type="text" name="inputPhoneNumber" id="inputPhoneNumber"
                                       placeholder="Phone" required
                                        <c:choose>
                                            <c:when test="${not empty param.inputPhoneNumber}">
                                                value="${param.inputPhoneNumber}"
                                            </c:when>
                                            <c:otherwise>
                                                value="${user.phoneNumber}"
                                            </c:otherwise>
                                        </c:choose>
                                />
                            </div>
                        </div>
                        <c:if test="${not empty validator.phoneNumberErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage"
                                               items="${validator.phoneNumberErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>

                        <%-- Additional information --%>
                        <div class="control-group">
                            <label class="control-label" for="textareaAdditionalInformation">Additional
                                information</label>
                            <div class="controls">
                                <textarea name="textareaAdditionalInformation"
                                          id="textareaAdditionalInformation"
                                          cols="26"
                                          rows="3"
                                          placeholder="Additional information"
                                ><c:choose><c:when
                                        test="${not empty param.textareaAdditionalInformation}">${param.textareaAdditionalInformation}</c:when><c:otherwise>${user.additionalInformation}</c:otherwise></c:choose></textarea>
                            </div>
                        </div>
                        <c:if test="${not empty validator.additionalInformationErrorMessages}">
                            <div class="alert alert-block alert-error fade in">
                                <button type="button" class="close" data-dismiss="alert">×</button>
                                <ul>
                                    <c:forEach var="errorMessage"
                                               items="${validator.additionalInformationErrorMessages}">
                                        <li><strong>Error!</strong> ${errorMessage}</li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </c:if>
                        <p><sup>*</sup>Required field </p>

                        <div class="control-group">
                            <div class="controls">
                                <input class="btn btn-large btn-success" type="submit" name="submit"
                                       value="Edit"/>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Footer ======================================================================================================== -->
<script src="../../themes/js/registration.js" type="text/javascript"></script>
<%@include file="footer.jsp" %>


