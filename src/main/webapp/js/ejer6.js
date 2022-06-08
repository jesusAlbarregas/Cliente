$(document).ready(function () {



    $("input[id='enviar']").click(function () {
        let error = false;
        let nombre = $("#nombre").val();
        let apellidos = $("#apellidos").val();
        let dni = $("#dni").val();
        let numHer = $("#numHer").val();
        let fecha = $("#fecha").val();

        if (nombre.length === 0 || apellidos.length === 0 || dni.length === 0 || numHer.length === 0 || fecha.length === 0) {
            error = true;
        }
        if (!error) {
            $.ajax({
                type: "post",
                url: "Ajax",
                data: {
                    accion: "objetoJSON",
                    arreglo: JSON.stringify ({
                        "nombre": nombre,
                        "apellidos": apellidos,
                        "dni": dni,
                        "numHer": numHer,
                        "fecha": fecha

                    })
                },
                success: function (respuesta) {
                    $("#segunda").empty();
                    console.log(respuesta);
                    $('thead').append("<tr><th>Nombre</th><th>Apellidos</th><th>DNI</th><th>Num. hermanos</th><th>Fecha</th></tr>");

                    $("#segunda").append(`<tr><td>${respuesta.nombre}</td><td>${respuesta.apellidos}</td><td>${respuesta.dni}</td><td>${respuesta.numHer}</td><td>${respuesta.fecha}</td></tr>`);

                }

            });
        } else {

            $.notify('Todos los campos son obligatorios.', {className: 'error'});
        }

    });



});

