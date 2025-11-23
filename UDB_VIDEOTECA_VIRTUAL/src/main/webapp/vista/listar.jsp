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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Libros</title>
    </head>
    <body>
        <div class="container mt-3">
            <div class="card">
                <div class="card-body">
                    <h3>Libros UDB</h3>
                    <hr />

                    <a href="LibroControlador?accion=nuevolibro" class="btn btn-success btn-sm">
                        <i class="fa fa-plus-circle"></i> Nuevo libro
                    </a>

                    <jsp:include page="../components/Mensaje.jsp" />

                    <table class="table table-bordered table-striped mt-2">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Codigo</th>
                                <th>Disponibles</th>
                                <th>ISBN</th>
                                <th>Titulo</th>
                                <th>Autor</th>
                                <th>Editorial</th>
                                <th>Num. de paginas</th>
                                <th>Publicado</th>
                                <th>Categoria</th>
                                <th>Idioma</th>
                                <th>Formato</th>
                                <th>Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${libros}" var="item">
                                <tr>
                                    <td>${item.id}</td>
                                    <td>${item.cdidentificacion}</td>
                                    <td>${item.stock}</td>
                                    <td>${item.isbn}</td>
                                    <td>${item.titulo}</td>
                                    <td>${item.autor}</td>
                                    <td>${item.editorial}</td>
                                    <td>${item.numpag}</td>
                                    <td>${item.year}</td>
                                    <td>${item.categoria}</td>
                                    <td>${item.idioma}</td>
                                    <td>${item.formato}</td>
                                    <td>
                                        <a href="LibroControlador?accion=editar&id=${item.id}" 
                                           class="btn btn-info btn-sm">
                                            <i class="fa fa-edit"></i>
                                        </a>
                                        <a href="LibroControlador?accion=eliminar&id=${item.id}" 
                                           onclick="return confirm('Estas seguro que desea eliminar el empleado con id ${item.id}')"
                                           class="btn btn-danger btn-sm">
                                            <i class="fa fa-trash"></i>
                                        </a>
                                    </td>
                                </tr>
                            </c:forEach>
                            <c:if test="${libros.size() == 0}">
                                <tr>
                                    <td colspan="12">Tabla vacia</td>
                                </tr>
                            </c:if>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </body>
</html>
