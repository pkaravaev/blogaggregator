<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: karav
  Date: 15.04.2018
  Time: 14:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>

    <jsp:include page="taglib.jsp"/>
    <title>Title</title>
    <style>
        .form-signin {
            max-width: 330px;
            padding: 15px;
            margin: 0 auto;
        }

        .form-signin .form-signin-heading,
        .form-signin .checkbox {
            margin-bottom: 10px;
        }

        .form-signin .checkbox {
            font-weight: normal;
        }

        .form-signin .form-control {
            position: relative;
            height: auto;
            -webkit-box-sizing: border-box;
            -moz-box-sizing: border-box;
            box-sizing: border-box;
            padding: 10px;
            font-size: 16px;
        }

        .form-signin .form-control:focus {
            z-index: 2;
        }

        .form-signin input[type="email"] {
            margin-bottom: -1px;
            border-bottom-right-radius: 0;
            border-bottom-left-radius: 0;
        }

        .form-signin input[type="password"] {
            margin-bottom: 10px;
            border-top-left-radius: 0;
            border-top-right-radius: 0;
        }
    </style>
</head>
<body>
    <%--<form class="form-signin" action="<spring:url value="/login"/>" method="post">--%>
        <%--<h2 class="form-signin-heading">Please Login </h2>--%>
        <%--<input type="text" name="username" class="form-control" placeholder="Login" required autofocus>--%>
        <%--<input type="password" name="password" class="form-control" placeholder="Password" required>--%>
        <%--&lt;%&ndash;<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>&ndash;%&gt;--%>
        <%--<input class="btn btn-lg btn-primary btn-block" type="submit">--%>
    <%--</form>--%>


<form class="form-signin"   name="frm" action="<c:url value='login'/>" method="post">
    <table>
        <tr> <td>User:</td> <td><input type="text" name="username" class="form-control" ></td></tr>
        <tr><td>Password:</td> <td><input type="password" name="password" class="form-control"></td></tr>
        <tr><td colspan="2"><input name="submit" type="submit"></td></tr>
    </table>
    <input type="hidden" name="<c:out value="${_csrf.parameterName}"/>"
           value="<c:out value="${_csrf.token}"/>"/>
    </form>


</body>

