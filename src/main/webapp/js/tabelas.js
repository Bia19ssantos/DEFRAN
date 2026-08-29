
// Função para fazer a solicitação AJAX - CLIENTES
function getClientes() {
    var filtro = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ClienteServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var clienteDefran = JSON.parse(xhr.responseText);
                carregarClientes(clienteDefran, filtro); // Corrigido o nome da função aqui
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos clientes
function carregarClientes(clienteDefran, filtro) {
    var tableBody = document.getElementById("table-body");

    // Limpar a tabela antes de popular novamente
    tableBody.innerHTML = "";

    clienteDefran.forEach(clienteDefran => {
        // Verificar se o filtro está vazio ou se o nome do cliente contém o texto do filtro
        if (filtro === "" || clienteDefran.razao.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = clienteDefran.razao;
            row.insertCell().textContent = clienteDefran.cnpj;
            row.insertCell().textContent = clienteDefran.contato;
            row.insertCell().textContent = clienteDefran.telefone;
            row.insertCell().textContent = clienteDefran.celular;
            row.insertCell().textContent = clienteDefran.email;
        }
    });
}

// Chamar a função para obter os dados dos clientes e preencher a tabela
getClientes(); // Corrigido o nome da função aqui

document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtro");

    // Chamar a função para obter os dados dos clientes e preencher a tabela inicialmente
    getClientes();

    // Evento de escuta para o campo de filtro
    inputFiltro.addEventListener("keyup", function () {
        getClientes(); // Chamar a função novamente com o novo valor do filtro
    });

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

