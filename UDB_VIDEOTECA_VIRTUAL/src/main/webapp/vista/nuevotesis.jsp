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
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css">
        <title>Formulario Tesis</title>
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
                            <form action="TesisControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty tesis ? "Nueva" : (tesis.id == 0 ? "Nueva" : "Editar")} Tesis</h3>
                                <hr />
                                
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">ISBN:</label>
                                            <input value="${tesis.isbn}" name="isbn" type="text" class="form-control">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Título:</label>
                                            <input value="${tesis.titulo}" name="titulo" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Autor:</label>
                                            <input value="${tesis.autor}" name="autor" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Director de Tesis:</label>
                                            <input value="${tesis.director}" name="director" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Institución:</label>
                                            <input value="${tesis.institucion}" name="institucion" type="text" class="form-control" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">Año de Defensa:</label>
                                            <input value="${tesis.year}" name="year" type="date" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Grado Académico:</label>
                                            <select name="gradoacademico" class="form-control" required>
                                                <option value="">--Seleccione grado--</option>
                                                <option value="Licenciatura" ${tesis.gradoacademico == 'Licenciatura' ? 'selected' : ''}>Licenciatura</option>
                                                <option value="Maestría" ${tesis.gradoacademico == 'Maestría' ? 'selected' : ''}>Maestría</option>
                                                <option value="Doctorado" ${tesis.gradoacademico == 'Doctorado' ? 'selected' : ''}>Doctorado</option>
                                                <option value="Postdoctorado" ${tesis.gradoacademico == 'Postdoctorado' ? 'selected' : ''}>Postdoctorado</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Número de Páginas:</label>
                                            <input value="${tesis.numpag}" name="numpag" type="number" class="form-control" min="1" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Calificación:</label>
                                            <select name="calificacion" class="form-control" required>
                                                <option value="">--Seleccione calificación--</option>
                                                <option value="Sobresaliente" ${tesis.calificacion == 'Sobresaliente' ? 'selected' : ''}>Sobresaliente</option>
                                                <option value="Aprobado" ${tesis.calificacion == 'Aprobado' ? 'selected' : ''}>Aprobado</option>
                                                <option value="Muy Bueno" ${tesis.calificacion == 'Muy Bueno' ? 'selected' : ''}>Muy Bueno</option>
                                                <option value="Bueno" ${tesis.calificacion == 'Bueno' ? 'selected' : ''}>Bueno</option>
                                                <option value="Regular" ${tesis.calificacion == 'Regular' ? 'selected' : ''}>Regular</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Idioma:</label>
                                            <select name="idioma" class="form-control" required>
                                                <option value="">--Seleccione idioma--</option>
                                                <option value="Español" ${tesis.idioma == 'Español' ? 'selected' : ''}>Español</option>
                                                <option value="Inglés" ${tesis.idioma == 'Inglés' ? 'selected' : ''}>Inglés</option>
                                                <option value="Francés" ${tesis.idioma == 'Francés' ? 'selected' : ''}>Francés</option>
                                                <option value="Alemán" ${tesis.idioma == 'Alemán' ? 'selected' : ''}>Alemán</option>
                                                <option value="Portugués" ${tesis.idioma == 'Portugués' ? 'selected' : ''}>Portugués</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="mb-3">
                                    <input type="hidden" name="id" value="${tesis.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <button class="btn btn-primary btn-sm">
                                        <i class="fa fa-save"></i> Guardar
                                    </button>
                                    <a href="TesisControlador?accion=listar" class="btn btn-secondary btn-sm">
                                        <i class="fa fa-times"></i> Volver atrás
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