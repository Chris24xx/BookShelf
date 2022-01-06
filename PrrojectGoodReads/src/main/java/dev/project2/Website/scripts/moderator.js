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
// Get Pending Contact Requests
  async function getPendingContactRequests(){
    let url = "http://localhost:8080/contactRequests/pending";

    let response = await fetch(url);
    
    if (response.status === 200){
        let body = await response.json();
        populateData(body);
    } else {
        alert("There was a problem trying to get pending contact requests: sorry!");
    }
}

// Get Completed Contact Requests -----------------------------------------

async function getCompletedContactRequests(){
    let url = "http://localhost:8080/contactRequests/completed";

    let response = await fetch(url);
    
    if (response.status === 200){
        let body = await response.json();
        populateDataComp(body);
    } else {
        alert("There was a problem trying to get completed contact requests: sorry!");
    }
}

// Populate data for Pending contact us table
function populateData(responseBody){
  for (let contact_us of responseBody){
      let tableRow = document.createElement("tr");
      tableRow.innerHTML = `<td>${contact_us.email}</td><td>${contact_us.fullName}</td><td>${contact_us.issueMessage}</td><td>${contact_us.status}</td>`;
      pendingTableBody.appendChild(tableRow);
  }
}

// Populate data for Completed contact us table
function populateDataComp(responseBody){
  for (let contact_us of responseBody){
      let tableRow = document.createElement("tr");
      tableRow.innerHTML = `<td>${contact_us.email}</td><td>${contact_us.fullName}</td><td>${contact_us.issueMessage}</td><td>${contact_us.status}</td>`;
      completedTableBody.appendChild(tableRow);
  }
}

getCompletedContactRequests()
getPendingContactRequests()

//------------------End of contact request js on this page

  



// LOGOUT
function logout(){
    window.location.href = "login.html";
  };