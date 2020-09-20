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

    const tab =
        `<tr>  
            <th>Name</th> 
            <td>${data.name} </td>
        </tr>
        <tr>
            <th>Surname</th> 
            <td>${data.surname}</td> 
        </tr>
        <tr>
            <th>Nick</th> 
            <td>${data.nick}</td>
        </tr>
        <tr> 
            <th>Role</th>
            <td>${data.role}</td>
        </tr>
        <tr>
            <th>Age</th> 
            <td>${data.age}</td>           
        </tr>
        <tr>
            <th>Team</th> 
            <td>${team}</td>           
        </tr>`;

    // Setting innerHTML as tab variable
    document.getElementById("players").innerHTML = tab;
}