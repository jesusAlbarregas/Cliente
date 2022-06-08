$(document).ready(function () {

    $("#volver").attr("disabled","disabled");
    $("input[id='enviar']").click(function () {

        $.ajax({
            type: "post",
            url: "Ajax",
            data: {
                accion: "mensaje"
            },
            success: function (respuesta) {
                $("#mensaje").empty();
                console.log(respuesta);
                $("#mensaje").append(respuesta.mensaje);
                $("#volver").removeAttr("disabled");
                $("#enviar").attr("disabled","disabled");
            }

        });

    });

});

