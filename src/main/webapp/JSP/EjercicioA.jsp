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
        <title>Ejercicio10</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
    </head>
    <body>
        <div id="principal">
            <h2>DNI válido y correcto</h2>
            <div>
                <span>Introduce los números del DNI: </span>
                <input type="text" name="dni" id="dni" placeholder="Ej: 00001234S">
            </div>
            <div class="b1">
                <input class="boton" type="button" value="Indice" name="cancelar" id="volver" onclick="location.href = 'Finalizar'" />
            </div>
        </div>       
    </body>
    
</html>
<script type="text/javascript" src="${contexto}/js/ejerA.js"></script>
