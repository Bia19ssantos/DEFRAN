var manilhasCrosby = [];

// Função para fazer a solicitação AJAX Manilhas Crosby
function getManilhasCrosby(filtroProduto) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ManilhasCrosbyServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                manilhasCrosby = JSON.parse(xhr.responseText);
                carregarTabelaManilhasCrosby(filtroProduto);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para formatar um número Decimal
function formatarDecimal(valor) {
    return valor.toFixed(2); // Formata o número com duas casas decimais
}

// Função para carregar a tabela de ProdutoCrosbyServlet
function carregarTabelaManilhasCrosby(filtroProduto) {
    var tableBody = document.getElementById("table-body-manilhas");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    manilhasCrosby.forEach(manilhas => {
        // Verificar se o texto do produto contém o filtro digitado
        if (filtroProduto === "" || manilhas.refProd.toLowerCase().includes(filtroProduto.toLowerCase())) {
            var row = tableBody.insertRow();
            row.classList.add("selected-row"); // Adicione a classe aqui

            row.insertCell().textContent = manilhas.sap;
            row.insertCell().textContent = manilhas.refProd;
            row.insertCell().textContent = manilhas.descProd;
            row.insertCell().textContent = manilhas.ncm;
            row.insertCell().textContent = manilhas.ipi;
            row.insertCell().textContent = manilhas.tipo;
            row.insertCell().textContent = formatarDecimal(manilhas.valorCusto);
            row.insertCell().textContent = formatarDecimal(manilhas.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableManilhas = document.getElementById("table-manilhas");
    tableManilhas.style.display = "table";

}

//----------------------------------INICIO DA TABELA MANILHAS----------------------------------------------------
// Adicione um evento de clique à tabela do modal
document.querySelector("#table-manilhas tbody").addEventListener("click", function (event) {
    // Verifica se o clique foi em uma linha da tabela
    if (event.target.tagName === "TD") {
        // Obtém os dados da linha clicada
        var rowData = getRowManilhas(event.target.closest("tr"));

        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputRefProd").value = rowData.refProd;
        document.getElementById("inputValorUnit").value = rowData.ValorVenda;
        document.getElementById("inputTipo").value = rowData.tipo;
        document.getElementById("inputNcm").value = rowData.ncm;
        document.getElementById("inputDescProd").value = rowData.descProd;
    }
});

// Função para formatar um número Decimal
function formatarDecimal(valor) {
    return valor.toFixed(2); // Formata o número com duas casas decimais
}

// Adicione um evento de clique às linhas da tabela dentro do modal
document.addEventListener("DOMContentLoaded", function () {
    var tableRows = document.querySelectorAll("#table-body-manilhas tr");
    var inputQtde = document.getElementById("inputQtde");
    var inputValorUnit = document.getElementById("inputValorUnit");
    var inputTotalItem = document.getElementById("inputTotalItem");

    // Função para calcular o valor total
    function calcularTotal() {
        var quantidade = parseFloat(inputQtde.value) || 0;
        var valorUnitario = parseFloat(inputValorUnit.value) || 0;

        var totalItem = quantidade * valorUnitario;
        var valorTotalFormatado = formatarDecimal(totalItem);

        inputTotalItem.value = valorTotalFormatado;

    }

    tableRows.forEach(row => {
        row.addEventListener("click", function () {
            // Remove classe de todas as linhas para desmarcar a anterior
            tableRows.forEach(row => {
                row.classList.remove("selected-row");
            });

            // Adiciona classe à linha clicada para destacá-la
            row.classList.add("selected-row");

            // Obtém os dados da linha clicada e preenche os campos de input
            var refProd = row.cells[1].textContent;
            var descProd = row.cells[2].textContent;
            var ValorVenda = row.cells[7].textContent;
            var ncm = row.cells[3].textContent;
            var tipo = row.cells[5].textContent;

            document.getElementById("inputRefProd").value = refProd;
            document.getElementById("inputValorUnit").value = formatarDecimal(ValorVenda);
            document.getElementById("inputNcm").value = ncm;
            document.getElementById("inputTipo").value = tipo;
            document.getElementById("inputDescProd").value = descProd;

            // Calcula o total com base nos valores atuais
            calcularTotal();
        });
    });

    // Adicione evento ao campo de quantidade
    inputQtde.addEventListener("input", calcularTotal);
});

// Função para obter os dados da linha clicada na tabela Manilhas
function getRowManilhas(row) {
    return {
        sap: row.cells[0].textContent,
        refProd: row.cells[1].textContent,
        descProd: row.cells[2].textContent,
        ncm: row.cells[3].textContent,
        ipi: row.cells[4].textContent,
        tipo: row.cells[5].textContent,
        ValorCusto: row.cells[6].textContent,
        ValorVenda: row.cells[7].textContent
    };
}

