const pageUrl = window.location.search;

const nick = new URLSearchParams(pageUrl).get('nick');

const playerUrl = 'http://localhost:8090/player_api/player/' + nick;

const editButtons = document.getElementsByClassName('edit-button');

const infoInputs = document.getElementsByClassName('updateInfo');

const saveButton = document.querySelector('#save');

saveButton.addEventListener('click', updatePlayer);

let data;

document.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        saveButton.click()
    }
})

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

function updatePlayer() {
    for (let i = 0; i < infoInputs.length; i++) {
        let item = infoInputs.item(i);
        if (item.value.length !== 0) {
            data[item.id] = item.value;
            console.log('item: ' + infoInputs.item(i).value);
            console.log('id: ' + infoInputs.item(i).id);
            console.log('json: ' + data[infoInputs.item(i).id]);
        }
    }
    console.log(data);
    return data;
}