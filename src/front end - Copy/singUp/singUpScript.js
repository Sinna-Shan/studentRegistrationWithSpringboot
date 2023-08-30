const firstName = document.getElementById("firstName");
const lastName = document.getElementById("lastName");
const gender = document.getElementsByName("gender");
const age = document.getElementById("age");
const nic = document.getElementById("nic");
const address = document.getElementById("address");
const batch = document.getElementById("batch");
const userName = document.getElementById("userName");
const password = document.getElementById("password");
const btnReg = document.getElementById("btnReg");
const file = document.getElementById("file");
let selGender;

let firstNameError = document.getElementById("firstNameError");
let lastNameError = document.getElementById("lastNameError");
let genderError = document.getElementById("genderError");
let ageError = document.getElementById("ageError");
let nicError = document.getElementById("nicError");
let addressError = document.getElementById("addressError");
let batchError = document.getElementById("batchError");
let userNameError = document.getElementById("userNameError");
let passwordError = document.getElementById("passwordError");

function clearErrorFields() {
  firstNameError.innerHTML = "";
  lastNameError.innerHTML = "";
  genderError.innerHTML = "";
  ageError.innerHTML = "";
  nicError.innerHTML = "";
  addressError.innerHTML = "";
  batchError.innerHTML = "";
  userNameError.innerHTML = "";
  passwordError.innerHTML = "";
}

function clearInputFields() {
  firstName.value = "";
  lastName.value = "";
  for (let i = 0; i < gender.length; i++) {
    if (gender[i].checked) {
      gender[i].checked = false;
    }
  }
  age.value = "";
  nic.value = "";
  address.value = "";
  batch.value = "";
  userName.value = "";
  password.value = "";
}

btnReg.addEventListener("click", () => {
  for (let i = 0; i < gender.length; i++) {
    if (gender[i].checked) {
      selGender = gender[i].value;
    }
  }

  let student = {
    firstName: firstName.value,
    lastName: lastName.value,
    gender: selGender,
    age: age.value,
    nic: nic.value,
    address: address.value,
    batch: batch.value,
    userName: userName.value,
    password: password.value,
  };

  fetch(`http://localhost:8080/student`, {
    method: "POST",
    enctype : "multipart/form-data",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(student),
  })
    .then((res) => res.json())
    .then((data) => {
      console.log(data);
      if (data.password !== "-1" && nic.value == data.nic) {
        clearInputFields();
        alert("Successfully added!");
        window.open("../login/login.html",'_top');
      } else {
        ifNotAdded(data);
      }
    });
});

const ifNotAdded = (data) => {
  data.firstName == "1"
    ? (firstNameError.innerHTML = `<span class="star">* </span>please enter first name`)
    : (firstNameError.innerHTML = "");

  data.lastName == "2"
    ? (lastNameError.innerHTML = `<span class="star">* </span>please enter first name`)
    : (lastNameError.innerHTML = "");

  data.gender == "3"
    ? (document.getElementById(
        "genderError"
      ).innerHTML = `<span class="star">* </span>please select you gender`)
    : (document.getElementById("genderError").innerHTML = "");

  data.age == "4"
    ? (ageError.innerHTML = `<span class="star">* </span>please enter a valid age between 12 and 65`)
    : (addressError.innerHTML = "");

  data.nic == "5"
    ? (nicError.innerHTML = `<span class="star">* </span>please enter a valid NIC number <br> It must contain 9 digits with v or 12 digits`)
    : (nicError.innerHTML = "");

  data.address == "6"
    ? (addressError.innerHTML = `<span class="star">* </span>please Enter your Address`)
    : (addressError.innerHTML = "");

  data.batch == "7"
    ? (batchError.innerHTML = `<span class="star">* </span>please Enter your batch`)
    : (batchError.innerHTML = "");

  data.userName == "8"
    ? (userNameError.innerHTML = `<span class="star">* </span>please Enter your User Name`)
    : (userNameError.innerHTML = "");

  if (data.password == "9") {
    passwordError.innerHTML = `<span class="star">*</span>length 4 - 20 <br> one lowercase letter <br>
    one uppercase letter <br>
    one digit <br>
    one "!@#$%"`;
  } else if (data.password == "-1") {
    passwordError.innerHTML = `<span class="star">*</span>Password already taken`;
    password.value = "";
  } else {
    passwordError.innerHTML = "";
  }
};

let inputs = [
  firstName,
  lastName,
  age,
  nic,
  address,
  batch,
  userName,
  password,
];
let errors = [
  firstNameError,
  lastNameError,
  ageError,
  nicError,
  addressError,
  batchError,
  userNameError,
  passwordError,
];

for (let i = 0; i < inputs.length; i++) {
  inputs[i].addEventListener("keypress", () => {
    errors[i].innerHTML = "";
  });
}
