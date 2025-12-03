<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    response.setCharacterEncoding("UTF-8");
    request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
        <title>Tesis - Videoteca Virtual</title>
    </head>
    <body>
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
            <div class="container">
                <a class="navbar-brand" href="#">
                    Videoteca Virtual UDB
                </a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle active" href="#" id="navbarDropdown" role="button" 
                               data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="fas fa-book"></i> Materiales
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="LibroControlador?accion=listar">
                                    <i class="fas fa-book"></i> Libros
                                </a></li>
                                <li><a class="dropdown-item" href="CdControlador?accion=listar">
                                    <i class="fas fa-compact-disc"></i> CDs
                                </a></li>
                                <li><a class="dropdown-item active" href="TesisControlador?accion=listar">
                                    <i class="fas fa-graduation-cap"></i> Tesis
                                </a></li>
                                <li><a class="dropdown-item" href="RevistaControlador?accion=listar">
                                    <i class="fas fa-newspaper"></i> Revistas
                                </a></li>
                                <li><a class="dropdown-item" href="ObraControlador?accion=listar">
                                    <i class="fas fa-palette"></i> Obras
                                </a></li>
                                <li><a class="dropdown-item" href="PatentesControlador?accion=listar">
                                    <i class="fas fa-certificate"></i> Patentes
                                </a></li>
                            </ul>
                        </li>
                    </ul>
                    <div class="d-flex">
                        <a href="#" class="btn btn-outline-light btn-sm">
                            <i class="fas fa-sign-out-alt"></i> Salir
                        </a>
                    </div>
                </div>
            </div>
        </nav>

        <div class="container mt-3">
            <div class="card">
                <div class="card-body">
                    <h3>Tesis</h3>
                    <hr />

                    <a href="TesisControlador?accion=nuevatesis" class="btn btn-success btn-sm">
                        <i class="fa fa-plus-circle"></i> Nueva Tesis
                    </a>

                    <jsp:include page="../components/Mensaje.jsp" />

                    <table class="table table-bordered table-striped mt-2">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Código</th>
                                <th>ISBN</th>
                                <th>Título</th>
                                <th>Autor</th>
                                <th>Director</th>
                                <th>Institución</th>
                                <th>Año</th>
                                <th>Grado</th>
                                <th>Páginas</th>
                                <th>Calificación</th>
                                <th>Idioma</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${tesis}" var="item">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.cdidentificacion}</td>
                                    <td>${item.isbn}</td>
                                    <td>${item.titulo}</td>
                                    <td>${item.autor}</td>
                                    <td>${item.director}</td>
                                    <td>${item.institucion}</td>
                                    <td>${item.year}</td>
                                    <td>${item.gradoacademico}</td>
                                    <td>${item.numpag}</td>
                                    <td>
                                        <span class="badge bg-${item.calificacion == 'Aprobado' ? 'success' : item.calificacion == 'Sobresaliente' ? 'info' : 'warning'}">
                                            ${item.calificacion}
                                        </span>
                                    </td>
                                    <td>${item.idioma}</td>
                                    <td>
                                        <a href="TesisControlador?accion=editar&id=${item.id}" 
                                           class="btn btn-info btn-sm">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                        <a href="TesisControlador?accion=eliminar&id=${item.id}" 
                                           onclick="return confirm('¿Estás seguro que deseas eliminar la tesis con id ${item.id}?')"
                                           class="btn btn-danger btn-sm">
                                            <i class="fa fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:if test="${empty tesis or tesis.size() == 0}">
                                <tr>
                                    <td colspan="13">No hay tesis registradas</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
                    
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>