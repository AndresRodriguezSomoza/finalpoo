package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelos.EntidadPatentes;

public class PatentesControlador extends HttpServlet {

    private CPatentes cpatentes = new CPatentes();
    private final String pagListar = "/vista/crud_patentes.jsp";
    private final String pagNuevo = "/vista/nuevopatentes.jsp";

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
            case "nuevapatente":
                nuevapatente(request, response);
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

        int result = cpatentes.eliminar(id);

        if (result > 0) {
            request.getSession().setAttribute("success", "Patente con id " + id + " eliminada!");
        } else {
            request.getSession().setAttribute("error", "No se pudo eliminar la patente.");
        }
        response.sendRedirect("PatentesControlador?accion=listar");
    }

    private void editar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        int id = Integer.parseInt(request.getParameter("id"));

        EntidadPatentes obj = cpatentes.buscarPorId(id);

        if (obj != null) {
            request.setAttribute("patentes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        } else {
            request.getSession().setAttribute("error", "No se encontró la patente con ID: " + id);
            response.sendRedirect("PatentesControlador?accion=listar");
        }
    }

    private void guardar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        EntidadPatentes obj = new EntidadPatentes();
        
        // Para el parámetro id
        String idParam = request.getParameter("id");
        if (idParam != null && !idParam.isEmpty()) {
            obj.setId(Integer.parseInt(idParam));
        } else {
            obj.setId(0);
        }
        
        obj.setTitulo(request.getParameter("titulo"));
        obj.setInventor(request.getParameter("inventor"));
        obj.setTitular(request.getParameter("titular"));
        obj.setFecha_registro(request.getParameter("fecha_registro"));
        obj.setFecha_vencimiento(request.getParameter("fecha_vencimiento"));
        obj.setPais(request.getParameter("pais"));
        obj.setPatente(request.getParameter("patente"));
        obj.setEstado(request.getParameter("estado"));
        obj.setExtension_regional(request.getParameter("extension_regional"));
        obj.setCampo_tecnologico(request.getParameter("campo_tecnologico"));

        int result;

        if (obj.getId() == 0) {
            result = cpatentes.registrar(obj);
        } else {
            result = cpatentes.editar(obj);
        }

        if (result > 0) {
            request.getSession().setAttribute("success", "Datos guardados!");
            response.sendRedirect("PatentesControlador?accion=listar");
        } else {
            request.getSession().setAttribute("error", "No se pudo guardar datos.");
            request.setAttribute("patentes", obj);
            request.getRequestDispatcher(pagNuevo).forward(request, response);
        }
    }

    protected void nuevapatente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("patentes", new EntidadPatentes());
        request.getRequestDispatcher(pagNuevo).forward(request, response);
    }

    protected void listar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("patentes", cpatentes.ListarTodos());
        request.getRequestDispatcher(pagListar).forward(request, response);
    }
}
