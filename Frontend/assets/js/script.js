(function() {
    const formulario = document.querySelector("form");
    const Inome = document.querySelector(".form__group--name input");
    const Iemail = document.querySelector(".form__group--email input");
    const Isenha = document.querySelector(".form__group--password input");
    const form_validation = document.querySelector(".form__validation");
    const form_validation_content = document.querySelector(".form__validation span");
    const form_group_name = document.querySelector(".form__group--name");
    const getBtn = document.querySelector(".btn--get");
  
    function showMessage(message, color) {
      form_validation.style.display = "block";
      form_group_name.style.marginTop = "12rem";
      form_validation_content.innerHTML = message;
      form_validation_content.style.color = color;
    }
  
    function cadastrar() {
      fetch("http://localhost:8080/usuarios", {
        headers: {
          'Accept': 'application/json',
          'Content-type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify({
          nome: Inome.value,
          email: Iemail.value,
          senha: Isenha.value
        })
      })
      .then(response => {
        if (response.ok) {
          showMessage("Cadastro realizado com sucesso!", "#00FF00");
        } else {
          showMessage("Erro ao realizar cadastro!", "#FF0000");
        }
      })
      .catch(error => {
        console.log(error);
      });
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
          console.log(responseData);
        })
        .catch(error => {
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
    });
  
    getBtn.addEventListener('click', function (obj) {
      pegarLogins();
      obj.preventDefault();
    });
  })();
  