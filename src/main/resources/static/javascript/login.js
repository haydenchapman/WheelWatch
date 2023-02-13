let loginForm = document.getElementById("login-form")
let loginUsername = document.getElementById("login-username")
let loginPassword = document.getElementById("login-password")

const headers = {
    'Content-Type': 'application/json'
}

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        username: loginUsername.value,
        password: loginPassword.value
    }

    //const baseUrl = 'http://localhost:8080/api/v1/users';

    //wen host
    const response = await fetch("http://localhost:8080/api/v1/users/login",{
        method: "POST", body: JSON.stringify(bodyObj), headers: headers})
        .catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200){
        document.cookie = `userId=${responseArr[1]}=${responseArr[2]}`
        window.location.replace(responseArr[0])
    }
}
loginForm.addEventListener('submit', handleSubmit)
