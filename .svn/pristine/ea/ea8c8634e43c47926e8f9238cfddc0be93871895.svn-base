/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Função para fazer a solicitação AJAX de clientes
function getModLingas() {
    var filtro = document.getElementById("filtroRefLingas").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ModLingasServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var modelosLingas = JSON.parse(xhr.responseText);
                    console.log(modelosLingas); // Verifique se os dados estão corretos
                    carregarTabelaModLingas(modelosLingas, filtro);
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
function carregarTabelaModLingas(modelosLingas, filtroRefLingas) {
    var tableBody = document.getElementById("table-body-lingas");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    modelosLingas.forEach(mod => {
        if (mod.refLinga.toLowerCase().includes(filtroRefLingas.toLowerCase())) {
            var row = tableBody.insertRow();
            row.setAttribute("data-id", mod); // Adicione o atributo data-id com o índice

            var cellId = row.insertCell();
            var cellCodigo = row.insertCell();
            var cellRefLinga = row.insertCell();
            var cellDescLinga = row.insertCell();

            cellId.textContent = mod.id;
            cellCodigo.textContent = mod.codigo;
            cellRefLinga.textContent = mod.refLinga;
            cellDescLinga.textContent = mod.descLinga;
        }
    });
}

// Evento de escuta para o campo de filtro
document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtroRefLingas");

    // Chamar a função para obter os dados dos produtos e preencher a tabela inicialmente
    getModLingas();

    inputFiltro.addEventListener("keyup", function () {
        // Chamar a função novamente com o novo valor do filtro ao digitar
        getModLingas();
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
document.querySelector("#table-lingas tbody").addEventListener("click", function (event) {
    
    if (event.target.tagName === "TD") {

        var rowData = getRowLinga(event.target.closest("tr"));

        // Preenche os campos na página com os dados obtidos
        document.getElementById("inputRefLinga").value = rowData.refLinga;
        document.getElementById("inputDescLinga").value = rowData.descLinga;
        
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
            var refLinga = row.cells[2].textContent;
            var descLinga = row.cells[3].textContent;

            // Preenche os campos na página com os dados obtidos
            document.getElementById("inputRefLinga").value = refLinga;
            document.getElementById("inputDescLinga").value = descLinga;
           

            // Fecha o modal ao clicar em um item da tabela
            $('#modalModLingas').modal('hide');
        });
    });
});

// Remova a classe selected-row de todas as linhas na inicialização da página
document.querySelectorAll('.table-row').forEach(function (row) {
    row.classList.remove('selected-row');
});

// Função para obter os dados da linha clicada
function getRowLinga(row) {
    return {
        id: row.cells[0].textContent,
        codigo: row.cells[1].textContent,
        refLinga: row.cells[2].textContent,
        descLinga: row.cells[3].textContent
    };
}

