const pageUrl = window.location.search;

const nick = new URLSearchParams(pageUrl).get('nick');

const playerUrl = 'http://localhost:8090/player_api/player/' + nick;

const saveButton = document.querySelector('#save');

saveButton.addEventListener('click', sendUpdatedPlayer);

let player;

getapi(playerUrl);

rollButtons();

document.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        saveButton.click()
    }
})

async function getapi(url) {

    const response = await fetch(url);

    let data = await response.json();
    console.log(data);
    if (response) {
        hideloader();
    }
    show(data);

    player = data;
}

function hideloader() {
    document.getElementById('loading').style.display = 'none';
}

function show(player) {

    document.querySelector('#player-name').textContent += player.name
    document.querySelector('#player-surname').textContent += player.surname
    document.querySelector('#player-nick').textContent += player.nick
    document.querySelector('#player-role').textContent += player.role
    document.querySelector('#player-age').textContent += player.age
    if (player.team === null) {
        document.querySelector('#player-team').textContent += ''
    } else {
        document.querySelector('#player-team').textContent += player.team.name
    }
}

function rollButtons() {
    const editButtons = document.getElementsByClassName('edit-button');

    console.log(editButtons);

    for (let i = 0; i < editButtons.length; i++) {

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
}

function updatePlayer(infoInputs) {

    for (let i = 0; i < infoInputs.length; i++) {
        let item = infoInputs.item(i);
        if (item.value.length !== 0) {
            player[item.id] = item.value;
            console.log('item: ' + infoInputs.item(i).value);
            console.log('id: ' + infoInputs.item(i).id);
            console.log('json: ' + player[infoInputs.item(i).id]);
        }
    }
    console.log(player);
    return player;
}

function clearInputs(infoInputs) {
    for (let i = 0; i < infoInputs.length; i++) {
        infoInputs.item(i).value = ''
    }
}

function sendUpdatedPlayer() {
    let xhr = new XMLHttpRequest();
    let url = 'http://localhost:8090/player_api/update';
    const infoInputs = document.getElementsByClassName('updateInfo');

    xhr.open('PUT', url, true);

    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            console.log(xhr.response);

        }
    };

    const updatedPlayer = JSON.stringify(updatePlayer(infoInputs));

    xhr.send(updatedPlayer);

    clearInputs(infoInputs);

    setTimeout(location.reload.bind(location), 100);
}