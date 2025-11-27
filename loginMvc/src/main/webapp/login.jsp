<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Iniciar Sesión - Amigos de Don Bosco</title>
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
        label { 
            display: block; 
            margin-bottom: 5px; 
            font-weight: bold;
            color: #333;
        }
        input[type="text"], input[type="password"] { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ddd; 
            border-radius: 4px; 
            box-sizing: border-box;
            font-size: 14px;
            height: 40px;
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
            font-weight: bold;
        }
        button:hover { background-color: #0056b3; }
        .error { 
            color: red; 
            margin-bottom: 15px; 
            padding: 10px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
            font-size: 14px;
        }
        .success { 
            color: #155724; 
            margin-bottom: 15px; 
            padding: 10px;
            background-color: #d4edda;
            border: 1px solid #c3e6cb;
            border-radius: 4px;
        }
        .login-header {
            text-align: center;
            margin-bottom: 30px;
        }
        .logo {
            max-width: 150px;
            height: auto;
            margin-bottom: 15px;
        }
        .title {
            color: #333;
            margin-bottom: 5px;
            font-size: 24px;
        }
        .subtitle {
            color: #666;
            margin: 0;
            font-size: 16px;
        }
        .register-link { 
            text-align: center; 
            margin-top: 20px; 
        }
        .register-link a {
            color: #007bff;
            text-decoration: none;
        }
        .register-link a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-header">
            <img src="https://i.ibb.co/vCk57hhR/logo.png" alt="Amigos de Don Bosco" class="logo">
            <h2 class="title">Iniciar Sesión</h2>
        </div>
        
        <% if (request.getParameter("registro") != null && request.getParameter("registro").equals("exitoso")) { %>
            <div class="success">¡Registro exitoso! Ahora puedes iniciar sesión.</div>
        <% } %>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="login" method="post">
            <div class="form-group">
                <label for="usuario">Usuario:</label>
                <input type="text" id="usuario" name="usuario" required 
                       placeholder="Ingresa tu usuario">
            </div>
            
            <div class="form-group">
                <label for="contrasena">Contraseña:</label>
                <input type="password" id="contrasena" name="contrasena" required 
                       placeholder="Ingresa tu contraseña">
            </div>
            
            <button type="submit">Iniciar Sesión</button>
        </form>
        
        <div class="register-link">
            <p><a href="registro.jsp">¿No tienes cuenta? Regístrate aquí</a></p>
        </div>
    </div>
</body>
</html>