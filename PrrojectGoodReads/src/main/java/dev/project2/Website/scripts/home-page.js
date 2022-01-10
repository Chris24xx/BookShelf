// WORKING TABS
function openTab(evt, tabName) {
  let tabcontent = document.getElementsByClassName("tabcontent");
  closeReviewBox();
  for (let i = 0; i < tabcontent.length; i++) {
    tabcontent[i].style.display = "none";
  };
  let tablink = document.getElementsByClassName("tablink");
  for (let i = 0; i < tablink.length; i++) {
    tablink[i].className = tablink[i].className.replace(" active", "");
  };
  document.getElementById(tabName).style.display = "block";
  evt.currentTarget.className += " active";
};



// OPEN/CLOSE BOX TO CREATE NEW MEDIA
let mediaButton = document.getElementsByClassName("add-new-media-button");
let newMediaBox = document.getElementsByClassName("add-new-media");

// Open the media box.
function openMediaBox() {
  for(let i = 0; i < newMediaBox.length; i++){
    newMediaBox[i].style.display = "block";
  }
};

function mediaButtonsListener(){
  for(let i = 0; mediaButton.length; i++){
    if(mediaButton[i].id === "media-button"){
      mediaButton[i].addEventListener("click", openMediaBox);
    }
  }
}

function closeMediaBox() {
  for(let i = 0; i < newMediaBox.length; i++){
    newMediaBox[i].style.display = "none";
  }
};



// RANDOM MEDIA IMAGES ON HOME PAGE
let media = ["images/anne-green-gables.jpg", "images/harry-potter.jpg", "images/mario-cart.jpg", "images/die-hard.jpg"];
let media2 = ["images/hobbit.jpg", "images/into-the-woods.jpg", "images/stardust.jpg", "images/Halo_Infinite.png", "images/metal-gear-solid.jpg"];

let i = 0;

setInterval(function revolveMedia() {
  const eleBook = document.getElementById("media-revolve");
  eleBook.setAttribute('src', media[++i]);
  if(i === media.length - 1) {
    i = -1;
  }
  return;
}, 3000);

setInterval(function revolveMedia2() {
  const eleMovie = document.getElementById("media2-revolve");
  eleMovie.setAttribute('src', media2[++i]);
  if(i === media2.length - 1) {
    i = -1;
  }
  return;
}, 3000);




// Create contact function and constants
const email = document.getElementById("contactUsEmailInput")
const fullName = document.getElementById("contactUsNameInput")
const issue = document.getElementById("contactUsIssueInput")

async function createContactRequest(){
  // let url = "http://localhost:8080/contact"
  
   let response = await fetch(
    "http://localhost:8080/contact", {
           method:"POST",
           headers: {"Content-Type": "application/json"},
           body: JSON.stringify({
            "contactId":0,
             "email":email.value,
             "fullName":fullName.value,
             "issueMessage":issue.value,
              "status":false})
       }
       )
       if (response.status === 200 || response.status === 201){
      alert("your contact request has been sent")
      document.location.reload(true)
       let body = await response.json() 
   } else {
       alert("your contact request was not sent")
   }
}



// End of contact function and constants



// LOGOUT
function logout(){
  window.location.href = "login.html";
};

mediaButtonsListener();