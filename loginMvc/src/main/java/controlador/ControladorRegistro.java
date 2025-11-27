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
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nombre = request.getParameter("nombre");
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        String tipo = "Alumno";

        System.out.println("📝 [CONTROLADOR] Registro de alumno:");
        System.out.println("   👤 Nombre: " + nombre);
        System.out.println("   👥 Usuario: " + usuario);
        System.out.println("   🔑 Contraseña: " + contrasena);
        
        // Validaciones
        if (usuario == null || usuario.trim().isEmpty()) {
            request.setAttribute("error", "Usuario es obligatorio");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        // Verificar si usuario ya existe
        if (usuarioDAO.existeUsuario(usuario)) {
            request.setAttribute("error", "El usuario ya está registrado");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        // Generar identificador automático
        String identificador = generarIdentificador(nombre);
        
        // Registrar usuario
        Usuario nuevoUsuario = new Usuario(identificador, nombre, usuario, contrasena, tipo);
        
        if (usuarioDAO.registrarUsuario(nuevoUsuario)) {
            System.out.println("🎉 [CONTROLADOR] Registro exitoso, redirigiendo a login...");
           
            response.sendRedirect("login.jsp?registro=exitoso");
        } else {
            request.setAttribute("error", "Error al registrar el alumno");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
        }
    }
    
    private String generarIdentificador(String nombre) {
        String iniciales = "";
        String[] partes = nombre.split(" ");
        for (String parte : partes) {
            if (!parte.isEmpty()) {
                iniciales += parte.charAt(0);
            }
        }
        return "AL" + System.currentTimeMillis() % 10000 + iniciales.toUpperCase();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("registro.jsp");
    }
}