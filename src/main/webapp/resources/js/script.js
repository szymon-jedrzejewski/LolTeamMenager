const api_url = 'http://localhost:8090/api/players';

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
        </tr>`;
    }
    // Setting innerHTML as tab variable 
    document.getElementById("players").innerHTML = tab;
}