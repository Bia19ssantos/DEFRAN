document.addEventListener("DOMContentLoaded", function () {
    var tabelaBody = document.getElementById("table-body");
    var tableData = [];
    var proximoItem = 1;

    var qtItemElement = document.getElementById("inputQtde");
    var valorUnitElement = document.getElementById("inputValorUnit");
    var totalItemElement = document.getElementById("inputTotalItem");

    valorUnitElement.addEventListener("input", calcularTotalItem);

    function calcularTotalItem() {
        var tItem = 0;

        var qtItem = parseFloat(qtItemElement.value);
        var valorUnit = parseFloat(valorUnitElement.value);

        tItem = qtItem * valorUnit;
        totalItemElement.value = formatarDecimal(tItem);
    }
    function adicionarLinha(item, referencia, ncm, tipo, quantidade, valorUnitario, totalItem, rowIndex) {


        var novaLinha = tabelaBody.insertRow();

        novaLinha.innerHTML = `
        <td>${item}</td>
        <td>${referencia}</td>
        <td>${ncm}</td>
        <td>${tipo}</td>
        <td>${quantidade}</td>
        <td>${valorUnitario}</td>
        <td>${totalItem}</td>
        <td>
          <button type="button" class="btnExcluir" id="btnExcluir">
                <img src="assets/icons/excluir.ico" alt="excluir" width="10" height="10">
            </button>
        </td>`;

        var rowData = {
            item: proximoItem,
            refItem: referencia,
            ncm: ncm,
            tipo: tipo,
            qtdeItem: quantidade,
            valorUnit: valorUnitario,
            totalItem: totalItem,
            rowIndex: rowIndex
        };

        var btnRemover = novaLinha.querySelector(".btnExcluir");
        btnRemover.addEventListener("click", function () {
            if (confirm("Tem certeza de que deseja remover esta linha?")) {
                tabelaBody.deleteRow(rowIndex);
                tableData.splice(rowIndex, 1);
                atualizarIndicesLinhas();
                calcularEExibirValorTotal();
                excluirPedido();
                proximoItem++;
            }
        });

        tableData.push(rowData);
        calcularEExibirValorTotal();
    }
    
    function excluirPedido() {
   
        var numPedido = document.getElementById("inputNumPedido").value;
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "ExcluirVendasServlet", true);
        xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    try {
                        var response = JSON.parse(xhr.responseText);
                        if (response.success) {
                            confirm("Linha removida com sucesso!");
                        } else {
                            alert("Erro ao excluir o pedido: " + response.error);
                        }
                    } catch (error) {
                        console.error("Erro ao processar resposta JSON:", error);
                    }
                } else {
                    console.error("Erro ao excluir o pedido. Status:", xhr.status);
                    console.error("Resposta do servidor:", xhr.responseText);
                }
            }
        };
        xhr.send("numPedido=" + numPedido);
    }

    function limparCamposEntrada() {
        var camposEntrada = document.querySelectorAll(
                "#inputRefItem, #inputQtde, #inputValorUnit, #inputTotalItem"
                );

        camposEntrada.forEach(function (campo) {
            campo.value = "";
        });
    }

    function calcularEExibirValorTotal() {
        var total = 0;

        for (var i = 0; i < tableData.length; i++) {
            var rowData = tableData[i];
            total += parseFloat(rowData.totalItem);
        }
        var totalOrc = document.getElementById("inputTotalPedido");
        totalOrc.value = formatarDecimal(total);
    }

    function formatarDecimal(valor) {
        return parseFloat(valor).toFixed(2);
    }

    function atualizarIndicesLinhas() {
        for (var i = 0; i < tableData.length; i++) {
            tableData[i].rowIndex = i;
        }
    }

    document.getElementById('modalValidacao').addEventListener('click', function (event) {
        if (event.target === this) {
            fecharModal();
        }
    });

    document.getElementById('btnFechar').addEventListener('click', function () {
        fecharModal(); 
    });

    function fecharModal() {
        document.getElementById('modalValidacao').style.display = 'none';
    }

    function validarCampos() {
        const campos = ['inputRefItem', 'inputNcm', 'inputTipo', 'inputQtde', 'inputValorUnit', 'inputTotalItem', 'inputDataPedido', 'inputCliente', 'inputNF', 'inputDataNF'];

        for (const campo of campos) {
            const valorCampo = document.getElementById(campo).value.trim();
            if (valorCampo === '') {
                //alert("Preencha todos os campos corretamente.");
                document.getElementById('modalValidacao').style.display = 'block';
                return;
            }
        }
        
        return true;
    }

    var btnAddItens = document.getElementById("btnAddItens");
    btnAddItens.addEventListener("click", function () {

        if (validarCampos()) {

            var item = document.getElementById("inputItem").value;
            var referencia = document.getElementById("inputRefItem").value;
            var ncm = document.getElementById("inputNcm").value;
            var tipo = document.getElementById("inputTipo").value;
            var quantidade = document.getElementById("inputQtde").value;
            var valorUnitario = document.getElementById("inputValorUnit").value;
            var totalItem = document.getElementById("inputTotalItem").value;

            adicionarLinha(item, referencia, ncm, tipo, quantidade, valorUnitario, totalItem, tableData.length);
            document.getElementById("btnEnviarPedido").click();
        }
    });

    var btnEnviarPedido = document.getElementById("btnEnviarPedido");
    btnEnviarPedido.addEventListener("click", function (event) {
        event.preventDefault();
        
        if (validarCampos()) {
            
            var formData = new FormData(document.getElementById('formVendas'));

            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'SalvarVendaServlet', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onload = function () {
                if (xhr.status === 200) {
                    console.log("Dados enviados com sucesso para o servlet.");

                    limparCamposEntrada();
                    proximoItem++;
                    document.getElementById("inputItem").value = proximoItem;
                } else {
                    console.error("Erro ao enviar dados para o servlet. Status: " + xhr.status);
                }
            };

            xhr.onerror = function () {
                console.error("Erro de rede ao enviar dados para o servlet.");
            };

            try {
                xhr.send(new URLSearchParams(formData));
            } catch (error) {
                console.error("Erro ao enviar dados para o servlet. Detalhes:", error);
            }
        }
    });

    function limparCamposETabela() {
        document.getElementById("formVendas").reset();
        var tableBody = document.getElementById("table-body");
        tableBody.innerHTML = "";
    }

    var btnSalvar = document.getElementById("btnSave");

    btnSalvar.addEventListener("click", function () {
        
        limparCamposETabela();
        abrirModalSucesso();
    });

    function abrirModalSucesso() {
        var modalSucesso = document.getElementById("modalSave");
        modalSucesso.style.display = "block";
    }

    document.getElementById('modalSave').addEventListener('click', function (event) {
        if (event.target === this) {
            fecharModalS(); // Chame a função para fechar o modal
        }
    });

    document.getElementById('btnNovo').addEventListener('click', function () {
        fecharModalS(); // Chame a função para fechar o modal
    });

    function fecharModalS() {
        document.getElementById('modalSave').style.display = 'none';
    }

});
