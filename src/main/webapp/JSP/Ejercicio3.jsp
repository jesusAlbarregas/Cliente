<jsp:directive.page contentType="text/html" pageEncoding="UTF-8"/>
<!DOCTYPE html>
<html lang="es">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio3</title>
        <link rel="stylesheet" type="text/css" href="${applicationScope.estilo}" />
        <script src="${applicationScope.contexto}/js/ejer3_1.js" defer></script>
        <%--<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>--%>
    </head>
    <body>
        <div id="principal">
            <h2>Escribir un mensaje del servidor</h2>
            <div id="terciario">
                <p id="mensaje"></p>
                
                <div class="b1">
                    <input class="boton" type="button" value="Mensaje" id="btnEnviar" />
                </div>
                <div class="b2">
                    <input class="boton" type="button" value="Indice" id="btnVolver" onclick="location.href = 'Finalizar'" />
                </div>
            </div>
        </div>       
    </body>
    <%--<script type="text/javascript" src="${applicationScope.contexto}/js/ejer3.js"></script>--%>
</html>
