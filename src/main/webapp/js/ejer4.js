$(document).ready(function () {
    $("#volver").attr("disabled","disabled");

    $("input[id='enviar']").click(function () {

        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "lista"
            },
            success: function (respuesta) {
                $("#lista").empty();
                console.log(respuesta);
                $.each(respuesta, function (i, option) {
                    $('#lista').append(`<li>${option.diaSemana}</li>`);
                    
                });
                $("#volver").removeAttr("disabled");
                $("#enviar").attr("disabled","disabled");

            }

        });

    });

});

