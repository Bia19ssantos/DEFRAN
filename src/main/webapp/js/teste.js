var dados = [
    [01, "EGKN-8-10", "Descrição 1", "76589876", "PC", "3", "500", "1500", "5 dias"],
    [02, "G-8-10", "Descrição 2", "76589876", "PC", "4", "500", "2000", "5 dias"]
];

// Função para gerar a tabela com os dados
function gerarTabela() {
    var tabelaBody = document.getElementById("tabelaBody");

    for (var i = 0; i < dados.length; i++) {
        var row = document.createElement("tr");
        for (var j = 0; j < dados[i].length; j++) {
            var cell = document.createElement("td");
            cell.appendChild(document.createTextNode(dados[i][j]));
            row.appendChild(cell);
        }
        tabelaBody.appendChild(row);
    }
}

// Chame a função para gerar a tabela ao carregar a página
window.onload = function () {
    gerarTabela();
};

    // Envie os dados para o servidor usando AJAX
    $.ajax({
        type: "POST",
        url: "testeServlet",
        data: {dados: JSON.stringify(dados)},
        success: function (response) {
            alert("Dados salvos com sucesso!");
        },
        error: function (xhr, status, error) {
            alert("Erro ao salvar dados: " + error);
        }
    });


