
// Declaração de variáveis globais para armazenar os dados das tabelas
var prodGunnebo = [];

// Função para fazer a solicitação AJAX Gunnebo
function getProdGunnebo(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdutoGunneboServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                prodGunnebo = JSON.parse(xhr.responseText);
                carregarTabelaProdutoGunnebo(filtro);
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

function carregarTabelaProdutoGunnebo(filtro) {
    var tableBody = document.getElementById("table-body-gunnebo");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    prodGunnebo.forEach(produto => {
        if (produto.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.setAttribute("data-id", produto); // Adicione o atributo data-id com o índice

            row.insertCell().textContent = produto.sap;
            row.insertCell().textContent = produto.refProd;
            row.insertCell().textContent = produto.descProd;
            row.insertCell().textContent = produto.ncm;
            row.insertCell().textContent = produto.ipi;
            row.insertCell().textContent = produto.tipo;
            row.insertCell().textContent = produto.comprimento;
            row.insertCell().textContent = formatarDecimal(produto.valorCusto);
            row.insertCell().textContent = formatarDecimal(produto.valorVenda);
            row.insertCell().textContent = Math.ceil(formatarDecimal(produto.precoLinga));

        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableGunnebo = document.getElementById("table-gunnebo");
    tableGunnebo.style.display = "table";

}

//------------------------------------------- TABELA GUNNEBO ----------------------------------------------------------------
// Adicione um evento de clique à tabela do modal
document.querySelector("#table-gunnebo tbody").addEventListener("click", function (event) {
    // Verifica se o clique foi em uma linha da tabela
    if (event.target.tagName === "TD") {
        var rowData = getRowGunnebo(event.target.closest("tr"));

        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputRefProd").value = rowData.refProd;
        document.getElementById("inputValorUnit").value = rowData.ValorVenda;
        document.getElementById("inputNcm").value = rowData.ncm;
        document.getElementById("inputTipo").value = rowData.tipo;
        document.getElementById("inputTamanho").value = rowData.comprimento;
        document.getElementById("inputDescProd").value = rowData.descProd;

        document.getElementById("inputRefProd1").value = rowData.refProd;
        document.getElementById("inputIpi").value = rowData.ipi;
        document.getElementById("inputValorUnit1").value = Math.ceil(rowData.precoLinga);
        document.getElementById("inputTipo1").value = rowData.tipo;
    }
});

// Adicione um evento de clique às linhas da tabela dentro do modal
document.addEventListener("DOMContentLoaded", function () {
    var tableRows = document.querySelectorAll("#table-body-gunnebo .table-row");
    var selectedRow = null; // Para manter o controle da linha selecionada
    var inputQtde = document.getElementById("inputQtde");
    var inputQtde1 = document.getElementById("inputQtde1");

    tableRows.forEach(row => {
        row.addEventListener("click", function () {
            // Remove classe de todas as linhas para desmarcar a anterior
            tableRows.forEach(row => {
                row.classList.remove("selected-row");
            });

            // Adiciona classe à linha clicada para destacá-la
            row.classList.add("selected-row");
            selectedRow = row; // Atualiza a linha selecionada

            var refProd = row.cells[1].textContent;
            var descProd = row.cells[2].textContent;
            var ValorVenda = row.cells[8].textContent;
            var ncm = row.cells[3].textContent;
            var tipo = row.cells[5].textContent;
            var comprimento = row.cells[6].textContent;

            var refProd1 = row.cells[1].textContent;
            var ipi = row.cells[4].textContent;
            var ValorVenda1 = row.cells[9].textContent;
            var tipo1 = row.cells[5].textContent;

            document.getElementById("inputRefProd").value = refProd;
            document.getElementById("inputValorUnit").value = formatarDecimal(ValorVenda);
            document.getElementById("inputNcm").value = ncm;
            document.getElementById("inputIpi").value = ipi;
            document.getElementById("inputTipo").value = tipo;
            document.getElementById("inputDescProd").value = descProd;
            document.getElementById("inputTamanho").value = comprimento;

            document.getElementById("inputRefProd1").value = refProd1;
            document.getElementById("inputValorUnit1").value = Math.ceil(formatarDecimal(ValorVenda1));
            document.getElementById("inputTipo1").value = tipo1;

            // Função para calcular o valor total
            function calcularTotal() {

                var inputQtde = document.getElementById("inputQtde");
                var inputValorUnit = document.getElementById("inputValorUnit");
                var inputTotalItem = document.getElementById("inputTotalItem");

                var quantidade = parseFloat(inputQtde.value) || 0;
                var valorUnitario = parseFloat(inputValorUnit) || 0;

                var totalItem = quantidade * valorUnitario;

                // Formate o valor total como decimal com duas casas decimais
                inputTotalItem.value = formatarDecimal(totalItem);
            }

            inputQtde.addEventListener("input", calcularTotal);
        });
    });

    // Adicione um ouvinte de eventos ao inputQtde1
    inputQtde1.addEventListener("input", function () {
        calcularTotal12();
    });

    var selectMarca = document.getElementById("marca");
    var inputFiltro = document.getElementById("filtro");

    selectMarca.addEventListener("change", function () {
        var selectedOption = selectMarca.value;
        var filtro = inputFiltro.value.toLowerCase();

        limparTodasTabelas();

        if (selectedOption === "gunnebo") {
            getProdGunnebo(filtro);
        } else if (selectedOption === "pewag") {
            getProdPewag(filtro);
        } else if (selectedOption === "spanset") {
            getProdSpanset(filtro);
        } else if (selectedOption === "crosby") {
            getProdCrosby(filtro);
        } else if (selectedOption === "manilhas") {
            getManilhasCrosby(filtro);
        } else {
            limparTodasTabelas();
        }
    });

    // Adicionar evento de escuta para o input de filtro
    inputFiltro.addEventListener("input", function () {
        var selectedOption = selectMarca.value;
        var filtro = inputFiltro.value.toLowerCase();

        // Chamar a função correspondente ao option selecionado, passando o filtro como argumento
        if (selectedOption === "gunnebo") {
            carregarTabelaProdutoGunnebo(filtro);
        } else if (selectedOption === "pewag") {
            getProdPewag(filtro);
        } else if (selectedOption === "spanset") {
            getProdSpanset(filtro);
        } else if (selectedOption === "crosby") {
            getProdCrosby(filtro);
        } else if (selectedOption === "manilhas") {
            getManilhasCrosby(filtro);
        } else {
            // Opção vazia ou desconhecida selecionada, pode fazer alguma ação de limpeza ou mostrar uma mensagem de erro
        }
    });

    // Iniciar a tabela de dados 
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

// Função para obter os dados da linha clicada na tabela Gunnebo
function getRowGunnebo(row) {
    return {
        sap: row.cells[0].textContent,
        refProd: row.cells[1].textContent,
        descProd: row.cells[2].textContent,
        ncm: row.cells[3].textContent,
        ipi: row.cells[4].textContent,
        tipo: row.cells[5].textContent,
        comprimento: row.cells[6].textContent,
        ValorCusto: row.cells[7].textContent,
        ValorVenda: row.cells[8].textContent,
        precoLinga: row.cells[9].textContent

    };
}
// Função para limpar todas as tabelas
function limparTodasTabelas() {
    var tables = document.getElementsByClassName("datatablesSimple");
    for (var i = 0; i < tables.length; i++) {
        tables[i].style.display = "none";
        tables[i].getElementsByTagName("tbody")[0].innerHTML = "";
    }
}


// Função para calcular o total do item com base na quantidade e no valor unitário
function calcularTotal12() {
    var inputQtde1 = document.getElementById("inputQtde1");
    var inputValorUnit1 = document.getElementById("inputValorUnit1");
    var inputTotalItem1 = document.getElementById("inputTotalItem1");

    var quantidade1 = parseFloat(inputQtde1.value) || 0;
    var valorUnitario1 = parseFloat(inputValorUnit1.value) || 0;

    var totalItem1 = Math.ceil(quantidade1 * valorUnitario1);

    // Atualize o inputTotalItem1
    inputTotalItem1.value = formatarDecimal(totalItem1);
}


    