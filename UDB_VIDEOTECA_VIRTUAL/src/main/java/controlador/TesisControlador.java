package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadTesis;

public class TesisControlador extends HttpServlet {

    private CTesis ctesis = new CTesis();
    private final String pagListar = "/vista/crud_tesis.jsp";
    private final String pagNuevo = "/vista/nuevotesis.jsp";

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
            case "nuevatesis":
                nuevatesis(request, response);
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

        int result = ctesis.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Tesis con id " + id + " eliminada!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar la tesis.");
        }
        response.sendRedirect("TesisControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadTesis obj = ctesis.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("tesis", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró la tesis con ID: " + id);
            response.sendRedirect("TesisControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadTesis obj = new EntidadTesis();
        
        // Para el parámetro id
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setId(Integer.parseInt(idParam));
        } else {
            obj.setId(0);
        }
        
        obj.setIsbn(request.getParameter("isbn"));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setAutor(request.getParameter("autor"));
        obj.setDirector(request.getParameter("director"));
        obj.setInstitucion(request.getParameter("institucion"));
        obj.setYear(request.getParameter("year"));
        obj.setGradoacademico(request.getParameter("gradoacademico"));
        obj.setNumpag(Integer.parseInt(request.getParameter("numpag")));
        obj.setCalificacion(request.getParameter("calificacion"));
        obj.setIdioma(request.getParameter("idioma"));

        int result;

        if (obj.getId() == 0) {
            result = ctesis.registrar(obj);
        } else {
            result = ctesis.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("TesisControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("tesis", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevatesis(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("tesis", new EntidadTesis());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("tesis", ctesis.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}