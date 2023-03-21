let submit = document.getElementById("submit");
let idesc = document.getElementById("IDesc");
let statuss=document.getElementById("IStatus");
let dropdown = document.getElementById("locality-dropdown");
let dropdown1=document.getElementById("dropdown-assignee");
let dropdown2=document.getElementById("dropdown-reporter");
let test1=document.getElementById("test1");
let test2=document.getElementById("test2");
let test3=document.getElementById("test3");
let sec=document.getElementById("sec");
const stat = new Map([
    ["TODO", 1],
    ["IN PROGRESS", 2],
    ["READY FOR QA", 3],
    ["DONE",4]
  ]);
submit.addEventListener("click", (e) =>{
    if(idesc.value===""){
        idesc.value=data.desc;
    }
    if(test2.value===""){
        test2.value=us.issue_assignee;
    }
    if(test3.value===""){
        test3.value=us.issue_reporter;
    }
    if(test1.value===""){
        test1.value=us.issue_project;
    }
    if(statuss.value===""){
        statuss.value=us.issue_status;
    }
    else{
        if((data.status!=="DONE") && (stat.get(statuss.value)<stat.get(data.status))){
            alert("Status value cannot be reversed");
            return;
        }
        if(data.issue_status==="DONE" && (statuss.value!=="TODO")){
            alert("Enter a valid status");
            return;
        }
        let date = new Date().toJSON().slice(0, 10);
        fetch("issuelog", {
     
            // Adding method type
            method: "POST",
            
            // Adding body or contents to send
            body: JSON.stringify({
                id:data.id,
                issue_changes:test3.value,
                issue_old:us.issue_status,
                issue_new:statuss.value,
                issue_time:date
            }),
            
            // Adding headers to the request
            headers: {
                "Content-Type": "application/json",
            }
        })
    }
    fetch("issue/"+data.id, {
     
        // Adding method type
        method: "PUT",
        
        // Adding body or contents to send
        body: JSON.stringify({
            issue_created:data.time,
            issue_description: idesc.value,
            issue_assignee: test2.value,
            issue_reporter: test3.value,
            issue_status:statuss.value,
            issue_project:test1.value,
            id:data.id
        }),
        
        // Adding headers to the request
        headers: {
            "Content-Type": "application/json",
        }
    })
});
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
    // show(projects);
    dd1(users);
    dd2(projects);
    dd3(users);
}
let us;
let pro;
let log=0;
async function getapi3(url){
    const response = await fetch(url);
    
    // Storing data in form of JSON
    pro = await response.json();
    console.log(pro);
}
async function getapi4(url){
    const response = await fetch(url);
    
    // Storing data in form of JSON
    us = await response.json();
    console.log(us);
}
let logv;
async function getapi5(url){
    const response = await fetch(url);
    
    // Storing data in form of JSON
    log = await response.json();
    console.log(log);
    for(let x of log){
        logv=log;
    }
}
function show(data){
    sec.innerHTML=`<div class="card" style="width: 18rem;">
    <div class="card-body">
    Issue Description:<h5 class="card-title"> `+data.desc+`</h5>
    Project Name:<h3 class="card-title"> `+data.project+`</h3>
    Issue Raise Date:<h3 class="card-title">`+data.time+`</h3>
    Issue Assignee:<h3 class="card-title">`+data.assignee+`</h3>
    Issue Reporter:<h3 class="card-title">`+data.reporter+`</h3>
    Issue Status:<h3 class="card-title">`+data.status+`</h3>
    </div>
  </div>`
}
var url_string = window.location;
var url = new URL(url_string);
var id = url.searchParams.get("id");
getapi("issue/"+id)
getapi1("users");
getapi2("projects");
getapi3("project/"+id);
getapi4("issues/"+id);
getapi5("issuelog");
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