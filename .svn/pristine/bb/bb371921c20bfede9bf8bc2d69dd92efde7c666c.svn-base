// Declaração de variáveis globais para armazenar os dados das tabelas
var prodGunnebo = [];
var produtosPewag = [];
var produtosSpanset = [];
var produtosCrosby = [];
var manilhasCrosby = [];

// Função para fazer a solicitação AJAX Gunnebo
function getProdGunnebo(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdutoGunneboServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                prodGunnebo = JSON.parse(xhr.responseText);
                carregarTabelaProdutoGunnebo(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };

    xhr.send();
}

// Função para fazer a solicitação AJAX PEWAG
function getProdPewag(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdPewagServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                produtosPewag = JSON.parse(xhr.responseText);
                carregarTabelaProdutoPewag(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para fazer a solicitação AJAX SPANSET
function getProdSpanset(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdSpansetServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                produtosSpanset = JSON.parse(xhr.responseText);
                carregarTabelaProdutoSpanset(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para fazer a solicitação AJAX Crosby
function getProdCrosby(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ProdutoCrosbyServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                produtosCrosby = JSON.parse(xhr.responseText);
                carregarTabelaProdutosCrosby(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

// Função para fazer a solicitação AJAX Manilhas Crosby
function getManilhasCrosby(filtro) {
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "ManilhasCrosbyServlet", true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                manilhasCrosby = JSON.parse(xhr.responseText);
                carregarTabelaManilhasCrosby(filtro);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

function carregarTabelaProdutoGunnebo(filtro) {
    var tableBody = document.getElementById("table-body-gunnebo");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    prodGunnebo.forEach(produto => {
        if (produto.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = produto.sap;
            row.insertCell().textContent = produto.refProd;
            row.insertCell().textContent = produto.ncm;
            row.insertCell().textContent = produto.ipi;
            row.insertCell().textContent = produto.tipo;
            row.insertCell().textContent = formatarMoeda(produto.valorCusto);
            row.insertCell().textContent = produto.comprimento;
            row.insertCell().textContent = formatarMoeda(produto.valorVenda);
            row.insertCell().textContent = formatarMoeda(produto.precoLinga);
        }
    });
  
    // Tornar a tabela visível após o carregamento dos dados
    var tableGunnebo = document.getElementById("table-gunnebo");
    tableGunnebo.style.display = "table";
    
}

// Função para carregar a tabela de ProdPewagServlet
function carregarTabelaProdutoPewag(filtro) {
    var tableBody = document.getElementById("table-body-pewag");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    produtosPewag.forEach(prodPewag => {
        // Verificar se o filtro está vazio ou se o nome do produto contém o texto do filtro
        if (filtro === "" || prodPewag.refPewag.toLowerCase().includes(filtro.toLowerCase()) || filtro === "" || prodPewag.refGunnebo.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = prodPewag.codigo;
            row.insertCell().textContent = prodPewag.refGunnebo;
            row.insertCell().textContent = prodPewag.refPewag;
            row.insertCell().textContent = prodPewag.icms;
            row.insertCell().textContent = prodPewag.ipi;
            row.insertCell().textContent = prodPewag.comprimento;
            row.insertCell().textContent = formatarMoeda(prodPewag.valorCusto);
            row.insertCell().textContent = formatarMoeda(prodPewag.valorVenda);
        }
    });
    // Tornar a tabela visível após o carregamento dos dados
    var tablePewag = document.getElementById("table-pewag");
    tablePewag.style.display = "table";
}

// Função para carregar a tabela de ProdSpansetServlet
function carregarTabelaProdutoSpanset(filtro) {
    var tableBody = document.getElementById("table-body-spanset");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    produtosSpanset.forEach(prodSpanset => {
        if (filtro === "" || prodSpanset.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = prodSpanset.codigo;
            row.insertCell().textContent = prodSpanset.refProd;
            row.insertCell().textContent = prodSpanset.icms;
            row.insertCell().textContent = formatarMoeda(prodSpanset.valorCusto);
            row.insertCell().textContent = formatarMoeda(prodSpanset.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableSpanset = document.getElementById("table-spanset");
    tableSpanset.style.display = "table";
}

// Função para carregar a tabela de ProdutosCrosbyServlet
function carregarTabelaProdutosCrosby(filtro) {
    var tableBody = document.getElementById("table-body-crosby");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    produtosCrosby.forEach(prodCrosby => {
        // Verificar se o texto do produto contém o filtro digitado
        if (filtro === "" || prodCrosby.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = prodCrosby.sap;
            row.insertCell().textContent = prodCrosby.refProd;
            row.insertCell().textContent = prodCrosby.ipi;
            row.insertCell().textContent = prodCrosby.tipo;
            row.insertCell().textContent = formatarMoeda(prodCrosby.valorCusto);
            row.insertCell().textContent = prodCrosby.cargaTrabalho;
            row.insertCell().textContent = prodCrosby.comprimento;
            row.insertCell().textContent = formatarMoeda(prodCrosby.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableCrosby = document.getElementById("table-crosby");
    tableCrosby.style.display = "table";
}

// Função para carregar a tabela de ProdutoCrosbyServlet
function carregarTabelaManilhasCrosby(filtro) {
    var tableBody = document.getElementById("table-body-manilhas");
    tableBody.innerHTML = ""; // Limpar a tabela antes de popular novamente

    manilhasCrosby.forEach(manilhas => {
        // Verificar se o texto do produto contém o filtro digitado
        if (filtro === "" || manilhas.refProd.toLowerCase().includes(filtro.toLowerCase())) {
            var row = tableBody.insertRow();
            row.insertCell().textContent = manilhas.sap;
            row.insertCell().textContent = manilhas.refProd;
            row.insertCell().textContent = manilhas.ipi;
            row.insertCell().textContent = manilhas.tipo;
            row.insertCell().textContent = formatarMoeda(manilhas.valorCusto);
            row.insertCell().textContent = manilhas.cargaTrabalho;
            row.insertCell().textContent = manilhas.comprimento;
            row.insertCell().textContent = formatarMoeda(manilhas.valorVenda);
        }
    });

    // Tornar a tabela visível após o carregamento dos dados
    var tableManilhas = document.getElementById("table-manilhas");
    tableManilhas.style.display = "table";
}

// Adicionar evento de escuta para o elemento <select>
document.addEventListener("DOMContentLoaded", function () {

    var selectMarca = document.getElementById("marca");
    var inputFiltro = document.getElementById("filtro");

    selectMarca.addEventListener("change", function () {
        var selectedOption = selectMarca.value;
        var filtro = inputFiltro.value.toLowerCase();

        limparTodasTabelas();

        if (selectedOption === "gunnebo") {
            getProdGunnebo(filtro);
        } else if (selectedOption === "pewag") {
            getProdPewag(filtro);
        } else if (selectedOption === "spanset") {
            getProdSpanset(filtro);
        } else if (selectedOption === "crosby") {
            getProdCrosby(filtro);
        } else if (selectedOption === "manilhas") {
            getManilhasCrosby(filtro);
        } else {
            limparTodasTabelas();
        }
    });

    // Adicionar evento de escuta para o input de filtro
    inputFiltro.addEventListener("input", function () {
        var selectedOption = selectMarca.value;
        var filtro = inputFiltro.value.toLowerCase();

        // Chamar a função correspondente ao option selecionado, passando o filtro como argumento
        if (selectedOption === "gunnebo") {
            carregarTabelaProdutoGunnebo(filtro);
        } else if (selectedOption === "pewag") {
            getProdPewag(filtro);
        } else if (selectedOption === "spanset") {
            getProdSpanset(filtro);
        } else if (selectedOption === "crosby") {
            getProdCrosby(filtro);
        } else if (selectedOption === "manilhas") {
            getManilhasCrosby(filtro);
        } else {
            // Opção vazia ou desconhecida selecionada, pode fazer alguma ação de limpeza ou mostrar uma mensagem de erro
        }
    });

    // Iniciar a tabela de dados 
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});

// Função para formatar um número em moeda (R$)
function formatarMoeda(valor) {
    return new Intl.NumberFormat('pt-BR', {style: 'currency', currency: 'BRL'}).format(valor);
}

// Função para limpar todas as tabelas
function limparTodasTabelas() {
    var tables = document.getElementsByClassName("datatablesSimple");
    for (var i = 0; i < tables.length; i++) {
        tables[i].style.display = "none";
        tables[i].getElementsByTagName("tbody")[0].innerHTML = "";
    }
}
