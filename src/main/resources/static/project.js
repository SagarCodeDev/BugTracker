let submit = document.getElementById("submit");
let pdesc = document.getElementById("PDesc");
let  pname=document.getElementById("PName");
let dropdown1=document.getElementById("dropdown-assignee");
let test2=document.getElementById("test2");
let sec=document.getElementById("sec");

submit.addEventListener("click", (e) =>{
    if(pdesc.value===""){
        pdesc.value=data.desc;
    }
    if(test2.value===""){
        test2.value=us.project_lead;
    }
    if(pname.value===""){
        pname.value=data.name;
    }
    fetch("projects/"+data.id, {
     
        // Adding method type
        method: "PUT",
        
        // Adding body or contents to send
        body: JSON.stringify({
            project_name:pname.value,
            project_created:data.time,
            project_description: pdesc.value,
            project_lead: test2.value,
            id:data.id
        }),
        
        // Adding headers to the request
        headers: {
            "Content-Type": "application/json",
        }
    })
    location.reload();
});
let users;
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
let us;
async function getapi3(url){
    const response = await fetch(url);
    
    // Storing data in form of JSON
    us = await response.json();
    console.log(us);
    dd1(users);
}
function show(data){
    sec.innerHTML=`<div class="card" style="width: 18rem;">
    <div class="card-body">
    Project Name:<h5 class="card-title"> `+data.name+`</h5>
    Project Lead:<h3 class="card-title"> `+data.lead+`</h3>
    Project Description:<h3 class="card-title">`+data.desc+`</h3>
    Project Created:<h3 class="card-title">`+data.time+`</h3>
    </div>
  </div>`
}
let url_string = window.location;
let url = new URL(url_string);
let id = url.searchParams.get("id");
getapi("projects/"+id)
getapi1("users");
getapi3("project/"+id);
function dd1(users){
    for(let r of users){
        dropdown1.innerHTML+=('<option value="'+r.id+'">'+r.user_name+'</option');
    }
}