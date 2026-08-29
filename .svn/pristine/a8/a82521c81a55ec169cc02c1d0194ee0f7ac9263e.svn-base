// Função para aplicar a máscara no campo CNPJ
document.addEventListener('DOMContentLoaded', function () {
    const inputCNPJ = document.getElementById('cnpj');

    // Function to format the CNPJ as the user types
    inputCNPJ.addEventListener('input', function () {
        const value = inputCNPJ.value.replace(/\D/g, '');

        if (value.length > 2) {
            inputCNPJ.value = `${value.slice(0, 2)}.${value.slice(2)}`;
        }

        if (value.length > 5) {
            inputCNPJ.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5)}`;
        }

        if (value.length > 8) {
            inputCNPJ.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5, 8)}/${value.slice(8)}`;
        }

        if (value.length > 12) {
            inputCNPJ.value = `${value.slice(0, 2)}.${value.slice(2, 5)}.${value.slice(5, 8)}/${value.slice(8, 12)}-${value.slice(12)}`;
        }
    });
});

// Função para validar CNPJ
function validarCNPJ(cnpj) {
    cnpj = cnpj.replace(/[^\d]+/g, ''); // Remove caracteres não numéricos
    if (cnpj === '' || cnpj.length !== 14) {
        return false;
    }
    
    // Verifica se todos os dígitos são iguais (caso contrário, será considerado inválido)
    if (/^(\d)\1+$/.test(cnpj)) {
        return false;
    }
    
    // Calcula os dígitos verificadores
    let tamanho = cnpj.length - 2;
    let numeros = cnpj.substring(0, tamanho);
    let digitos = cnpj.substring(tamanho);
    let soma = 0;
    let pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) {
            pos = 9;
        }
    }
    
    let resultado = soma % 11 < 2 ? 0 : 11 - (soma % 11);
    
    if (resultado.toString() !== digitos.charAt(0)) {
        return false;
    }
    
    tamanho = tamanho + 1;
    numeros = cnpj.substring(0, tamanho);
    soma = 0;
    pos = tamanho - 7;
    
    for (let i = tamanho; i >= 1; i--) {
        soma += numeros.charAt(tamanho - i) * pos--;
        if (pos < 2) {
            pos = 9;
        }
    }
    
    resultado = soma % 11 < 2 ? 0 : 11 - (soma % 11);
    
    if (resultado.toString() !== digitos.charAt(1)) {
        return false;
    }
    
    return true;
}

// Adicione a validação de CNPJ ao campo CNPJ
const inputCNPJElement = document.getElementById('cnpj');
const validationMessage = document.getElementById('cnpj-validation-message');

inputCNPJElement.addEventListener('input', function () {
    const cnpjValue = inputCNPJElement.value;
    if (validarCNPJ(cnpjValue)) {
        validationMessage.textContent = ''; // CNPJ válido, limpa a mensagem de validação
    } else {
        validationMessage.textContent = 'CNPJ inválido';
    }
});

// Função para aplicar a máscara no campo de telefone quando perder o foco
const inputTelefone = document.getElementById('telefone');

inputTelefone.addEventListener('blur', function () {
    const telefoneValue = inputTelefone.value;
    
    if (telefoneValue !== '') {
        // Aplica a máscara somente se o campo não estiver vazio
        inputTelefone.value = telefoneValue.replace(/(\d{2})(\d{4})(\d{4})/, '($1)$2-$3');
    }
});

// Função para validar o telefone
const telefoneValidationMessage = document.getElementById('telefone-validation-message');

inputTelefone.addEventListener('input', function () {
    const telefoneValue = inputTelefone.value;

    if (validarTelefone(telefoneValue)) {
        telefoneValidationMessage.textContent = ''; // telefone válido, limpa a mensagem de validação
    } else {
        telefoneValidationMessage.textContent = 'Telefone inválido';
    }
});

// Função para validar o celular
function validarTelefone(telefone) {
    // Remove caracteres não numéricos
    telefone = telefone.replace(/\D/g, '');

    // Verifica se o celular possui 11 dígitos
    return telefone.length === 11;
}

// Função para aplicar a máscara no campo de celular quando perder o foco
const inputCelular = document.getElementById('celular');

inputCelular.addEventListener('blur', function () {
    const celularValue = inputCelular.value;
    
    if (celularValue !== '') {
        // Aplica a máscara somente se o campo não estiver vazio
        inputCelular.value = celularValue.replace(/(\d{2})(\d{5})(\d{4})/, '($1)$2-$3');
    }
});

// Função para validar o celular
const celularValidationMessage = document.getElementById('celular-validation-message');

inputCelular.addEventListener('input', function () {
    const celularValue = inputCelular.value;

    if (validarCelular(celularValue)) {
        celularValidationMessage.textContent = ''; // Celular válido, limpa a mensagem de validação
    } else {
        celularValidationMessage.textContent = 'Celular inválido';
    }
});

// Função para validar o celular
function validarCelular(celular) {
    // Remove caracteres não numéricos
    celular = celular.replace(/\D/g, '');

    // Verifica se o celular possui 11 dígitos
    return celular.length === 11;
}

// Função para aplicar a máscara no campo CEP
const inputCEP = document.getElementById('cep');

inputCEP.addEventListener('input', function () {
    const cepValue = inputCEP.value.replace(/\D/g, ''); // Remove caracteres não numéricos

    if (cepValue.length > 5) {
        inputCEP.value = `${cepValue.slice(0, 5)}-${cepValue.slice(5)}`;
    }
});

