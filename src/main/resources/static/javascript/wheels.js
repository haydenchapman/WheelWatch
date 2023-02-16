//cookies
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
const username = cookieArr[2];

//DOM Elements
wheelContainer = document.getElementById("wheel-container")

//modalElements
let wheelBody = document.getElementById("wheel-body")

const headers = {
    'Content-Type': 'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1';

//check
if(!userId){    window.location.href = "/login.html";}

// logout
function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

//cards
const createWheelCards = (array) =>{
    wheelContainer.innerHTML = ''
    array.forEach(obj =>{
        console.log(array)
        let wheelCard = document.createElement("div")
        wheelCard.classList.add("m-2")
        wheelCard.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                    <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                                    <ul>
                                        <li class="card-text">Brand: ${obj.brand}</li>
                                        <li class="card-text">Model: ${obj.model}</li>
                                        <li class="card-text">Diameter: ${obj.diameter}</li>
                                        <li class="card-text">Width: ${obj.width}</li>
                                        <li class="card-text">Bolt Pattern: ${obj.boltPattern}</li>
                                        <li class="card-text">Offset: +${obj.offset}</li>
                                        <li class="card-text">Material: ${obj.material}</li>
                                        <li class="card-text">Finish: ${obj.finish}</li>
                                    </ul>
                                        <div class="d-flex justify-content-between"> 
                                        </div>
                                    </div>
                                </div>
                                    `
        wheelContainer.append(wheelCard);
    })
}

const populateModal = (obj) => {
    wheelBody.innerText = ''
}

const getAllWheels = async () =>{
    const response = await fetch(`${baseUrl}/wheels`)
        .then(response => response.json())
        .then(data => createWheelCards(data))
        .catch(err => console.error(err))
}

let allWheels = getAllWheels();