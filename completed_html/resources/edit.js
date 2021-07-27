
function showPassword(){
    if(document.getElementById("pass-container").style.display == "none"){
        document.getElementById("pass-container").style.display = "flex";
    }
    else{
        document.getElementById("pass-container").style.display = "none"
    }

}
function showUser(){
    if(document.getElementById("user-container").style.display == "none")
    {
        document.getElementById("user-container").style.display = "flex";
    }
    else{
        document.getElementById("user-container").style.display = "none";
    }
}

async function putUsername(newUsername){

    data = {"customer_id":1, "customer_username":newUsername}

    const res = await fetch('localhost:3001/books', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      })
}

async function putPassword(newPassword){

    data = {"customer_id":1, "customer_password":newPassword}

    const res = await fetch('localhost:3001/books', {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
      })
}


function updateUsername(){
    console.log("updating username...")
    const username = document.getElementById("username").value
    const confirmUsername = document.getElementById("confirm_username").value
    if(username===confirmUsername){
        putUsername(username)
    }
}

function updatePassword(){
    const password = document.getElementById("password").value
    const confirmPassword = document.getElementById("confirm_password").value
    if(password===confirmPassword){
        putPassword(password)
    }
}