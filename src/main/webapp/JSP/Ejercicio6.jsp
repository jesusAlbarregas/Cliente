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
        <title>Ejercicio6</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
        <script type="text/javascript" src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/notify/0.4.2/notify.min.js"></script>
    </head>
    <body>
        <div id="principal">
            <h2>Interpretar objetos JSON en Java</h2>
            <form id="form1">
                <table>
                    <tr>
                        <td><label for="nombre">Nombre</label></td>
                        <td colspan="2"><input type="text" name="nombre" id="nombre" placeholder="Ej: Juan"></td>
                    </tr>
                    <tr>
                        <td><label for="apellidos">Apellidos</label></td>
                        <td colspan="2"><input type="text" name="apellidos" id="apellidos" placeholder="Ej: Sánchez Pérez"></td>
                    </tr>
                    <tr>
                        <td><label for="dni">DNI</label></td>
                        <td colspan="2"><input type="text" name="dni" id="dni" placeholder="Ej: 12345678A"></td>
                    </tr>
                    <tr>
                        <td><label for="numHer">Número de hermanos</label></td>
                        <td colspan="2"><input type="text" name="numHer" id="numHer" placeholder="Ej: 1"></td>
                    </tr>
                    <tr>
                        <td><label for="fecha">Fecha nacimiento</label></td>
                        <td colspan="2"><input type="date" name="fecha" id="fecha"></td>
                    </tr>

                </table>
                <div class="b1">
                    <input class="boton" type="button" value="Enviar" id="enviar" />
                </div>
                <div class="b2">
                    <input class="boton" type="reset" value="Limpiar">
                </div>
                
            </form>
            <div id="terciario" style="width: 96%; left: 2%;">
                    <table>
                        <thead></thead>
                        <tbody id="segunda"></tbody>
                    </table>
                    <div class="b1">
                        <input class="boton" type="button" value="Indice" name="cancelar" onclick="location.href = 'Finalizar'" />
                    </div>



                </div>
        </div>       
    </body>
    
    <script type="text/javascript" src="${contexto}/js/ejer6.js"></script>
</html>
