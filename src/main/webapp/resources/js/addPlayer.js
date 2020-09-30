const playerAddButton = document.querySelector('#add-player-button');

playerAddButton.addEventListener('click', addPlayer);

document.addEventListener('keyup', function(event) {
    if (event.key === 'Enter') {
        playerAddButton.click()
    }
})

function getPlayer() {
    let newPlayer = {
        name: '',
        surname: '',
        nick: '',
        role: '',
        age: 0,
        playerStats: {}
    }

    const roles = document.querySelector('#roles');
    console.log(roles)
    newPlayer.name = document.querySelector('#name').value;
    newPlayer.surname = document.querySelector('#surname').value;
    newPlayer.nick = document.querySelector('#nick').value;
    newPlayer.role = roles.options[roles.selectedIndex].value;
    newPlayer.age = document.querySelector('#age').value;

    console.log(newPlayer);

    return newPlayer;
}

function addPlayer() {
    let xhr = new XMLHttpRequest();
    let url = 'http://localhost:8090/player_api/add';

    xhr.open('POST', url, true);

    xhr.setRequestHeader('Content-Type', 'application/json');

    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {

            console.log(xhr.response);

        }
    };

    let player = JSON.stringify(getPlayer());
    xhr.send(player);
}