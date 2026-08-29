var produtosSpanset = [];

// Função para fazer a solicitação AJAX SPANSET
function getProdSpanset(filtroProduto) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdSpansetServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                produtosSpanset = JSON.parse(xhr.responseText);
                carregarTabelaProdutoSpanset(filtroProduto);
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

// Função para carregar a tabela de ProdSpansetServlet
function carregarTabelaProdutoSpanset(filtroProduto) {
    var tableBody = document.getElementById("table-body-spanset");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    produtosSpanset.forEach(prodSpanset => {
        if (filtroProduto === "" || prodSpanset.refProd.toLowerCase().includes(filtroProduto.toLowerCase())) {
            var row = tableBody.insertRow();
            row.classList.add("selected-row"); // Adicione a classe aqui

            row.insertCell().textContent = prodSpanset.codigo;
            row.insertCell().textContent = prodSpanset.refProd;
            row.insertCell().textContent = prodSpanset.ncm;
            row.insertCell().textContent = prodSpanset.icms;
            row.insertCell().textContent = prodSpanset.tipo;
            row.insertCell().textContent = formatarDecimal(prodSpanset.valorCusto);
            row.insertCell().textContent = formatarDecimal(prodSpanset.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableSpanset = document.getElementById("table-spanset");
    tableSpanset.style.display = "table";

}

//----------------------------------INICIO DA TABELA SPANSET----------------------------------------------------
// Adicione um evento de clique à tabela do modal
document.querySelector("#table-spanset tbody").addEventListener("click", function (event) {
    // Verifica se o clique foi em uma linha da tabela
    if (event.target.tagName === "TD") {
        // Obtém os dados da linha clicada
        var rowData = getRowSpanset(event.target.closest("tr"));

        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputRefProd").value = rowData.refProd;
        document.getElementById("inputValorUnit").value = rowData.ValorVenda;
        document.getElementById("inputNcm").value = rowData.ncm;
        document.getElementById("inputTipo").value = rowData.tipo;
    }
});

// Adicione um evento de clique às linhas da tabela dentro do modal
document.addEventListener("DOMContentLoaded", function () {
    var tableRows = document.querySelectorAll("#table-body-spanset .table-row");
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
            var ValorVenda = row.cells[6].textContent;
            var ncm = row.cells[2].textContent;
            var tipo = row.cells[4].textContent;

            document.getElementById("inputRefProd").value = refProd;
            document.getElementById("inputValorUnit").value = formatarDecimal(ValorVenda);
            document.getElementById("inputNcm").value = ncm;
            document.getElementById("inputTipo").value = tipo;


            // Calcula o total com base nos valores atuais
            calcularTotal();
        });
    });

    // Adicione evento ao campo de quantidade
    inputQtde.addEventListener("input", calcularTotal);
});

// Função para obter os dados da linha clicada
function getRowSpanset(row) {
    return {
        codigo: row.cells[0].textContent,
        refProd: row.cells[1].textContent,
        ncm: row.cells[2].textContent,
        icms: row.cells[3].textContent,
        tipo: row.cells[4].textContent,
        ValorCusto: row.cells[5].textContent,
        ValorVenda: row.cells[6].textContent
    };
}
