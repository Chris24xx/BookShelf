// WORKING TABS
function openTab(evt, tabName) {
  let tabcontent = document.getElementsByClassName("tabcontent");
  approveMessage.textContent = '';
  denyMessage.textContent = '';
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






// TO VIEW PENDING MEDIA
let pendingMediaButton = document.getElementById("pending-media");
pendingMediaButton.addEventListener("click", getAllPendingMedia);

async function getAllPendingMedia(){
    pendingMediaTableBody.innerHTML = '';
    const pendingMediaRoute = "http://localhost:8080/pendingMedia";
    let response = await fetch(pendingMediaRoute);
    if(response.status == 200){
        let pendingMediaBody = await response.json();
        console.log(pendingMediaBody);
        populatePendingMedia(pendingMediaBody);
    } else {
        alert("Could not retrieve pending media!");
    };
};

const pendingMediaTable = document.getElementById("pending-media-table");
const pendingMediaTableBody = document.getElementById("pending-media-info");

function populatePendingMedia(jsonBody){
    for(let pm of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${pm.mediaId}</td><td>${pm.title}</td><td>${pm.synopsis}</td><td>${pm.genre}</td>`;
        pendingMediaTableBody.appendChild(tableRow);
    };
};




// TO VIEW PAST APPROVED MEDIA
let approvedMediaButton = document.getElementById("pending-media");
approvedMediaButton.addEventListener("click", getAllApprovedMedia);

async function getAllApprovedMedia(){
    approvedMediaTableBody.innerHTML = '';
    const approvedMediaRoute = "http://localhost:8080/approvedMedia";
    let response = await fetch(approvedMediaRoute);
    if(response.status == 200){
        let approvedMediaBody = await response.json();
        console.log(approvedMediaBody);
        populateApprovedMedia(approvedMediaBody);
    } else {
        alert("Could not retrieve approved media!");
    };
};

const approvedMediaTable = document.getElementById("approved-media-table");
const approvedMediaTableBody = document.getElementById("approved-media-info");

function populateApprovedMedia(jsonBody){
    for(let am of jsonBody){
        let tableRow = document.createElement("tr");
        tableRow.innerHTML = `<td>${am.mediaId}</td><td>${am.title}</td><td>${am.synopsis}</td><td>${am.genre}</td>`;
        approvedMediaTableBody.appendChild(tableRow);
    };
};




// TO APPROVE A PIECE OF MEDIA
let approveDenyMessage = document.getElementById("approve-deny-message");

async function approveMedia(){
    let mediaIdInput = document.getElementById("media-id-input");

    let approveRoute = "http://localhost:8080/approveMedia/";
    let response = await fetch(approveRoute + mediaIdInput.value, {headers:{'Content-Type': 'application/json'}, method: "PATCH", body:JSON.stringify({"status": true}) });

    if(response.status == 200){
        let approveMediaBody = await response.json();
        mediaIdInput.value = '';
        console.log(approveMediaBody);
        approveDenyMessage.textContent = "This title has been approved.";
    } else if(response.status == 404){
        alert("Could not approve this media!");
    };
};



// TO DENY/DELETE A PIECE OF MEDIA
async function deleteMedia(){
    let mediaIdInput = document.getElementById("media-id-input");

    let deleteRoute = "http://localhost:8080/deleteMedia/";
    let response = await fetch(deleteRoute + mediaIdInput.value, {headers:{'Content-Type': 'application/json'}, method: "DELETE"});

    if(response.status == 200){
        let deleteMediaBody = await response.json();
        mediaIdInput.value = '';
        console.log(deleteMediaBody);
        approveDenyMessage.textContent = "This title has been denied.";
    } else if(response.status == 404){
        alert("Could not delete this media!");
    };
};






 // LOGOUT
function logout() {
  window.location.href = "login.html";
};