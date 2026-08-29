
//Consultar as Vendas
function getVendas() {
    var numPedido = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "VendasServlet?numPedido=" + numPedido, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var vendas = JSON.parse(xhr.responseText);
                    carregarDados(vendas, numPedido);
                    // Chamar getItensPedido apenas se houver dados do Pedido
                    if (vendas && vendas.length > 0) {
                        getItensPedido(numPedido);
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

//Função para preencher os inputs do formulário
function carregarDados(vendas) {
    if (vendas && vendas.length > 0) { // Verifique se há dados no array
        var dadosPedido = vendas[0]; // Acesse o primeiro elemento do array
        document.getElementById("inputCliente").value = dadosPedido.cliente;
        document.getElementById("inputNF").value = dadosPedido.numNF;
        document.getElementById("inputNumOrc").value = dadosPedido.numOrc;
        document.getElementById("inputTotalPedido").value = formatarValor(dadosPedido.totalPedido);

        // Formatando a data do pedido
        var dataPedido = new Date(dadosPedido.dataPedido);
        var dataPedidoFormatada = dataPedido.toLocaleDateString('pt-BR');
        document.getElementById("inputDataPedido").value = dataPedidoFormatada;

        // Formatando a data da NF
        var dataNF = new Date(dadosPedido.dataNF);
        var dataNFFormatada = dataNF.toLocaleDateString('pt-BR');
        document.getElementById("inputDataNF").value = dataNFFormatada;

    } else {
        // Limpar os inputs se não houver orçamento encontrado
        document.getElementById("inputCliente").value = "";
        document.getElementById("inputDataPedido").value = "";
        document.getElementById("inputNumOrc").value = "";
        document.getElementById("inputDataNF").value = "";
        document.getElementById("inputNF").value = "";
        document.getElementById("inputTotalPedido").value = "";
    }

    // Adicione o botão Excluir
    var btnExcluir = document.createElement("btnExcluir");
    btnExcluir.className = "btn btn-danger btn-sm";
    btnExcluir.textContent = "Excluir";
    btnExcluir.setAttribute("data-toggle", "modal");
    btnExcluir.setAttribute("data-target", "#confirmacaoExclusaoModal");
    btnExcluir.onclick = function () {
        // Armazenar o número do orçamento no botão de confirmação de exclusão
        document.getElementById("btnConfirmarExclusao").setAttribute("data-num-pedido", vendas.numPedido);
    };
}

// Adicione isso ao seu código JavaScript
document.getElementById("btnConfirmarExclusao").addEventListener("click", function () {

    // Chamar o servlet de exclusão
    excluirPedido();
    // Fechar o modal após a exclusão
    $("#confirmacaoExclusaoModal").modal("hide");
});

// Função para excluir um Pedido
function excluirPedido() {
    var numPedido = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ExcluirVendasServlet", true);
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
                        $("#sucessoExcluirModal").modal("show");

                        // Aguardar um pouco antes de redirecionar (opcional)
                        setTimeout(function () {
                            // Redirecionar para a página vendas.html
                            window.location.href = "vendas.html";
                        }, 1500); // Aguardar 1,5 segundos (1500 milissegundos) 

                    } else {
                        console.error("Erro ao excluir o Pedido: " + response.error);
                        alert("Erro ao excluir o Pedido: " + response.error);
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                }
            } else {
                console.error("Erro ao excluir o Pedido. Status:", xhr.status);
                console.error("Resposta do servidor:", xhr.responseText); // Adicione esta linha para imprimir a resposta do servidor no console
                alert("Erro ao excluir o Pedido. Status: " + xhr.status);
            }
        }
    };

    // Enviar o número do pedido como parâmetro
    xhr.send("numPedido=" + numPedido);
}

// Função para fazer a solicitação AJAX dos itens do orçamento
function getItensPedido() {
    var numPedido = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ItensPedidoServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var itensPedido = JSON.parse(xhr.responseText);
                carregarItens(itensPedido, numPedido);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para preencher a tabela com os dados dos itens do orçamento
function carregarItens(itensPedido, numPedido) {
    var tableBody1 = document.getElementById("table-pedido");

    // Limpar a tabela antes de popular novamente
    tableBody1.innerHTML = "";

    itensPedido.forEach(itensPedido => {
        // Verificar se o filtro está vazio ou se o número do orçamento contém o texto do filtro
        if (numPedido === "" || itensPedido.numPedido.toString().includes(numPedido)) {
            var row = tableBody1.insertRow();
            row.insertCell().textContent = formatarInteiro(itensPedido.numPedido);
            row.insertCell().textContent = formatarInteiro(itensPedido.item);
            row.insertCell().textContent = itensPedido.refItem;
            row.insertCell().textContent = itensPedido.tipo;
            row.insertCell().textContent = formatarDecimal(itensPedido.qtdeItem);
            row.insertCell().textContent = formatarDecimal(itensPedido.valorUnit);
            row.insertCell().textContent = formatarDecimal(itensPedido.totalItem);
        }
    });
}

// Evento de escuta para o campo de filtro
document.getElementById("filtro").addEventListener("keyup", function () {
    getItensPedido(); // Chamar a função novamente com o novo valor do filtro
    getVendas();

    // Iniciar a tabela de dados
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
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