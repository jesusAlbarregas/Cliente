<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar datos</title>
        <link rel="stylesheet" type="text/css" href="${estilo}">
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
    </head>
    <body>
        <div id="principal" style="width: 60%; position: relative; left: 20%;">
              
            <form id="modAvatar">
                <fieldset style="padding-left: 20px;">
                    <!--<input type="hidden" name="id" value="${usuario.id}">-->
                    <legend>Datos del usuario</legend>
                    <label for="nombre">Nombre:</label>
                    <input type="text" id="nombre" name="nombre" maxlength="15" required="required" class="form-control" placeholder="Ej: Juan"/>
                    <br>
                    <label for="ape">Apellidos:</label>
                    <input type="text" id="ape" name="apellidos" required="required" class="form-control" placeholder="Ej: Pérez García"/>
                    <br>
                    
                    <label for="fn">Fecha de nacimiento: </label>
                    <input id="fn" type="date" name="fechaNacimiento" placeholder="dd-mm-aaaa" required="required" class="form-control">
                    <br>
                    
                    <img src='<c:url value="/images/avatar/default.png"/>' 
                         alt="avatar del usuario" title="Avatar del usuario" width="100" height="100" id="previa"/>
                    <br>
                    <label for="ficheroAvatar">Avatar (png o jpg y como máximo 100 KB): </label>
                    <input id="ficheroAvatar" type="file" name="avatar" required="required" class="form-control">

                </fieldset>
                <br/>
                <div class="b1">
                    <button class="boton" name="realizar" id="cambiarAvatar">
                        <div>Añadir</div>
                    </button>
                </div>
                
                
            </form>
                         <div id="terciario" style="width: 96%; left: 2%;">
                    <table>
                        <thead id="cabSegunda"></thead>
                        <tbody id="segunda"></tbody>
                    </table>
                             <div>
                                 <img id="imagenDelServidor" src="" hidden="hidden">
                             </div>
                    <div class="b1">
                        <input id="vuelta" class="boton" type="button" value="Indice" name="cancelar" onclick="location.href = 'Finalizar'" hidden="hidden"/>
                    </div>



                </div>
        </div>
                         <script type="text/javascript" src="${contexto}/js/ejer9.js"></script>
    </body>
</html>
