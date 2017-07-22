<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@include file="header.jsp" %>

<c:if test="${empty user}">
    <c:redirect url="profile"/>
</c:if>

<c:if test="${not empty errorMessage}">
    <h1 class="error">${errorMessage}</h1>
</c:if>

<form action="" method="post">

    <div class="field-wrap">
        <div class="label">
            Email Address<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="email" name="email" value="${user.email}" required readonly/>
    </div>

    <div class="field-wrap">
        <div class="label">
            Password<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="password" name="password" value="${param.password}" required/>
    </div>

    ${validator.passwordErrorMessage}

    <div class="field-wrap">
        <div class="label">
            Re-enter password<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="password" name="confirmPassword" value="${param.confirmPassword}" required/>
    </div>

    <div class="field-wrap">
        <div class="label">
            First Name<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="text" name="firstName" value="${user.firstName}" required/>
    </div>

    ${validator.firstNameErrorMessage}

    <div class="field-wrap">
        <div class="label">
            Second Name<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <input type="text" name="secondName" value="${user.secondName}" required/>
    </div>

    ${validator.secondNameErrorMessage}

    <div class="field-wrap">
        <div class="label">
            Region<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
        <jsp:useBean id="regionBean" class="ua.itea.dao.Region"/>
        <select name="region" required>
            <c:forEach var="region" items="${regionBean.regions}">
                <c:choose>
                    <c:when test="${user.region eq region}">
                        <option selected value="${region}">${region}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${region}">${region}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>

    ${validator.regionErrorMessage}

    <div class="field-wrap">
        <div class="label">
            Gender<span class="req">*</span>
        </div>
    </div>
    <div class="field-wrap">
    </div>

    <div class="field-border">
        <div class="top-row">
            <div class="field-wrap">
                <div class="label">
                    Male
                </div>
            </div>
            <div class="field-wrap">
                <c:choose>
                    <c:when test="${user.gender eq 'Male'}">
                        <input type="radio" name="gender" value="Male" checked/>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="gender" value="Male"/>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="field-wrap">
                <div class="label">
                    Female
                </div>
            </div>
            <div class="field-wrap">
                <c:choose>
                    <c:when test="${user.gender eq 'Female'}">
                        <input type="radio" name="gender" value="Female" checked/>
                    </c:when>
                    <c:otherwise>
                        <input type="radio" name="gender" value="Female"/>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    ${validator.genderErrorMessage}

    <div class="top-row">
        <div class="field-wrap">
            <div class="label">
                Spam<span class="req">*</span>
            </div>
        </div>
        <div class="field-wrap">
            <div class="label">
                <c:choose>
                    <c:when test="${user.subscription eq 'on'}">
                        <input type="checkbox" name="subscription" id="checkbox" checked/>
                    </c:when>
                    <c:otherwise>
                        <input type="checkbox" name="subscription" id="checkbox"/>
                    </c:otherwise>
                </c:choose>
                <label for="checkbox"></label>
            </div>
        </div>
    </div>

    <button type="submit" name="profileAction" value="edit" class="button button-block"/>
    Edit
    </button>

</form>

<%@include file="footer.jsp" %>
