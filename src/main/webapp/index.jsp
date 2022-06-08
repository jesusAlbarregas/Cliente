<%-- 
    Document   : index
    Created on : 04-dic-2019, 10:04:32
    Author     : jesus
--%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:directive.page pageEncoding="UTF-8" contentType="text/html" />
<c:url var="estilo" value="/CSS/estilo.css" scope="application"/>
<c:set var="contexto" value="${pageContext.request.contextPath}" scope="application"/>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Indice</title>
        <link rel="stylesheet" type="text/css" href="${estilo}" />
    </head>
    <body>
        <div id="principal">
            <h2>Ejercicio de JQuery y Ajax</h2>
            <ol>
                <li><a href="${contexto}/Eleccion?opcion=Ejer1">Cambiar el  contenido de un párrafo</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer2">Rellenar un campo de texto</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer3">Escribir un mensaje del servidor</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer4">Cargar una lista con elementos desde el servidor</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer5">Cargar una tabla con elementos desde el servidor</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer6">Interpretar objetos JSON en el servidor</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer7">Cambiar la clase CSS de un elemento</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer8">Select anidados</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer9">Imagen previa y subida al servidor</a></li>
                <li><a href="${contexto}/Eleccion?opcion=Ejer10">DNI válido y correcto</a></li>
            </ol>
        </div>
    </body>
</html>
