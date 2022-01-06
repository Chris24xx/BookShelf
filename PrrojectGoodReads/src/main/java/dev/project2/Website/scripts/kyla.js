// TO VIEW ALL BOOKS
let bookButton = document.getElementById("books");
bookButton.addEventListener("click", getAllBooks);

async function getAllBooks(){
    const booksRoute = "http://localhost:8080/books";
}


// let pendingButton = document.getElementById("pending");
// button.addEventListener("click", getPendingData);

// async function getPendingData(){
//   // tableBody.innerHTML = ``;
//   const pendingRoute = "http://127.0.0.1:5000/employee/pending/";
//   // Fetching the information from the route.
//   let response = await fetch(pendingRoute + sessionStorage.getItem("valueEmp"));
//   if(response.status == 200){
//     let pBody = await response.json();
//     populateReimburseData(pBody);
//   } else {
//     alert("Could not retrieve reimbursement data!")
//   }
// };


// TO POPULATE THE TABLE DATA
// This grabs the tables and table bodies so that we can populate data into them.
// const table = document.getElementById("reimburse-table");
// const tableBody = document.getElementById("r-body");

// function populateReimburseData(jsonBody){
//   for(let rb of jsonBody){
//     let tableRow = document.createElement("tr");
//     tableRow.innerHTML = `<td>${rb.reimburseId}</td><td>${rb.requestLabel}</td><td>$${rb.amount}</td><td>${rb.status}</td><td>${rb.reason}</td>`;
//     tableBody.appendChild(tableRow);
//   };
// };