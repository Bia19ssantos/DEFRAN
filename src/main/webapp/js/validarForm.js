
document.addEventListener("DOMContentLoaded", function () {

function validarFormulario() {
 
    var inputItem = document.getElementById("inputItem").value;
    var inputRefProd = document.getElementById("inputRefProd").value;
    var inputDescProd = document.getElementById("inputDescProd").value;
    var inputNcm = document.getElementById("inputNcm").value;
    var inputTipo = document.getElementById("inputTipo").value;
    var inputQtde = document.getElementById("inputQtde").value;
    var inputValorUnit = document.getElementById("inputValorUnit").value;
    var inputTotalItem = document.getElementById("inputTotalItem").value;
    var inputPrazo = document.getElementById("inputPrazo").value;

    var inputNumOrc = document.getElementById("inputNumOrc");
    var inputEmpresa = document.getElementById("inputEmpresa").value;
    var inputDataOrc = new Date(document.getElementById("inputDataOrc").value).toISOString().split('T')[0];
    var inputCnpj = document.getElementById("inputCnpj").value;
    var SelectVendedor = document.getElementById("SelectVendedor").value;
    var inputPagamento = document.getElementById("inputPagamento").value;
    var inputTransporte = document.getElementById("inputTransporte").value;
    var inputTotalOrc = document.getElementById("inputTotalOrc").value;

    // Obtenha referências aos elementos de mensagem
    var mensagemErro = document.getElementById("mensagemErro");
    var mensagemSucesso = document.getElementById("mensagemSucesso");

    // Limpe mensagens anteriores
    mensagemErro.innerHTML = "";
    mensagemSucesso.innerHTML = "";

    // Validação de campos
    if (inputNumOrc.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputEmpresa.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputDataOrc.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputCnpj.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (SelectVendedor.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputPagamento.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputTransporte.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputTotalOrc.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputItem.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false; 
    }
    if (inputRefProd.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false; 
    }
    if (inputDescProd.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false; 
    }
    if (inputNcm.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false; 
    }
    if (inputTipo.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputQtde.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputValorUnit.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputTotalItem.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }
    if (inputPrazo.value === "") {
        alert("Número do Orçamento é obrigatório.");
        return false;
    }

    mensagemSucesso.innerHTML = "Formulário validado com sucesso!";
    return true;
}
});