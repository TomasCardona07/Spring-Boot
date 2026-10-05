const gamesList = document.getElementById("gamesTableBody");
const addGame = document.getElementById("addGameButton");
const deleteGame = document.getElementById("deleteGameButton");
const searchGame = document.getElementById("searchInput");
const saveGame = document.getElementById("saveGameButton");
const deleteForm = document.getElementById("deleteForm");
const confirmDelete = document.getElementById("confirmDeleteButton");
const gameForm = document.getElementById("gameForm");

function cargarVideojuegos() {
    fetch("https://tomascardona07.github.io/Spring-Boot")
    .then(response => response.json())
    .then(videojuegos => {
        // Limpiar la tabla
        gamesList.innerHTML = "";
        // Recorrer los videojuegos
        videojuegos.forEach(videojuego => {
            gamesList.innerHTML += `
                <tr>
                    <td>${videojuego.id}</td>
                    <td>${videojuego.name}</td>
                    <td>${videojuego.hours}</td>
                    <td>
                        ${videojuego.completed ? "Completado" : "Pendiente"}
                    </td>
                </tr>
            `;
        });
    })
    .catch(error => {
        console.error("Error al cargar videojuegos:", error);
    });
}
addGame.addEventListener("click", function() {
    gameForm.style.display = "block";
});

saveGame.addEventListener("click", function() {
    const nombre = document.getElementById("gameName").value;
    const horas = document.getElementById("gameHours").value;
    const completado = document.getElementById("gameCompleted").checked;

    const videojuego = {
        name: nombre,
        hours: Number(horas),
        completed: completado
    };
    fetch("https://tomascardona07.github.io/Spring-Boot", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(videojuego)
    })
    .then(response => {
        if (!response.ok) {
            return response.text().then(mensaje => {
                throw new Error(mensaje);
            });
        }
        return response.json();
    })
    .then(data => {
        console.log("Videojuego creado:");
        console.log(data);
        gameForm.style.display = "none";
        // Actualizar la tabla
        cargarVideojuegos();
    })
    .catch(error => {
        console.error("Error: ",error)
    });
});

deleteGame.addEventListener("click", function() {
    deleteForm.style.display = "block";
});

confirmDelete.addEventListener("click", function() {
    const id = document.getElementById("deleteGameId").value;
    fetch("https://tomascardona07.github.io/Spring-Boot/" + id, {
        method: "DELETE"
    })
    .then(response => response.text())
    .then(data => {
        console.log(data);
        deleteForm.style.display = "none";
        // Actualizar la tabla
        cargarVideojuegos();
    })
    .catch(error => {
        console.error("Error:", error);
    });
});
cargarVideojuegos();
