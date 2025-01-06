const URL = 'http://localhost:8080/Cliente';

let buttonVolver = document.getElementById("btnVolver");
let submitButtonElement = document.getElementById("btnEnviar");
let parrafoMensaje = document.getElementById("mensaje");

buttonVolver.disabled = true;

submitButtonElement.addEventListener('click', () => {
   
    fetch(URL, {
    method: 'POST',
    headers: {
//      'Content-Type': 'application/json',
      Controlador: 'Ajax'
    },
    accion: 'mensaje'
  })
  
  .then(response => {
      if (!response.ok) {
        throw new Error(`Error de red: ${response.statusText}`);
      }
      return response.json();
    })
    .then(data => {
      console.log("RESULTADO: " + data.result);
      parrafoMensaje.innerText = data.result;
      buttonVolver.disabled = false;
      submitButtonElement.disabled = true;
      
    });
//    .catch(error => {
//      console.error('Error de fetch:', error.message);
//    });
    
})


//$(document).ready(function () {
//
//    $("#volver").attr("disabled","disabled");
//    $("input[id='enviar']").click(function () {
//
//        $.ajax({
//            type: "post",
//            url: "Ajax",
//            data: {
//                accion: "mensaje"
//            },
//            success: function (respuesta) {
//                $("#mensaje").empty();
//                console.log(respuesta);
//                $("#mensaje").append(respuesta.mensaje);
//                $("#volver").removeAttr("disabled");
//                $("#enviar").attr("disabled","disabled");
//            }
//
//        });
//
//    });
//
//});

