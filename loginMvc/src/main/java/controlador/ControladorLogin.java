package controlador;

import modelo.Usuario;
import modelo.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        
        System.out.println("📨 [LOGIN] doPost recibido");
        
        // Obtener parámetros
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("contrasena");
        
        System.out.println("🔍 [LOGIN] Usuario: " + usuario);
        System.out.println("🔍 [LOGIN] Contraseña: " + contrasena);
        
        // Validaciones
        if (usuario == null || usuario.trim().isEmpty()) {
            request.setAttribute("error", "Usuario es obligatorio");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        if (contrasena == null || contrasena.trim().isEmpty()) {
            request.setAttribute("error", "Contraseña es obligatoria");
            request.getRequestDispatcher("login.jsp").forward(request, response);
            return;
        }
        
        // Autenticar
        Usuario usuarioAutenticado = usuarioDAO.autenticarUsuario(usuario, contrasena);
        
        if (usuarioAutenticado != null) {
            System.out.println("✅ [LOGIN] Autenticación exitosa");
            
            HttpSession session = request.getSession();
            session.setAttribute("usuario", usuarioAutenticado);
            session.setAttribute("tipo", usuarioAutenticado.getTipo());
            
            // Redirigir
            response.sendRedirect("http://localhost:8080/UDB_VIDEOTECA_VIRTUAL/");
            
        } else {
            System.out.println("❌ [LOGIN] Autenticación fallida");
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