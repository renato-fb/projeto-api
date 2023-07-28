const formulario = document.querySelector("form");
const Inome = document.querySelector(".form__group--name input");
const Iemail = document.querySelector(".form__group--email input");
const Isenha = document.querySelector(".form__group--password input");
const form_validation = document.querySelector(".form__validation");
const form_validation_content = document.querySelector(".form__validation span");
const form_group_name = document.querySelector(".form__group--name");
const getBtn = document.querySelector(".btn--get")

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
  var url = 'http://localhost:8080/usuarios'; // Replace with your API endpoint URL

  fetch(url)
    .then(response => {
      if (!response.ok) {
        throw new Error('Network response was not ok');
      }
      return response.json();
    })
    .then(responseData => {
      // Process responseData here
      console.log(responseData);
      var name = responseData.nome;
      console.log(responseData.nome);
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