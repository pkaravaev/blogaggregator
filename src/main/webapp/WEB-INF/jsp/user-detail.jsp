<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: karav
  Date: 4/1/2018
  Time: 10:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<h1>${user.name}</h1>

<c:forEach items="${user.blogs}" var="blog">

    <h1>${blog.name}</h1>
    <p>${blog.url}</p>
    <table>
        <thead>
        <tr>
            <th>Title</th>
            <th>Link</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${blog.items}" var="item">
            <tr>
                <td>${item.title}</td>
                <td>${item.link}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</c:forEach>