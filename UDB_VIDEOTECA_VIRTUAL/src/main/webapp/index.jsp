<%@page import="java.sql.Connection"%>
<%@page import="config.conexionmysql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% 
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            response.sendRedirect("LibroControlador?accion=listar");
        %>
    </body>
</html>