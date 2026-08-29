 // Associar a função de exclusão ao botão de exclusão
    document.getElementById("btnExcluir").addEventListener("click", function () {
        // Exibir modal de confirmação antes de excluir
        $("#confirmacaoExclusaoModal").modal("show");
    });

function excluirCliente() {
    var razao = document.getElementById("inputRazao").value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "ExcluirClienteServlet", true);
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
                            window.location.href = "clientes.html";
                        }, 2000); // Aguardar 2 segundos antes de redirecionar
                    } else {
                        alert("Erro ao excluir o cliente: " + response.error);
                    }
                } catch (error) {
                    console.error("Erro ao processar resposta JSON:", error);
                }
            } else {
                console.error("Erro ao excluir o cliente. Status:", xhr.status);
                console.error("Resposta do servidor:", xhr.responseText);
            }
        }
    };
    console.log("Valor do razao: " + razao);
    xhr.send("inputRazao=" + encodeURIComponent(razao));
}

// Associar a função de exclusão ao botão de confirmação de exclusão no modal
    document.getElementById("btnConfirmarExclusao").addEventListener("click", function () {
        excluirCliente();
        // Fechar o modal após a confirmação
        $("#confirmacaoExclusaoModal").modal("hide");
    });