<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="taglib.jsp"/>
<%--
  Created by IntelliJ IDEA.
  User: karav
  Date: 4/1/2018
  Time: 10:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<table class="table table-bordered table-hover table-striped">
    <thead>
    <tr>
        <th>user name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <tr>
            <td>
                <a href="<spring:url  value="/users/${user.id}.html"/>">
                        ${user.name}
                </a>

            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
