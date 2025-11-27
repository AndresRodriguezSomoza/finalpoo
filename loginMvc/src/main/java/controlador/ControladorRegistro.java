package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorRegistro", urlPatterns = {"/registro"})
public class ControladorRegistro extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
        System.out.println("🔄 ControladorRegistro INICIADO");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("📨 [CONTROLADOR] doPost RECIBIDO");
        
        String nombre = request.getParameter("nombre");
String email = request.getParameter("email");
String contrasena = request.getParameter("contrasena");
String tipoUsuario = request.getParameter("tipoUsuario");


        
        System.out.println("📝 [CONTROLADOR] Parámetros recibidos:");
        System.out.println("   📧 Email: " + email);
        System.out.println("   🔑 Contraseña: " + contrasena);
        System.out.println("   👤 Tipo Usuario: " + tipoUsuario);
        
        // Validaciones
        if (email == null || email.trim().isEmpty()) {
            System.out.println("❌ [CONTROLADOR] Email vacío");
            request.setAttribute("error", "Email es obligatorio");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        if (contrasena == null || contrasena.trim().isEmpty()) {
            System.out.println("❌ [CONTROLADOR] Contraseña vacía");
            request.setAttribute("error", "Contraseña es obligatoria");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        // Verificar si email existe
        System.out.println("🔍 [CONTROLADOR] Verificando si email existe...");
        if (usuarioDAO.existeEmail(email)) {
            System.out.println("❌ [CONTROLADOR] Email YA EXISTE: " + email);
            request.setAttribute("error", "El email ya está registrado");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        System.out.println("✅ [CONTROLADOR] Email disponible");
        
        // Registrar usuario
        System.out.println("🔄 [CONTROLADOR] Creando objeto Usuario...");
        Usuario usuario = new Usuario(nombre, email, contrasena, tipoUsuario);
        
        System.out.println("🔄 [CONTROLADOR] Llamando a usuarioDAO.registrarUsuario...");
        boolean registrado = usuarioDAO.registrarUsuario(usuario);
        
        if (registrado) {
            System.out.println("🎉 [CONTROLADOR] REGISTRO EXITOSO!");
            request.setAttribute("mensaje", "Usuario registrado exitosamente. Ahora puedes iniciar sesión.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            System.out.println("💥 [CONTROLADOR] REGISTRO FALLÓ!");
            request.setAttribute("error", "Error al registrar el usuario");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("📨 [CONTROLADOR] doGet - Redirigiendo a registro.jsp");
        response.sendRedirect("registro.jsp");
    }
}