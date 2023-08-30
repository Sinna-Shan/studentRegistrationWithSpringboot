const findAll = `http://localhost:8080/student`;
const container = document.querySelector(".container");
const searchInput = document.querySelector(".search-field");
const btnSearch = document.querySelector(".btn-search");
const btnLogOut = document.querySelector(".btn-logout");

btnLogOut.addEventListener("click",()=>{
    window.open("../login/login.html",'_top');
})


getAllStudents(findAll);
function getAllStudents(findAll) {
  fetch(findAll)
    .then((res) => res.json())
    .then((data) => {
      data.forEach((element) => {
        createCard(element);
      });
    });
}

function createCard(element) {
  const card = document.createElement("div");
  card.classList.add("card");
  const cardHeading = document.createElement("div");
  cardHeading.classList.add("card-heading");
  const firstName = document.createElement("h1");
  firstName.classList.add("card-heading-h1");
  const lastName = document.createElement("h4");
  lastName.classList.add("card-heading-h4");

  const cardBody = document.createElement("div");
  cardBody.classList.add("cardBody");
  const gender = document.createElement("h4");
  gender.classList.add("card-body-h4");
  const age = document.createElement("h4");
  age.classList.add("card-body-h4");
  const nic = document.createElement("h4");
  nic.classList.add("card-body-h4");
  const batch = document.createElement("h4");
  batch.classList.add("card-body-h4");

  firstName.innerHTML = element.firstName;
  lastName.innerHTML = element.lastName;
  gender.innerHTML = `<span class="card-span">Gender: </span>${element.gender}`;
  age.innerHTML = `<span class="card-span">Age: </span>${element.age}`;
  nic.innerHTML = `<span class="card-span">NIC: </span>${element.nic}`;
  batch.innerHTML = `<span class="card-span">Batch: </span>${element.batch}`;

  cardHeading.appendChild(firstName);
  cardHeading.appendChild(lastName);
  cardBody.appendChild(gender);
  cardBody.appendChild(age);
  cardBody.appendChild(nic);
  cardBody.appendChild(batch);
  card.appendChild(cardHeading);
  card.appendChild(cardBody);
  container.appendChild(card);
}

btnSearch.addEventListener("click", () => {
  if (searchInput.value != "") {
    fetch(`http://localhost:8080/student/${searchInput.value}`)
      .then((res) => res.json())
      .then((data) => {
        console.log(data);
        if (data.length !=0) {
          container.innerHTML = "";
          data.forEach((element) => {
            createCard(element);
          });
        }else{
            container.innerHTML = "";
            const h1 = document.createElement("h1");
            h1.classList.add('card-heading-h1')
            h1.innerHTML = "Nothing Found..!";
            container.appendChild(h1);
        }
      });
  }else{
    container.innerHTML = "";
    getAllStudents(findAll);
  }
});

