/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// Função para fazer a solicitação AJAX - Orcamentos
function getOrcamentos() {
    var numOrc = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "OrcamentosServlet?numOrc=" + numOrc, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var orcamento = JSON.parse(xhr.responseText);
                    carregarDados(orcamento, numOrc);
                    // Chamar getItensOrcamento apenas se houver dados do orçamento
                    if (orcamento && orcamento.length > 0) {
                        getItensOrcamento(numOrc);
                        getItensLinga(numOrc);
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                }
            } else {
                console.error("Erro ao obter os dados do servidor. Status:", xhr.status);
            }
        }
    };
    xhr.send();
}

// Função para preencher os inputs do formulário com os dados do orçamento
function carregarDados(orcamento) {
    if (orcamento && orcamento.length > 0) { // Verifique se há dados no array
        var dadosOrcamento = orcamento[0]; // Acesse o primeiro elemento do array
        document.getElementById("inputCliente").value = dadosOrcamento.cliente;
        document.getElementById("inputDataOrc").value = dadosOrcamento.dataOrc;
        document.getElementById("inputVendedor").value = dadosOrcamento.vendedor;
        document.getElementById("inputPagamento").value = dadosOrcamento.condicaoPgto;
        document.getElementById("inputTransporte").value = dadosOrcamento.condicaoTransporte;
    } else {
        // Limpar os inputs se não houver orçamento encontrado
        document.getElementById("inputCliente").value = "";
        document.getElementById("inputDataOrc").value = "";
        document.getElementById("inputVendedor").value = "";
        document.getElementById("inputPagamento").value = "";
        document.getElementById("inputTransporte").value = "";
    }

    // Adicione o botão Excluir
    var btnExcluir = document.createElement("btnExcluir");
    btnExcluir.className = "btn btn-danger btn-sm";
    btnExcluir.textContent = "Excluir";
    btnExcluir.setAttribute("data-toggle", "modal");
    btnExcluir.setAttribute("data-target", "#confirmacaoExclusaoModal");
    btnExcluir.onclick = function () {
        // Armazenar o número do orçamento no botão de confirmação de exclusão
        document.getElementById("btnConfirmarExclusao").setAttribute("data-num-orcamento", orcamento.numOrc);
    };
}

// Adicione isso ao seu código JavaScript
document.getElementById("btnConfirmarExclusao").addEventListener("click", function () {

    // Chamar o servlet de exclusão
    excluirOrcamento();
    // Fechar o modal após a exclusão
    $("#confirmacaoExclusaoModal").modal("hide");
});


// Função para excluir um orçamento
function excluirOrcamento() {
    // Fazer uma solicitação AJAX para o servlet ExcluirOrcamentoServlet
    var numOrc = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ExcluirOrcamentoServlet", true);
    xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var response = JSON.parse(xhr.responseText);
                    if (response.success) {
                        // Fechar o modal após a exclusão
                        $("#confirmacaoExclusaoModal").modal("hide");

                        // Exibir modal de sucesso
                        $("#sucessoExclusaoModal").modal("show");

                        // Aguardar um pouco antes de redirecionar (opcional)
                        setTimeout(function () {
                            // Redirecionar para a página orcamentos.html
                            window.location.href = "orcamentos.html";
                        }, 2000); // Aguardar 2 segundos (2000 milissegundos) antes de redirecionar
                    } else {
                        alert("Erro ao excluir o orçamento: " + response.error);
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                }
            } else {
                console.error("Erro ao excluir o orçamento. Status:", xhr.status);
                console.error("Resposta do servidor:", xhr.responseText); // Adicione esta linha para imprimir a resposta do servidor no console
            }
        }
    };
    // Enviar o número do orçamento como parâmetro
    xhr.send("numOrc=" + numOrc);
}


// Função para fazer a solicitação AJAX dos itens do orçamento
function getItensOrcamento() {
    var numOrc = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ItensServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var itensOrcamentos = JSON.parse(xhr.responseText);
                carregarItens(itensOrcamentos, numOrc);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos itens do orçamento
function carregarItens(itensOrcamentos, numOrc) {
    var tableBody1 = document.getElementById("table-itens");

    // Limpar a tabela antes de popular novamente
    tableBody1.innerHTML = "";

    itensOrcamentos.forEach(itensOrcamento => {
        // Verificar se o filtro está vazio ou se o número do orçamento contém o texto do filtro
        if (numOrc === "" || itensOrcamento.numOrc.toString().includes(numOrc)) {
            var row = tableBody1.insertRow();
            row.insertCell().textContent = formatarInteiro(itensOrcamento.numOrc);
            row.insertCell().textContent = formatarInteiro(itensOrcamento.item);
            row.insertCell().textContent = itensOrcamento.refProd;
            row.insertCell().textContent = formatarDecimal(itensOrcamento.qtde);
            row.insertCell().textContent = formatarDecimal(itensOrcamento.valorUnit);
            row.insertCell().textContent = formatarDecimal(itensOrcamento.totalItem);
            row.insertCell().textContent = itensOrcamento.prazoEntrega;
        }
    });
}


//Tabela dos itens da Linga
// Função para fazer a solicitação AJAX dos itens do orçamento
function getItensLinga() {
    var numOrc = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ItensLingasServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var orcLingas = JSON.parse(xhr.responseText);
                carregarItensLingas(orcLingas, numOrc);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos itens do orçamento
function carregarItensLingas(orcLingas, numOrc) {
    var tableBody = document.getElementById("table-linga");

    // Limpar a tabela antes de popular novamente
    tableBody.innerHTML = "";

    orcLingas.forEach(orcLingas => {
        // Verificar se o filtro está vazio ou se o número do orçamento contém o texto do filtro
        if (numOrc === "" || orcLingas.numOrc.toString().includes(numOrc)) {
            var row = tableBody.insertRow();

            row.insertCell().textContent = orcLingas.modeloLinga;
            row.insertCell().textContent = orcLingas.refAcessorio;
            row.insertCell().textContent = formatarDecimal(orcLingas.qtdeAcessorio);
            row.insertCell().textContent = formatarDecimal(orcLingas.valorAcessorio);
            row.insertCell().textContent = formatarDecimal(orcLingas.totalAcessorio);
            row.insertCell().textContent = formatarInteiro(orcLingas.qtdeElos);
            row.insertCell().textContent = formatarDecimal(orcLingas.qtdeMetros);
        }
    });
}


// Evento de escuta para o campo de filtro
document.getElementById("filtro").addEventListener("keyup", function () {

    var numOrc = document.getElementById("filtro").value;
    // Verificar se o número do orçamento tem um comprimento mínimo
    if (numOrc.length >= 4) {

        getItensOrcamento(); // Chamar a função novamente com o novo valor do filtro
        getOrcamentos();
        getItensLinga();
        // Iniciar a tabela de dados
        const datatablesSimple = document.getElementById('datatablesSimple');
        if (datatablesSimple) {
            new simpleDatatables.DataTable(datatablesSimple);
        }
    }
});
// Função para formatar um valor no formato "R$ 00000,00"
function formatarValor(valor) {
    var valorFormatado = valor.toLocaleString("pt-BR", {
        style: "currency",
        currency: "BRL"
    });
    return valorFormatado;
}

function formatarDecimal(valor) {
    return parseFloat(valor).toFixed(2);
}

function formatarInteiro(valor) {
    return parseInt(valor, 10); // O segundo argumento (10) especifica a base numérica (decimal).
}