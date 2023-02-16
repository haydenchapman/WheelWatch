//cookies
const cookieArr = document.cookie.split("=")
const userId = cookieArr[1];
const username = cookieArr[2];

//DOM Element
comboContainer = document.getElementById("combo-container")

//modalElements
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
welcome_user.innerHTML = `Welcome back, ${username}!`

//card creation helpers
const createComboCards = (array) =>{
    comboContainer.innerHTML = ''
    console.log(array)
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
    comboBody.innerText = ''
}

async function getAllCombos(){
    await fetch(`${baseUrl}/combo`, {method:"GET",headers: headers})
        .then(response => response.json())
        .then(data => createComboCards)

}

//yay
let allCombos = getAllCombos();
//const wheelsByUserId = getWheelsByUserId(userId);