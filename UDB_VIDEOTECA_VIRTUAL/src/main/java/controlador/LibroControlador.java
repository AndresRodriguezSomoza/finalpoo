package controlador;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadLibro;

public class LibroControlador extends HttpServlet {

    private CLibro clibro = new CLibro();
    private final String pagListar = "/vista/listar.jsp";
    private final String pagNuevo = "/vista/nuevolibro.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");

        switch (accion) {
            case "listar":
                listar(request, response);
                break;
            case "nuevolibro":
                nuevolibro(request, response);
                break;
            case "guardar":
                guardar(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        EntidadLibro obj = new EntidadLibro();
        obj.setStock(Integer.parseInt(request.getParameter("stock")));
        obj.setIsbn(request.getParameter("isbn"));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setAutor(request.getParameter("autor"));
        obj.setEditorial(request.getParameter("editorial"));
        obj.setNumpag(Integer.parseInt(request.getParameter("numpag")));
        obj.setYear(request.getParameter("year"));
        obj.setCategoria(request.getParameter("categoria"));
        obj.setIdioma(request.getParameter("idioma"));
        obj.setFormato(request.getParameter("formato"));

        int result = clibro.registrar(obj);

        if (result > 0) {
            response.sendRedirect(pagListar);
        }
    }

    protected void nuevolibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("libro", new EntidadLibro());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("libros", clibro.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}
