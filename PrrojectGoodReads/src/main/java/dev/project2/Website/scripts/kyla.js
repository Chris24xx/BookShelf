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