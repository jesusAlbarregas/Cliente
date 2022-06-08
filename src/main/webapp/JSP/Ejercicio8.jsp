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
        <title>Ejercicio7</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    </head>
    <body>
        <div id="principal">
            <h2>select anidados</h2>
            <div>      
                <select id="comunidad">
                    <option value="">Elige la comunidad</option>
                </select>

                <select id="provincia">
                    <option value="">Elige la provincia</option>
                </select>

                <select id="localidad">
                    <option value="">Elige la localidad</option>
                </select>

            </div>
            <br><br>
            <div id="espera" style="text-align: center;">
            </div>

            <div id="mensajes" style="text-align: center;">
            </div>
            <div class="b1">
                <input class="boton" type="button" value="Indice" name="cancelar" id="volver" onclick="location.href = 'Finalizar'" />
            </div>

        </div>
    </div>       
</body>
<script type="text/javascript" src="${contexto}/js/ejer8.js"></script>
</html>
