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
        
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        
        Usuario usuario = usuarioDAO.autenticarUsuario(email, contrasena);
        
        if (usuario != null) {
            // Login exitoso
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuario);
            session.setAttribute("tipoUsuario", usuario.getTipoUsuario());
            
            response.sendRedirect("home.jsp");// aqui redireccionare a la de andres
        } else {
            // Login fallido
            request.setAttribute("error", "Email o contraseña incorrectos");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendRedirect("login.jsp");
    }
}