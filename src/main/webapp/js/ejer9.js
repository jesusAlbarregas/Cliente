/* global waitingDialog */

if (typeof imagenInput === 'undefined') {
    var imagenInput;
}

$(document).ready(function () {
    let original = $('#previa').attr('src');
    let selloTiempo = new Date();

    $('#previa').attr('src', original + '?' + selloTiempo);
    $('#ficheroAvatar').on('change', function () {
        $("#cambiarAvatar").prop("disabled", false);
        readURL(this);
    });


//cambio de avatar
    $("#cambiarAvatar").on('click', function () {

        event.preventDefault();
        var form = $("#modAvatar")[0];
        var data = new FormData(form);

        $("#cambiarAvatar").prop("disabled", true);

        console.log("Antes del ajax");
        $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "AjaxConImagen",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            success: function (data) {
                console.log(data);
                if (data.tipo !== "error") {
                    $("#cabSegunda").empty();
                    $("#segunda").empty();
                    console.log(data);
                    $('thead').append("<tr><th>Nombre</th><th>Apellidos</th><th>Fecha</th></tr>");

                    $("#segunda").append(`<tr><td>${data.nombre}</td><td>${data.apellidos}</td><td>${data.fecha}</td></tr>`);
                    $("#vuelta").removeAttr("hidden");
                    $('#imagenDelServidor').attr('src', imagenInput);
                    $("#imagenDelServidor").removeAttr("hidden");
                } else {


                    $.notify(data.mensaje, {className: data.tipo});

                    $("#cambiarAvatar").prop("disabled", false);
                }
            },
            error: function () {
                $.notify("Error en el servidor", {className: 'error'});
            }
        });
    });
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            imagenInput = e.target.result;
//            let selloTiempo = new Date();
//            $("#myimg").attr("src", "/myimg.jpg?"+d.getTime());
//            $('#previa').attr('src', e.target.result+'?'+selloTiempo.getTime());
            $('#previa').attr('src', e.target.result);
        };
        reader.readAsDataURL(input.files[0]);
    }
}