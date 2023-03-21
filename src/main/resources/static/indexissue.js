let submit = document.getElementById("submit");
let todoContainer = document.getElementById("test");
let idesc = document.getElementById("IDesc");
let issue_date=document.getElementById("IDate");
let test1 = document.getElementById("test1");
let test2=  document.getElementById("test2");
let test3=  document.getElementById("test3");
let dropdown=document.getElementById("locality-dropdown");
let dropdown1=document.getElementById("dropdown-assignee");
let dropdown2=document.getElementById("dropdown-reporter");
submit.addEventListener("click", (e) =>{
    console.log(test1.value,"Nice");
    if(idesc.value==="" || test1.value==="" || test2.value==="" || test3.value==="" || issue_date===""){
        alert("Fill all the fields");
    }
    else{
        fetch("issue", {
     
            // Adding method type
            method: "POST",
            
            // Adding body or contents to send
            body: JSON.stringify({
                issue_created:issue_date.value,
                issue_description: idesc.value,
                issue_assignee: test2.value,
                issue_reporter: test3.value,
                issue_status:"TODO",
                issue_project:test1.value,
                id:single_value.id+1
            }),
            
            // Adding headers to the request
            headers: {
                "Content-Type": "application/json",
            }
        })
        window.location.replace("IssuePage.html");
        }
});
let single_value=0;
let users;
let projects;
let data;
async function getapi(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    data = await response.json();
    console.log(data);
    show(data);
}
async function getapi1(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    users = await response.json();
    console.log(users);
}
async function getapi2(url) {
    
    // Storing response
    const response = await fetch(url);
    
    // Storing data in form of JSON
    projects = await response.json();
    console.log(projects);
    dd1(users);
    dd2(projects);
    dd3(users);
    // show(projects);
}
getapi("issue");
getapi1("users");
getapi2("projects");
function show(data) {
    // Loop to access all rows
    let tab=``;
    for (let r of data) {
        single_value=r;
    tab+= `<div class="card bg-success">
    <div class="card-body text-center">
      <p class="card-text"> <a id="anchor" href="issue.html?id=`+encodeURIComponent(r.id)+`">`+r.issue_description+`</a></p>
    </div>
  </div>`;
    }
    // Setting innerHTML as tab variable
    document.getElementById("test").innerHTML = tab;
}
function dd1(users){
    for(let r of users){
        dropdown1.innerHTML+=('<option value="'+r.id+'">'+r.user_name+'</option');
    }
}
function dd2(projects){
    for(let r of projects){
        dropdown.innerHTML+=('<option value="'+r.id+'">'+r.project_name+'</option');
    }
}
function dd3(users){
    for(let r of users){
        dropdown2.innerHTML+=('<option value="'+r.id+'">'+r.user_name+'</option');
    }
}