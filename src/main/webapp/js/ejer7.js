$(document).ready(function () {


    $("#fondo").click(function () {
        if($("#bloque").hasClass("fondo")) {
            $("#bloque").removeClass("fondo");
        } else {
            $("#bloque").addClass("fondo");
        }
        

    })
    $("#marco").click(function () {
        if($("#bloque").hasClass("marco")) {
            $("#bloque").removeClass("marco");
        } else {
            $("#bloque").addClass("marco");
        }
        

    })

});

