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
        <title>Formulario CD</title>
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
                            <form action="CdControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty cds ? "Nuevo" : (cds.id == 0 ? "Nuevo" : "Editar")} CD</h3>
                                <hr />
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label>Stock:</label>
                                            <input value="${cds.stock}" name="stock" type="number" min="0" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Título:</label>
                                            <input value="${cds.titulo}" name="titulo" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Artista:</label>
                                            <input value="${cds.artista}" name="artista" type="text" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Productor:</label>
                                            <input value="${cds.productor}" name="productor" type="text" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label>Compositor:</label>
                                            <input value="${cds.compositor}" name="compositor" type="text" class="form-control">
                                        </div>
                                    </div>
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label>Discografía:</label>
                                            <input value="${cds.discografia}" name="discografia" type="text" class="form-control">
                                        </div>
                                        <div class="mb-3">
                                            <label>Año de Publicación:</label>
                                            <input value="${cds.year}" name="year" type="date" class="form-control" required="">
                                        </div>
                                        <div class="mb-3">
                                            <label>Género:</label>
                                            <select name="genero" class="form-control" required>
                                                <option value="">--Seleccione un género--</option>
                                                <option value="Rock" ${cds.genero == 'Rock' ? 'selected' : ''}>Rock</option>
                                                <option value="Pop" ${cds.genero == 'Pop' ? 'selected' : ''}>Pop</option>
                                                <option value="Jazz" ${cds.genero == 'Jazz' ? 'selected' : ''}>Jazz</option>
                                                <option value="Clásica" ${cds.genero == 'Clásica' ? 'selected' : ''}>Clásica</option>
                                                <option value="Electrónica" ${cds.genero == 'Electrónica' ? 'selected' : ''}>Electrónica</option>
                                                <option value="Hip Hop" ${cds.genero == 'Hip Hop' ? 'selected' : ''}>Hip Hop</option>
                                                <option value="Reggaetón" ${cds.genero == 'Reggaetón' ? 'selected' : ''}>Reggaetón</option>
                                                <option value="Balada" ${cds.genero == 'Balada' ? 'selected' : ''}>Balada</option>
                                                <option value="Salsa" ${cds.genero == 'Salsa' ? 'selected' : ''}>Salsa</option>
                                                <option value="Otro" ${cds.genero == 'Otro' ? 'selected' : ''}>Otro</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label>Idioma:</label>
                                            <select name="idioma" class="form-control" required>
                                                <option value="">--Seleccione un idioma--</option>
                                                <option value="Español" ${cds.idioma == 'Español' ? 'selected' : ''}>Español</option>
                                                <option value="Inglés" ${cds.idioma == 'Inglés' ? 'selected' : ''}>Inglés</option>
                                                <option value="Francés" ${cds.idioma == 'Francés' ? 'selected' : ''}>Francés</option>
                                                <option value="Italiano" ${cds.idioma == 'Italiano' ? 'selected' : ''}>Italiano</option>
                                                <option value="Alemán" ${cds.idioma == 'Alemán' ? 'selected' : ''}>Alemán</option>
                                                <option value="Portugués" ${cds.idioma == 'Portugués' ? 'selected' : ''}>Portugués</option>
                                                <option value="Otro" ${cds.idioma == 'Otro' ? 'selected' : ''}>Otro</option>
                                            </select>
                                        </div>
                                        <div class="mb-3">
                                            <label>País:</label>
                                            <input value="${cds.pais}" name="pais" type="text" class="form-control" placeholder="Ej: Estados Unidos, México, España">
                                        </div>
                                    </div>
                                </div>
                                <div class="mb-3">
                                    <input type="hidden" name="id" value="${cds.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <button class="btn btn-primary btn-sm">
                                        <i class="fa fa-save"></i> Guardar
                                    </button>
                                    <a href="CdControlador?accion=listar" class="btn btn-dark btn-sm">
                                        <i class="fa fa-arrow-left"></i> Volver atrás
                                    </a>
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