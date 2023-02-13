let registerForm = document.getElementById('register-form');
let registerUsername = document.getElementById('register-username');
let registerPassword = document.getElementById('register-password');

const headers = {
    'Content-Type':'application/json'
}

const baseUrl = 'http://localhost:8080/api/v1/users';

const handleSubmit = async (e) =>{
    e.preventDefault()

    let bodyObj = {
        password: registerPassword.value,
        username: registerUsername.value,
    }

    const response = await fetch("http://localhost:8080/api/v1/users/register",
        {method: "POST", body: JSON.stringify(bodyObj), headers: headers})
        .catch(err => console.error(err.message))
    const responseArr = await response.json()

    if (response.status === 200){
        window.alert(`Successfully registered! Welcome to Wheel Watch ${username}`)
        window.location.replace(responseArr[0])
    }
}

//remember UserServiceImpl
registerForm.addEventListener('submit', handleSubmit)