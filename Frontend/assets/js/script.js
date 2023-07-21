const formulario = document.querySelector("form");
const Inome = document.querySelector(".form__group--name input");
const Iemail = document.querySelector(".form__group--email input");
const Isenha = document.querySelector(".form__group--password input");
const form_validation = document.querySelector(".form__validation");
const form_validation_content = document.querySelector(".form__validation span");
const form_group_name = document.querySelector(".form__group--name");

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
            form_group_name.style.marginTop="3rem";
            if (res.ok) {
                form_validation_content.innerHTML = "Cadastro realizado com sucesso!";
            } else {
                form_validation_content.innerHTML = "Erro ao realizar cadastro!";
                form_validation_content.style.color = "#FF0000";
            }
        })
        .catch(function (res) { console.log(res) })

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