let submit = document.getElementById("submit");
let ProjectPage = document.getElementById("Project-Page");
let pname = document.getElementById("PName");
let pdescription = document.getElementById("PDescription");
let pdate = document.getElementById("PDate");
let test=document.getElementById("test1");
let dropdown1=document.getElementById("locality-dropdown");
submit.addEventListener("click", (e) =>{
    if(pname.value==="" || test.value==="" || pdescription.value==="" || pdate.value===""){
        alert("Fill all the fields");
    }
    else{
        fetch("projects", {
     
            // Adding method type
            method: "POST",
            
            // Adding body or contents to send
            body: JSON.stringify({
                project_created:pdate.value,
                project_name: pname.value,
                project_description: pdescription.value,
                project_lead: test.value,
                id:single_value.id+1
            }),
            
            // Adding headers to the request
            headers: {
                "Content-Type": "application/json",
            }
        })
        window.location.replace("");
        }
});
let data;
let users;
let single_value=0;
async function getapi(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    data = await response.json();
    console.log(data);
    show(data);
}
getapi("projects");
getapi1("users");
function show(data) {
    // Loop to access all rows
    let tab=``;
    for (let r of data) {
        single_value=r;
    tab+= `<div class="card bg-success">
    <div class="card-body text-center">
      <p class="card-text"><a id="anchor" href="project.html?id=`+r.id+`">`+r.project_name+`</a></p>
    </div>
  </div>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("test").innerHTML = tab;
}
async function getapi1(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    users = await response.json();
    console.log(users);
    dd1(users);
}
function dd1(users){
    for(let r of users){
        dropdown1.innerHTML+=('<option value="'+r.id+'">'+r.user_name+'</option');
    }
}