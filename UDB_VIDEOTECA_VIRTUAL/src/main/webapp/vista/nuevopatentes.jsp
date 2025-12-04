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
        <title>Formulario Patente</title>
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
                            <form action="PatentesControlador" method="post" accept-charset="UTF-8">
                                <h3>${empty patentes ? "Nueva" : (patentes.id == 0 ? "Nueva" : "Editar")} Patente</h3>
                                <hr />
                                
                                <div class="row">
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">Título de la Patente:</label>
                                            <input value="${patentes.titulo}" name="titulo" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Inventor(es):</label>
                                            <input value="${patentes.inventor}" name="inventor" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Titular:</label>
                                            <input value="${patentes.titular}" name="titular" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Fecha de Registro:</label>
                                            <input value="${patentes.fecha_registro}" name="fecha_registro" type="date" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Fecha de Vencimiento:</label>
                                            <input value="${patentes.fecha_vencimiento}" name="fecha_vencimiento" type="date" class="form-control" readonly>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">País:</label>
                                            <input value="${patentes.pais}" name="pais" type="text" class="form-control" required>
                                        </div>
                                    </div>
                                    
                                    <div class="col-md-6">
                                        <div class="mb-3">
                                            <label class="form-label">Número de Patente:</label>
                                            <input value="${patentes.patente}" name="patente" type="text" class="form-control" required>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Estado:</label>
                                            <select name="estado" class="form-control" required>
                                                <option value="">--Seleccione estado--</option>
                                                <option value="Activa" ${patentes.estado == 'Activa' ? 'selected' : ''}>Activa</option>
                                                <option value="Vencida" ${patentes.estado == 'Vencida' ? 'selected' : ''}>Vencida</option>
                                                <option value="En Proceso" ${patentes.estado == 'En Proceso' ? 'selected' : ''}>En Proceso</option>
                                                <option value="Renovada" ${patentes.estado == 'Renovada' ? 'selected' : ''}>Renovada</option>
                                                <option value="Cancelada" ${patentes.estado == 'Cancelada' ? 'selected' : ''}>Cancelada</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Extensión Regional:</label>
                                            <select name="extension_regional" class="form-control">
                                                <option value="">--Seleccione extensión--</option>
                                                <option value="PCT" ${patentes.extension_regional == 'Nacional' ? 'selected' : ''}>PCT</option>
                                                <option value="EAPO" ${patentes.extension_regional == 'Regional' ? 'selected' : ''}>EAPO</option>
                                                <option value="EPO" ${patentes.extension_regional == 'Internacional' ? 'selected' : ''}>EPO</option>
                                                <option value="OAPI" ${patentes.extension_regional == 'Centroamérica' ? 'selected' : ''}>OAPI</option>
                                                <option value="ARIPO" ${patentes.extension_regional == 'América' ? 'selected' : ''}>ARIPO</option>
                                            </select>
                                        </div>
                                        
                                        <div class="mb-3">
                                            <label class="form-label">Campo Tecnológico:</label>
                                            <select name="campo_tecnologico" class="form-control" required>
                                                <option value="">--Seleccione campo--</option>
                                                <option value="Tecnología Informática" ${patentes.campo_tecnologico == 'Tecnología Informática' ? 'selected' : ''}>Tecnología Informática</option>
                                                <option value="Biotecnología" ${patentes.campo_tecnologico == 'Biotecnología' ? 'selected' : ''}>Biotecnología</option>
                                                <option value="Ingeniería Mecánica" ${patentes.campo_tecnologico == 'Ingeniería Mecánica' ? 'selected' : ''}>Ingeniería Mecánica</option>
                                                <option value="Ingeniería Eléctrica" ${patentes.campo_tecnologico == 'Ingeniería Eléctrica' ? 'selected' : ''}>Ingeniería Eléctrica</option>
                                                <option value="Medicina" ${patentes.campo_tecnologico == 'Medicina' ? 'selected' : ''}>Medicina</option>
                                                <option value="Farmacéutica" ${patentes.campo_tecnologico == 'Farmacéutica' ? 'selected' : ''}>Farmacéutica</option>
                                                <option value="Energía" ${patentes.campo_tecnologico == 'Energía' ? 'selected' : ''}>Energía</option>
                                                <option value="Telecomunicaciones" ${patentes.campo_tecnologico == 'Telecomunicaciones' ? 'selected' : ''}>Telecomunicaciones</option>
                                                <option value="Química" ${patentes.campo_tecnologico == 'Química' ? 'selected' : ''}>Química</option>
                                                <option value="Materiales" ${patentes.campo_tecnologico == 'Materiales' ? 'selected' : ''}>Materiales</option>
                                                <option value="Otro" ${patentes.campo_tecnologico == 'Otro' ? 'selected' : ''}>Otro</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                
                                <div class="mb-3">
                                    <input type="hidden" name="id" value="${patentes.id}">
                                    <input type="hidden" name="accion" value="guardar">
                                    <button class="btn btn-primary btn-sm">
                                        <i class="fa fa-save"></i> Guardar
                                    </button>
                                    <a href="PatentesControlador?accion=listar" class="btn btn-secondary btn-sm">
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
