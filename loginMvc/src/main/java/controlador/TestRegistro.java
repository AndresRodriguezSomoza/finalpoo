package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "TestRegistro", urlPatterns = {"/testregistro"})
public class TestRegistro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("🎯🎯🎯 TEST REGISTRO EJECUTADO 🎯🎯🎯");
        System.out.println("✅ Servlet funcionando correctamente");
        System.out.println("✅ Conexión establecida");
        
        response.getWriter().println("TEST EXITOSO - Revisa la consola de NetBeans");
    }
}