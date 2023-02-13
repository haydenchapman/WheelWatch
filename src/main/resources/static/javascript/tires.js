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