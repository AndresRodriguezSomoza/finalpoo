package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadRevista;

public class RevistaControlador extends HttpServlet {

    private CRevista crevista = new CRevista();
    private final String pagListar = "/vista/crud_revista.jsp";
    private final String pagNuevo = "/vista/nuevorevista.jsp";

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
            case "nuevarevista":
                nuevarevista(request, response);
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

        int result = crevista.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Revista con id " + id + " eliminada!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar la revista.");
        }
        response.sendRedirect("RevistaControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadRevista obj = crevista.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("revistas", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró la revista con ID: " + id);
            response.sendRedirect("RevistaControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadRevista obj = new EntidadRevista();
        
        // Para el parámetro id
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setId(Integer.parseInt(idParam));
        } else {
            obj.setId(0);
        }
        
        obj.setIssn(request.getParameter("issn"));
        obj.setStock(Integer.parseInt(request.getParameter("stock")));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setEditorial(request.getParameter("editorial"));
        obj.setEdicion(Integer.parseInt(request.getParameter("edicion")));
        obj.setYear(request.getParameter("year"));
        obj.setPeriocidad(request.getParameter("periocidad"));
        obj.setNumpag(Integer.parseInt(request.getParameter("numpag")));
        obj.setEstado(request.getParameter("estado"));

        int result;

        if (obj.getId() == 0) {
            result = crevista.registrar(obj);
        } else {
            result = crevista.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("RevistaControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("revistas", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevarevista(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("revistas", new EntidadRevista());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("revistas", crevista.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}