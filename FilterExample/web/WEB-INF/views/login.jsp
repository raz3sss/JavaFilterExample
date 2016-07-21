<%-- 
    Document   : login
    Created on : Jul 20, 2016, 10:58:27 PM
    Author     : Rajesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please login</h1>
        <div>
            <c:choose>
                <c:when test="${param.error != null}">
                    Invalid User details!!
                </c:when>
            </c:choose>
        </div>
        <form action="" method="post">
            <div>
                <label>Username</label>
                <input type="text" name="username" />
            </div>
            
            <div>
                <label>Password</label>
                <input type="password" name="password" />
            </div>
            
            <button type="submit">Login</button>
        </form>
    </body>
</html>
