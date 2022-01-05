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






  



// LOGOUT
function logout(){
    window.location.href = "login.html";
  };