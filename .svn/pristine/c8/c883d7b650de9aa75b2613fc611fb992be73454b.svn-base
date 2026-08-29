document.addEventListener("DOMContentLoaded", function () {
    // Variáveis globais
    var tabelaBody1 = document.getElementById("table-body1");
    var tableData1 = []; // Matriz para armazenar os dados da tabela
    let proximoItem1 = 1; // Variável para rastrear o próximo número do item

    // Função para adicionar uma linha à tabela com um botão "Remover"
    function adicionarLinha1(numOrc, modLinga, refItem, quantidade1, valorUnitario1, totalItem1, tamanho, rowIndex) {
        // Valide os campos de entrada
        if (!numOrc || !modLinga || !refItem || !quantidade1 || !valorUnitario1 || !totalItem1 || !tamanho) {
            alert("Preencha todos os campos corretamente.");
            return;
        }

        var novaLinha1 = tabelaBody1.insertRow();

        // Use innerHTML para adicionar o botão "Remover" com ícone
        novaLinha1.innerHTML = `
            <td>${numOrc}</td>
            <td>${modLinga}</td>
            <td>${refItem}</td>
            <td>${quantidade1}</td>
            <td>${valorUnitario1}</td>
            <td>${totalItem1}</td>
            <td>${tamanho}</td>
            <td>
                <button type="button" class="btn-remover1">
                <img src="assets/icons/lixo.gif" alt="adicionar">        
                <span aria-hidden="true">&times;</span>
                </button>
            </td>`;

        // Adicione os dados da linha a um objeto
        var rowData1 = {
            numOrc: numOrc,
            modLinga: modLinga,
            refItem: refItem,
            quantidade: quantidade1,
            valorUnitario: valorUnitario1,
            totalItem: totalItem1,
            tamanho: tamanho,
            rowIndex: rowIndex
        };

        // Adicione um ouvinte de evento para o botão "Remover" com o índice da linha
        var btnRemover1 = novaLinha1.querySelector(".btn-remover1");
        btnRemover1.addEventListener("click", function () {
            if (confirm("Tem certeza de que deseja remover esta linha?")) {
                tabelaBody1.deleteRow(rowIndex);
                tableData1.splice(rowIndex, 1); // Remova o item da matriz
                calcularEExibirValorTotal1();
                calcularSomaTamanho();
                calcularElosECorrente();
            }
        });

        // Adicione o objeto rowData a uma matriz global
        tableData1.push(rowData1);

        calcularEExibirValorTotal1();
        calcularSomaTamanho();

    }

    // Função para limpar os campos de entrada
    function limparCamposEntrada1() {
        var camposEntrada1 = document.querySelectorAll(
                "#inputRefProd1, #inputTipo1, #inputQtde1, #inputValorUnit1, #inputTotalItem1, #inputTamanho"
                );

        camposEntrada1.forEach(function (campo1) {
            campo1.value = "";
        });
    }

    function limparCampos() {

        document.getElementById('inputRefProd1').value = '';
        document.getElementById('inputTipo1').value = '';
        document.getElementById('inputTamanho').value = '';
        document.getElementById('inputDiametro').value = '';
        document.getElementById('inputComprLinga').value = '';
        document.getElementById('inputTotalElos').value = '';
        document.getElementById('inputTotalCorrente').value = '';
        document.getElementById('inputIpi').value = '';
        document.getElementById('inputQtde1').value = '';
        document.getElementById('inputValorUnit1').value = '';
        document.getElementById('inputTotalItem1').value = '';
        document.getElementById('inputRefLinga').value = '';
        document.getElementById('inputDescLinga').value = '';
        document.getElementById('inputNumOrc1').value = '';

        // Limpe a tabela de itens
        var tabelaItens = document.getElementById('itensTable1');
        var tbody = tabelaItens.getElementsByTagName('tbody')[0];
        tbody.innerHTML = '';

        // Limpe os campos de Comprimento de Itens e Preço da Linga
        document.getElementById('totalTamanho').value = '';
        document.getElementById('inputTotalLinga').value = '';
    }

    // Função para formatar um número Decimal
    function formatarDecimal(valor) {
        return parseFloat(valor).toFixed(2); // Formata o número com duas casas decimais
    }

    // Função para calcular e exibir o valor total
    function calcularEExibirValorTotal1() {
        var total1 = 0;

        for (var i = 0; i < tableData1.length; i++) {
            var rowData1 = tableData1[i];
            total1 += parseFloat(rowData1.totalItem);
        }
        var totalLinga = document.getElementById("inputTotalLinga");
        totalLinga.value = formatarDecimal(total1);

    }

    // Adicione um evento de clique ao overlay do modal
    document.getElementById('modalValidacao').addEventListener('click', function (event) {
        if (event.target === this) {
            fecharModal1(); // Chame a função para fechar o modal
        }
    });

// Adicione um evento de clique ao botão "OK"
    document.getElementById('btnFechar').addEventListener('click', function () {
        fecharModal1(); // Chame a função para fechar o modal
    });

// Função para fechar o modal
    function fecharModal1() {
        document.getElementById('modalValidacao').style.display = 'none';
    }

    // Função para verificar se os campos estão vazios
    function validarCampos1() {
        const campos1 = ['inputRefLinga', 'inputRefProd1', 'inputQtde1', 'inputValorUnit1', 'inputTotalItem1', 'inputTamanho', 'inputNumOrc'];

        for (const campo1 of campos1) {
            const valorCampo1 = document.getElementById(campo1).value.trim();
            if (valorCampo1 === '') {
                //alert("Preencha todos os campos corretamente.");
                document.getElementById('modalValidacao').style.display = 'block';
                return;
            }
        }

        // Todos os campos estão preenchidos, retorna true
        return true;
    }

    // Ouvinte de evento para o botão "Adicionar"
    var btnAdicionar1 = document.getElementById("btnAdicionar1");
    btnAdicionar1.addEventListener("click", function () {

        // Execute a validação antes de adicionar o novo item
        if (validarCampos1()) {

            var item = parseInt(document.getElementById("inputItem1").value);
            document.getElementById("inputItem1").value = item + 1;

            var numOrc = document.getElementById("inputNumOrc").value;
            var modLinga = document.getElementById("inputRefLinga").value;
            var refItem = document.getElementById("inputRefProd1").value;
            var quantidade1 = document.getElementById("inputQtde1").value;
            var valorUnitario1 = document.getElementById("inputValorUnit1").value;
            var totalItem1 = document.getElementById("inputTotalItem1").value;
            var tamanho = document.getElementById("inputTamanho").value;

            adicionarLinha1(numOrc, modLinga, refItem, quantidade1, valorUnitario1, totalItem1, tamanho);
            document.getElementById("btnEnviar1").click();

            // Limpeza dos campos
            limparCamposEntrada1();
        }
    });

    var btnEnviar1 = document.getElementById("btnEnviar1");
    btnEnviar1.addEventListener("click", function (event) {
        event.preventDefault(); // Evitar o comportamento padrão do botão submit

        // Execute a validação antes de adicionar o novo item
        if (validarCampos1()) {
            // Obtenha os dados do formulário
            var formData1 = new FormData(document.getElementById('formLingas'));

            // Faça uma solicitação AJAX para o servlet
            var xhr = new XMLHttpRequest();
            xhr.open('POST', 'salvarLingaServlet', true);
            xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

            xhr.onload = function () {
                if (xhr.status === 200) {
                    console.log("Dados enviados com sucesso para o servlet.");
                } else {
                    console.error("Erro ao enviar dados para o servlet. Status: " + xhr.status);
                }
            };

            xhr.onerror = function () {
                console.error("Erro de rede ao enviar dados para o servlet.");
            };

            // Envie os dados do formulário
            try {
                xhr.send(new URLSearchParams(formData1));
            } catch (error) {
                console.error("Erro ao enviar dados para o servlet. Detalhes:", error);
            }
        }
    });


    var inputDiametro = document.getElementById("inputDiametro");
    var inputComprLinga = document.getElementById("inputComprLinga");
    var inputTotalElos = document.getElementById("inputTotalElos");
    var inputTotalCorrente = document.getElementById("inputTotalCorrente");
    var inputQtde1 = document.getElementById("inputQtde1");
    var inputTotalItem1 = document.getElementById("inputTotalItem1");
    var inputValorUnit1 = document.getElementById("inputValorUnit");


// Função para calcular a soma dos tamanhos dos itens
    function calcularSomaTamanho() {
        var somaT = 0;

        for (var i = 0; i < tableData1.length; i++) {
            var rowData1 = tableData1[i];
            somaT += parseFloat(rowData1.tamanho);
        }

        // Atualize o campo totalTamanho com o valor somado
        var totalTamanhoCampo = document.getElementById("totalTamanho");
        totalTamanhoCampo.value = formatarDecimal(somaT);

        // Retorne a soma (opcional, se você precisar usar o valor em outro lugar)
        return somaT;
    }


    inputTotalElos.addEventListener("input", function () {
        calcularElosECorrente();
    });

// Função para calcular elos, atualizar inputTotalElos e calcular o valor da corrente
    function calcularElosECorrente() {
        var somaItens = calcularSomaTamanho();
        var diametro = formatarDecimal(inputDiametro.value) || 0;
        var comprLinga = formatarDecimal(inputComprLinga.value) || 0;
        var valorUnit1 = formatarDecimal(inputValorUnit1.value) || 0;
        var qtde = parseFloat(inputQtde1.value) || 0;

        // Verificar se o checkbox checkOlhal está marcado
        var isCheckOlhalAtivado = document.getElementById("checkOlhal").checked;

        // Verificar se o checkbox checkClevis está marcado
        var isCheckClevisAtivado = document.getElementById("checkClevis").checked;

        // Calcular a quantidade de elos
        var qtdeElos = Math.floor((comprLinga - somaItens) / (diametro * 3));

        // Ajustar para o próximo ímpar se checkOlhal estiver ativado e qtdeElos for par
        if (isCheckOlhalAtivado && qtdeElos % 2 === 0) {
            qtdeElos++;
        }

        // Ajustar para o próximo par se checkClevis estiver ativado e qtdeElos for ímpar
        if (isCheckClevisAtivado && qtdeElos % 2 !== 0) {
            qtdeElos++;
        }

        // Atualizar o valor em inputTotalElos
        inputTotalElos.value = qtdeElos;

        // Calcular a quantidade de corrente
        var qtdeCorrente = (((qtdeElos + 1) * qtde) * (diametro * 3)) / 1000;

        // Atualizar os valores
        inputTotalCorrente.value = formatarDecimal(qtdeCorrente);
        inputTotalItem1.value = Math.ceil(formatarDecimal(qtdeCorrente * valorUnit1));
    }


    // Ouvinte de evento para o botão "Calcular"
    var btnCalcular = document.getElementById("btnCalcular");
    btnCalcular.addEventListener("click", function () {
        calcularElosECorrente();
    });

    // Obtém o elemento de input pelo ID
    var inputNcmLinga = document.getElementById("inputNcmLinga");
    var valorFixo = "7312.90.00";
    inputNcmLinga.value = valorFixo;


    var btnAddLinga = document.getElementById("btnAddLinga");
    btnAddLinga.addEventListener("click", function () {

        // Obtém os valores dos campos do modal
        var inputRefLinga = document.getElementById("inputRefLinga").value;
        var inputDescLinga = document.getElementById("inputDescLinga").value;
        var inputTotalLinga = document.getElementById("inputTotalLinga").value;
        var inputNcmLinga = document.getElementById("inputNcmLinga").value;

        // Define os valores nos campos da página principal
        var inputRefProd = document.getElementById("inputRefProd");
        var inputDescProd = document.getElementById("inputDescProd");
        var inputValorUnit = document.getElementById("inputValorUnit");
        var inputNcm = document.getElementById("inputNcm");

        inputRefProd.value = inputRefLinga;
        inputDescProd.value = inputDescLinga;
        inputNcm.value = inputNcmLinga;
        inputValorUnit.value = inputTotalLinga;

        // Limpe a tabela
        tabelaBody1.innerHTML = "";

        // Redefina a matriz tableData1
        tableData1 = [];

        // Reinicie a variável próximoItem1
        proximoItem1 = 1;
        document.getElementById("inputItem1").value = proximoItem1;

        // Limpe os campos de entrada
        limparCamposEntrada1();

        limparCampos();

    });

    var btnLinga = document.getElementById("btnLinga");
    btnLinga.addEventListener("click", function () {

        var inputNumOrc = document.getElementById("inputNumOrc").value;
        var inputNumOrc1 = document.getElementById("inputNumOrc1");

        inputNumOrc1.value = inputNumOrc;

    });

});
