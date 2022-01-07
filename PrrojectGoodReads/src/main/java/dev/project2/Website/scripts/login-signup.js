const url = "http://localhost:8080/webUser/login";

let loginButton = document.getElementById("loginButton");
loginButton.onclick = login;


async function login(){
    let loginEmailInput = document.getElementById("loginEmailInput");
    let loginPasswordInput = document.getElementById("loginPasswordInput");

    let response = await fetch(url, {
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