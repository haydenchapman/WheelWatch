//cookies
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
const username = cookieArr[2];

//DOM Elements
tireContainer = document.getElementById("tire-container")

//modalElements
let tireBody = document.getElementById("tire-body")

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

//create tire cards
const createTireCards = (array) =>{
    tireContainer.innerHTML = ''
    console.log(array)
    array.forEach(obj => {
        let tireCard = document.createElement("div")
        tireCard.classList.add("m-2")
        tireCard.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                                <ul>
                                <li class="card-text">Brand: ${obj.brand}</li>
                                <li class="card-text">Model: ${obj.model}</li>
                                <li class="card-text">Width: ${obj.width}</li>
                                <li class="card-text">Aspect Ratio: ${obj.aspectRatio}%</li>
                                <li class="card-text">Diameter: ${obj.diameter}</li>
                                <li class="card-text">Type: ${obj.tireType}</li>
                                <li class="card-text">Price: $ ${obj.price}</li>
                                </ul>
                                    
                                    <div class="d-flex justify-content-between"</div>
                                </div>
                                </div>
                                `
        tireContainer.append(tireCard)
    })
}

const populateModal = (obj) => {
    tireBody.innerText = ''
}

//get tires
async function getAllTires(){
    await fetch(`${baseUrl}/tires`,{method: "GET", headers: headers})
        .then(response => response.json())
        .then(data => createTireCards(data))
        .catch(err => console.error(err))
}

let allTires = getAllTires();