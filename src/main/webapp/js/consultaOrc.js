var orcamentoTimeout;

document.getElementById("inputNumOrc").addEventListener("input", function () {
    var numOrc = document.getElementById("inputNumOrc").value;

    if (numOrc.trim() !== "") {
        clearTimeout(orcamentoTimeout);
        orcamentoTimeout = setTimeout(getOrcamento, 500);
    }
});

// Adiciona evento de clique ao botão de pesquisa de itens
document.getElementById("btnNavbarSearchItens").addEventListener("click", function () {
    // Chama a função para consultar e preencher os inputs dos itens
    obterDadosItem();
});


// Função para obter e preencher os dados dos itens
function obterDadosItem() {
    var numOrc = document.getElementById("inputNumOrc").value;
    console.log("NumOrc digitado:", numOrc);

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ConsultaOrcServlet?numOrc=" + numOrc, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var response = JSON.parse(xhr.responseText);
                    console.log("Resposta JSON:", response);

                    // Verificar se há dados de orçamento
                    if (response.orcamento && !response.orcamento.error) {
                        var orcamento = response.orcamento[0];
                        console.log("NumOrc do Orcamento:", orcamento.numOrc);

                        // Verificar se o número do orçamento corresponde ao digitado
                        if (orcamento.numOrc === numOrc) {
                            document.getElementById("inputCliente").value = orcamento.cliente;
                            document.getElementById("inputTotalPedido").value = orcamento.totalOrc;

                            // Verificar se há itens e preencher os campos de input dos itens
                            if (response.itensOrcamento && response.itensOrcamento.length > 0) {
                                var numItem = document.getElementById("inputItem").value;
                                atualizarCamposItens(response.itensOrcamento, numItem);
                            } else {
                                // Limpar os campos de input dos itens se não houver itens correspondentes
                                limparCamposItens();
                            }
                        } else {
                            console.log("NumOrc do Orcamento não corresponde ao digitado.");
                            
                            // Limpar os campos se o número do orçamento não corresponder
                            limparCampos();
                            limparCamposItens();
                        }
                    } else {
                        console.log("Sem dados de orçamento.");
                        
                        // Limpar os campos se não houver dados de orçamento
                        limparCampos();
                        limparCamposItens();
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                    // Limpar os campos em caso de erro
                    limparCampos();
                    limparCamposItens();
                }
            } else {
                console.error("Erro ao obter os dados do servidor. Status:", xhr.status);
                // Limpar os campos em caso de erro
                limparCampos();
                limparCamposItens();
            }
        }
    };
    xhr.send();
}


// Função para consultar o orçamento no servlet
function getOrcamento() {
    var numOrc = document.getElementById("inputNumOrc").value;
    console.log("NumOrc digitado:", numOrc);

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ConsultaOrcServlet?numOrc=" + numOrc, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                try {
                    var response = JSON.parse(xhr.responseText);
                    console.log("Resposta JSON:", response);

                    // Verificar se há dados de orçamento
                    if (response.orcamento && !response.orcamento.error) {
                        var orcamento = response.orcamento[0];
                        console.log("NumOrc do Orcamento:", orcamento.numOrc);

                        // Verificar se o número do orçamento corresponde ao digitado
                        if (orcamento.numOrc == numOrc) {
                            document.getElementById("inputCliente").value = orcamento.cliente;
                            document.getElementById("inputTotalPedido").value = orcamento.totalOrc;

                            // Verificar se há itens e preencher os campos de input dos itens
                            if (response.itensOrcamento && response.itensOrcamento.length > 0) {
                                var numItem = document.getElementById("inputItem").value;
                                atualizarCamposItens(response.itensOrcamento, numItem);
                            } else {
                                // Limpar os campos de input dos itens se não houver itens correspondentes
                                limparCamposItens();
                            }
                        } else {
                            console.log("NumOrc do Orcamento não corresponde ao digitado.");
                           
                            limparCampos();
                            limparCamposItens();
                        }
                    } else {
                        console.log("Sem dados de orçamento.");
                        
                        // Limpar os campos se não houver dados de orçamento
                        limparCampos();
                        limparCamposItens();
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                    // Limpar os campos em caso de erro
                    limparCampos();
                    limparCamposItens();
                }
            } else {
                console.error("Erro ao obter os dados do servidor. Status:", xhr.status);
                // Limpar os campos em caso de erro
                limparCampos();
                limparCamposItens();
            }
        }
    };
    xhr.send();
}

// Função para atualizar os campos de input dos itens
function atualizarCamposItens(itens, numItem) {
    var itemCorrespondente = itens.find(function (item) {
        return item.item == numItem;
    });

    // Preencher os campos de input dos itens se houver correspondência
    if (itemCorrespondente) {
        document.getElementById("inputRefItem").value = itemCorrespondente.refProd;
        document.getElementById("inputTipo").value = itemCorrespondente.tipo;
        document.getElementById("inputNcm").value = itemCorrespondente.ncm;
        document.getElementById("inputQtde").value = itemCorrespondente.qtde;
        document.getElementById("inputValorUnit").value = itemCorrespondente.valorUnit;
        document.getElementById("inputTotalItem").value = itemCorrespondente.totalItem;
    } else {
        // Limpar os campos de input dos itens
        limparCamposItens();

        // Mostrar o modal quando o número do item não existir
        $('#modalNaoTem').modal('show');
    }
}

// Função para limpar os campos de input do orçamento
function limparCampos() {
    console.log("Limpando campos do orçamento.");
    document.getElementById("inputCliente").value = "";
    document.getElementById("inputTotalPedido").value = "";
}

// Função para limpar os campos de input dos itens
function limparCamposItens() {
    console.log("Limpando campos dos itens.");
    document.getElementById("inputItem").value = "";
    document.getElementById("inputRefItem").value = "";
    document.getElementById("inputTipo").value = "";
    document.getElementById("inputNcm").value = "";
    document.getElementById("inputQtde").value = "";
    document.getElementById("inputValorUnit").value = "";
    document.getElementById("inputTotalItem").value = "";
}
