<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro - Sistema</title>
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
        input[type="text"], input[type="email"], input[type="password"], select { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ddd; 
            border-radius: 4px; 
            box-sizing: border-box;
        }
        button { 
            background-color: #28a745; 
            color: white; 
            padding: 12px 20px; 
            border: none; 
            border-radius: 4px; 
            cursor: pointer; 
            width: 100%;
            font-size: 16px;
        }
        button:hover { background-color: #218838; }
        .error { 
            color: red; 
            margin-bottom: 15px; 
            padding: 10px;
            background-color: #f8d7da;
            border: 1px solid #f5c6cb;
            border-radius: 4px;
        }
        h2 { text-align: center; margin-bottom: 30px; color: #333; }
        .login-link { text-align: center; margin-top: 20px; }
    </style>
</head>
<body>
    <div class="container">
        <h2>Registro de Usuario</h2>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        
        <form action="registro" method="post">
            <div class="form-group">
                <label>Nombre completo:</label>
                <input type="text" name="nombre" required>
            </div>
            
            <div class="form-group">
                <label>Email:</label>
                <input type="email" name="email" required>
            </div>
            
            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" name="contrasena" required>
            </div>
            
            <div class="form-group">
                <label>Tipo de Usuario:</label>
                <select name="tipoUsuario">
                    <option value="Usuario">Usuario</option>
                    <option value="Administrador">Administrador</option>
                    <option value="Recepcionista">Recepcionista</option>
                </select>
            </div>
            
            <button type="submit">Registrarse</button>
        </form>
        
        <div class="login-link">
            <p><a href="login.jsp">¿Ya tienes cuenta? Inicia sesión aquí</a></p>
        </div>
    </div>
</body>
</html>