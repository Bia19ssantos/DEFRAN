/* global simpleDatatables, Intl */

var produtosPewag = [];
// Função para fazer a solicitação AJAX PEWAG
function getProdPewag() {
    var filtro = document.getElementById("filtro").value;

    fetch("ProdPewagServlet")
            .then(response => {
                if (!response.ok) {
                    throw new Error("Erro ao obter os dados do servidor.");
                }
                return response.json();
            })
            .then(data => {
                produtosPewag = data;
                carregarTabelaProdutoPewag(filtro);
            })
            .catch(error => console.error(error));
}

// Função para carregar a tabela de ProdPewagServlet
function carregarTabelaProdutoPewag(filtro) {
    var tableBody = document.getElementById("table-body-pewag");
    tableBody.innerHTML = "";

    produtosPewag.forEach(prodPewag => {
        const containsFilter = (str) => str.toLowerCase().includes(filtro.toLowerCase());
        if (filtro === "" || containsFilter(prodPewag.refPewag) || containsFilter(prodPewag.refGunnebo)) {
            var row = tableBody.insertRow();
            row.classList.add("selected-row");

            row.insertCell().textContent = prodPewag.codigo;
            row.insertCell().textContent = prodPewag.refPewag;
            row.insertCell().textContent = prodPewag.refGunnebo;
            row.insertCell().textContent = prodPewag.descProd;
            row.insertCell().textContent = prodPewag.ncm;
            row.insertCell().textContent = prodPewag.icms;
            row.insertCell().textContent = prodPewag.ipi;
            row.insertCell().textContent = prodPewag.tipo;
            row.insertCell().textContent = prodPewag.comprimento;
            row.insertCell().textContent = formatarDecimal(prodPewag.valorCusto);
            row.insertCell().textContent = formatarDecimal(prodPewag.valorVenda);
        }
    });

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
        document.getElementById("inputCodigo").value = rowData.codigo;
        document.getElementById("inputRefGun").value = rowData.refGunnebo;
        document.getElementById("inputRefPewag").value = rowData.refPewag;
        document.getElementById("inputDesc").value = rowData.descProd;
        document.getElementById("inputNcm").value = rowData.ncm;
        document.getElementById("inputICMS").value = rowData.icms;
        document.getElementById("inputIPI").value = rowData.ipi;
        document.getElementById("inputTipo").value = rowData.tipo;
        document.getElementById("inputCompr").value = rowData.comprimento;
        document.getElementById("inputCusto").value = rowData.ValorCusto;
        document.getElementById("inputVenda").value = rowData.ValorVenda;

    }
});

// Adicione um evento de clique às linhas da tabela dentro do modal
document.addEventListener("DOMContentLoaded", function () {
    var tableRows = document.querySelectorAll("#table-body-pewag .table-row");


    tableRows.forEach(row => {
        row.addEventListener("click", function () {
            // Remove classe de todas as linhas para desmarcar a anterior
            tableRows.forEach(row => {
                row.classList.remove("selected-row");
            });

            // Adiciona classe à linha clicada para destacá-la
            row.classList.add("selected-row");

            var codigo = row.cells[0].textContent;
            var refPewag = row.cells[1].textContent;
            var refGun = row.cells[2].textContent;
            var descProd = row.cells[3].textContent;
            var ncm = row.cells[4].textContent;
            var ipi = row.cells[5].textContent;
            var icms = row.cells[6].textContent;
            var tipo = row.cells[7].textContent;
            var comprimento = row.cells[8].textContent;
            var ValorCusto = row.cells[9].textContent;
            var ValorVenda = row.cells[10].textContent;

            document.getElementById("inputCodigo").value = codigo;
            document.getElementById("inputRefPewag").value = refPewag;
            document.getElementById("inputRefGun").value = refGun;
            document.getElementById("inputDesc").value = descProd;
            document.getElementById("inputNcm").value = ncm;
            document.getElementById("inputICMS").value = icms;
            document.getElementById("inputIPI").value = ipi;
            document.getElementById("inputTipo").value = tipo;
            document.getElementById("inputCompr").value = comprimento;
            document.getElementById("inputCusto").value = formatarMoeda(ValorCusto);
            document.getElementById("inputVenda").value = formatarMoeda(ValorVenda);

        });
    });


});

