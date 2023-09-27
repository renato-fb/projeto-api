const formulario = document.querySelector("form");
const Inome = document.querySelector(".form__group--name input");
const Iemail = document.querySelector(".form__group--email input");
const Isenha = document.querySelector(".form__group--password input");
const form_validation = document.querySelector(".form__validation");
const form_validation_content = document.querySelector(".form__validation span");
const form_group_name = document.querySelector(".form__group--name");
const getBtn = document.querySelector(".btn--get")
const titleElements = document.querySelectorAll(".notes__item-text--title");
const descriptionElements = document.querySelectorAll(".notes__item-text--description");
const btn = document.querySelectorAll(".btn");

function cadastrar() {
    fetch("http://localhost:8080/usuarios",
        {
            headers: {
                'Accept': 'application/json',
                'Content-type': 'application/json'
            },
            method: "POST",
            body: JSON.stringify({
                nome: Inome.value,
                email: Iemail.value,
                senha: Isenha.value,
            })
        })
        .then(function (res) {
            form_validation.style.display = "block"
            form_group_name.style.marginTop="12rem";
            if (res.ok) {
                console.log("Cadastro realizado com sucesso")
                form_validation_content.innerHTML = "Cadastro realizado com sucesso!";
                form_validation_content.style.color = "#00FF00";
            } else {
                form_validation_content.innerHTML = "Erro ao realizar cadastro!";
                form_validation_content.style.color = "#FF0000";
            }
        })
        .catch(function (res) { console.log(res) })

}

function pegarLogins() {
  var url = 'http://localhost:8080/usuarios'; 

  fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(responseData => {
      // Process responseData here
      console.log(responseData)
    })
    .catch(error => {
      // Handle error
      console.error('Fetch error:', error);
    });
}

function limpar() {
    Inome.value = "";
    Iemail.value = "";
    Isenha.value = "";
}

formulario.addEventListener('submit', function (event) {
    event.preventDefault();
    cadastrar();
    limpar();
})

getBtn.addEventListener('click', function(obj) {
    pegarLogins();
    obj.preventDefault();
})

function pegarNotas() {
    var noteUrl = 'http://localhost:8080/notes'; 

    fetch(noteUrl)
      .then(response => {
        if (!response.ok) {
          throw new Error('Network response was not ok');
        }
        return response.json();
      })
      .then(responseData => {
        // Process responseData here
        responseData.forEach((data, index) => {
            // Update the title and description elements based on their corresponding indices
            titleElements[index].textContent = data.title;
            descriptionElements[index].textContent = data.description;
        });
      })
      .catch(error => {
        // Handle error
        console.error('Fetch error:', error);
      });
};


btn.forEach(bt => {
    bt.addEventListener('click', function(e) {
        e.preventDefault();
    });
});

