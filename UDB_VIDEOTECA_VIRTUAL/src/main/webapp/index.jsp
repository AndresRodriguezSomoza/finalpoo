<%@page import="java.sql.Connection"%>
<%@page import="config.conexionmysql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World desde html</h1>
        <%
            Connection c = conexionmysql.obtenerConexion();
            out.println(c != null ? "Conexión exitosa" : "Fallo en la conexión");
        %>
    </body>
</html>
