/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Função para fazer a solicitação AJAX - ESTOQUE DEFRAN

function getEstoqueDefran() {
    var filtro = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "EstoqueDefranServlet", true);
    
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var estoqueDefran = JSON.parse(xhr.responseText);
                carregarDados(estoqueDefran, filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos produtos
function carregarDados(estoqueDefran, filtro) {
    var tableBody = document.getElementById("table-body");

    // Limpar a tabela antes de popular novamente
    tableBody.innerHTML = "";

    estoqueDefran.forEach(estoqueDefran => {
        // Verificar se o filtro está vazio ou se o nome do produto contém o texto do filtro
        if (filtro === "" || estoqueDefran.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = estoqueDefran.id;
            row.insertCell().textContent = estoqueDefran.codigo;
            row.insertCell().textContent = estoqueDefran.refProd;
            row.insertCell().textContent = estoqueDefran.descProd;
            row.insertCell().textContent = estoqueDefran.qtde;
        }
    });
}

// Chamar a função para obter os dados dos produtos e preencher a tabela
getEstoqueDefran();
document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtro");

    // Chamar a função para obter os dados dos produtos e preencher a tabela inicialmente
    getEstoqueDefran();

    // Evento de escuta para o campo de filtro
    inputFiltro.addEventListener("keyup", function () {
        getEstoqueDefran(); // Chamar a função novamente com o novo valor do filtro
    });

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});