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
                    "userId": SESSIONSTORAGEPENDING}) });
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
    let response = await fetch(profileMediaRoute + SESSIONSTORAGEPENDING);
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