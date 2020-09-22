const pageUrl = window.location.search;
console.log(pageUrl);
const nick = new URLSearchParams(pageUrl).get('nick');
console.log(nick);
const playerUrl = 'http://localhost:8090/player_api/player/' + nick;

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
getapi(playerUrl);

// Function to hide the loader
function hideloader() {
    document.getElementById('loading').style.display = 'none';
}

function show(data) {

    // Loop to access all rows

    let team = data.team;

    if (team === null) {
        team = '';
    }

    document.querySelector('#name').appendChild(document.createElement('p').appendChild(document.createTextNode('Name: ' + data.name)));
    document.querySelector('#surname').appendChild(document.createElement('p').appendChild(document.createTextNode('Surname: ' + data.surname)));
    document.querySelector('#nick').appendChild(document.createElement('p').appendChild(document.createTextNode('Nick: ' + data.nick)));
    document.querySelector('#role').appendChild(document.createElement('p').appendChild(document.createTextNode('Role: ' + data.role)));
    document.querySelector('#age').appendChild(document.createElement('p').appendChild(document.createTextNode('Age: ' + data.age)));
    document.querySelector('#team').appendChild(document.createElement('p').appendChild(document.createTextNode('Team: ' + team)));

    // Setting innerHTML as tab variable
    document.getElementById("players").innerHTML = tab;
}