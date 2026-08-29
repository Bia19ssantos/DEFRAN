
// Função para fazer a solicitação AJAX de clientes
function getOrcs() {
    var filtro = document.getElementById("filtroOrcs").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "BuscaTodosOrcServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var orcamento = JSON.parse(xhr.responseText);
                    console.log(orcamento); // Verifique se os dados estão corretos
                    carregarTabelaOrcs(orcamento, filtro);
                } catch (error) {
                    console.error("Erro ao analisar JSON: " + error);
                }
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };

    xhr.send();
}

// Função para carregar a tabela de clientes
function carregarTabelaOrcs(orcamento, filtroOrcs) {
    var tableBody = document.getElementById("table-body-orcs");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    orcamento.forEach(orc => {
        if (orc.numOrc.toLowerCase().includes(filtroOrcs.toLowerCase())) {
            var row = tableBody.insertRow();
            row.setAttribute("data-id", orc); // Adicione o atributo data-id com o índice

            var cellRazao = row.insertCell();
            var cellCnpj = row.insertCell();
            var cellContato = row.insertCell();
            var cellTelefone = row.insertCell();
            var cellEmail = row.insertCell();

            cellRazao.textContent = orc.razao;
            cellCnpj.textContent = orc.cnpj;
            cellContato.textContent = orc.contato;
            cellTelefone.textContent = orc.telefone;
            cellEmail.textContent = orc.email;
        }
    });
}

// Evento de escuta para o campo de filtro
document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtroOrcs");

    // Chamar a função para obter os dados dos produtos e preencher a tabela inicialmente
    getOrcs();

    inputFiltro.addEventListener("keyup", function () {
        // Chamar a função novamente com o novo valor do filtro ao digitar
        getOrcs();
    });

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

//----------------------------------------TABELA CLIENTE MODAL-------------------------------------------------
// 
// Adicione um evento de clique à tabela do modal
document.querySelector("#table-clientes tbody").addEventListener("click", function (event) {
    // Verifica se o clique foi em uma linha da tabela
    if (event.target.tagName === "TD") {
        // Obtém os dados da linha clicada
        var rowData = getRowData(event.target.closest("tr"));


        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputCliente").value = rowData.razao;
        document.getElementById("inputCnpj").value = rowData.cnpj;
        document.getElementById("inputContato").value = rowData.contato;
        document.getElementById("inputNumOrc").value = ""; // Preencha conforme necessário
        document.getElementById("inputDataOrc").value = ""; // Preencha conforme necessário
        document.getElementById("inputTelefone").value = rowData.telefone;
        document.getElementById("inputEmail").value = rowData.email;

    }
});


document.addEventListener("DOMContentLoaded", function () {
    // Função para adicionar/remover a classe 'selected-row' quando a linha é clicada
    function toggleRowSelection(row) {
        // Adicione a classe apenas à linha clicada (selecionar)
        row.classList.add('selected-row');

        // Remova a classe de todas as outras linhas para desmarcar as anteriores
        var tableRows = document.querySelectorAll('.table-row');
        tableRows.forEach(function (otherRow) {
            if (otherRow !== row) {
                otherRow.classList.remove('selected-row');
            }
        });
    }

    // Adicione um evento de clique a todas as linhas da tabela com a classe 'table-row'
    var tableRows = document.querySelectorAll('.table-row');
    tableRows.forEach(function (row) {
        row.addEventListener('click', function () {
            toggleRowSelection(row);

            // Obtém os dados da linha clicada e preenche os campos de input
            var razao = row.cells[0].textContent;
            var cnpj = row.cells[1].textContent;
            var contato = row.cells[2].textContent;
            var telefone = row.cells[3].textContent;
            var email = row.cells[4].textContent;

            // Preenche os campos na página com os dados obtidos
            document.getElementById("inputCliente").value = razao;
            document.getElementById("inputCnpj").value = cnpj;
            document.getElementById("inputContato").value = contato;
            document.getElementById("inputNumOrc").value = ""; // Preencha conforme necessário
            document.getElementById("inputDataOrc").value = ""; // Preencha conforme necessário
            document.getElementById("inputTelefone").value = telefone;
            document.getElementById("inputEmail").value = email;

            // Fecha o modal ao clicar em um item da tabela
            $('#modalCliente').modal('hide');
        });
    });
});

// Remova a classe selected-row de todas as linhas na inicialização da página
document.querySelectorAll('.table-row').forEach(function (row) {
    row.classList.remove('selected-row');
});

// Função para obter os dados da linha clicada
function getRowData(row) {
    return {
        razao: row.cells[0].textContent,
        cnpj: row.cells[1].textContent,
        contato: row.cells[2].textContent,
        telefone: row.cells[3].textContent,
        email: row.cells[4].textContent
    };
}




