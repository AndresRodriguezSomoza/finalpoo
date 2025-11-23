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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
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
            case "editar":
                editar(request, response);
                break;
            case "eliminar":
                eliminar(request, response);
                break;
            default:
                throw new ServletException("Acción no válida: " + accion);
        }
    }

    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        int result = clibro.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Libro con id " + id + " eliminado!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar libro.");
        }
        response.sendRedirect("LibroControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadLibro obj = clibro.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("libros", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró el libro con ID: " + id);

            response.sendRedirect("LibroControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadLibro obj = new EntidadLibro();
        obj.setId(Integer.parseInt(request.getParameter("id")));
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

        int result;

        if (obj.getId() == 0) {
            result = clibro.registrar(obj);
        } else {
            result = clibro.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("LibroControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("libros", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevolibro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("libro", new EntidadLibro());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("libros", clibro.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}
