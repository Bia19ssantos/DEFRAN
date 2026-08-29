/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function validate(val) {
    v1 = document.getElementById("fname");
    v2 = document.getElementById("lname");
    v3 = document.getElementById("email");
    v4 = document.getElementById("mob");
    v5 = document.getElementById("job");
    v6 = document.getElementById("ans");

    flag1 = true;
    flag2 = true;
    flag3 = true;
    flag4 = true;
    flag5 = true;
    flag6 = true;

    if (val >= 1 || val == 0) {
        if (v1.value == "") {
            v1.style.borderColor = "red";
            flag1 = false;
        } else {
            v1.style.borderColor = "green";
            flag1 = true;
        }
    }

    if (val >= 2 || val == 0) {
        if (v2.value == "") {
            v2.style.borderColor = "red";
            flag2 = false;
        } else {
            v2.style.borderColor = "green";
            flag2 = true;
        }
    }
    if (val >= 3 || val == 0) {
        if (v3.value == "") {
            v3.style.borderColor = "red";
            flag3 = false;
        } else {
            v3.style.borderColor = "green";
            flag3 = true;
        }
    }
    if (val >= 4 || val == 0) {
        if (v4.value == "") {
            v4.style.borderColor = "red";
            flag4 = false;
        } else {
            v4.style.borderColor = "green";
            flag4 = true;
        }
    }
    if (val >= 5 || val == 0) {
        if (v5.value == "") {
            v5.style.borderColor = "red";
            flag5 = false;
        } else {
            v5.style.borderColor = "green";
            flag5 = true;
        }
    }
    if (val >= 6 || val == 0) {
        if (v6.value == "") {
            v6.style.borderColor = "red";
            flag6 = false;
        } else {
            v6.style.borderColor = "green";
            flag6 = true;
        }
    }

    flag = flag1 && flag2 && flag3 && flag4 && flag5 && flag6;

    return flag;
}
function validateCNPJ(cnpj) {
    // Remove any non-numeric characters from the CNPJ
    cnpj = cnpj.replace(/\D/g, '');

    // Check if the CNPJ has 14 digits
    if (cnpj.length !== 14) {
        return false;
    }

    // Check if all digits are the same (e.g., '00000000000000')
    if (/^(\d)\1+$/.test(cnpj)) {
        return false;
    }

    // Validate the first verification digit
    let sum = 0;
    let multiplier = 5;
    for (let i = 0; i < 12; i++) {
        sum += parseInt(cnpj.charAt(i)) * multiplier;
        multiplier = multiplier === 2 ? 9 : multiplier - 1;
    }

    let remainder = sum % 11;
    const firstVerificationDigit = remainder < 2 ? 0 : 11 - remainder;

    if (parseInt(cnpj.charAt(12)) !== firstVerificationDigit) {
        return false;
    }

    // Validate the second verification digit
    sum = 0;
    multiplier = 6;
    for (let i = 0; i < 13; i++) {
        sum += parseInt(cnpj.charAt(i)) * multiplier;
        multiplier = multiplier === 2 ? 9 : multiplier - 1;
    }

    remainder = sum % 11;
    const secondVerificationDigit = remainder < 2 ? 0 : 11 - remainder;

    return parseInt(cnpj.charAt(13)) === secondVerificationDigit;
}

// Função para fazer a solicitação AJAX - CLIENTES
function getClientes() {
    var filtro = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ClienteServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var clienteDefran = JSON.parse(xhr.responseText);
                carregarClientes(clienteDefran, filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

function carregarClientes(clienteDefran, filtro) {
    var tableBody = document.getElementById("table-body");
    var selectClientes = document.getElementById("clientesSelect");
    selectClientes.innerHTML = ""; // Limpar as opções antes de popular novamente

    // Limpar a tabela antes de popular novamente
    tableBody.innerHTML = "";

    clienteDefran.forEach(clienteDefran => {
        // Verificar se o filtro está vazio ou se o nome do cliente contém o texto do filtro
        if (filtro === "" || clienteDefran.razao.toLowerCase().includes(filtro.toLowerCase()) || clienteDefran.cnpj.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = clienteDefran.razao;
            row.insertCell().textContent = clienteDefran.cnpj;
            row.insertCell().textContent = clienteDefran.contato;
            row.insertCell().textContent = clienteDefran.telefone;
            row.insertCell().textContent = clienteDefran.cidade;
            row.insertCell().textContent = clienteDefran.estado;
            row.insertCell().textContent = clienteDefran.email;


            // Preencher o <select> com opções
            var option = document.createElement("option");
            option.value = clienteDefran.razao;
            option.textContent = clienteDefran.razao;
            selectClientes.appendChild(option);
        }
    });
}

document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtro");
    var inputRazao = document.getElementById("inputRazao");

    // Chamar a função para obter os dados dos clientes e preencher a tabela inicialmente
    getClientes();

    // Evento de escuta para o campo de filtro
    inputFiltro.addEventListener("keyup", function () {
        getClientes(); // Chamar a função novamente com o novo valor do filtro
    });

    // Evento de escuta para o campo de entrada
    inputRazao.addEventListener("input", function () {
        buscarRazao(); // Chamar a função de busca sempre que o valor for alterado
    });

    // Função para buscar a razão no servidor
    function buscarRazao() {
        var valorDigitado = inputRazao.value;

        if (valorDigitado.length >= 3) {
            // Fazer a solicitação AJAX para buscar a razão no servidor
            var xhr = new XMLHttpRequest();
            xhr.open("GET", "BuscaRazaoServlet?valor=" + valorDigitado, true);
            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        var razaoEncontrada = xhr.responseText;
                        inputRazao.value = razaoEncontrada;
                    } else {
                        console.error("Erro ao buscar a razão.");
                    }
                }
            };
            xhr.send();
        }
    }

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

// Função para limpar todas as tabelas
function limparTodasTabelas() {
    var tables = document.getElementsByClassName("datatablesSimple");
    for (var i = 0; i < tables.length; i++) {
        tables[i].style.display = "none";
        tables[i].getElementsByTagName("tbody")[0].innerHTML = "";
    }
}


