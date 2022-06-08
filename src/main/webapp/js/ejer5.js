$(document).ready(function () {
    $("#volver").attr("disabled","disabled");

    $("input[id='enviar']").click(function () {

        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "tabla"
            },
            success: function (respuesta) {
                $("tbody").empty();
                console.log(respuesta);
                $('thead').append("<tr><th>Día semana</th><th>Sigla</th></tr>");
                $.each(respuesta, function (i, option) {
                    $('tbody').append(`<tr><td>${option.diaSemana}</td><td>${option.sigla}</td></tr>`);
                    
                });
                $("#volver").removeAttr("disabled");
                $("#enviar").attr("disabled","disabled");

            }

        });

    });

});

