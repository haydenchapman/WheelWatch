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
const createComboCards = (combos) => {
    comboContainer.innerHTML = '';
    combos.forEach(combo => {
        const { tires, wheels } = combo;
        const card = document.createElement('div');
        card.classList.add('card', 'm-2');
        card.innerHTML = `<div class="card-body">
                                <h5 class="card-title">Combo Details</h5>
                                <p class="card-text">${combo.tires} ${combo.wheels} ${combos.tires} ${combos.wheels}</p>
                                <p class="card-text">Tires: ${tires.brand} ${tires.model} ${tires.width}</p>
                                <p class="card-text">Wheels: ${wheels.brand} ${wheels.model} ${wheels.width}</p>
                            </div>`;
        comboContainer.appendChild(card);
    });
};

//populate modal
const populateModal = (obj) => {
    comboBody.innerText = ''
}

async function getAllCombos(){
    await fetch(`${baseUrl}/combo`, {method:"GET",headers: headers})
        .then(response => response.json())
        .then(data => createComboCards(data));
}

//yay
let allCombos = getAllCombos();
//const wheelsByUserId = getWheelsByUserId(userId);