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
        <title>Formulario Obra</title>
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
                            <form action="ObraControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty obras ? "Nueva" : (obras.id == 0 ? "Nueva" : "Editar")} Obra</h3>
                                <hr />
                                
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">ISBN:</label>
                                            <input value="${obras.isbn}" name="isbn" type="text" class="form-control">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Disponibilidad:</label>
                                            <input value="${obras.stock}" name="stock" type="number" class="form-control" min="0" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Título:</label>
                                            <input value="${obras.titulo}" name="titulo" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Autor:</label>
                                            <input value="${obras.autor}" name="autor" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Editorial:</label>
                                            <input value="${obras.editorial}" name="editorial" type="text" class="form-control">
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">Año de Publicación:</label>
                                            <input value="${obras.year}" name="year" type="date" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Género Principal:</label>
                                            <select name="genero" class="form-control" required>
                                                <option value="">--Seleccione un género--</option>
                                                <option value="Novela" ${obras.genero == 'Novela' ? 'selected' : ''}>Novela</option>
                                                <option value="Poesía" ${obras.genero == 'Poesía' ? 'selected' : ''}>Poesía</option>
                                                <option value="Teatro" ${obras.genero == 'Teatro' ? 'selected' : ''}>Teatro</option>
                                                <option value="Ensayo" ${obras.genero == 'Ensayo' ? 'selected' : ''}>Ensayo</option>
                                                <option value="Cuento" ${obras.genero == 'Cuento' ? 'selected' : ''}>Cuento</option>
                                                <option value="Biografía" ${obras.genero == 'Biografía' ? 'selected' : ''}>Biografía</option>
                                                <option value="Histórico" ${obras.genero == 'Histórico' ? 'selected' : ''}>Histórico</option>
                                                <option value="Ciencia Ficción" ${obras.genero == 'Ciencia Ficción' ? 'selected' : ''}>Ciencia Ficción</option>
                                                <option value="Fantasía" ${obras.genero == 'Fantasía' ? 'selected' : ''}>Fantasía</option>
                                                <option value="Otro" ${obras.genero == 'Otro' ? 'selected' : ''}>Otro</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Número de Páginas:</label>
                                            <input value="${obras.numpag}" name="numpag" type="number" class="form-control" min="1">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Subgénero:</label>
                                            <input value="${obras.subgenero}" name="subgenero" type="text" class="form-control">
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Tema Principal:</label>
                                            <input value="${obras.tema}" name="tema" type="text" class="form-control">
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="mb-3">
                                    <input type="hidden" name="id" value="${obras.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <button class="btn btn-primary btn-sm">
                                        <i class="fa fa-save"></i> Guardar
                                    </button>
                                    <a href="ObraControlador?accion=listar" class="btn btn-secondary btn-sm">
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