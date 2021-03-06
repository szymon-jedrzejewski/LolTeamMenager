const api_url = 'http://localhost:8090/player_api/players';

// Defining async function
async function getapi(url) {

    // Storing response
    const response = await fetch(url);

    // Storing data in form of JSON
    var data = await response.json();
    console.log(data);
    if (response) {
        hideloader();
    }
    show(data);
}

// Calling that async function
getapi(api_url);

// Function to hide the loader
function hideloader() {
    document.getElementById('loading').style.display = 'none';
}

// Function to define innerHTML for HTML table
function show(data) {
    let tab =
        `<tr> 
            <th>Name</th> 
            <th>Surname</th> 
            <th>Nick</th> 
            <th>Role</th>
            <th>Age</th> 
         </tr>`;

    // Loop to access all rows
    for (let r of data) {
        tab +=
            `<tr>  
            <td>${r.name} </td> 
            <td>${r.surname}</td> 
            <td>${r.nick}</td>  
            <td>${r.role}</td>
            <td>${r.age}</td>           
            <td><button class="deletePlayer" id="${r.nick}">Delete</button></td>           
            <td><button class="updatePlayer" id="${r.nick}">Update</button></td>           
        </tr>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("players").innerHTML = tab;
}

const players = document.querySelector("#players");

//TODO move it to separate script
players.addEventListener('click', event => {

    if (event.target.className === 'deletePlayer') {

        return fetch('http://localhost:8090/player_api/delete/' + event.target.id, {
            method: 'delete',
        }).then(response =>
            response.json().then(json => {
                location.reload();
                return json;
            })
        );
    }
});

players.addEventListener('click', event => {
    if (event.target.className === "updatePlayer") {
        location.href = 'http://localhost:8090/update_player?nick=' + event.target.id
    }
})