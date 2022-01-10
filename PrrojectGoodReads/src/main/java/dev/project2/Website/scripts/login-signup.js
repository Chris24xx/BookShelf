const url = "http://localhost:8080/";



//Function to Login
async function login(){
    let urlAttach = "webUser/login";
    let loginEmailInput = document.getElementById("loginEmailInput");
    let loginPasswordInput = document.getElementById("loginPasswordInput");

    let response = await fetch(url + urlAttach, {
        headers: {'Content-Type': 'application/json'},
        method: "POST", 
        body: JSON.stringify({["userEmail"]: loginEmailInput.value, ["password"]: loginPasswordInput.value})
    });

    if(response.status === 201){
        let info = await response.json();
        console.log(info);
        console.log(info.moderator); 

        if(info.moderator === true){
            sessionStorage.setItem("webUserId", info.userId);
            window.location.href = "moderator.html";
        }
        else if(info.moderator === false){
            sessionStorage.setItem("webUserId", info.userId);
            window.location.href = "home-page.html";
        }
    }
    else if(response.status === 404){
        let info = await response.json();
        alert(info);
    }
    else{
        console.log("This ain't working");
    }
}

//Function to Sign-Up
async function signUp(){
    let urlAttach = "webUser";
    let signUpFirstNameInput = document.getElementById("firstNameInput");
    let signUpLastNameInput = document.getElementById("lastNameInput");
    let signUpEmailInput = document.getElementById("emailInput");
    let signUpPasswordInput = document.getElementById("passwordInput");

    let response = await fetch(url + urlAttach, {
        headers: {'Content-Type': 'application/json'},
        method: "POST", 
        body: JSON.stringify({
            ["userId"]: 100, 
            ["firstName"]: signUpFirstNameInput.value, 
            ["lastName"]: signUpLastNameInput.value, 
            ["userEmail"]: signUpEmailInput.value, 
            ["password"]: signUpPasswordInput.value,
            ["moderator"]: false})
    });

    if(response.status === 201){
        let info = await response.json();
        console.log(info);
        sessionStorage.setItem("webUserId", info.userId);
        window.location.href = "home-page.html";
    }
    else if(response.status === 404){
        let info = await response.json();
        console.log(info);
        alert(info);
    }
    else{
        console.log("This ain't working");
    }
}

function loginOrSignUp(){
    let loginTitle = document.getElementById("loginTitle");
    let signUpTitle = document.getElementById("signUpTitle");

    if(document.contains(loginTitle)){
        let loginButton = document.getElementById("loginButton");
        loginButton.onclick = login;
    }

    else if(document.contains(signUpTitle)){
        let signUpButton = document.getElementById("signUpButton");
        signUpButton.onclick = signUp;
    }
}

loginOrSignUp();