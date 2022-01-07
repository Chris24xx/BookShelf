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
async function approveMedia(){
    let mediaIdInput = document.getElementById("media-id-input");

    let approveRoute = "http://localhost:8080/approveMedia/";
    let response = await fetch(approveRoute + mediaIdInput.value, {headers:{'Content-Type': 'application/json'}, method: "PATCH", body:JSON.stringify({"status": true}) });

    if(response.status == 200){
        let approveMediaBody = await response.json();
        mediaIdInput.value = '';
        // document.location.reload(true);
        console.log(approveMediaBody);
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
        // document.location.reload(true);
        console.log(deleteMediaBody);
    } else if(response.status == 404){
        alert("Could not delete this media!");
    };
};