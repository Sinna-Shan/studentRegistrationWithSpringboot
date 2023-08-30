const userName = document.querySelector(".user-Name");
const password = document.querySelector(".password");
const check = document.getElementById("check");
const btn = document.querySelector(".btn");

check.onclick = () => {
  if (password.type == "password") {
    password.type = "text";
  } else {
    password.type = "password";
  }
};

btn.addEventListener("click", () => {
  if (userName.value == "" || password.value == "") {
    userName.style.borderColor = "red";
    password.style.borderColor = "red";
    restFields();
    return;
  }
  fetch(`http://localhost:8080/admin/${userName.value}/${password.value}`)
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      if (data.length != 0) {
        userName.value = "";
        password.value = "";
        window.open("../home/home.html", "_top");
      } else{
        userName.style.borderColor = "red";
        password.style.borderColor = "red";
        userName.value='';
        password.value='';
        restFields();
      }
    });
});

function restFields(){
    const inputs = [userName,password]
    for(let i = 0; i<inputs.length;i++){
        inputs[i].addEventListener("keypress",()=>{
            inputs[i].style.borderColor = "black";
        })
    }
}