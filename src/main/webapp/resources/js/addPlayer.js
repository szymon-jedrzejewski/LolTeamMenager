document.querySelector('#add-player-button').addEventListener('click', addPlayer);

let xhr = new XMLHttpRequest();
let url = "http://localhost:8090/api/add";

// open a connection 
xhr.open("POST", url, true);

// Set the request header i.e. which type of content you are sending 
xhr.setRequestHeader("Content-Type", "application/json");

// Create a state change callback 
xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {

        // Print received data from server 
        console.log(xhr.response);

    }
};

function getPlayer() {
    let newPlayer = {
        name: '',
        surname: '',
        nick: '',
        role: '',
        age: 0,
        playerStats: {},
        team: {
            name: ''
        }
    }

    newPlayer.name = document.querySelector('#name').value;
    newPlayer.surname = document.querySelector('#surname').value;
    newPlayer.nick = document.querySelector('#nick').value;
    newPlayer.role = document.querySelector('#role').value;
    newPlayer.age = document.querySelector('#age').value;
    newPlayer.team.name = document.querySelector('#team').value;

    console.log(newPlayer);

    return newPlayer;
}

function addPlayer() {

    let player = JSON.stringify(getPlayer());
    xhr.send(player);
}