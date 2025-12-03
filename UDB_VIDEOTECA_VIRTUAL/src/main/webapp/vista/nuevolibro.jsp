<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Form Libro</title>
    </head>
    <body>
        <nav class="navbar navbar-light bg-light mb-3 border-bottom">
            <div class="container">
                <a class="navbar-brand" href="index.jsp">
                    <i class="fas fa-video"></i> Videoteca Virtual
                </a>
            </div>
        </nav>
        <div class="container mt-2">
            <div class="row justify-content-center">
                <div class="col-md-10">
                    <div class="card">
                        <div class="card-body">
                            <form action="LibroControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty libros.id ? "Nuevo": "Editar" } Libro</h3>
                                <hr />
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label>Disponibilidad:</label>
                                            <input value="${libros.stock}" name="stock" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>ISBN:</label>
                                            <input value="${libros.isbn}" name="isbn" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Titulo:</label>
                                            <input value="${libros.titulo}" name="titulo" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Autor:</label>
                                            <input value="${libros.autor}" name="autor" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Editorial:</label>
                                            <input value="${libros.editorial}" name="editorial" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Num. de paginas:</label>
                                            <input value="${libros.numpag}" name="numpag" type="text" class="form-control" required="">
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label>Publicacion:</label>
                                            <input value="${libros.year}" name="year" type="date" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Categoria:</label>
                                            <input value="${libros.categoria}" name="categoria" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Idioma:</label>
                                            <select name="idioma" class="form-control" required>
                                                <option value="">--Seleccione una opcion--</option>
                                                <option value="Español" ${libros.idioma == 'Español' ? 'selected' : ''}>Español</option>
                                                <option value="Ingles" ${libros.idioma == 'Ingles' ? 'selected' : ''}>Ingles</option>
                                                <option value="Frances" ${libros.idioma == 'Frances' ? 'selected' : ''}>Frances</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label>Formato:</label>
                                            <select name="formato" class="form-control" required>
                                                <option value="">--Seleccione una opcion--</option>
                                                <option value="Tapa Blanda" ${libros.formato == 'Tapa Blanda' ? 'selected' : ''}>Tapa Blanda</option>
                                                <option value="Tapa Dura" ${libros.formato == 'Tapa Dura' ? 'selected' : ''}>Tapa Dura</option>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="mb-3">
                                        <input type="hidden" name="id" value="${libros.id}">
                                        <input type="hidden" name="accion" value="guardar">
                                        <button class="btn btn-primary btn-sm">
                                            <i class="fa fa-save"></i> Guardar
                                        </button>
                                        <a href="LibroControlador?accion=listar" class="btn btn-dark btn-sm">
                                            <i class="fa fa-arrow-left"></i> Volver atrás
                                        </a>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
