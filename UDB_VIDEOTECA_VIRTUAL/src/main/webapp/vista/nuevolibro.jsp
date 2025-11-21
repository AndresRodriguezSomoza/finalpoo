<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/7.0.1/css/all.min.css" integrity="sha512-2SwdPD6INVrV/lHTZbO2nodKhrnDdJK9/kg2XD1r9uGqPo1cUbujc+IYdlYdEErWNu69gVcYgdxlmVmzTWnetw==" crossorigin="anonymous" referrerpolicy="no-referrer" />
        <title>Form Libro</title>
    </head>
    <body>
        <div class="container mt-2">
            <div>
                <div class="card-body">
                    <form action="LibroControlador" method="post">
                        <h3>Nuevo Libro</h3>
                        <hr />
                        <div class="mb-3">
                            <label>Disponibilidad:</label>
                            <input name="stock" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>ISBN:</label>
                            <input name="isbn" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Titulo:</label>
                            <input name="titulo" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Autor:</label>
                            <input name="autor" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Editorial:</label>
                            <input name="editorial" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Num. de paginas:</label>
                            <input name="numpag" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Publicacion:</label>
                            <input name="year" type="date" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Categoria:</label>
                            <input name="categoria" type="text" class="form-control" required="">
                        </div>
                        <div class="mb-3">
                            <label>Idioma:</label>
                            <select name="idioma" id="idioma-select" class="form-control" required="">
                                <option value="">--Seleccione una opcion--</option>
                                <option value="Español">Español</option>
                                <option value="Ingles">Ingles</option>
                                <option value="Frances">Frances</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label>Formato:</label>
                            <select name="formato" id="formato-select" class="form-control" required="">
                                <option value="">--Seleccione una opcion--</option>
                                <option value="Tapa Blanda">Tapa Blanda</option>
                                <option value="Tapa Dura">Tapa Dura</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <input type="hidden" name="accion" value="guardar">
                            <button class="btn btn-primary btn-sm">
                                <i class="fa fa-save"></i> Registrar
                            </button>
                            <a href="LibroControlador?accion=listar" class="btn btn-dark btn-sm">
                                <i class="fa fa-arrow-left"></i> Volver atras
                            </a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
