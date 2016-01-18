<%-- 
    Document   : loginCheck
    Created on : 18/01/2016, 12:59:03
    Author     : bruno.souza
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html">
        <title>Finanças</title>
    </head>
    <body>
        <% 
            String username = request.getParameter("usuario"); 
            String senha = request.getParameter("senha");
             
            if(username.equals("admin") && senha.equals("admin")) { 
                response.sendRedirect("index.html"); 
            } else {                
                response.sendRedirect("login.html");
            } 
        %> 
    </body>
</html>