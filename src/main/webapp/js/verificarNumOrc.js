/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function verificarNumeroOrcamento() {
                // Obtenha o número do orçamento digitado
                var numOrc = document.getElementById('inputNumOrc').value;

                $.ajax({
                    type: 'POST',
                    url: 'NumOrcExisteServlet', // Substitua pelo caminho do seu servlet de verificação
                    data: {numOrc: numOrc},
                    success: function (response) {
                        // Se o número do orçamento já está em uso, exiba o modal de atenção
                        if (response.existe) {
                            $('#modalAtencao').modal('show');
                        }
                    },
                    error: function (error) {
                        console.error('Erro na verificação do número do orçamento:', error);
                    }
                });
            }
