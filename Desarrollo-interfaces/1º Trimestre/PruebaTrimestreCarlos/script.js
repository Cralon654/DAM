const formulario = document.querySelector("form");

function Enviar() {
    const nombre = document.getElementById("nombre").value;
    const edad = document.getElementById("edad").value;
    const correo = document.getElementById("correo").value;


    if (!nombre || !edad || !correo) {
        alert("Por favor, completa todos los campos.");
        return;
    }

    const camposDinamicos = document.querySelectorAll(".campo-dinamico");

    let camposAdicionalesMensaje = "";

    // Recorrer la lista y construir el mensaje
    camposDinamicos.forEach((campo, index) => {
        // Añadir el valor de cada campo a la cadena
        camposAdicionalesMensaje += `Campo Adicional ${index + 1}: ${campo.value}\n`;
    });
    const mensajeFinal = `
        Datos Principales:
        -------------------------
        Nombre: ${nombre}
        Edad: ${edad}
        Correo: ${correo}
        
        Datos Adicionales:
        -------------------------
        ${camposAdicionalesMensaje || "No se añadieron campos adicionales."}
    `;

    alert(mensajeFinal);

    formulario.reset();
}

function campoNuevo() {

    const nuevoCampo = document.createElement("input");
    nuevoCampo.type = "text";
    nuevoCampo.classList.add("campo-dinamico");
    nuevoCampo.placeholder = "Datos adicionales";
    const ultimoCampo = document.getElementById("nuevocampo");

    const contenedorPadre = ultimoCampo.parentNode;


    contenedorPadre.insertBefore(nuevoCampo, ultimoCampo);
    contenedorPadre.insertBefore(saltoLinea, ultimoCampo);
}

function eliminarCampo() {
    const camposDinamicos = document.querySelectorAll(".campo-dinamico");

    if (camposDinamicos.length > 0) {

        const ultimoCampo = camposDinamicos[camposDinamicos.length - 1];
        const brSiguiente = ultimoCampo.nextElementSibling;
        
        ultimoCampo.remove(); 
        
        if (brSiguiente && brSiguiente.tagName === 'BR') {
             brSiguiente.remove(); 
        }
        
    } else {
        alert("No hay campos para eliminar.");
    }
}