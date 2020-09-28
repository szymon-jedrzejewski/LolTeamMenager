const pageUrl = window.location.search;
console.log(pageUrl);
const nick = new URLSearchParams(pageUrl).get('nick');
console.log(nick);
const playerUrl = 'http://localhost:8090/player_api/player/' + nick;
let data;
const editButtons = document.getElementsByClassName('edit-button');


async function getapi(url) {

    // Storing response
    const response = await fetch(url);

    // Storing data in form of JSON
    data = await response.json();
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

    document.querySelector('#player-name').textContent += data.name
    document.querySelector('#player-surname').textContent += data.surname
    document.querySelector('#player-nick').textContent += data.nick
    document.querySelector('#player-role').textContent += data.role
    document.querySelector('#player-age').textContent += data.age
    document.querySelector('#player-team').textContent += team
}

for (let i = 0; editButtons.length; i++) {
    editButtons[i].addEventListener('click', function() {
        this.classList.toggle('active');
        let content = this.nextElementSibling;
        console.log(content);
        if (content.style.maxHeight) {
            content.style.maxHeight = null
        } else {
            content.style.maxHeight = content.scrollHeight + 'px';
        }
    });
}