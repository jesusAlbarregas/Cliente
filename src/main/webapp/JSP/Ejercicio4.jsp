<%-- 
    Document   : Ejercicio1
    Created on : 04-dic-2019, 10:00:28
    Author     : jesus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio4</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    </head>
    <body>
        <div id="principal">
            <h2>Cargar una lista</h2>
            <div id="terciario">
                <ol id="lista">
                </ol>



                <div class="b1">
                    <input class="boton" type="button" value="Lista" id="enviar" />
                </div>
                <div class="b2">
                    <input class="boton" type="button" value="Indice" name="cancelar" id="volver" onclick="location.href = 'Finalizar'" />
                </div>

            </div>
        </div>       
    </body>
    <script type="text/javascript" src="${contexto}/js/ejer4.js"></script>
</html>
