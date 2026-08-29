var produtosPewag = [];

// Função para fazer a solicitação AJAX PEWAG
function getProdPewag(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdPewagServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                produtosPewag = JSON.parse(xhr.responseText);
                carregarTabelaProdutoPewag(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para carregar a tabela de ProdPewagServlet
function carregarTabelaProdutoPewag(filtro) {
    var tableBody = document.getElementById("table-body-pewag");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    produtosPewag.forEach(prodPewag => {
        // Verificar se o filtro está vazio ou se o nome do produto contém o texto do filtro
        if (filtro === "" || prodPewag.refPewag.toLowerCase().includes(filtro.toLowerCase()) || filtro === "" || prodPewag.refGunnebo.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.classList.add("selected-row"); // Adicione a classe aqui

            row.insertCell().textContent = prodPewag.codigo;
            row.insertCell().textContent = prodPewag.refPewag;
            row.insertCell().textContent = prodPewag.descProd;
            row.insertCell().textContent = prodPewag.ncm;
            row.insertCell().textContent = prodPewag.ipi;
            row.insertCell().textContent = prodPewag.tipo;
            row.insertCell().textContent = prodPewag.comprimento;
            row.insertCell().textContent = formatarDecimal(prodPewag.valorCusto);
            row.insertCell().textContent = formatarDecimal(prodPewag.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tablePewag = document.getElementById("table-pewag");
    tablePewag.style.display = "table";

}

// Função para formatar um número Decimal
function formatarDecimal(valor) {
    return valor.toFixed(2); // Formata o número com duas casas decimais
}

//----------------------------------TABELA PEWAG-------------------------------------
// Adicione um evento de clique à tabela do modal
document.querySelector("#table-pewag tbody").addEventListener("click", function (event) {
    // Verifica se o clique foi em uma linha da tabela
    if (event.target.tagName === "TD") {
        // Obtém os dados da linha clicada
        var rowData = getRowPewag(event.target.closest("tr"));


        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputRefProd").value = rowData.refPewag;
        document.getElementById("inputValorUnit").value = rowData.ValorVenda;
        document.getElementById("inputNcm").value = rowData.ncm;
        document.getElementById("inputIpi").value = rowData.ipi;
        document.getElementById("inputTipo").value = rowData.tipo;
        document.getElementById("inputTamanho").value = rowData.comprimento;
        document.getElementById("inputDescProd").value = rowData.descProd;

        document.getElementById("inputRefProd1").value = rowData.refPewag;
        document.getElementById("inputValorUnit1").value = Math.ceil(rowData.ValorCusto * 1.55 * 1.14 * rowData.ipi);
        document.getElementById("inputTipo1").value = rowData.tipo;
    }
});

// Adicione um evento de clique às linhas da tabela dentro do modal
document.addEventListener("DOMContentLoaded", function () {
    var tableRows = document.querySelectorAll("#table-body-pewag .table-row");
    var inputQtde = document.getElementById("inputQtde");
    var inputValorUnit = document.getElementById("inputValorUnit");
    var inputTotalItem = document.getElementById("inputTotalItem");
    

    // Função para calcular o valor total
    function calcularTotal() {
        var quantidade = parseFloat(inputQtde.value) || 0;
        var valorUnitario = parseFloat(inputValorUnit.value) || 0;

        var totalItem = Math.ceil(quantidade * valorUnitario);
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

            var refProd = row.cells[1].textContent;
            var ValorVenda = row.cells[8].textContent;
            var ncm = row.cells[3].textContent;
            var ipi = row.cells[4].textContent;
            var tipo = row.cells[5].textContent;
            var comprimento = row.cells[6].textContent;
            var descProd = row.cells[2].textContent;

            // Obtém os dados da linha clicada e preenche os campos de input
            var refPewag1 = row.cells[1].textContent;
            var ValorVenda1 = row.cells[6].textContent;
            var tipo1 = row.cells[4].textContent;

            document.getElementById("inputRefProd").value = refProd;
            document.getElementById("inputValorUnit").value = formatarMoeda(ValorVenda);
            document.getElementById("inputNcm").value = ncm;
            document.getElementById("inputTipo").value = tipo;
            document.getElementById("inputIpi").value = ipi;
            document.getElementById("inputTamanho").value = comprimento;
            document.getElementById("inputDescProd").value = descProd;

            document.getElementById("inputRefProd1").value = refPewag1;
            document.getElementById("inputValorUnit1").value = formatarDecimal(ValorVenda1);
            document.getElementById("inputTipo1").value = tipo1;

            calcularTotal();
        });
    });

    // Adicione evento ao campo de quantidade
    inputQtde.addEventListener("input", calcularTotal);
});

// Função para obter os dados da linha clicada na tabela Pewag
function getRowPewag(row) {
    return {
        codigo: row.cells[0].textContent,
        refPewag: row.cells[1].textContent,
        descProd: row.cells[2].textContent,
        ncm: row.cells[3].textContent,
        ipi: row.cells[4].textContent,
        tipo: row.cells[5].textContent,
        comprimento: row.cells[6].textContent,
        ValorCusto: row.cells[7].textContent,
        ValorVenda: row.cells[8].textContent
        
    };
}

// Adicionar evento de escuta para o elemento <select>
document.addEventListener("DOMContentLoaded", function () {

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

// Função para formatar um número em moeda (R$)
function formatarMoeda(valor) {
    return new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(valor);
}

// Função para limpar todas as tabelas
function limparTodasTabelas() {
    var tables = document.getElementsByClassName("datatablesSimple");
    for (var i = 0; i < tables.length; i++) {
        tables[i].style.display = "none";
        tables[i].getElementsByTagName("tbody")[0].innerHTML = "";
    }
}