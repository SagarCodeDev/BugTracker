let submit = document.getElementById("loginsubmit");
let username = document.getElementById("loginusername");
let password = document.getElementById("loginpassword");
submit.addEventListener("click", (e) =>{
if (username.value === "" || password.value === "" ) 
    alert("Kindly complete all fields");
else{
    fetch("http://localhost:8585/login")
  .then((response) => window.location.pathname('/ProjectPage.html'))
  .catch((data) => alert(data.message));
}
});