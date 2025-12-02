package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadCd;

public class CdControlador extends HttpServlet {

    private CCd ccd = new CCd();
    private final String pagListar = "/vista/crud_cd.jsp";
    private final String pagNuevo = "/vista/nuevocd.jsp";

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
            case "nuevocd":
                nuevocd(request, response);
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

        int result = ccd.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "CD con id " + id + " eliminado!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar CD.");
        }
        response.sendRedirect("CdControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadCd obj = ccd.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("cds", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró el CD con ID: " + id);
            response.sendRedirect("CdControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadCd obj = new EntidadCd();
        
        // Para el parámetro id, si viene vacío o es 0, asignar 0 (nuevo registro)
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setId(Integer.parseInt(idParam));
        } else {
            obj.setId(0);
        }
        
        obj.setStock(Integer.parseInt(request.getParameter("stock")));
        obj.setTitulo(request.getParameter("titulo"));
        obj.setArtista(request.getParameter("artista"));
        obj.setProductor(request.getParameter("productor"));
        obj.setCompositor(request.getParameter("compositor"));
        obj.setDiscografia(request.getParameter("discografia"));
        obj.setYear(request.getParameter("year"));
        obj.setGenero(request.getParameter("genero"));
        obj.setIdioma(request.getParameter("idioma"));
        obj.setPais(request.getParameter("pais"));

        int result;

        if (obj.getId() == 0) {
            result = ccd.registrar(obj);
        } else {
            result = ccd.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("CdControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("cds", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevocd(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("cds", new EntidadCd());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("cds", ccd.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}