// Função para validar o CEP
const cepValidationMessage = document.getElementById('cep-validation-message');

inputCEP.addEventListener('input', function () {
    const cepValue = inputCEP.value.replace(/\D/g, '');

    if (validarCEP(cepValue)) {
        cepValidationMessage.textContent = ''; // CEP válido, limpa a mensagem de validação
    } else {
        cepValidationMessage.textContent = 'CEP inválido';
    }
});

function validarCEP(cep) {
    // Remova caracteres não numéricos
    cep = cep.replace(/\D/g, '');

    // Verifique se o CEP possui 8 dígitos
    return cep.length === 8;
}


// Função para buscar o endereço com base no CEP
function buscarCEP(cep) {
    // Formate o CEP removendo caracteres não numéricos
    cep = cep.replace(/\D/g, '');

    // Verifique se o CEP possui 8 dígitos e é válido
    if (validarCEP(cep)) {
        // Construa a URL para consulta à API ViaCEP
        const url = `https://viacep.com.br/ws/${cep}/json/`;

        // Faça uma requisição HTTP para a URL
        fetch(url)
            .then((response) => response.json())
            .then((data) => {
                // Verifique se a resposta contém dados de endereço válidos
                if (!data.erro) {
                    // Preencha os campos de endereço com os dados obtidos
                    document.getElementById('endereco').value = data.logradouro;
                    document.getElementById('bairro').value = data.bairro;                                        
                    
                    // Preencha os campos de cidade e estado com os dados obtidos
                    document.getElementById('cidade').value = data.localidade;
                    document.getElementById('estado').value = data.uf;
                } else {
                    // Caso contrário, mostre uma mensagem de erro
                    document.getElementById('cep-validation-message').textContent = 'CEP não encontrado';
                }
            })
            .catch((error) => {
                console.error('Erro ao buscar CEP:', error);
            });
    } else {
        // Se o CEP não for válido, mostre uma mensagem de erro
        document.getElementById('cep-validation-message').textContent = 'CEP inválido';
    }
}


// Selecionar o botão Buscar CEP
const buscarCEPButton = document.getElementById('buscar-cep-button');

// Adicionar um ouvinte de eventos 'click' ao botão
buscarCEPButton.addEventListener('click', function () {
    const cepValue = inputCEP.value.replace(/\D/g, ''); // Remove caracteres não numéricos
    buscarCEP(cepValue);
});


    $(document).ready(function () {
        $("#btnSalvar").click(function (e) {
            e.preventDefault(); // Evita que o formulário seja enviado automaticamente

            // Limpa as mensagens de validação
            $(".text-danger").text("");

            // Validação de campos obrigatórios
            if ($("#cnpj").val() === "") {
                exibirModal("CNPJ é obrigatório.");
                return;
            }

            if ($("#razao").val() === "") {
                exibirModal("Razão Social é obrigatória.");
                return;
            }

            if ($("#contato").val() === "") {
                exibirModal("Contato é obrigatório.");
                return;
            }

            if ($("#email").val() === "") {
                exibirModal("E-mail é obrigatório.");
                return;
            }

            if ($("#cep").val() === "") {
                exibirModal("CEP é obrigatório.");
                return;
            }

            if ($("#cidade").val() === "") {
                exibirModal("Cidade é obrigatória.");
                return;
            }

            if ($("#estado").val() === "") {
                exibirModal("UF é obrigatório.");
                return;
            }

            if ($("#bairro").val() === "") {
                exibirModal("Bairro é obrigatório.");
                return;
            }

            if ($("#endereco").val() === "") {
                exibirModal("Endereço é obrigatório.");
                return;
            }

            if ($("#numero").val() === "") {
                exibirModal("Número é obrigatório.");
                return;
            }

            if ($("#condPgto").val() === "") {
               exibirModal("Condição de Pagamento é obrigatória.");
                return;
            }

            if ($("#condTransporte").val() === "") {
                exibirModal("Condição de Transporte é obrigatória.");
                return;
            }

            // Se todas as validações passarem, você pode enviar o formulário
            $("#formCliente").submit();
        });
    function exibirModal(mensagem) {
            // Configura a mensagem no modal
            $("#modalValidacao .modal-body").text(mensagem);

            // Abre o modal
            $("#modalValidacao").modal("show");
        }

        $("#btnFechar").click(function () {
            // Fecha o modal quando o botão OK é clicado
            $("#modalValidacao").modal("hide");
        });
    });


// Quando o formulário for submetido
$("#formCliente").submit(function (event) {
    event.preventDefault(); // Impede que o formulário seja enviado normalmente

    $.ajax({
        url: "SalvarClienteServlet", // O URL do Servlet
        method: "POST",
        data: $(this).serialize(), // Serializa o formulário para enviar os dados
        dataType: "json", // Espera uma resposta JSON
        success: function (response) {
            // Verifica se a resposta é de sucesso
            if (response === "Os dados foram salvos com sucesso.") {
                // Limpa os campos do formulário
                $("#formCliente")[0].reset();

                // Exibe o modal
                $("#modalSucesso").modal("show");
            } else {
                // Se a resposta não for de sucesso, faça algo com a mensagem de erro (opcional)
                console.error("Erro: " + response);
                // Exibe o modal de Erro
               window.location.href = "modalErro.html";
            }
        },
        error: function (error) {
            console.error("Erro: " + error.responseText);
        }
    });
});


