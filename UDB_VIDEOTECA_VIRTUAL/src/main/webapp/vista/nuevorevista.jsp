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
        <title>Formulario Revista</title>
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
                            <form action="RevistaControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty revistas ? "Nueva" : (revistas.id == 0 ? "Nueva" : "Editar")} Revista</h3>
                                <hr />
                                
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">ISSN:</label>
                                            <input value="${revistas.issn}" name="issn" type="text" class="form-control">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Disponibilidad:</label>
                                            <input value="${revistas.stock}" name="stock" type="number" class="form-control" min="0" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Título:</label>
                                            <input value="${revistas.titulo}" name="titulo" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Editorial:</label>
                                            <input value="${revistas.editorial}" name="editorial" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Edición:</label>
                                            <input value="${revistas.edicion}" name="edicion" type="number" class="form-control" min="1" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">Año de Publicación:</label>
                                            <input value="${revistas.year}" name="year" type="date" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Periodicidad:</label>
                                            <select name="periocidad" class="form-control" required>
                                                <option value="">--Seleccione periodicidad--</option>
                                                <option value="Diaria" ${revistas.periocidad == 'Diaria' ? 'selected' : ''}>Diaria</option>
                                                <option value="Semanal" ${revistas.periocidad == 'Semanal' ? 'selected' : ''}>Semanal</option>
                                                <option value="Quincenal" ${revistas.periocidad == 'Quincenal' ? 'selected' : ''}>Quincenal</option>
                                                <option value="Mensual" ${revistas.periocidad == 'Mensual' ? 'selected' : ''}>Mensual</option>
                                                <option value="Bimestral" ${revistas.periocidad == 'Bimestral' ? 'selected' : ''}>Bimestral</option>
                                                <option value="Trimestral" ${revistas.periocidad == 'Trimestral' ? 'selected' : ''}>Trimestral</option>
                                                <option value="Semestral" ${revistas.periocidad == 'Semestral' ? 'selected' : ''}>Semestral</option>
                                                <option value="Anual" ${revistas.periocidad == 'Anual' ? 'selected' : ''}>Anual</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Número de Páginas:</label>
                                            <input value="${revistas.numpag}" name="numpag" type="number" class="form-control" min="1">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Estado:</label>
                                            <select name="estado" class="form-control" required>
                                                <option value="">--Seleccione estado--</option>
                                                <option value="Disponible" ${revistas.estado == 'Disponible' ? 'selected' : ''}>Disponible</option>
                                                <option value="Prestado" ${revistas.estado == 'Prestado' ? 'selected' : ''}>Prestado</option>
                                                <option value="Reservado" ${revistas.estado == 'Reservado' ? 'selected' : ''}>Reservado</option>
                                                <option value="En reparación" ${revistas.estado == 'En reparación' ? 'selected' : ''}>En reparación</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="mb-3">
                                    <input type="hidden" name="id" value="${revistas.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <button class="btn btn-primary btn-sm">
                                        <i class="fa fa-save"></i> Guardar
                                    </button>
                                    <a href="RevistaControlador?accion=listar" class="btn btn-secondary btn-sm">
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