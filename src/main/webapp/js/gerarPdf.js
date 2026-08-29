document.addEventListener("DOMContentLoaded", function () {

    function formatarData(data) {
    const meses = [
        "janeiro", "fevereiro", "março", "abril", "maio", "junho",
        "julho", "agosto", "setembro", "outubro", "novembro", "dezembro"
    ];

    // Obtém a data no fuso horário local
    const dataLocal = new Date(data.getTime() + (data.getTimezoneOffset() * 60000));

    // Converte a data para o formato desejado
    const dia = dataLocal.getDate();
    const mes = meses[dataLocal.getMonth()];
    const ano = dataLocal.getFullYear();

    return `Porto Feliz, ${dia} de ${mes} de ${ano}`;
}

    function carregarDadosDaPagina() {

        const numOrc = document.getElementById('inputNumOrc').value;
        const vendedor = document.getElementById('inputVendedor').value;
        const cliente = document.getElementById('inputCliente').value;
        const cnpj = document.getElementById('inputCnpj').value;
        const telefone = document.getElementById('inputTelefone').value;
        const contato = document.getElementById('inputContato').value;
        const email = document.getElementById('inputEmail').value;
        const dataOrc = new Date(document.getElementById('inputDataOrc').value + 'T00:00:00');
        const dataFormatada = formatarData(dataOrc);
        const pgto = document.getElementById('inputPagamento').value;
        const transporte = document.getElementById('inputTransporte').value;
        const obs = document.getElementById('inputObs').value;

        // Retorne um objeto com os dados
        return {
            numOrc,
            vendedor,
            cliente,
            cnpj,
            telefone,
            contato,
            email,
            dataFormatada,
            pgto,
            transporte,
            obs
        };
    }

    function preencherCamposDoIframe(dados) {
        // Acesse o iframe
        const iframe = document.getElementById('pdfIframe');
        const iframeDoc = iframe.contentDocument;

        // Preencha os campos no iframe com os dados
        iframeDoc.getElementById('numOrc').value = dados.numOrc;
        iframeDoc.getElementById('vendedor').value = dados.vendedor;
        iframeDoc.getElementById('cliente').value = dados.cliente;
        iframeDoc.getElementById('cnpj').value = dados.cnpj;
        iframeDoc.getElementById('telefone').value = dados.telefone;
        iframeDoc.getElementById('contato').value = dados.contato;
        iframeDoc.getElementById('email').value = dados.email;
        iframeDoc.getElementById('dataOrc').textContent = dados.dataFormatada;
        iframeDoc.getElementById('pgto').value = dados.pgto;
        iframeDoc.getElementById('transporte').value = dados.transporte;
        iframeDoc.getElementById('obs').value = dados.obs;

        // Obtenha a tabela da página principal
        const tabelaPrincipal = document.getElementById('itensTable');
        const tabelaPDF = iframeDoc.getElementById('tabelaPdf'); // Use o ID correto da tabela no seu arquivo orcPdf.html

        // Obtenha as linhas da tabela da página principal
        const linhasTabelaPrincipal = tabelaPrincipal.querySelectorAll('tbody tr');

        // Limpe a tabela no iframe do PDF
        tabelaPDF.innerHTML = '';

        // Crie uma linha de cabeçalho na tabela do PDF
        const cabecalhoTabelaPDF = tabelaPDF.createTHead();
        const linhaCabecalho = cabecalhoTabelaPDF.insertRow(0);

        // Obtenha as células do cabeçalho da tabela principal
        const celulasCabecalhoTabelaPrincipal = tabelaPrincipal.querySelectorAll('thead th');

        // Para cada célula do cabeçalho da tabela principal
        celulasCabecalhoTabelaPrincipal.forEach((celulaCabecalho) => {
            // Crie uma nova célula no cabeçalho do PDF e defina seu conteúdo
            const novaCelulaCabecalho = linhaCabecalho.insertCell(-1);
            novaCelulaCabecalho.textContent = celulaCabecalho.textContent;

            // Adicione estilos à célula do cabeçalho
            novaCelulaCabecalho.style.fontWeight = 'bold';
            novaCelulaCabecalho.style.border = '1px solid #cccccc';

        });

        // Para cada linha da tabela da página principal
        linhasTabelaPrincipal.forEach((linha) => {
            // Crie uma nova linha na tabela do PDF
            const novaLinha = tabelaPDF.insertRow(-1);

            // Obtenha as células da linha da página principal
            const celulasTabelaPrincipal = linha.querySelectorAll('td');

            // Para cada célula da linha da página principal
            celulasTabelaPrincipal.forEach((celula) => {
                // Crie uma nova célula na linha do PDF e defina seu conteúdo
                const novaCelula = novaLinha.insertCell(-1);
                novaCelula.textContent = celula.textContent;
            });
        });
    }

    function gerarPDF() {
        // Carregue os dados da página principal
        const dados = carregarDadosDaPagina();

        // Preencha os campos no iframe
        preencherCamposDoIframe(dados);

        // Em seguida, você pode gerar o PDF a partir do conteúdo do iframe
        const iframe = document.getElementById('pdfIframe');
        iframe.contentWindow.print();


        // Após a impressão, exiba o modal de confirmação
        const modalConfirmacaoElement = document.getElementById('modalSucesso');
        if (modalConfirmacaoElement) {
            const modalConfirmacao = new bootstrap.Modal(modalConfirmacaoElement);
            modalConfirmacao.show();
        } else {
            console.error("Elemento do modal de confirmação não encontrado");
        }
    }


    // Associe a função ao botão "Gerar PDF"
    document.getElementById('btnSalvar').addEventListener('click', gerarPDF);

});
