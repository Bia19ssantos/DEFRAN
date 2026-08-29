document.addEventListener("DOMContentLoaded", function () {
    var tabelaBody = document.getElementById("table-body");
    var tableData = [];
    var proximoItem = 1;
    function adicionarLinha(item, referencia, descricao, ncm, tipo, quantidade, valorUnitario, totalItem, prazoEntrega, rowIndex) {


        var novaLinha = tabelaBody.insertRow();
        novaLinha.innerHTML = `
        <td>${item}</td>
        <td>${referencia}</td>
        <td>${descricao}</td>
        <td>${ncm}</td>
        <td>${tipo}</td>
        <td>${quantidade}</td>
        <td>${valorUnitario}</td>
        <td>${totalItem}</td>
        <td>${prazoEntrega}</td>
        <td>
            <button type="button" class="btnExcluir" id="btnExcluir">
                <img src="assets/icons/excluir.ico" alt="excluir" width="10" height="10">
                
            </button>
        </td>`;
        var rowData = {
            item: proximoItem,
            refProd: referencia,
            descProd: descricao,
            ncm: ncm,
            tipo: tipo,
            qtde: quantidade,
            valorUnit: valorUnitario,
            totalItem: totalItem,
            prazoEntrega: prazoEntrega,
            rowIndex: rowIndex
        };
        var btnRemover = novaLinha.querySelector(".btnExcluir");
        btnRemover.addEventListener("click", function () {
            if (confirm("Tem certeza de que deseja remover esta linha?")) {
                tabelaBody.deleteRow(rowIndex);
                tableData.splice(rowIndex, 1);
                atualizarIndicesLinhas();
                calcularEExibirValorTotal();
                excluirOrcamento();
                proximoItem++;
            }
        });
        tableData.push(rowData);
        calcularEExibirValorTotal();
    }

// Função para excluir um orçamento
    function excluirOrcamento() {
// Fazer uma solicitação AJAX para o servlet ExcluirOrcamentoServlet
        var numOrc = document.getElementById("inputNumOrc").value;
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "ExcluirOrcamentoServlet", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    try {
                        var response = JSON.parse(xhr.responseText);
                        if (response.success) {
                            confirm("Linha removida com sucesso!");
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

    function limparCamposEntrada() {
        var camposEntrada = document.querySelectorAll(
                "#inputRefProd, #inputDescProd, #inputNcm, #inputTipo, #inputQtde, #inputValorUnit, #inputTotalItem"
                );
        camposEntrada.forEach(function (campo) {
            campo.value = "";
        });
    }

    function formatarDecimal(valor) {
        return parseFloat(valor).toFixed(2);
    }

    function calcularEExibirValorTotal() {
        var total = 0;
        for (var i = 0; i < tableData.length; i++) {
            var rowData = tableData[i];
            total += parseFloat(rowData.totalItem);
        }
        var totalOrc = document.getElementById("inputTotalOrc");
        totalOrc.value = formatarDecimal(total);
    }

    function atualizarIndicesLinhas() {
        for (var i = 0; i < tableData.length; i++) {
            tableData[i].rowIndex = i;
        }
    }

// Adicione um evento de clique ao overlay do modal
    document.getElementById('modalValidacao').addEventListener('click', function (event) {
        if (event.target === this) {
            fecharModal(); // Chame a função para fechar o modal
        }
    });
// Adicione um evento de clique ao botão "OK"
    document.getElementById('btnFechar').addEventListener('click', function () {
        fecharModal(); // Chame a função para fechar o modal
    });
// Função para fechar o modal
    function fecharModal() {
        document.getElementById('modalValidacao').style.display = 'none';
    }

// Função para verificar se os campos estão vazios
    function validarCampos() {
        const campos = ['inputRefProd', 'inputDescProd', 'inputNcm', 'inputTipo', 'inputQtde', 'inputValorUnit', 'inputTotalItem', 'inputPrazoEntrega', 'inputDataOrc', 'inputCliente', 'inputVendedor', 'inputNumOrc'];
        for (const campo of campos) {
            const valorCampo = document.getElementById(campo).value.trim();
            if (valorCampo === '') {
//alert("Preencha todos os campos corretamente.");
                document.getElementById('modalValidacao').style.display = 'block';
                return;
            }
        }

// Todos os campos estão preenchidos, retorna true
        return true;
    }

    var btnAdicionar = document.getElementById("btnAdicionar");
    btnAdicionar.addEventListener("click", function () {

        // Execute a validação antes de adicionar o novo item
        if (validarCampos()) {

            var item = parseInt(document.getElementById("inputItem").value);
            var referencia = document.getElementById("inputRefProd").value;
            var descricao = document.getElementById("inputDescProd").value;
            var ncm = document.getElementById("inputNcm").value;
            var tipo = document.getElementById("inputTipo").value;
            var quantidade = document.getElementById("inputQtde").value;
            var valorUnitario = document.getElementById("inputValorUnit").value;
            var totalItem = document.getElementById("inputTotalItem").value;
            var prazoEntrega = document.getElementById("inputPrazoEntrega").value;
            adicionarLinha(item, referencia, descricao, ncm, tipo, quantidade, valorUnitario, totalItem, prazoEntrega, tableData.length);
            document.getElementById("btnEnviar").click();
        }
    });
    var btnEnviar = document.getElementById("btnEnviar");
    btnEnviar.addEventListener("click", function (event) {
        event.preventDefault(); // Evitar o comportamento padrão do botão submit

        // Execute a validação antes de adicionar o novo item
        if (validarCampos()) {
            // Obtenha os dados do formulário
            var formData = new FormData(document.getElementById('formOrc'));
            // Faça uma solicitação AJAX para o servlet
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'OrcSalvarServlet', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
            xhr.onload = function () {
                if (xhr.status === 200) {
                    console.log("Dados enviados com sucesso para o servlet.");
                    // Limpeza dos campos
                    limparCamposEntrada();
                    // Atualização do número do item
                    proximoItem++;
                    document.getElementById("inputItem").value = proximoItem;
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
        }
    });
    //modal lingas
    // Seleciona o botão que abrirá o modalProdutos
    var btnBuscaProdutos = document.getElementById('btnBuscaProdutos');
    // Seleciona o modalProdutos
    var modalProdutos = document.getElementById('modalProdutos');
    // Adiciona um evento de clique ao botão
    btnBuscaProdutos.addEventListener('click', function () {
        // Abre o modalProdutos
        var modal = new bootstrap.Modal(modalProdutos);
        modal.show();
    });
    var btnOK = document.getElementById("btnOK");
    // Adiciona um ouvinte de clique ao botão
    btnOK.addEventListener("click", function () {
        // Redireciona para a página "cadastro_orcamentos.html"
        $('#modalLingas').modal('hide');
    });


    //verificar se existe orçamento

    var inputNumOrc = document.getElementById("inputNumOrc");

    inputNumOrc.addEventListener("blur", function () {
        var numOrc = inputNumOrc.value.trim();

        // Verifica se o número do orçamento está preenchido
        if (numOrc !== "") {
            // Faz uma solicitação AJAX para verificar se o número do orçamento já existe
            var xhr = new XMLHttpRequest();
            xhr.open("POST", "NumOrcExisteServlet", true);
            xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

            xhr.onreadystatechange = function () {
                if (xhr.readyState === XMLHttpRequest.DONE) {
                    if (xhr.status === 200) {
                        try {
                            var response = JSON.parse(xhr.responseText);
                            if (response.existe) {
                                $('#modalAtencao').modal('show');

                                // Aguardar um pouco antes de fechar o modal (opcional)
                                setTimeout(function () {
                                    $('#modalAtencao').modal('hide');
                                }, 3000); // Aguardar 3 segundos antes de fechar o modal
                            }
                            // Se o número do orçamento não existir, você pode adicionar outras ações aqui se necessário
                        } catch (error) {
                            console.error("Erro ao processar resposta JSON:", error);
                        }
                    } else {
                        console.error("Erro ao verificar o número do orçamento. Status:", xhr.status);
                        console.error("Resposta do servidor:", xhr.responseText);
                    }
                }
            };

            // Envie o número do orçamento como parâmetro
            xhr.send("numOrc=" + numOrc);
        }
    });

});

