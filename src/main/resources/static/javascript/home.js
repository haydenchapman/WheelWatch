//cookies
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
const username = cookieArr[2];

//DOM Elements
wheelContainer = document.getElementById("wheel-container")
tireContainer = document.getElementById("tire-container")
comboContainer = document.getElementById("combo-container")

//modalElements
let wheelBody = document.getElementById("wheel-body")
let tireBody = document.getElementById("tire-body")
let comboBody = document.getElementById("combo-body")
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
console.log(cookieArr)
let welcome_user = document.getElementById("welcome")
welcome_user.innerHTML = `Welcome back! ${username}!`

//card creation helpers
const createWheelCards = (array) =>{
    wheelContainer.innerHTML = ''
    console.log(array)
    array.forEach(obj =>{
        console.log(obj.boltPattern) ;
        let wheelCard = document.createElement("div")
        wheelCard.classList.add("m-2")
        wheelCard.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                    <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                                        <p class="card-text">"Bolt Pattern:"${obj.boltPattern}</p>
                                        <p class="card-text">"Brand:"${obj.brand}</p>
                                        <div class="d-flex justify-content-between"> 
                                        </div>
                                    </div>
                                </div>
                                    `
            wheelContainer.append(wheelCard);
        })
    }
const createTireCards = (array) =>{
    tireContainer.innerHTML = ''
    array.forEach(obj => {
        let tireCard = document.createElement("div")
        tireCard.classList.add("m-2")
        tireCard.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                                    <p class="card-text">${obj.body}</p>
                                    <div class="d-flex justify-content-between"</div>
                                </div>
                                </div>
                                `
        tireContainer.append(tireCard)
    })
}

const createComboCards = (array) =>{
    comboContainer.innerHTML = ''
    array.forEach(obj => {
        let comboCard = document.createElement("div")
        comboCard.classList.add("m-2")
        comboCard.innerHTML = `<div class="card d-flex" style="width: 18rem; height: 18rem;">
                                    <div class="card-body d-flex flex-column justify-content-between" style="height: available">
                                    <p class="card-text">${obj.body}</p>
                                    <div class="d-flex justify-content-between"</div>
                                </div>
                                </div>
                                `
    })
}
//populate modal
const populateModal = (obj) => {
    wheelBody.innerText = ''
    tireBody.innerText = ''
    comboBody.innerText = ''
}

//get func
//async function getAllWheels(){
//    await fetch(`${baseUrl}/wheels`,{method: "GET", headers: headers})
//        .then(response => response.json())
//        .then(data => createWheelCards(data))
//        .catch(err => console.error(err))
//}
const getAllWheels = async () =>{
    const response = await fetch(`${baseUrl}/wheels`)
        .then(response => response.json())
        .then(data => createWheelCards(data))
        .catch(err => console.error(err))
}
async function getAllTires(){
    await fetch(`${baseUrl}/tires`,{method: "GET", headers: headers})
        .then(response => response.json())
        .then(data => createTireCards(data))
        .catch(err => console.error(err))
}

async function getAllCombos(){
    await fetch(`${baseUrl}/combo`, {method:"GET",headers: headers})
        .then(response => response.json())
        .then(data => createComboCards)

}

//yay
let allWheels = getAllWheels();
let allTires = getAllTires();
let allCombos = getAllCombos();
//const wheelsByUserId = getWheelsByUserId(userId);