// TO CREATE A NEW PIECE OF MEDIA
async function createMedia(){
    let mediaType = document.getElementById("media-type");
    let mediaTitle = document.getElementById("media-title");
    let mediaCreator = document.getElementById("media-creator");
    let mediaGenre = document.getElementById("media-genre");
    let mediaSynopsis = document.getElementById("synopsis");
    let submitMessage = document.getElementById("submit-message");

    const createRoute = "http://localhost:8080/newMedia";
    let response = await fetch(createRoute, {headers:{'Content-Type':'application/json'}, method:["POST"], body:JSON.stringify({"mediaId":0, 
                    "title":mediaTitle.value, 
                    "creator":mediaCreator.value, 
                    "synopsis":mediaSynopsis.value, 
                    "mediaType": mediaType.value, 
                    "genre":mediaGenre.value, 
                    "status":false, 
                    "userId": sessionStorage.getItem("webUserId")}) });
    if(response.status == 201){
        let createdMediaBody = await response.json();
        mediaType.value = '';
        mediaTitle.value = '';
        mediaCreator.value = '';
        mediaGenre.value = '';
        mediaSynopsis.value = '';
        submitMessage.textContent = 'Your media has been added and is awaiting approval';
    } else {
        submitMessage.textContent = 'There was an issue. Your media was not added.';
    };
};





// GET MEDIA PER USER
let profileButton = document.getElementById("profile");
profileButton.addEventListener("click", userMediaList);

async function userMediaList(){
    profileTableBody.innerHTML = '';
    const profileMediaRoute = "http://localhost:8080/userMedia/";
    let response = await fetch(profileMediaRoute + sessionStorage.getItem("webUserId"));
    if(response.status == 200){
        let userMediaBody = await response.json();
        console.log(userMediaBody);
        populateUserMedia(userMediaBody);
    } else {
        alert("Could not retrieve your media!");
    };
};

const profileTable = document.getElementById("user-list-table");
const profileTableBody = document.getElementById("user-media-body");

function populateUserMedia(jsonBody){
    for(let um of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${um.mediaType}</td><td>${um.title}</td><td>${um.creator}</td><td>${um.synopsis}</td><td>${um.genre}</td>`;
        profileTableBody.appendChild(tableRow);
    };
}





// TO VIEW ALL BOOKS
let bookButton = document.getElementById("books");
bookButton.addEventListener("click", getAllApprovedBooks);

async function getAllApprovedBooks(){
    bookTableBody.innerHTML = '';
    const booksRoute = "http://localhost:8080/books";
    let response = await fetch(booksRoute);
    if(response.status == 200){
        let bookBody = await response.json();
        console.log(bookBody);
        populateBooks(bookBody);
    } else {
        alert("Could not retrieve books!");
    };
};

const bookTable = document.getElementById("books-list-table");
const bookTableBody = document.getElementById("books-info");

function populateBooks(jsonBody){
    for(let bb of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${bb.title}</td><td>${bb.creator}</td><td>${bb.synopsis}</td><td>${bb.genre}</td>`;
        bookTableBody.appendChild(tableRow);
    };
};





// TO VIEW ALL MOVIES
let movieButton = document.getElementById("movies");
movieButton.addEventListener("click", getAllApprovedMovies);

async function getAllApprovedMovies(){
    movieTableBody.innerHTML = '';
    const moviesRoute = "http://localhost:8080/movies";
    let response = await fetch(moviesRoute);
    if(response.status == 200){
        let movieBody = await response.json();
        console.log(movieBody);
        populateMovies(movieBody);
    } else {
        alert("Could not retrieve Movies!");
    };
};

const movieTable = document.getElementById("movies-list-table");
const movieTableBody = document.getElementById("movies-info");

function populateMovies(jsonBody){
    for(let mb of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${mb.title}</td><td>${mb.creator}</td><td>${mb.synopsis}</td><td>${mb.genre}</td>`;
        movieTableBody.appendChild(tableRow);
    };
};




// TO VIEW ALL GAMES
let gameButton = document.getElementById("games");
gameButton.addEventListener("click", getAllApprovedGames);

async function getAllApprovedGames(){
    gameTableBody.innerHTML = '';
    const gamesRoute = "http://localhost:8080/games";
    let response = await fetch(gamesRoute);
    if(response.status == 200){
        let gameBody = await response.json();
        console.log(gameBody);
        populateGames(gameBody);
    } else {
        alert("Could not retrieve Games!");
    };
};

const gameTable = document.getElementById("games-list-table");
const gameTableBody = document.getElementById("games-info");

function populateGames(jsonBody){
    for(let gb of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${gb.title}</td><td>${gb.creator}</td><td>${gb.synopsis}</td><td>${gb.genre}</td>`;
        gameTableBody.appendChild(tableRow);
    };
};


// Review Functions

async function userReviewList() {
    mediaId = sessionStorage.getItem("mediaId")
    userId = sessionStorage.getItem("webUserId")
    let url = `http://localhost:8080/review/all/${userId}/${mediaId}`;
    let response = await fetch(url);
    if(response.status === 200){
        let body = await response.json();
        console.log(body)
    }

}