<%-- 
    Document   : signup
    Created on : Jul 20, 2016, 10:30:48 PM
    Author     : Rajesh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Please submit the below form.</h1>
        <form action="addUser" method="post">
            <div>
                <label>Username</label>
                <input type="text" name="username" />
            </div>
            
            <div>
                <label>Password</label>
                <input type="password" name="password" />
            </div>
            
            <div>
                <label>Email</label>
                <input type="text" name="email" />
            </div>
            <button type="submit">Signup</button>
        </form>
    </body>
</html>
