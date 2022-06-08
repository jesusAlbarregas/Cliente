$(document).ready(function () {

    alert('Texto inicial ' + $('#mensaje').text());
    $("input[id='enviar']").click(function () {
        
        $('#mensaje').text("Hola Mundo");
        
    });
    
});

