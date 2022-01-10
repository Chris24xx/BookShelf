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


  //Contact us List of Completed and Pending Function Constants
  const pendingTable = document.getElementById("pending-messages-table");
  const pendingTableBody = document.getElementById("pending-message-body");
  const completedTable = document.getElementById("completed-messages-table");
  const completedTableBody = document.getElementById("completed-message-body");
  const pendingInput = document.getElementById("pendingIdInput");
  const deleteIdInput = document.getElementById("deleteIdInput");
// Get Pending Contact Requests
async function getPendingContactRequests() {
  let url = "http://localhost:8080/contactRequests/pending";

  let response = await fetch(url);

  if (response.status === 200) {
    let body = await response.json();
    populateData(body);
  } else {
    alert("There was a problem trying to get pending contact requests: sorry!");
  }
}

// Get Completed Contact Requests -----------------------------------------

async function getCompletedContactRequests() {
  let url = "http://localhost:8080/contactRequests/completed";

  let response = await fetch(url);

  if (response.status === 200) {
    let body = await response.json();
    populateDataComp(body);
  } else {
    alert("There was a problem trying to get completed contact requests: sorry!");
  }
}


// Update Contact Request Status
async function updateContactRequestStatus(){
  sessionStorage.setItem("pendingInput", pendingInput.value);
  let url = "http://localhost:8080/updateContactRequestStatus/"
 
   let response = await fetch(
       url + pendingInput.value
       ,{
          method:"PATCH",
          headers: {"Content-Type": "application/json"},
          body: JSON.stringify({
            "contactId":pendingInput.value,
            "status":true
          })
      
    }
   )

   if (response.status === 200 || response.status === 201){
       document.location.reload(true)
       let body = await response.json()

    
   } else {
       alert("your contact request update failed")
       document.location.reload(true)
   }
}

// Delete Contact Request
async function deleteContactRequest(){
  sessionStorage.setItem("deleteIdInput", deleteIdInput.value);
  let url = "http://localhost:8080/deleteContactRequest/"
 
   let response = await fetch(
       url + deleteIdInput.value
       ,{
          method:"DELETE",
          headers: {"Content-Type": "application/json"},
          body: JSON.stringify({
            "contactId":deleteIdInput.value,
            "status":true
          })
      
    }
   )

   if (response.status === 200 || response.status === 201){
       document.location.reload(true)
       let body = await response.json()

    
   } else {
       alert("your have not deleted your contact request")
       document.location.reload(true)
   }
}


// Populate data for Pending contact us table
function populateData(responseBody) {
  for (let contact_us of responseBody) {
    let tableRow = document.createElement("tr");
    tableRow.innerHTML = `<td>${contact_us.contactId}</td><td>${contact_us.email}</td><td>${contact_us.fullName}</td><td>${contact_us.issueMessage}</td><td>${contact_us.status}</td>`;
    pendingTableBody.appendChild(tableRow);
  }
}

// Populate data for Completed contact us table
function populateDataComp(responseBody) {
  for (let contact_us of responseBody) {
    let tableRow = document.createElement("tr");
    tableRow.innerHTML = `<td>${contact_us.contactId}</td><td>${contact_us.email}</td><td>${contact_us.fullName}</td><td>${contact_us.issueMessage}</td><td>${contact_us.status}</td>`;
    completedTableBody.appendChild(tableRow);
  }
}

getCompletedContactRequests()
getPendingContactRequests()

//------------------End of contact request js on this page
//------------------Reviews
let reviewButton = document.getElementById("pending-reviews")
reviewButton.addEventListener("click", pendingReviewList)
reviewButton.addEventListener("click", pastList)
let pendingReviewTable = document.getElementById("pending-review-table")
let approveReviewTable = document.getElementById("approved-review-table")
let reviewField = document.getElementById("updateReview")
let approveButton = document.getElementById("Approve")
let denyButton = document.getElementById("Deny")

async function pendingReviewList(params) {
  let url = "http://localhost:8080/review/pending";
  let response = await fetch(url);
  if (response.status === 200) {
    let body = await response.json();
    populatePendingList(body)

  } else if (response.status === 404) {
    alert("List can not be generated")

  } else {
    alert("something went wrong.")
  }
}

function populatePendingList(responseBody) {
  let array = responseBody
  for (let reviews of array) {
    let tableRow = document.createElement("tr")
    tableRow.innerHTML = `<td>${reviews.reviewId}</td><td>${reviews.userReview}</td><td>${reviews.mediaId}</td>`
    pendingReviewTable.appendChild(tableRow);
  }


}

async function pastList() {
  let url = "http://localhost:8080/review/past";
  let response = await fetch(url);
  if (response.status === 201) {
    let body = await response.json();
    populatePastList(body)

  } else if (response.status === 404) {
    alert("List can not be generated")

  } else {
    alert("something went wrong.")
  }
}

function populatePastList(responseBody) {
  for (let reviews of responseBody) {
    let table = document.createElement("tr")
    if (reviews.status === true) {
      table.innerHTML = `<td>${reviews.reviewId}</td><td>${reviews.userReview}</td><td>${reviews.mediaId}</td>`
      approveReviewTable.appendChild(table);
    }

  }
}

async function updateReview(approval) {
  let status = approval
  let url = `http://localhost:8080/review/update/${reviewField.value}`;
  let response = await fetch(url, { method: "PATCH", headers: { "Content-Type": "application/json" }, body: JSON.stringify({ ["status"]: status }) });
      if (response.status === 201) {
        alert("Success");
        if(status === false){
          let url = `http://localhost:8080/review/delete/${reviewField.value}`;
          let response = await fetch(url, { method: "DELETE", headers: { "Content-Type": "application/json" }});
          if(response.status === 200){
            alert("Success")
          }
          
        }
    
      } else {
        alert("something went wrong.");
      }
 }
  
  


  



//-------------End of Reviews
  //User List Function and Constants
  const userTable = document.getElementById("users-table");
  const userTableBody = document.getElementById("user-table-body");
// List all users 
async function getAllUsers(){
  let url = "http://localhost:8080/webUsers";

  let response = await fetch(url);
  
  if (response.status === 200 || response.status === 201){
      let body = await response.json();
      populateUserData(body);
  } else {
      alert("There was a problem trying to get all users: sorry!");
  }
}

// Populate data for all users
function populateUserData(responseBody){
  for (let web_user of responseBody){
      let tableRow = document.createElement("tr");
      tableRow.innerHTML = `<td>${web_user.userId}</td><td>${web_user.firstName}</td><td>${web_user.lastName}</td><td>${web_user.userEmail}</td>`;
      userTable.appendChild(tableRow);
  }
}

 getAllUsers()
// LOGOUT
function logout() {
  window.location.href = "login.html";
};