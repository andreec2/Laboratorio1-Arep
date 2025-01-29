window.onload = function () {
    // Mensaje en la consola
    console.log("Página cargada correctamente.");

    // Cambiar el fondo de la página aleatoriamente
    const colors = ["#FF5733", "#33FF57", "#3357FF", "#FF33A1", "#A133FF"];
    const randomColor = colors[Math.floor(Math.random() * colors.length)];
    document.body.style.backgroundColor = randomColor;

    // Mostrar la hora actual en la consola
    const now = new Date();
    console.log("Hora actual: " + now.toLocaleTimeString());

    // Crear y agregar un mensaje al centro de la página
    const message = document.createElement("div");
    message.textContent = "¡Disfruta tu visita! La página se cargó correctamente.";
    message.style.position = "absolute";
    message.style.top = "70%";
    message.style.left = "50%";
    message.style.transform = "translate(-50%, -50%)";
    message.style.padding = "20px";
    message.style.fontSize = "20px";
    message.style.color = "#fff";
    message.style.backgroundColor = "#000";
    message.style.borderRadius = "10px";
    message.style.boxShadow = "0 4px 10px rgba(0, 0, 0, 0.3)";
    document.body.appendChild(message);
};
