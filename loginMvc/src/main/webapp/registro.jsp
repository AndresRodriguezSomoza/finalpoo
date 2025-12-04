<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registro - Amigos de Don Bosco</title>
    <style>
        body { 
            font-family: Arial, sans-serif; 
            margin: 0;
            padding: 0;
            background-image: url('https://i.ibb.co/VWGQGsDB/FRONt-END3.jpg');
            background-repeat: no-repeat;
            background-position: center;
            background-size: cover;
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
        input[type="text"], input[type="password"], select { 
            width: 100%; 
            padding: 10px; 
            border: 1px solid #ddd; 
            border-radius: 4px; 
            box-sizing: border-box;
            font-size: 14px;
            height: 40px;
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
        .login-link { text-align: center; margin-top: 20px; }
        .info-box {
            background-color: #e7f3ff;
            border: 1px solid #b3d9ff;
            border-radius: 4px;
            padding: 15px;
            margin-bottom: 20px;
            text-align: center;
        }
        .info-box p {
            margin: 0;
            color: #0066cc;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="login-header">
            <img src="https://i.ibb.co/vCk57hhR/logo.png" alt="Amigos de Don Bosco" class="logo">
            <h2 class="title">Registro de Alumno</h2>
        </div>
        
        <% if (request.getAttribute("error") != null) { %>
            <div class="error"><%= request.getAttribute("error") %></div>
        <% } %>
        

        <form action="registro" method="post">
            <div class="form-group">
                <label>Nombre completo:</label>
                <input type="text" name="nombre" required placeholder="Ingresa tu nombre completo">
            </div>
            
            <div class="form-group">
                <label>Usuario:</label>
                <input type="text" name="usuario" required placeholder="Crea un nombre de usuario">
            </div>
            
            <div class="form-group">
                <label>Contraseña:</label>
                <input type="password" name="contrasena" required placeholder="Crea una contraseña segura">
            </div>
            
 
            <input type="hidden" name="tipo" value="Alumno">
            
            <button type="submit">Registrarse </button>
        </form>
        
        <div class="login-link">
            <p><a href="login.jsp">¿Ya tienes cuenta? Inicia sesión aquí</a></p>
        </div>
    </div>
</body>
</html>