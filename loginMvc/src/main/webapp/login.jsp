<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login - Sistema</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container { 
            background: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
            width: 100%;
            max-width: 400px;
        }
        .form-group { margin-bottom: 20px; }
        label { display: block; margin-bottom: 5px; font-weight: bold; }
        input[type="email"], input[type="password"] { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ddd; 
            border-radius: 4px; 
            box-sizing: border-box;
        }
        button { 
            background-color: #007bff; 
            color: white; 
            padding: 12px 20px; 
            border: none; 
            border-radius: 4px; 
            cursor: pointer; 
            width: 100%;
            font-size: 16px;
        }
        button:hover { background-color: #0056b3; }
        .error { 
            color: red; 
            margin-bottom: 15px; 
            padding: 10px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
        }
        .mensaje { 
            color: green; 
            margin-bottom: 15px; 
            padding: 10px;
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
        }
        h2 { text-align: center; margin-bottom: 30px; color: #333; }
    </style>
</head>
<body>
    <div class="container">
        <div style="text-align: center; margin-bottom: 30px;">
    <img src="https://i.ibb.co/vCk57hhR/logo.png" alt="Iniciar Sesión" 
         style="display: block; margin: 0 auto; max-width: 200px; height: auto;">
        <h2>Iniciar Sesión</h2>
      
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <% if (request.getAttribute("mensaje") != null) { %>
            <div class="mensaje"><%= request.getAttribute("mensaje") %></div>
        <% } %>
        
        <form action="login" method="post">
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" name="contrasena" required>
            </div>
            
            <button type="submit">Ingresar</button>
        </form>
        
        <p style="text-align: center; margin-top: 20px;">
            <a href="registro.jsp">¿No tienes cuenta? Regístrate aquí</a>
        </p>
    </div>
</body>
</html>