$(document).ready(function () {

    $("#volver").attr("disabled", "disabled");

    cargarComunidades();
    $("#comunidad").on("change", function () {
        cargarProvincia($(this).val());
    });

    $("#provincia").on("change", function () {
        cargarLocalidad($(this).val());
    });

    $('#localidad').on("change", function () {
        let nombreLocalidad = $(this).find('option:selected').text();
        if (nombreLocalidad != "Elige la localidad") {
            $('#mensajes').html("Has seleccionado: " + nombreLocalidad);
            $("#volver").removeAttr("disabled");
        } else {
            $('#mensajes').html("");
        }
    });
});

function cargarComunidades() {
//    mostrarEspera();
    $.ajax({
        url: "https://raw.githubusercontent.com/codeforspain/ds-organizacion-administrativa/master/data/autonomias.json",
        success: function (respuesta) {
//            ocultarEspera();
            respuesta = JSON.parse(respuesta);
            $.each(respuesta, function (key, val) {
                $('#comunidad').append(`<option value="${val.autonomia_id}">${val.nombre}</option>`);
            });
        },
        error: function () {
//            ocultarEspera();
            $('#mensajes').html("No se han podido cargar las comunidades.");
        }
    });
}
;

//Funcion para cargar las provincias
function cargarProvincia(idComunidad) {
    $('#provincia').children().not(":first").remove();
    $('#localidad').children().not(":first").remove();
    $('#mensajes').html("");
//    mostrarEspera();
    $.ajax({
        url: "https://raw.githubusercontent.com/EloyGarciaAlvarez/provincias/master/provincias-comunidades.json",
        success: function (respuesta) {
//            ocultarEspera();
            respuesta = JSON.parse(respuesta);
            $.each(respuesta, function (key, val) {
                if (val.comunidad_id === idComunidad) {
                    $('#provincia').append(`<option value="${val.provincia_id}">` + val.nombre + '</option>');
                }
            });
        },
        error: function () {
//            ocultarEspera();
            $('#mensajes').html("No se han podido cargar las provincias.");
        }
    });
}
;
//Funcion para cargar la localidad
function cargarLocalidad(idProvincia) {
    $('#localidad').children().not(":first").remove();
    $('#mensajes').html("");
//    mostrarEspera();
    $.ajax({
        url: "https://raw.githubusercontent.com/codeforspain/ds-organizacion-administrativa/master/data/municipios.json",
        success: function (respuesta) {
//            ocultarEspera();
            respuesta = JSON.parse(respuesta);
            $.each(respuesta, function (key, val) {
                if (val.provincia_id === idProvincia) {
                    $('#localidad').append(`<option value="${val.municipio_id}">` + val.nombre + '</option>');
                }
            });
            
        },
        error: function () {
//            ocultarEspera();
            $('#mensajes').html("No se han podido cargar las localidades.");
        }
    });
}
;

function mostrarEspera() {
    let imagen = `<img class="image" src="../images/carga.gif"></img>`;
    $('#espera').append(imagen);
}

function ocultarEspera() {
    $('#espera').empty();
}