package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(name = "ControladorLogin", urlPatterns = {"/login"})
public class ControladorLogin extends HttpServlet {

    private UsuarioDAO usuarioDAO;

    @Override
    public void init() throws ServletException {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuarioParam = request.getParameter("usuario"); // Cambiado a usuarioParam
        String contrasena = request.getParameter("contrasena");
        
        // CORREGIDO: usar nombre diferente para el objeto Usuario
        Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(usuarioParam, contrasena);
        
        if (usuarioAutenticado != null) {
            // Login exitoso
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioAutenticado);
            session.setAttribute("tipo", usuarioAutenticado.getTipo());
            
            response.sendRedirect("home.jsp"); // aquí redireccionaré a la de Andres
        } else {
            // Login fallido
            request.setAttribute("error", "Usuario o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}