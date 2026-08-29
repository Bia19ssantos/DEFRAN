
function getPedidos() {
    var numPed = document.getElementById("filtro").value;
    var xhr = new XMLHttpRequest();
    xhr.open("GET", "PedidosServlet", true);

    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                var vendas = JSON.parse(xhr.responseText);
                carregarPedidos(vendas, numPed);
            } else {
                console.error("Erro ao obter os dados do servidor.");
            }
        }
    };
    xhr.send();
}

function carregarPedidos(vendas, numPed) {
    var tableBody = document.getElementById("table-body");

    tableBody.innerHTML = "";

    vendas.forEach(pedido => {
        
        if (numPed === "" || pedido.numPedido.toLowerCase().includes(numPed.toLowerCase())) {
        var row = tableBody.insertRow();

        var numOrcCell = row.insertCell(0);
        var numPedidoCell = row.insertCell(1);
        var dataPedidoCell = row.insertCell(2);
        var clienteCell = row.insertCell(3);
        var dataNFCell = row.insertCell(4);
        var numNFCell = row.insertCell(5);
        var totalPedidoCell = row.insertCell(6);

        numOrcCell.textContent = pedido.numOrc;
        numPedidoCell.textContent = pedido.numPedido;
        dataPedidoCell.textContent = pedido.dataPedido;
        clienteCell.textContent = pedido.cliente;
        dataNFCell.textContent = pedido.dataNF;
        numNFCell.textContent = pedido.numNF;
        totalPedidoCell.textContent = pedido.totalPedido;
    }
    });
}
getPedidos();
   
document.addEventListener("DOMContentLoaded", function () {
    var inputFiltro = document.getElementById("filtro");
    
    getPedidos();

    inputFiltro.addEventListener("keyup", function () {
        getPedidos();
    });
    
    const datatablesSimple = document.getElementById('datatablesSimple');
    if (datatablesSimple) {
        new simpleDatatables.DataTable(datatablesSimple);
    }
});
