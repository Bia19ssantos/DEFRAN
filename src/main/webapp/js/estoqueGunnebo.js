// Função para fazer a solicitação AJAX - ESTOQUE GUNNEBO
function getEstoqueGunnebo() {
    var filtro = document.getElementById("filtro").value; // Captura o valor do filtro
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "EstoqueGunneboServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var estoqueGunnebo = JSON.parse(xhr.responseText);
                carregarTabela(estoqueGunnebo, filtro); // Passa o valor do filtro para a função carregarTabela
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos produtos
function carregarTabela(estoqueGunnebo, filtro) {
    var tableBody = document.getElementById("table-body");

    // Limpar a tabela antes de popular novamente
    tableBody.innerHTML = "";

    estoqueGunnebo.forEach(estoqueGunnebo => {
        // Verificar se o filtro está vazio ou se o nome do produto contém o texto do filtro (usando toLowerCase())
        if (filtro === "" || estoqueGunnebo.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = estoqueGunnebo.id;
            row.insertCell().textContent = estoqueGunnebo.codigo;
            row.insertCell().textContent = estoqueGunnebo.refProd;
            row.insertCell().textContent = estoqueGunnebo.qtde;
        }
    });
}
getEstoqueGunnebo();
document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtro");

    // Chamar a função para obter os dados dos produtos e preencher a tabela inicialmente
    getEstoqueGunnebo();

    // Evento de escuta para o campo de filtro
    inputFiltro.addEventListener("keyup", function () {
        getEstoqueGunnebo(); // Chamar a função novamente com o novo valor do filtro
    });

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});