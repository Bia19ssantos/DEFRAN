document.addEventListener("DOMContentLoaded", function () {
    
    var timeoutId;
    var numOrc = document.getElementById("inputNumOrc");

    numOrc.addEventListener("input", function () {
        
        clearTimeout(timeoutId);

        timeoutId = setTimeout(function () {
            verificarNumOrc();
        }, 500);
    });

    function verificarNumOrc() {
        var numOrc = document.getElementById('inputNumOrc').value;

        $.ajax({
            type: 'POST',
            url: 'NumOrcExisteServlet',
            data: {numOrc: numOrc},
            success: function (response) {

                if (response.existe) {
                    $('#modalAtencao').modal('show');
                }
            },
            error: function (error) {
                console.error('Erro na verificação do número do orçamento:', error);
            }
        });
    }
});
