<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

</div>
<div id="sidebar">
    <h2>Товари</h2>

    <c:if test="${not empty user}">
        <table border=1>
            <tr>
                <td width="252" align="left">
                    <font color=white>
                        Доброго! ${user.firstName} ${user.secondName}<br/>
                        Ви ще нічого не купили.
                    </font>
                </td>
            </tr>
        </table>
    </c:if>

    <ul>
        <%@include file="categories.jsp" %>
    </ul>
    <ul>
        <%@include file="menu.jsp" %>
    </ul>
</div>
</div>
</div>
</div>
</div>
<div id="footer">
    <p>Copyright (c) by dada.mazza</p>
</div>

</body>
</html>