// Função para obter os dados da linha clicada na tabela Pewag
function getRowPewag(row) {
    return {
        codigo: row.cells[0].textContent,
        refPewag: row.cells[1].textContent,
        refGunnebo: row.cells[2].textContent,
        descProd: row.cells[3].textContent,
        ncm: row.cells[4].textContent,
        icms: row.cells[5].textContent,
        ipi: row.cells[6].textContent,
        tipo: row.cells[7].textContent,
        comprimento: row.cells[8].textContent,
        ValorCusto: row.cells[9].textContent,
        ValorVenda: row.cells[10].textContent

    };
}

// Iniciar a tabela de dados 
const datatablesSimple = document.getElementById('datatablesSimple');
if (datatablesSimple) {
    new simpleDatatables.DataTable(datatablesSimple);
}

// Função para formatar um número em moeda (R$)
function formatarMoeda(valor) {
    return new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(valor);
}

function limparTodasTabelas() {
    var tables = document.getElementsByClassName("datatablesSimple");
    for (const table of tables) {
        table.style.display = "none";
        table.querySelector("tbody").innerHTML = "";
    }
}
document.addEventListener("DOMContentLoaded", function () {


    var inputFiltro = document.getElementById("filtro");

    // Chamar a função para obter os dados dos produtos e preencher a tabela inicialmente
    getProdPewag();

    // Evento de escuta para o campo de filtro
    inputFiltro.addEventListener("keyup", function () {
        getProdPewag(); // Chamar a função novamente com o novo valor do filtro
    });

    var btnEnviar = document.getElementById("btnEnviar");
    btnEnviar.addEventListener("click", function (event) {
        event.preventDefault(); // Evitar o comportamento padrão do botão submit

        // Obtenha os dados do formulário
        var formData = new FormData(document.getElementById('formProdutos'));
        var xhr = new XMLHttpRequest();
        xhr.open('POST', 'AtualizarProdutoServlet', true);
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.onload = function () {
            if (xhr.status === 200) {
                console.log("Dados enviados com sucesso para o servlet.");

                // Exibir o modal de sucesso
                var modalSave = new bootstrap.Modal(document.getElementById('modalSave'), {backdrop: 'static', keyboard: false});
                modalSave.show();

                // Aguardar um pouco antes de redirecionar (opcional)
                setTimeout(function () {
                    // Redirecionar para a página clientes.html
                    window.location.href = "cadastro_produtos.html";
                }, 2000); // Aguardar 2 segundos antes de redirecionar
            } else {
                console.error("Erro ao enviar dados para o servlet. Status: " + xhr.status);
            }
        };
        xhr.onerror = function () {
            console.error("Erro de rede ao enviar dados para o servlet.");
        };
        // Envie os dados do formulário
        try {
            xhr.send(new URLSearchParams(formData));
        } catch (error) {
            console.error("Erro ao enviar dados para o servlet. Detalhes:", error);
        }
    });

// Associar a função de exclusão ao botão de exclusão
    document.getElementById("btnExcluir").addEventListener("click", function () {
        // Exibir modal de confirmação antes de excluir
        $("#confirmacaoExclusaoModal").modal("show");
    });

function excluirProduto() {
    var codigo = document.getElementById("inputCodigo").value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ExcluirProdutoServlet", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var response = JSON.parse(xhr.responseText);
                    if (response.success) {
                        // Exibir modal de sucesso
                        $("#sucessoExclusaoModal").modal("show");

                        // Aguardar um pouco antes de redirecionar (opcional)
                        setTimeout(function () {
                            // Redirecionar para a página clientes.html
                            window.location.href = "cadastro_produtos.html";
                        }, 2000); // Aguardar 2 segundos antes de redirecionar
                    } else {
                        alert("Erro ao excluir o produto: " + response.error);
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                }
            } else {
                console.error("Erro ao excluir o produto. Status:", xhr.status);
                console.error("Resposta do servidor:", xhr.responseText);
            }
        }
    };
    console.log("Codigo do Produto: " + codigo);
    xhr.send("inputCodigo=" + encodeURIComponent(codigo));
}

// Associar a função de exclusão ao botão de confirmação de exclusão no modal
    document.getElementById("btnConfirmarExclusao").addEventListener("click", function () {
        excluirProduto();
        // Fechar o modal após a confirmação
        $("#confirmacaoExclusaoModal").modal("hide");
    });
});
