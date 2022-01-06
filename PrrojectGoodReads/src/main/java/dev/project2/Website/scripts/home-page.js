// WORKING TABS
function openTab(evt, tabName) {
  let tabcontent = document.getElementsByClassName("tabcontent");
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
let mediaButton = document.getElementById("media-button");
let newMediaBox = document.getElementsByClassName("add-new-media");

// Open the media box.
function openMediaBox() {
  newMediaBox.style.display = "block";
};

mediaButton.addEventListener("click", openMediaBox);

// Close the media box.
function closeMediaBox() {
  newMediaBox.style.display = "none";
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

// setInterval(function revolveGames() {
//   const eleGame = document.getElementById("game-revolve");
//   eleGame.setAttribute('src', games[++i]);
//   if(i === games.length - 1) {
//     i = -1;
//   }
// }, 3000);



// LOGOUT
function logout(){
  window.location.href = "login.html";
};