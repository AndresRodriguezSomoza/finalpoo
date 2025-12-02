package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadObra;

public class ObraControlador extends HttpServlet {

    private CObra cobra = new CObra();
    private final String pagListar = "/vista/crud_obra.jsp";
    private final String pagNuevo = "/vista/nuevoobra.jsp";

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
            case "nuevaobra":
                nuevaobra(request, response);
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

        int result = cobra.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Obra con id " + id + " eliminada!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar la obra.");
        }
        response.sendRedirect("ObraControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadObra obj = cobra.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("obras", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró la obra con ID: " + id);
            response.sendRedirect("ObraControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadObra obj = new EntidadObra();
        
        // Para el parámetro id
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setId(Integer.parseInt(idParam));
        } else {
            obj.setId(0);
        }
        
        obj.setIsbn(request.getParameter("isbn"));
        obj.setStock(Integer.parseInt(request.getParameter("stock")));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setAutor(request.getParameter("autor"));
        obj.setEditorial(request.getParameter("editorial"));
        obj.setYear(request.getParameter("year"));
        obj.setGenero(request.getParameter("genero"));
        obj.setNumpag(Integer.parseInt(request.getParameter("numpag")));
        obj.setSubgenero(request.getParameter("subgenero"));
        obj.setTema(request.getParameter("tema"));

        int result;

        if (obj.getId() == 0) {
            result = cobra.registrar(obj);
        } else {
            result = cobra.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("ObraControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("obras", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevaobra(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("obras", new EntidadObra());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("obras", cobra.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}
