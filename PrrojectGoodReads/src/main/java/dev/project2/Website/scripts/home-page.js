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
let books = ["images/anne-green-gables.jpg", "images/harry-potter.jpg", "images/hobbit.jpg"];
let movies = ["images/die-hard.jpg", "images/into-the-woods.jpg", "images/stardust.jpg"];
let games = ["images/Halo_Infinite.png", "images/mario-cart.jpg", "images/metal-gear-solid.jpg"];

let i = 0;

setInterval(function revolveBooks() {
  const eleBook = document.getElementById("books-revolve");
  eleBook.setAttribute('src', books[++i]);
  if(i === books.length - 1) {
    i = -1;
  }
  return;
}, 3000);

setInterval(function revolveMovies() {
  const eleMovie = document.getElementById("movie-revolve");
  eleMovie.setAttribute('src', movies[++i]);
  if(i === movies.length - 1) {
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