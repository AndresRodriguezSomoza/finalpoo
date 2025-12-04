package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        
        if (usuario == null || usuario.trim().isEmpty()) {
            request.setAttribute("error", "Usuario es obligatorio");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        if (usuarioDAO.existeUsuario(usuario)) {
            request.setAttribute("error", "El usuario ya está registrado");
            request.getRequestDispatcher("registro.jsp").forward(request, response);
            return;
        }
        
        String identificador = generarIdentificador(nombre);
        Usuario nuevoUsuario = new Usuario(identificador, nombre, usuario, contrasena, tipo);
        
        if (usuarioDAO.registrarUsuario(nuevoUsuario)) {
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