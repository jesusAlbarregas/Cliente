$(document).ready(function () {

    $("#volver").attr("disabled", "disabled");

    $("input[id='dni']").blur(function () {
        
        let dniIntroducido = $(this).val();
        let patrondni = new RegExp("^[0-9]{8}$");
        let resultado = patrondni.test(dniIntroducido);
        let resultado = true;
        if (resultado === true) {

            $.ajax({
                type: "POST",
                url: "Ajax",
                data: {
                    accion: "dni",
                    dni: dniIntroducido
                },
                success: function (data) {
                    
                    if (data.tipo === 'error') {
                        
                        $("#dni").val('');
                        $("#dni").focus();
                        $.notify(data.letra, {className: data.tipo});
                    } else {
                        
                        $("#dni").val(dniIntroducido + data.letra);
                        $("#volver").removeAttr("disabled");
                    }

                },
                error: function () {
                    $.notify('Error en servidor. No se pudo comprobar el DNI.',{className: 'error'});
                    $("#dni").val('');
                    $("#dni").focus();
                }
            });
        } else {
            if ($("#dni").val() !== '') {
                $("#dni").val('');
                $("#dni").focus();
                $.notify('El formato del DNI no es válido.', {className: 'error'});
            }
        }

    });



});

